package com.joshuaselbo.euler.solutions

import com.joshuaselbo.euler.utils.*

fun problem3() {
    val primeFactors = primeFactors(600851475143)
    println("largest prime factor: ${primeFactors.last().factor}")
}