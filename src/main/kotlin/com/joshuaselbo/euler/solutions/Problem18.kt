package com.joshuaselbo.euler.solutions

import com.joshuaselbo.euler.utils.*
import java.io.BufferedReader
import kotlin.math.max

fun problem18() {
    val lines = readLines("p18_triangle.txt")

    val triangle = Array(lines.size) { i -> IntArray(i+1) }
    for (i in lines.indices) {
        val digitStrs = lines[i].split(" ")
        for (j in digitStrs.indices) {
            triangle[i][j] = digitStrs[j].toInt()
        }
    }

    for (i in triangle.size-2 downTo 0) {
        val rowNumbers = triangle[i]
        for (j in rowNumbers.indices) {
            triangle[i][j] += max(triangle[i+1][j], triangle[i+1][j+1])
        }
    }
    val maxSum = triangle[0][0]
    println("max sum: $maxSum")
}