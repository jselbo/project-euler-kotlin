package com.joshuaselbo.euler.solutions

import kotlin.math.abs

fun problem44() {
    val pents = IntArray(2500)
    for (i in 1..pents.size) {
        pents[i - 1] = i * (3 * i - 1) / 2
    }

    var minDifference = Int.MAX_VALUE
    for (i in pents.indices) {
        for (j in i + 1 until pents.size) {
            val sum = pents[i] + pents[j]
            val difference = abs(pents[i] - pents[j])
            if (difference < minDifference && pents.contains(sum) && pents.contains(difference)) {
                minDifference = difference
            }
        }
    }

    println(minDifference)
}
