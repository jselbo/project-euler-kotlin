package com.joshuaselbo.euler.solutions

import com.joshuaselbo.euler.utils.primeFactors

fun problem47() {
    var i = 2
    var found = false
    while (!found) {
        if (primeFactors(i).size == 4) {
            found = true
            for (j in 1..3) {
                if (primeFactors(i + j).size != 4) {
                    found = false
                    i += j+1
                    break
                }
            }
        } else {
            i++
        }
    }

    println(i)
}
