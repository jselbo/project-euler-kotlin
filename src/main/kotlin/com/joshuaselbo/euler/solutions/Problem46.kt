package com.joshuaselbo.euler.solutions

import com.joshuaselbo.euler.utils.*
import kotlin.math.floor
import kotlin.math.sqrt

fun problem46() {
    val primes = mutableListOf<Int>()

    var i = 3
    search@ while (true) {
        if (isPrime(i)) {
            primes.add(i)
        } else {
            for (prime in primes) {
                val temp = sqrt((i - prime).toDouble() / 2.0)
                if (floor(temp) == temp) {
                    i += 2
                    continue@search
                }
            }
            println(i)
            break
        }
        i += 2
    }
}
