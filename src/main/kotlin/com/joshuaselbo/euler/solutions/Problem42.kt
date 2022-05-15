package com.joshuaselbo.euler.solutions

import com.joshuaselbo.euler.utils.*

fun problem42() {
    val words = readLines("p042_words.txt")[0].replace("\"", "").split(",")

    val triangles = mutableListOf<Int>()
    var triangle = 0
    var i = 1
    while (triangle <= 192) {
        triangle = i * (i + 1) / 2
        triangles.add(triangle)
        i++
    }

    val triangleWords = words.count { w -> triangles.contains(getAlphabeticValue(w)) }

    println(triangleWords)
}
