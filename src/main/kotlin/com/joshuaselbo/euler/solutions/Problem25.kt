package com.joshuaselbo.euler.solutions

import com.joshuaselbo.euler.utils.*
import java.math.BigInteger

fun problem25() {
    val it = BigIntegerFibonacciIterator()
    var value: BigInteger
    var counter = 0
    do {
        value = it.next()
        counter++
    } while (value.toDigits().size < 1000)
    println(counter)
}
