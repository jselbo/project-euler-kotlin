package com.joshuaselbo.euler.solutions

import com.joshuaselbo.euler.utils.*

fun problem5() {
    val divisors = (1..20).toList()
    var n = 1
    while (true) {
        if (divisors.all { d -> n % d == 0 }) {
            println("found: $n")
            break
        }
        n++
    }
}