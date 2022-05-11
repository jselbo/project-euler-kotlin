package com.joshuaselbo.euler.solutions

import com.joshuaselbo.euler.utils.toDigits

fun problem92() {
    var total = 0

    for (number in 1..10_000_000) {
        var currentNumber = number

        while (currentNumber != 1 && currentNumber != 89)
            currentNumber = currentNumber.toDigits().sumOf { it * it }

        if (currentNumber == 89)
            total++
    }

    println(total)
}