package com.joshuaselbo.euler.solutions

import com.joshuaselbo.euler.utils.*

fun problem41() {
    var high = 0
    for (i in 0..99999999) {
        if (isPandigital(i) && isPrime(i) && i > high) {
            high = i
        }
    }

    println(high)
}
