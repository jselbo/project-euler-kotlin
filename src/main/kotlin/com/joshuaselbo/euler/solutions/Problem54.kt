package com.joshuaselbo.euler.solutions

import com.joshuaselbo.euler.utils.*
import java.lang.RuntimeException

fun problem54() {
    val handPairs = parseHands("p054_poker.txt")

    var p1Wins = 0
    for (handPair in handPairs) {
//        println("p1: ${handPair.first}, p2: ${handPair.second}")
        val compare = handPair.first.compareTo(handPair.second)
        if (compare > 0) {
            p1Wins++
        }
        if (compare == 0) {
            throw RuntimeException("bug! eq classify hand: $handPair")
        }
//        println("winner: ${if (compare > 0) "P1" else "P2"}")
    }
    println("p1 wins: $p1Wins / ${handPairs.size}")
}