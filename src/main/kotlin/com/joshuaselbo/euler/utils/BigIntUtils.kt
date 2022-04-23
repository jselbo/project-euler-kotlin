package com.joshuaselbo.euler.utils

import java.math.BigInteger

fun BigInteger.toDigits(): List<Int> {
    require(this.signum() != -1)
    return toString().toCharArray().map { Integer.parseInt(it.toString()) }
}

fun List<Int>.toBigInteger(): BigInteger {
    this.forEach { require(it in 0..9) }
    return BigInteger(this.joinToString(separator = "") { it.toString() })
}

fun factorial(n: BigInteger): BigInteger {
    require(n >= BigInteger.ZERO)
    if (n == BigInteger.ZERO) return BigInteger.ONE

    var result = n
    var i = n.minus(BigInteger.ONE)
    while (i >= BigInteger.TWO) {
        result *= i
        i = i.minus(BigInteger.ONE)
    }
    return result
}

fun choose(n: BigInteger, r: BigInteger): BigInteger {
    if (r > n) return BigInteger.ZERO
    return factorial(n) / (factorial(r) * factorial(n - r))
}

fun isPalindrome(n: BigInteger): Boolean {
    val digits = n.toDigits()
    return digits == digits.reversed()
}