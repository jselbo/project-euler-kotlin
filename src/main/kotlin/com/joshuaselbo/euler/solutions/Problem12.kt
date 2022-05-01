package com.joshuaselbo.euler.solutions

import com.joshuaselbo.euler.utils.*

fun problem12() {
    var triangleNumber = 1
    var i = 2
    while (true) {
        if (divisors(triangleNumber).size >= 500) {
            println(triangleNumber)
            break
        }

        triangleNumber += i
        i++
    }
}