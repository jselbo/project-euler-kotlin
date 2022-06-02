package com.joshuaselbo.euler.solutions

import com.joshuaselbo.euler.utils.*

fun problem58() {
    while (true) {
        var nDiagonals = 1
        var nPrimeDiagonals = 0

        var spiralIteration = 2
        var counter = 1
        while (true) {
            // Span is difference between corner values for spiral with given iteration
            val span = 2*(spiralIteration-1)
            for (i in 1..4) {
                val diagonal = counter + i*span
                if (isPrimeNoCache(diagonal)) {
                    nPrimeDiagonals++
                }
            }
            nDiagonals += 4

            if (nPrimeDiagonals.toDouble() / nDiagonals < 0.10) {
                val sideLen = span+1
                println(sideLen)
                return
            }

            spiralIteration++
            counter += 4*span
        }
    }
}