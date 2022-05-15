package com.joshuaselbo.euler.solutions

import kotlin.math.floor
import kotlin.math.sqrt

fun problem45() {
    var term: Long = 0
    var n = 286
    while (!isPentagonal(term)) {
        term = (n * (2 * n - 1)).toLong() // all hexagonals are triangle
        n++
    }

    println(term)
}

private fun isPentagonal(num: Long): Boolean {
    val n = (1 + sqrt((1 + 24 * num).toDouble())) / 6.0
    return floor(n) == n
}
