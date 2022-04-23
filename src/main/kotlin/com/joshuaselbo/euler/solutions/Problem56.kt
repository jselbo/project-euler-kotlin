package com.joshuaselbo.euler.solutions

import com.joshuaselbo.euler.utils.*
import java.math.BigInteger

fun problem56() {
    var a = BigInteger.ONE
    var maxSum = 0
    while (a < 100.toBigInteger()) {
        for (b in 1..100) {
            val result = a.pow(b)
            val digits = result.toDigits()
            val sum = digits.sum()
            if (sum > maxSum) {
                maxSum = sum
            }
        }
        a++
    }
    println("max sum: $maxSum")
}