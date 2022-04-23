package com.joshuaselbo.euler.utils

import java.io.BufferedReader

enum class Suit {
    CLUB, SPADE, DIAMOND, HEART;

    override fun toString(): String {
        return when (this) {
            CLUB -> "C"
            SPADE -> "S"
            DIAMOND -> "D"
            HEART -> "H"
        }
    }
}

class Card(val value: Int, val suit: Suit) : Comparable<Card> {

    init {
        require(value in 2..14)
    }

    override fun toString(): String {
        val valueStr = when (value) {
            in 2..10 -> value.toString()
            11 -> "J"
            12 -> "Q"
            13 -> "K"
            14 -> "A"
            else -> throw RuntimeException()
        }
        return "$valueStr$suit"
    }

    override fun compareTo(other: Card): Int {
        if (value != other.value) {
            return value - other.value
        }
        if (suit != other.suit) {
            return suit.ordinal - other.suit.ordinal
        }
        return 0
    }

    companion object {
        fun parse(str: String): Card {
            if (str.length != 2) {
                throw IllegalArgumentException()
            }
            val valueChar = str[0]
            val value =
                if (valueChar in '2'..'9') {
                    Integer.parseInt(valueChar.toString())
                } else when (valueChar) {
                    'T' -> 10
                    'J' -> 11
                    'Q' -> 12
                    'K' -> 13
                    'A' -> 14
                    else -> throw IllegalArgumentException("invalid value: $valueChar")
                }
            val suitChar = str[1]
            val suit = when (suitChar) {
                'C' -> Suit.CLUB
                'S' -> Suit.SPADE
                'D' -> Suit.DIAMOND
                'H' -> Suit.HEART
                else -> throw IllegalArgumentException("invalid suit: $suitChar")
            }
            return Card(value, suit)
        }
    }
}

enum class HandClassification {
    HIGH_CARD,
    PAIR,
    TWO_PAIR,
    THREE_OF_A_KIND,
    STRAIGHT,
    FLUSH,
    FULL_HOUSE,
    FOUR_OF_A_KIND,
    STRAIGHT_FLUSH,
    ROYAL_FLUSH,
}

class PokerHand(cards: List<Card>) : Comparable<PokerHand> {

    // Sorted
    val cards: List<Card>

    // Values 2-14 with index+2
    private val counts = IntArray(13)

    init {
        require(cards.size == 5)
        this.cards = cards.sorted()
        for (card in cards) {
            counts[card.value - 2]++
        }
    }

    override fun compareTo(other: PokerHand): Int {
        val thisClassification = classify()
        val otherClassification = other.classify()
//        println("p1 class: $thisClassification -- p2 class: $otherClassification")
        if (thisClassification.ordinal != otherClassification.ordinal) {
            return thisClassification.ordinal - otherClassification.ordinal
        }
        return when (thisClassification) {
            HandClassification.HIGH_CARD -> highCardCompare(other)
            HandClassification.PAIR -> {
                val pairValue = counts.requireIndexOf(2) + 2
                val otherPairValue = other.counts.requireIndexOf(2) + 2
                val pairCompare = pairValue - otherPairValue
                if (pairCompare != 0) {
                    return pairCompare
                }
                return highCardCompare(other)
            }
            HandClassification.TWO_PAIR -> {
                val pairValues = counts.indicesOf(2).map { it + 2 }
                val otherPairValues = other.counts.indicesOf(2).map { it + 2 }
                check(pairValues.size == 2 && otherPairValues.size == 2)
                if (pairValues[1] != otherPairValues[1]) {
                    return pairValues[1] - otherPairValues[1]
                }
                if (pairValues[0] != otherPairValues[0]) {
                    return pairValues[0] - otherPairValues[0]
                }
                return highCardCompare(other)
            }
            HandClassification.THREE_OF_A_KIND -> {
                val threeOfAKindValue = counts.requireIndexOf(3) + 2
                val otherThreeOfAKindValue = other.counts.requireIndexOf(3) + 2
                if (threeOfAKindValue != otherThreeOfAKindValue) {
                    return threeOfAKindValue - otherThreeOfAKindValue
                }
                return highCardCompare(other)
            }
            HandClassification.STRAIGHT -> highCardCompare(other)
            HandClassification.FLUSH -> highCardCompare(other)
            HandClassification.FULL_HOUSE -> {
                val threeOfAKindValue = counts.requireIndexOf(3) + 2
                val otherThreeOfAKindValue = other.counts.requireIndexOf(3) + 2
                if (threeOfAKindValue != otherThreeOfAKindValue) {
                    return threeOfAKindValue - otherThreeOfAKindValue
                }
                val pairValue = counts.requireIndexOf(2) + 2
                val otherPairValue = other.counts.requireIndexOf(2) + 2
                val pairCompare = pairValue - otherPairValue
                if (pairCompare != 0) {
                    return pairCompare
                }
                return highCardCompare(other)
            }
            HandClassification.FOUR_OF_A_KIND -> {
                val fourOfAKindValue = counts.requireIndexOf(4) + 2
                val otherFourOfAKindValue = other.counts.requireIndexOf(4) + 2
                if (fourOfAKindValue != otherFourOfAKindValue) {
                    return fourOfAKindValue - otherFourOfAKindValue
                }
                return highCardCompare(other)
            }
            HandClassification.STRAIGHT_FLUSH -> highCardCompare(other)
            HandClassification.ROYAL_FLUSH -> highCardCompare(other)
        }
    }

