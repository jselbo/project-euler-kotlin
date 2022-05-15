package com.joshuaselbo.euler.solutions

import java.math.BigInteger

fun problem29() {
    val terms = mutableSetOf<BigInteger>()
    var a = BigInteger.TWO
    while (a.toInt() <= 100) {
        for (b in 2..100) {
            terms.add(a.pow(b))
        }
        a++
    }

    println(terms.size)
}
