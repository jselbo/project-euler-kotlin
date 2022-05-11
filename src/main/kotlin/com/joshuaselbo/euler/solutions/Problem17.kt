package com.joshuaselbo.euler.solutions

import java.lang.IllegalStateException

fun problem17() {
    var letterCount = 0
    for (i in 1..1000) {
//        println("$i -> ${toWord(i)}")
        letterCount += toWord(i).replace(" ", "").length
    }
    println("total: $letterCount")
}

// only works up to 1000
private fun toWord(n: Int): String {
    require(n in 1..1000)

    if (n == 1000) {
        return "one thousand"
    }
    if (n >= 100) {
        val hundredsDigit = n / 100
        val tenAndOnesDigits = n % 100
        return if (tenAndOnesDigits == 0)
            toWord(hundredsDigit) + " hundred"
        else
            toWord(hundredsDigit) + " hundred and " + toWord(tenAndOnesDigits)
    }
    if (n >= 20) {
        val tensDigit = n / 10
        val onesDigit = n % 10
        val tensWord = when (tensDigit) {
            2 -> "twenty"
            3 -> "thirty"
            4 -> "forty"
            5 -> "fifty"
            6 -> "sixty"
            7 -> "seventy"
            8 -> "eighty"
            9 -> "ninety"
            else -> throw IllegalStateException()
        }
        return if (onesDigit == 0)
            tensWord
        else
            tensWord + " " + toWord(onesDigit)
    }
    return when (n) {
        // could do <digit> + "teen" for 13+ but 13, 15, and 18 would need special cases anyway
        19 -> "nineteen"
        18 -> "eighteen"
        17 -> "seventeen"
        16 -> "sixteen"
        15 -> "fifteen"
        14 -> "fourteen"
        13 -> "thirteen"
        12 -> "twelve"
        11 -> "eleven"
        10 -> "ten"
        9 -> "nine"
        8 -> "eight"
        7 -> "seven"
        6 -> "six"
        5 -> "five"
        4 -> "four"
        3 -> "three"
        2 -> "two"
        1 -> "one"
        0 -> "zero"
        else -> throw IllegalStateException()
    }
}