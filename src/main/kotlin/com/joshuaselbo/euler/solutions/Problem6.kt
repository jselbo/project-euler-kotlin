package com.joshuaselbo.euler.solutions

import com.joshuaselbo.euler.utils.*

fun problem6() {
    val sumOfSquares = (1..100).map { n -> n.toBigInteger() }.map { n -> n*n }.sumOf { it }
    val sum = (1..100).map { n -> n.toBigInteger() }.sumOf { it }
    val squareOfSum = sum * sum
    val diff = squareOfSum - sumOfSquares
    println("result: $diff")
}