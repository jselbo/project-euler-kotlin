package com.joshuaselbo.euler.solutions

import com.joshuaselbo.euler.utils.isPandigital

fun problem38() {
    val upperBoundSearch = 10_000

    var maxPandigital = 0
    for (productRangeEnd in 2..9) {
        for (n in 1..upperBoundSearch) {
            val productRange = 1..productRangeEnd
            val products = productRange.map { p -> p*n }
            val concat = products.map(Int::toString).reduce(String::plus)

            if (concat.length != 9) {
                continue
            }
            val num = concat.toInt()
            if (num > maxPandigital && isPandigital(num)) {
                maxPandigital = num
            }
        }
    }
    println(maxPandigital)
}
