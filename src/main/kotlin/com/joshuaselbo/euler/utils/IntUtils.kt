package com.joshuaselbo.euler.utils

import kotlin.math.ceil
import kotlin.math.sqrt

fun Int.toDigits(): List<Int> = toLong().toDigits()

/**
 * Converts Long to list of digits. Only valid for non-negative numbers.
 *
 * e.g. 503 -> [5, 0, 3]
 */
fun Long.toDigits(): List<Int> {
    require(this >= 0)
    if (this == 0L) {
        return listOf(0)
    }

    val digits = mutableListOf<Int>()
    var n = this
    while (n > 0) {
        digits.add((n % 10).toInt())
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

fun isPalindrome(n: Int): Boolean = isPalindrome(n.toLong())

fun isPalindrome(n: Long): Boolean {
    val digits = n.toDigits()
    return digits == digits.reversed()
}

fun isPrime(n: Int): Boolean = isPrime(n.toLong())

/**
 * Trial division using 6k+-1 optimization
 *
 * Ref: https://en.wikipedia.org/wiki/Primality_test
 */
fun isPrime(n: Long): Boolean {
    if (n <= 1) return false
    if (n == 2L || n == 3L) return true
    if (n % 2 == 0L || n % 3 == 0L) return false

    var k = 6
    while (k - 1 <= sqrt(n.toDouble())) {
        if (n % (k - 1) == 0L) return false
        if (n % (k + 1) == 0L) return false
        k += 6
    }
    return true
}

data class PrimeFactor(val factor: Long, val exp: Int) {
    override fun toString(): String {
        return "$factor^$exp"
    }
}

fun primeFactors(n: Long): List<PrimeFactor> {
    require(n >= 2)
    var running = n

    val pi = PrimeIterator()
    var prime = pi.next()
    val primeFactors = mutableListOf<PrimeFactor>()
    while (prime <= ceil(sqrt(n.toDouble()))) {
        var exp = 0
        while (running % prime == 0L) {
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
