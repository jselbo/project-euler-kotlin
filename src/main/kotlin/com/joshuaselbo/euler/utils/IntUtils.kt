package com.joshuaselbo.euler.utils

import kotlin.math.ceil
import kotlin.math.sqrt

/**
 * Converts Int to list of digits. Only valid for non-negative numbers.
 *
 * e.g. 503 -> [5, 0, 3]
 */
fun Int.toDigits(): List<Int> {
    require(this >= 0)
    if (this == 0) {
        return listOf(0)
    }

    val digits = mutableListOf<Int>()
    var n = this
    while (n > 0) {
        digits.add(n % 10)
        n /= 10
    }
    return digits.reversed()
}

/**
 * Converts list of digits to Int. Leading zeros are trimmed.
 *
 * e.g. [5, 0, 3] -> 503
 */
fun List<Int>.toInt(): Int {
    var n = 0
    var tens = 1
    for (d in this.asReversed()) {
        require(d in 0..9)
        n += d * tens
        tens *= 10
    }
    return n
}

fun isPalindrome(n: Int): Boolean {
    val digits = n.toDigits()
    return digits == digits.reversed()
}

/**
 * Trial division using 6k+-1 optimization
 *
 * Ref: https://en.wikipedia.org/wiki/Primality_test
 */
fun isPrime(n: Int): Boolean {
    if (n <= 1) return false
    if (n == 2 || n == 3) return true
    if (n % 2 == 0 || n % 3 == 0) return false

    var k = 6
    // while k <= sqrt(n)
    while (k * k <= n) {
        if (n % (k - 1) == 0) return false
        if (n % (k + 1) == 0) return false
        k += 6
    }
    return true
}

data class PrimeFactor(val factor: Int, val exp: Int) {
    override fun toString(): String {
        return "$factor^$exp"
    }
}

fun primeFactors(n: Int): List<PrimeFactor> {
    require(n >= 2)
    var running = n

    val pi = PrimeIterator()
    var prime = pi.next()
    val primeFactors = mutableListOf<PrimeFactor>()
    while (prime <= ceil(sqrt(n.toDouble()))) {
        var exp = 0
        while (running % prime == 0) {
            running /= prime
            exp++
        }
        if (exp > 0) {
            primeFactors.add(PrimeFactor(prime, exp))
        }
        prime = pi.next()
    }
    return primeFactors
}
