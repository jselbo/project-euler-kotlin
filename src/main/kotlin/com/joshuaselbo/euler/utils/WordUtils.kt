package com.joshuaselbo.euler.utils

fun getAlphabeticValue(word: String): Int {
    return word.sumOf { c -> Character.getNumericValue(c) - 9 }
}