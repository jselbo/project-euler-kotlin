package com.joshuaselbo.euler.utils

import java.math.BigDecimal
import java.math.RoundingMode

/**
 * Immutable.
 *
 * @author Jacob Selbo
 */
class Rational(val numerator: Long, val denominator: Long) {

    constructor(value: Long) : this(value, 1)
    constructor(value: Int) : this(value.toLong())
    constructor(numerator: Int, denominator: Int) : this(numerator.toLong(), denominator.toLong())

    fun toDecimal(): Double {
        return numerator.toDouble() / denominator
    }

    /**
     * From the docs of [BigDecimal.divide] with single argument:
     *
     * @throws ArithmeticException – if the exact quotient does not have a terminating decimal expansion
     */
    fun toBigDecimal(): BigDecimal {
        return BigDecimal.valueOf(numerator).divide(BigDecimal.valueOf(denominator))
    }

    fun toBigDecimal(scale: Int, roundingMode: RoundingMode): BigDecimal {
        return BigDecimal.valueOf(numerator).divide(BigDecimal.valueOf(denominator), scale, roundingMode)
    }

    /**
     * Returns a Rational representing the same number but in reduced form.
     */
    fun toReduced(): Rational {
        return if (numerator <= 0 || (isPrime(numerator) && isPrime(denominator))) {
            this
        } else {
            val numeratorFactors = divisors(numerator).sorted()
            val denominatorFactors = divisors(denominator).sorted()
            var useFactor = 1L

            for (factor in numeratorFactors.asReversed()) {
                if (denominatorFactors.contains(factor)) {
                    useFactor = factor
                    break
                }
            }
            Rational(numerator / useFactor, denominator / useFactor)
        }
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
