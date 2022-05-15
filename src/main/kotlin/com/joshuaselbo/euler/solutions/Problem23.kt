package com.joshuaselbo.euler.solutions

import com.joshuaselbo.euler.utils.*

// Slow
fun problem23() {
    val abundants = ArrayList<Int>()

    var sum = 0L
    for (i in 1..28123) {
        if (isAbundant(i)) abundants.add(i)
        var sumOfAbundants = false
        search@ for (j in abundants.indices) {
            for (k in j until abundants.size) {
                if (abundants[j] + abundants[k] == i) {
                    sumOfAbundants = true
                    break@search
                }
            }
        }
        if (!sumOfAbundants) {
            sum += i.toLong()
        }
    }

    println(sum)
}

private fun isAbundant(num: Int): Boolean {
    return properDivisors(num).sum() > num
}
