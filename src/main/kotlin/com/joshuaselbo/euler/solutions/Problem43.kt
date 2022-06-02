package com.joshuaselbo.euler.solutions

import com.joshuaselbo.euler.utils.*
import java.math.BigInteger
import kotlin.system.exitProcess

fun problem43() {
    // Iterate pandigitals by permutations
    val basePandigital = 9876543210.toDigits()
    var sum = BigInteger.ZERO
    iteratePermutations(basePandigital) { p ->
        if (p.subList(1, 4).toInt() % 2 == 0
            && p.subList(2, 5).toInt() % 3 == 0
            && p.subList(3, 6).toInt() % 5 == 0
            && p.subList(4, 7).toInt() % 7 == 0
            && p.subList(5, 8).toInt() % 11 == 0
            && p.subList(6, 9).toInt() % 13 == 0
            && p.subList(7, 10).toInt() % 17 == 0) {
            sum += p.toBigInteger()
        }
    }
    println(sum)
}
