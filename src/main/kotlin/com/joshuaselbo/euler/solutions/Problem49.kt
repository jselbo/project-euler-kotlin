package com.joshuaselbo.euler.solutions

import com.joshuaselbo.euler.utils.isPrime

fun problem49() {
    var i = 1489
    search@ while (i < 10000) {
        if (!isPrime(i)) {
            i += 2
            continue
        }
        val upperBound = (10000 - i) / 2
        var j = 2
        while (j <= upperBound) {
            val i2 = i + j
            val i3 = i + 2 * j
            if (isPrime(i2) && isPrime(i3) && arePermutations(i, i2, i3)) {
                println(i.toString() + "" + i2 + "" + i3)
                break@search
            }
            j += 2
        }
        i += 2
    }
}

private fun arePermutations(vararg nums: Int): Boolean {
    val first = nums[0].toString()
    val firstChars = first.toCharArray()
    for (i in 1 until nums.size) {
        val curr = nums[i].toString()
        val chars = curr.toCharArray()
        for (c in chars) {
            if (first.indexOf(c) == -1) {
                return false
            }
        }
        for (c in firstChars) {
            if (curr.indexOf(c) == -1) {
                return false
            }
        }
    }
    return true
}
