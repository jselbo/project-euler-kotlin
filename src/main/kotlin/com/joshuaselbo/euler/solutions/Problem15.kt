package com.joshuaselbo.euler.solutions

fun problem15() {
    val size = 20

    val paths = Array(size + 1) { LongArray(size + 1) }

    for (i in paths.indices) {
        for (j in paths[i].indices) {
            if (i == 0 && j == 0) {
                paths[i][j] = 0
            } else if (i == 0 || j == 0) {
                paths[i][j] = 1
            } else {
                paths[i][j] = paths[i - 1][j] + paths[i][j - 1]
            }
        }
    }

    println("${paths[20][20]}")
}