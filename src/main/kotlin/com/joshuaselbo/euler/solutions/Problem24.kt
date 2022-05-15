package com.joshuaselbo.euler.solutions

import kotlin.system.exitProcess

private var counter = 0

fun problem24() {
    val perm = "0123456789"
    permute("", perm)
}

private fun permute(str: String, chars: String) {
    if (chars.length <= 1) {
        counter++
        if (counter == 1000000) {
            println(str + chars)
            exitProcess(0)
        }
    } else {
        for (i in chars.indices) {
            val newString = chars.substring(0, i) + chars.substring(i + 1)
            permute(str + chars[i], newString)
        }
    }
}