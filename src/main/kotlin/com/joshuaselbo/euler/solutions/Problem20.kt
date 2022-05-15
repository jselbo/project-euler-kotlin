package com.joshuaselbo.euler.solutions

import com.joshuaselbo.euler.utils.factorial
import com.joshuaselbo.euler.utils.toDigits
import java.math.BigInteger

fun problem20() {
    val num = factorial(BigInteger("100"))
    val sum = num.toDigits().sum()
    println(sum)
}
