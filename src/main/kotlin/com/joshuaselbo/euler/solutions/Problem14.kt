package com.joshuaselbo.euler.solutions

import com.joshuaselbo.euler.utils.*

fun problem14() {
    var longestChain = 0
    var nWithLongestChain = 0L
    for (i in 2L until 1_000_000L) {
        var chainLen = 0
        var n = i
        while (n != 1L) {
            n = collatz(n)
            chainLen++
        }

        if (chainLen > longestChain) {
            longestChain = chainLen
            nWithLongestChain = i
        }
    }
    println("n with longest chain: $nWithLongestChain")
}

fun collatz(n: Long): Long {
    return if (n % 2 == 0L) {
        n/2
    } else {
        3*n+1
    }
}