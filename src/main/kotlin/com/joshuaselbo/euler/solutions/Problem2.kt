package com.joshuaselbo.euler.solutions

import com.joshuaselbo.euler.utils.*

fun problem2() {
    val fi = FibonacciIterator()
    var sum = 0
    do {
        val fibonacciTerm = fi.next()
        if (fibonacciTerm % 2 == 0) {
            sum += fibonacciTerm
        }
    } while (fibonacciTerm <= 4_000_000)
    println("result: $sum")
}