package com.joshuaselbo.euler.solutions

import com.joshuaselbo.euler.utils.*

fun problem34() {
    var sum = 0

    for (i in 10..999999) {
        val digits = i.toDigits()
        val sumOfFactorials = digits.sumOf { d -> factorial(d) }
        if (i == sumOfFactorials) {
            sum += i
        }
    }

    println(sum)
}
