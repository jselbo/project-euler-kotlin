package com.joshuaselbo.euler.solutions

import java.io.BufferedReader
import kotlin.math.max

fun problem67() {
    val inputStream = DummyClass::class.java.classLoader.getResourceAsStream("p067_triangle.txt") ?: throw RuntimeException()
    val lines = inputStream.bufferedReader().use(BufferedReader::readLines)
    inputStream.close()

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