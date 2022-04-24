package com.joshuaselbo.euler.utils

/**
 * Sequence starting with 1, 1, 2, 3, 5, 8, ...
 */
class FibonacciIterator : Iterator<Int> {

    private var lastValue = 0
    private var currentValue = 1

    override fun hasNext(): Boolean = true

    override fun next(): Int {
        val valueToReturn = currentValue
        val nextValue = lastValue + currentValue
        lastValue = currentValue
        currentValue = nextValue
        return valueToReturn
    }
}