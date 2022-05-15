package com.joshuaselbo.euler.solutions

import com.joshuaselbo.euler.utils.*

fun problem37() {
    var sum = 0
    var numFound = 0
    var i = 10
    search@ while (numFound < 11) {
        var s = i.toString()

        // truncate left to right
        var len = s.length
        for (j in 0 until len) {
            if (!isPrime(s.toInt())) {
                i++
                continue@search
            }
            s = s.substring(1)
        }

        // truncate right to left
        s = i.toString()
        len = s.length
        for (j in 0 until len) {
            if (!isPrime(s.toInt())) {
                i++
                continue@search
            }
            s = s.substring(0, s.length - 1)
        }
        sum += i
        numFound++
        i++
    }

    println(sum)
}
