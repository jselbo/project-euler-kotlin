package com.joshuaselbo.euler.solutions

fun problem1() {
    val result = (1..999).filter { n -> n % 3 == 0 || n % 5 == 0 }.sum()
    println("sum: $result")
}