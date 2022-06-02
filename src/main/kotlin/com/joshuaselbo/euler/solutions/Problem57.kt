package com.joshuaselbo.euler.solutions

import com.joshuaselbo.euler.utils.BigIntegerRational
import com.joshuaselbo.euler.utils.toDigits
import java.math.BigInteger

/**
 * @author Jacob Selbo
 */
fun problem57() {
    val values = mutableListOf<BigIntegerRational>()
    var total = 0

    var i = 1
    var value = BigIntegerRational(BigInteger.ONE, 2.toBigInteger())

    while (i <= 1000) {
        value = BigIntegerRational(BigInteger.ONE) / (value + 2.toBigInteger())
        values.add(value + BigInteger.ONE)
//        println("$i: ${value+BigInteger.ONE}")
        i++
    }

    for (nth in values)
        if (nth.numerator.toDigits().size > nth.denominator.toDigits().size)
            total++

    println(total)
}