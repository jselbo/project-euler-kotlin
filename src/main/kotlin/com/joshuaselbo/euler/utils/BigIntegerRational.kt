package com.joshuaselbo.euler.utils

import java.math.BigInteger

/**
 * Immutable.
 *
 * @author Jacob Selbo
 */
class BigIntegerRational(val numerator: BigInteger, val denominator: BigInteger) {

    constructor(value: BigInteger) : this(value, BigInteger.ONE)

    operator fun plus(other: BigIntegerRational): BigIntegerRational {
        // todo could compute gcd
        val newDenominator = denominator * other.denominator
        val thisNumerator = numerator * other.denominator
        val otherNumerator = other.numerator * denominator

        return BigIntegerRational(thisNumerator + otherNumerator, newDenominator)
    }

    operator fun unaryMinus(): BigIntegerRational = BigIntegerRational(-numerator, denominator)

    operator fun minus(other: BigIntegerRational): BigIntegerRational = plus(-other)

    operator fun times(other: BigIntegerRational): BigIntegerRational {
        return BigIntegerRational(numerator * other.numerator, denominator * other.denominator)
    }

    operator fun div(other: BigIntegerRational): BigIntegerRational = this * other.reciprocal()

    operator fun plus(other: BigInteger): BigIntegerRational = this + BigIntegerRational(other)
    operator fun minus(other: BigInteger): BigIntegerRational = this - BigIntegerRational(other)
    operator fun times(other: BigInteger): BigIntegerRational = this * BigIntegerRational(other)
    operator fun div(other: BigInteger): BigIntegerRational = this / BigIntegerRational(other)

    fun reciprocal(): BigIntegerRational {
        return BigIntegerRational(denominator, numerator)
    }

    override fun toString(): String {
        return "$numerator/$denominator"
    }

    override fun equals(other: Any?): Boolean {
        return if (other is BigIntegerRational)
            numerator == other.numerator && denominator == other.denominator
        else false
    }

    override fun hashCode(): Int {
        var result = numerator.hashCode()
        result = 31 * result + denominator.hashCode()
        return result
    }

    init {
        require(denominator != BigInteger.ZERO) { "Denominator can't be 0, since the result would be undefined" }
        require(denominator > BigInteger.ZERO) { "Denominator must be greater than 0" }
    }
}
/*
    // This reduces a fraction, but it increases time complexity massively

    if (numerator > 0 && (!isPrime(numerator) || !isPrime(denominator))) {
        val numeratorFactors = divisors(numerator).sorted()
        val denominatorFactors = divisors(denominator).sorted()
        var useFactor: Long = 1

        for (factor in numeratorFactors.reversed()) {
            if (denominatorFactors.contains(factor)) {
                useFactor = factor
                break
            }
        }

        this.numerator = numerator / useFactor
        this.denominator = denominator / useFactor
    } else {
        this.numerator = numerator
        this.denominator = denominator
    }
 */