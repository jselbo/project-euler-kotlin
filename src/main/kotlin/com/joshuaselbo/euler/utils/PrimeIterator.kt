package com.joshuaselbo.euler.utils

class PrimeIterator(nth: Int = 1): Iterator<Int> {

    private var nextPrime = 2

    init {
        if (nth < 1) throw IllegalArgumentException()

        for (i in 1 until nth) {
            next()
        }
    }

    override fun hasNext(): Boolean = true

    override fun next(): Int {
        val ret = nextPrime

        if (nextPrime == 2) {
            nextPrime = 3
        } else {
            // Check odd numbers until we find the next prime
            do {
                nextPrime += 2
            } while (!isPrime(nextPrime))
        }

        return ret
    }

}
