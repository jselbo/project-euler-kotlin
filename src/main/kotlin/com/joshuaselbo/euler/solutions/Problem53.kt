package com.joshuaselbo.euler.solutions

import com.joshuaselbo.euler.utils.*

fun problem53() {
    var count = 0
    for (n in 1..100) {
        for (r in 0..n) {
            val nCombinations = choose(n.toBigInteger(), r.toBigInteger())
            if (nCombinations > 1_000_000.toBigInteger()) {
                count++
            }
        }
    }
    println(count)
}