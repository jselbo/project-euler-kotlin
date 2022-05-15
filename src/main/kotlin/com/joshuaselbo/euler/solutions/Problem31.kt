package com.joshuaselbo.euler.solutions

fun problem31() {
    val coins = intArrayOf(1, 2, 5, 10, 20, 50, 100, 200)

    // embarrassing...
    var ways = 0
    for (a in 0..200 / coins[0]) {
        for (b in 0..200 / coins[1]) {
            for (c in 0..200 / coins[2]) {
                for (d in 0..200 / coins[3]) {
                    for (e in 0..200 / coins[4]) {
                        for (f in 0..200 / coins[5]) {
                            for (g in 0..200 / coins[6]) {
                                for (h in 0..200 / coins[7]) {
                                    if (coins[0] * a
                                        + coins[1] * b
                                        + coins[2] * c
                                        + coins[3] * d
                                        + coins[4] * e
                                        + coins[5] * f
                                        + coins[6] * g
                                        + coins[7] * h == 200) {
                                        ways++
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    println(ways)
}
