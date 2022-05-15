package com.joshuaselbo.euler.solutions

import com.joshuaselbo.euler.utils.*

fun problem40() {
    var digitCounter = 0
    var expr = 1
    var destDigits = 1
    var i = 1
    while (destDigits < 1000000) {
        val digs = i.toDigits()
        if (digitCounter + digs.size >= destDigits) {
            val offset = digitCounter + digs.size - destDigits
            expr *= digs[digs.size - 1 - offset]
            destDigits *= 10
        }
        digitCounter += digs.size
        i++
    }

    println(expr)
}
