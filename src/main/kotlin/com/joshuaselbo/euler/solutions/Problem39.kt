package com.joshuaselbo.euler.solutions

import kotlin.math.floor
import kotlin.math.sqrt

fun problem39() {
    var highNumSols = 0
    var highP = 0
    for (p in 12..1000) {
        var numSols = 0
        for (a in 1 until p) {
            for (b in 1 until p) {
                val c = sqrt((a * a + b * b).toDouble())
                if (floor(c) == c && a + b + c == p.toDouble()) {
                    numSols++
                }
            }
        }
        if (numSols > highNumSols) {
            highNumSols = numSols
            highP = p
        }
    }

    println(highP)
}
