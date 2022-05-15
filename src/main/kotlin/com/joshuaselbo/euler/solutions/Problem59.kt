package com.joshuaselbo.euler.solutions

import com.joshuaselbo.euler.utils.readLines

/**
 * @author Jacob Selbo
 */
fun problem59() {
    fun xor(input: List<Int>, password: List<Int>): List<Int> {
        val output = mutableListOf<Int>()
        var indexPassword = 0

        for (charInt in input) {
            output.add(charInt.xor(password[indexPassword]))

            if (indexPassword == 2)
                indexPassword = 0
            else
                indexPassword++
        }

        return output
    }

    val cipherLine = readLines("p059_cipher.txt")[0]

    val cipherInts = cipherLine.split(',').map { it.toInt() }

    val aCode = 'a'.code
    val zCode = 'z'.code

    for (a in aCode ..zCode) {
        for (b in aCode..zCode) {
            for (c in aCode..zCode) {
                val output = xor(cipherInts, listOf(a, b, c))
                val chars = output.map { it.toChar() }.joinToString(separator = "")

                // Check alphanumeric, punctuation ascii range
                if (chars.all { it in 32.toChar()..126.toChar() }
                    // Check for common words and hope to get lucky
                    // Could also scan dictionary but that could be expensive
                    && chars.contains(" the ")
                    && chars.contains(" to ")
                    && chars.contains(" of ")
                    && chars.contains(" and ")) {
                    val asciiValueSum = output.sum()

                    println("str: $chars")
                    println("ascii sum: $asciiValueSum")
                }
            }
        }
    }
}