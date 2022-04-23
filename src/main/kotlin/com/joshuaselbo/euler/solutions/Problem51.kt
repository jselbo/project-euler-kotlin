package com.joshuaselbo.euler.solutions

import com.joshuaselbo.euler.utils.*

private val ALL_DIGITS = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

fun problem51() {
    val start = 56003
    val familylen = 8

    val pi = PrimeIterator()
    var prime: Int
    do {
        prime = pi.next()
    } while (prime < start)

    while (true) {
        val digits = prime.toDigits()
        val ndigits = digits.size

        // 5,6,0,0,3
        for (numDigitsToReplace in 1 until digits.size) {
            val indices = (0 until ndigits).toList()
            val combinations = allCombinations(indices, numDigitsToReplace)
            for (combination in combinations) {
                var nPrimesInFamily = 0
                val primes = mutableListOf<Int>()
                for (digit in ALL_DIGITS) {
                    if (digit == 0 && combination.contains(0)) {
                        continue
                    }

                    val candidateDigits = digits.toMutableList()
                    for (index in combination) {
                        candidateDigits[index] = digit
                    }
                    if (isPrime(candidateDigits.toInt())) {
                        nPrimesInFamily++
                        primes.add(candidateDigits.toInt())
                    }
                }
                if (nPrimesInFamily >= familylen) {
                    println("found $familylen prime family!!!")
                    println("primes: $primes")
                    println("replacing indices $combination")
                    return
                }
            }
        }

        prime = pi.next()
    }
}