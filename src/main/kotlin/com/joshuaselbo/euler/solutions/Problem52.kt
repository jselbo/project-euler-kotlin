package com.joshuaselbo.euler.solutions

import com.joshuaselbo.euler.utils.*

fun problem52() {
    var n = 1
    while (true) {
        val nDigits = n.toDigits()
        if (digitsEqual(nDigits, (2*n).toDigits())
            && digitsEqual(nDigits, (2*n).toDigits())
            && digitsEqual(nDigits, (3*n).toDigits())
            && digitsEqual(nDigits, (4*n).toDigits())
            && digitsEqual(nDigits, (5*n).toDigits())
            && digitsEqual(nDigits, (6*n).toDigits())) {
            println(n)
            return
        }
        n++
    }
}

private fun digitsEqual(d1: List<Int>, d2: List<Int>): Boolean {
    val d1Counts = LongArray(10)
    val d2Counts = LongArray(10)
    for (d in d1) {
        d1Counts[d]++
    }
    for (d in d2) {
        d2Counts[d]++
    }
    return d1Counts.contentEquals(d2Counts)
}
