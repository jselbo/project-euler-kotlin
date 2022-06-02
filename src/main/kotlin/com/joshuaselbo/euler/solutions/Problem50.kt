package com.joshuaselbo.euler.solutions

import com.joshuaselbo.euler.utils.*

fun problem50() {
    // To find upper bound of prime length search:
    // Result: 546
//    val pi = PrimeIterator()
//    var sum = 0L
//    var n = 0
//    while (true) {
//        sum += pi.next()
//        if (sum > 1_000_000L) {
//            break
//        }
//        n++
//    }
//    println(n)

    val lengthUpperBound = 546
    val primes = PrimeIterator.generate(lengthUpperBound).asList()

    for (length in primes.size downTo 1) {
        for (startIndex in 0..primes.size-length) {
            val sum = primes.subList(startIndex, startIndex+length).sum()
            if (isPrime(sum)) {
                println(sum)
                return
            }
        }
    }
}
