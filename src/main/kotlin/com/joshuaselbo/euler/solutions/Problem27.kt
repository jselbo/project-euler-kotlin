package com.joshuaselbo.euler.solutions

import com.joshuaselbo.euler.utils.isPrime

fun problem27() {
    var highPrimes = 0
    var a = 0
    var b = 0

    for (ai in -999..999) {
        for (bi in -999..999) {
            var numPrimes = 0
            var prime = true
            var n = 0
            while (prime) {
                val output = n * n + ai * n + bi
                prime = isPrime(output)
                if (prime) numPrimes++
                n++
            }
            if (numPrimes > highPrimes) {
                highPrimes = numPrimes
                a = ai
                b = bi
            }
        }
    }

    val product = a * b
    println(product)
}
