package com.joshuaselbo.euler.solutions

import com.joshuaselbo.euler.utils.*

fun problem36() {
    var sum = 0
    for (i in 0..999999) {
        val binary = Integer.toBinaryString(i)
        if (isPalindrome(i) && isPalindrome(binary)) {
            sum += i
        }
    }

    println(sum)
}
