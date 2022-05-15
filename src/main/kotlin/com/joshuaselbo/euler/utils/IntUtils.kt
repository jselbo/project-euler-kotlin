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

fun isPalindrome(s: String): Boolean = s == s.reversed()

private val primeCache = mutableSetOf<Long>()
private var primeCacheEnd = 0L

fun isPrime(n: Int): Boolean = isPrime(n.toLong())

fun isPrime(n: Long): Boolean {
    if (n > primeCacheEnd) {
        for (i in primeCacheEnd + 1..n) {
            if (isPrimeInternal(i)) {
                primeCache.add(i)
            }
        }
        primeCacheEnd = n
    }
    return primeCache.contains(n)
}

fun isPrimeInternal(n: Long): Boolean {
    // Trial division using 6k+-1 optimization
    // Ref: https://en.wikipedia.org/wiki/Primality_test
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

fun primeFactors(n: Int): List<PrimeFactor> = primeFactors(n.toLong())

fun primeFactors(n: Long): List<PrimeFactor> {
    require(n >= 2)

    if (isPrime(n)) {
        return listOf(PrimeFactor(n, 1))
    }

    var running = n

    val primeFactors = mutableListOf<PrimeFactor>()
    for (i in 2..n/2) {
        if (!isPrime(i)) continue
        var exp = 0
        while (running % i == 0L) {
            running /= i
            exp++
        }
        if (exp > 0) {
            primeFactors.add(PrimeFactor(i, exp))
        }
    }
    return primeFactors
}

fun divisors(n: Int): List<Int> = divisors(n.toLong()).map(Long::toInt)

/**
 * Divisors are returned in no particular order.
 */
fun divisors(n: Long): List<Long> = divisorsInternal(n, proper = false)

fun properDivisors(n: Int): List<Int> = properDivisors(n.toLong()).map(Long::toInt)

fun properDivisors(n: Long): List<Long> = divisorsInternal(n, proper = true)

private fun divisorsInternal(n: Long, proper: Boolean): List<Long> {
    require(n > 0)

    val divisors = mutableListOf<Long>(1)
    if (n == 1L) {
        return divisors
    }
    if (!proper) {
        divisors.add(n)
    }
    for (i in 2..sqrt(n.toDouble()).toLong()) {
        if (n % i == 0L) {
            divisors.add(i)
            if (i != n / i) {
                divisors.add(n / i)
            }
        }
    }
    return divisors
}

fun factorial(n: Int): Int = factorial(n.toLong()).toInt()

fun factorial(n: Long): Long {
    if (n == 0L) return 1

    var product = n
    for (i in 2 until n) {
        product *= i
    }
    return product
}

fun isPandigital(num: Int): Boolean {
    val digits = num.toDigits()
    if (digits.size > 9) return false
    for (i in 1..digits.size) {
        var contains = false
        for (j in digits.indices) {
            if (i == digits[j]) {
                contains = true
                break
            }
        }
        if (!contains) return false
    }
    return true
}