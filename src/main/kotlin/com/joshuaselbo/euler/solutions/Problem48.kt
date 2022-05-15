package com.joshuaselbo.euler.solutions

import java.math.BigInteger

fun problem48() {
    var sum = BigInteger.ZERO
    for (i in 1..1000) {
        sum += i.toBigInteger().pow(i)
    }

    val str = sum.toString()
    println(str.substring(str.length - 10))
}
