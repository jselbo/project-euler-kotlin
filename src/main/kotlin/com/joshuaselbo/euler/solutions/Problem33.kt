package com.joshuaselbo.euler.solutions

import com.joshuaselbo.euler.utils.*

fun problem33() {
    val fractions = mutableListOf<Rational>()
    for (i in 10..99) {
        for (j in i + 1..99) {
            val dec = i.toFloat() / j.toFloat()
            val iDigits = i.toDigits().toIntArray()
            val jDigits = j.toDigits().toIntArray()
            if (iDigits[0] == iDigits[1] && jDigits[0] == jDigits[1]) {
                continue
            }
            var eligible = false
            search@ for (k in iDigits.indices) {
                for (p in jDigits.indices) {
                    if (iDigits[k] == jDigits[p] && iDigits[k] != 0) {
                        iDigits[k] = -1
                        jDigits[p] = -1
                        eligible = true
                        break@search
                    }
                }
            }
            if (!eligible) continue
            var newI = 0
            for (k in iDigits.indices) {
                if (iDigits[k] != -1) {
                    newI = iDigits[k]
                }
            }
            var newJ = 0
            for (k in jDigits.indices) {
                if (jDigits[k] != -1) {
                    newJ = jDigits[k]
                }
            }
            var newDec = -1f
            if (newJ != 0) {
                newDec = newI.toFloat() / newJ.toFloat()
            }
            if (dec == newDec) {
                fractions.add(Rational(newI, newJ))
            }
        }
    }
    require(fractions.size == 4)
    val product = fractions.reduce(Rational::times)
    println(product.toReduced())
}
