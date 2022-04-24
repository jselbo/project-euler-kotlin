package com.joshuaselbo.euler.solutions

import com.joshuaselbo.euler.utils.*

fun problem4() {
    var largest = 0
    for (i in 100..999) {
        for (j in 100..999) {
            val product = i * j
            if (product > largest && isPalindrome(product)) {
                largest = product
            }
        }
    }
    println("largest: $largest")
}