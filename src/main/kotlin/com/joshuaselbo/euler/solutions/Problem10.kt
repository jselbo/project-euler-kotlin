package com.joshuaselbo.euler.solutions

import com.joshuaselbo.euler.utils.*
import java.math.BigInteger

fun problem10() {
    var sum = BigInteger.ZERO
    val pi = PrimeIterator()
    var prime = pi.next()
    while (prime <= 2_000_000) {
        sum += prime.toBigInteger()
        prime = pi.next()
    }
    println("sum: $sum")
}