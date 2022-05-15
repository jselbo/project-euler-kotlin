package com.joshuaselbo.euler.solutions

import com.joshuaselbo.euler.utils.toDigits
import kotlin.math.pow

fun problem30() {
    var sum = 0

    for (i in 2..999999) {
        val digits = i.toDigits()
        val sumOfFifthPowers = digits.sumOf { d -> d.toDouble().pow(5).toInt() }
        if (i == sumOfFifthPowers) {
            sum += i
        }
    }

    println(sum)
}
