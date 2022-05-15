package com.joshuaselbo.euler.utils

import java.math.BigInteger

class BigIntegerFibonacciIterator: Iterator<BigInteger> {

    private var lastValue = BigInteger.ZERO
    private var currentValue = BigInteger.ONE

    override fun hasNext(): Boolean = true

    override fun next(): BigInteger {
        val valueToReturn = currentValue
        val nextValue = lastValue + currentValue
        lastValue = currentValue
        currentValue = nextValue
        return valueToReturn
    }
}