package com.joshuaselbo.euler.solutions

import com.joshuaselbo.euler.utils.*

fun problem21() {
    val amicableNums = ArrayList<Int>()

    for (i in 1..9999) {
        val divs1 = properDivisors(i)
        val sum1 = divs1.sum()
        if (sum1 == i) {
            continue
        }

        val divs2 = properDivisors(sum1)
        val sum2 = divs2.sum()
        if (sum2 == i && !amicableNums.contains(i)) {
            amicableNums.add(i)
            amicableNums.add(sum1)
        }
    }

    val sum = amicableNums.sum()
    println(sum)
}
