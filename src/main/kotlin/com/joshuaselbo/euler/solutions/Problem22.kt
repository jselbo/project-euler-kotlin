package com.joshuaselbo.euler.solutions

import com.joshuaselbo.euler.utils.*

fun problem22() {
    val names = readLines("p022_names.txt")[0].split(",").sorted()
    var sum = 0
    for (i in names.indices) {
        sum += (i + 1) * getAlphabeticValue(names[i].trim('"'))
    }
    println(sum)
}
