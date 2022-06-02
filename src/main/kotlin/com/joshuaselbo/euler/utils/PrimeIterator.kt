package com.joshuaselbo.euler.utils

class PrimeIterator(nth: Int = 1): Iterator<Long> {

    private var nextPrime = 2L

    init {
        if (nth < 1) throw IllegalArgumentException()

        for (i in 1 until nth) {
            next()
        }
    }

    override fun hasNext(): Boolean = true

    override fun next(): Long {
        val ret = nextPrime

        if (nextPrime == 2L) {
            nextPrime = 3
        } else {
            // Check odd numbers until we find the next prime
            do {
                nextPrime += 2
            } while (!isPrime(nextPrime))
        }

        return ret
    }

    companion object {

        /** Returns array of [n] primes. */
        fun generate(n: Int): LongArray {
            val pi = PrimeIterator()
            return LongArray(n) { pi.next() }
        }
    }
}