    private fun highCardCompare(other: PokerHand): Int {
        for (i in cards.size - 1 downTo 0) {
            if (cards[i].value != other.cards[i].value) {
                return cards[i].value - other.cards[i].value
            }
        }
        return 0
    }

    private fun classify(): HandClassification {
        val isFlush = isFlush()
        if (isFlush
            && cards[0].value == 10
            && cards[1].value == 11
            && cards[2].value == 12
            && cards[3].value == 13
            && cards[4].value == 14) {
            return HandClassification.ROYAL_FLUSH
        }
        val isStraight = isStraight()
        if (isFlush && isStraight) {
            return HandClassification.STRAIGHT_FLUSH
        }
        if (counts.any { it == 4 }) {
            return HandClassification.FOUR_OF_A_KIND
        }
        if (counts.any { it == 3 } && counts.any { it == 2 }) {
            return HandClassification.FULL_HOUSE
        }
        if (isFlush) {
            return HandClassification.FLUSH
        }
        if (isStraight) {
            return HandClassification.STRAIGHT
        }
        if (counts.any { it == 3 }) {
            return HandClassification.THREE_OF_A_KIND
        }
        if (counts.count { it == 2 } == 2) {
            return HandClassification.TWO_PAIR
        }
        if (counts.any { it == 2 }) {
            return HandClassification.PAIR
        }
        return HandClassification.HIGH_CARD
    }

    private fun isFlush(): Boolean {
        return cards.all { card -> card.suit == cards[0].suit }
    }

    private fun isStraight(): Boolean {
        for (i in 1 until cards.size) {
            if (cards[i].value - cards[i - 1].value != 1) {
                return false
            }
        }
        return true
    }

    override fun toString(): String {
        return "$cards"
    }
}

fun parseHands(filename: String): List<Pair<PokerHand, PokerHand>> {
    val inputStream = Card::class.java.classLoader.getResourceAsStream(filename) ?: throw java.lang.RuntimeException()
    val handLines = inputStream.bufferedReader().use(BufferedReader::readLines)
    inputStream.close()

    return handLines.map(::parseHand)
}

fun parseHand(str: String): Pair<PokerHand, PokerHand> {
    val cards = str.split(' ').map(Card.Companion::parse)
    val p1Cards = cards.subList(0, 5)
    val p2Cards = cards.subList(5, 10)
    return Pair(PokerHand(p1Cards), PokerHand(p2Cards))
}

private fun IntArray.requireIndexOf(value: Int): Int {
    val index = indexOf(value)
    check(index != -1)
    return index
}

private fun IntArray.indicesOf(value: Int): List<Int> {
    val indices = mutableListOf<Int>()
    for (i in 0 until this.size) {
        if (this[i] == value) {
            indices.add(i)
        }
    }
    return indices
}