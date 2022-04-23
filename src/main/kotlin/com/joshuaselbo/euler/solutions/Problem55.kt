package com.joshuaselbo.euler.solutions

import com.joshuaselbo.euler.utils.*
import java.math.BigInteger

fun problem55() {
    var lychrelCount = 0
    var n = BigInteger.ONE
    while (n <= BigInteger.valueOf(10_000)) {
        var working = n
        var foundPalindrome = false
        for (i in 1..50) {
            val digits = working.toDigits()
            val workingRev = digits.reversed().toBigInteger()
            working += workingRev
            if (isPalindrome(working)) {
                foundPalindrome = true
                break
            }
        }
        if (!foundPalindrome) {
            lychrelCount++
        }
        n++
    }
    println("count: $lychrelCount")
}