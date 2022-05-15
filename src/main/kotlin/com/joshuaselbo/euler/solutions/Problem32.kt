package com.joshuaselbo.euler.solutions

import com.joshuaselbo.euler.utils.*

fun problem32() {
    val products = mutableSetOf<Int>() // use set to prevent duplicate products

    for (i in 1..9998) {
        for (j in i..9998) {
            val product = i * j
            val iDigits = i.toDigits()
            val jDigits = j.toDigits()
            val productDigits = product.toDigits()
            val numDigits = iDigits.size + jDigits.size + productDigits.size
            if (numDigits == 9 && isPandigital((iDigits + jDigits + productDigits).toInt())) {
                products.add(product)
            }
        }
    }

    println(products.sum())
}

