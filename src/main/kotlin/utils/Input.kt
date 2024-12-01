package dev.ketkev.utils

import java.io.File

fun readInput(fileName: String): List<String> =
    File(fileName).readLines()

fun readInputAsString(fileName: String): String =
    File(fileName).readText()

fun readInputAsInts(fileName: String): List<Int> =
    readInput(fileName).map { it.toInt() }
