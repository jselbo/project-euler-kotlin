package com.joshuaselbo.euler.solutions

import com.joshuaselbo.euler.utils.toDigits
import java.math.BigInteger

fun problem16() {
    val n = 2.toBigInteger().pow(1000)
    println("sum of digits: ${n.toDigits().sum()}")
}