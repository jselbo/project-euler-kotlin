package com.joshuaselbo.euler.utils

import java.io.BufferedReader
import java.io.InputStream

class DummyClass

fun openFile(fileName: String): InputStream {
    return DummyClass::class.java.classLoader.getResourceAsStream(fileName) ?: throw RuntimeException()
}

fun readLines(fileName: String): List<String> {
    return openFile(fileName).bufferedReader().use(BufferedReader::readLines)
}
