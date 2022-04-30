package com.joshuaselbo.euler.solutions

import com.joshuaselbo.euler.utils.*

fun problem9() {
    val sum = 1000
    for (a in 1..sum-2) {
        for (b in 1..sum-a-1) {
            val c = sum-a-b
            if (a*a + b*b == c*c) {
                println("found a=$a, b=$b, c=$c")
                println("product=${a*b*c}")
                return
            }
        }
    }
}