package dev.ketkev.days

import dev.ketkev.utils.readInput
import kotlin.math.abs

class Day01 : Day {
    override fun part1(): Int {
        val lines = readInput("input/day01.txt")

        val left = mutableListOf<Int>()
        val right = mutableListOf<Int>()

        for (line in lines) {
            val test = line.split("   ")
            left.add(test[0].toInt())
            right.add(test[1].toInt())
        }

        val leftSorted = left.sorted()
        val rightSorted = right.sorted()

        val res = leftSorted.zip(rightSorted).fold(0) { sum, (left, right) -> sum + abs(left - right) }

        return res
    }

    override fun part2(): Int {
        val lines = readInput("input/day01.txt")

        val left = mutableListOf<Int>()
        val right = mutableMapOf<Int, Int>()

        for (line in lines) {
            val (leftNum, rightNum) = line.split("   ").map { it.toInt() }
            left.add(leftNum)

            right[rightNum] = right.getOrDefault(rightNum, 0) + 1
        }

        val similarityScore = left.fold(0) { sum, num -> sum + num * right.getOrDefault(num, 0) }

        return similarityScore
    }

    override fun getDayNumber(): Int {
        return 1
    }
}