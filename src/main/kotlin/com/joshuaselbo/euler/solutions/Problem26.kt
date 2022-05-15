package com.joshuaselbo.euler.solutions

import com.joshuaselbo.euler.utils.*
import java.math.RoundingMode

fun problem26() {
    var highDigits = 0
    var d = 0

    for (i in 1..999) {
        val cycle = getRecurringCycle(Rational(1, i)) ?: continue
        if (cycle.size > highDigits) {
            highDigits = cycle.size
            d = i
        }
    }

    println(d)
}

/**
 * This method is absurd and I'm not sure how it works.
 *
 * @return number of recurring digits in the fraction's decimal form. If the decimal
 * does not repeat, this method returns `null`.
 */
private fun getRecurringCycle(rational: Rational): IntArray? {
    try {
        rational.toBigDecimal()
    } catch (ae: ArithmeticException) { // non-terminating decimal check
        val simplified = rational.toReduced()
        val dec = simplified.toBigDecimal(simplified.denominator.toInt() * 2, RoundingMode.DOWN)
        var seq = dec.toString()
        seq = seq.substring(seq.indexOf(".") + 1)
        var i = 0
        while (i < seq.length - 1) {
            val curr = seq.substring(i, i + 1)
            val rest = seq.substring(i + 1)
            val otherLocs = ArrayList<Int>()
            var index = rest.indexOf(curr)
            while (index >= 0) {
                otherLocs.add(index)
                index = rest.indexOf(curr, index + 1)
            }
            for (loc in otherLocs) {
                val tempSeq = seq.substring(i, i + loc + 1)
                val numChecks = (seq.length - tempSeq.length - i - 1) / tempSeq.length
                if (numChecks == 0) continue
                var allChecks = true
                var j = 0
                while (j < numChecks) {
                    val nextSeq = seq.substring(i + (j + 1) * tempSeq.length, i + (j + 2) * tempSeq.length)
                    if (tempSeq != nextSeq) {
                        allChecks = false
                        break
                    }
                    j++
                }
                if (allChecks) {
                    val output = IntArray(tempSeq.length)
                    val chars = tempSeq.toCharArray()
                    var k = 0
                    while (k < chars.size) {
                        output[k] = chars[k].digitToInt()
                        k++
                    }
                    return output
                }
            }
            i++
        }
    }
    return null
}
