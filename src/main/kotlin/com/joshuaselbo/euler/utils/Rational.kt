package com.joshuaselbo.euler.utils

/**
 * Immutable.
 *
 * @author Jacob Selbo
 */
class Rational(val numerator: Long, val denominator: Long) {

    constructor(value: Long) : this(value, 1)
    constructor(value: Int) : this(value.toLong())

    fun asDecimal(): Double {
        return numerator.toDouble() / denominator
    }

    operator fun plus(other: Rational): Rational {
        // todo could compute gcd
        val newDenominator = denominator * other.denominator
        val thisNumerator = numerator * other.denominator
        val otherNumerator = other.numerator * denominator

        return Rational(thisNumerator + otherNumerator, newDenominator)
    }

    operator fun unaryMinus(): Rational = Rational(-numerator, denominator)

    operator fun minus(other: Rational): Rational = plus(-other)

    operator fun times(other: Rational): Rational {
        return Rational(numerator * other.numerator, denominator * other.denominator)
    }

    operator fun div(other: Rational): Rational = this * other.reciprocal()

    operator fun plus(other: Int): Rational = this + Rational(other)
    operator fun minus(other: Int): Rational = this - Rational(other)
    operator fun times(other: Int): Rational = this * Rational(other)
    operator fun div(other: Int): Rational = this / Rational(other)

    fun reciprocal(): Rational {
        return Rational(denominator, numerator)
    }

    override fun toString(): String {
        return "$numerator/$denominator"
    }

    override fun equals(other: Any?): Boolean {
        return if (other is Rational)
            numerator == other.numerator && denominator == other.denominator
        else false
    }

    init {
        require(denominator != (0).toLong()) { "Denominator can't be 0, since the result would be undefined" }
        require(denominator > 0) { "Denominator must be greater than 0" }
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