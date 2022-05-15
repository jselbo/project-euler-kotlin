package com.joshuaselbo.euler.solutions

import com.joshuaselbo.euler.utils.*

fun problem35() {
    var circularPrimes = 0
    for (i in 1..999999) {
        if (isPrime(i)) {
            var allPrimes = true
            val rotations = getRotations(i)
            for (j in 1 until rotations.size) {
                if (!isPrime(rotations[j])) {
                    allPrimes = false
                    break
                }
            }
            if (allPrimes) circularPrimes++
        }
    }

    println(circularPrimes)
}

fun getRotations(num: Int): IntArray {
    val rotations = IntArray(num.toDigits().size)
    rotations[0] = num
    for (i in 1 until rotations.size) {
        var str = rotations[i - 1].toString()
        val c = str.substring(str.length - 1)
        str = c + str.substring(0, str.length - 1)
        rotations[i] = str.toInt()
    }
    return rotations
}
