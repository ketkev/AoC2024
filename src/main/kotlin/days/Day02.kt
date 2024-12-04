package dev.ketkev.days

import dev.ketkev.utils.readInput
import kotlin.math.abs

class Day02 : Day {
    override fun part1(): Int {
        val reports = readInput("input/day02.txt").map { it.split(" ").map { level -> level.toInt() } }

        var count = 0

        for (report in reports) {
            val alwaysHigher = report.zipWithNext().fold(true) { acc, (lhs, rhs) -> acc && lhs < rhs }
            val alwaysLower = report.zipWithNext().fold(true) { acc, (lhs, rhs) -> acc && lhs > rhs }
            val validDiff = report.zipWithNext().fold(true) { acc, (lhs, rhs) -> acc && (abs(lhs - rhs) in 1..3) }

            if (validDiff && (alwaysHigher xor alwaysLower)) {
                count++
            }
        }

        return count
    }

    override fun part2(): Int {
        val reports = readInput("input/day02.txt").map { it.split(" ").map { level -> level.toInt() } }

        val versions = reports.map { report ->
            getCombinationsExcludingOne(report)
        }

        var count = 0

        for (root in versions) {
            if (isValidSet(root)) {
                count++
                continue
            }
        }


        return count
    }

    override fun getDayNumber(): Int {
        return 2
    }

    fun <T> getCombinationsExcludingOne(list: List<T>): List<List<T>> {
        return List(list.size) { index ->
            list.filterIndexed { i, _ -> i != index }
        }
    }

    fun isValidSet(reportVersions: List<List<Int>>): Boolean {
        for (report in reportVersions) {
            val alwaysHigher = report.zipWithNext().fold(true) { acc, (lhs, rhs) -> acc && lhs < rhs }
            val alwaysLower = report.zipWithNext().fold(true) { acc, (lhs, rhs) -> acc && lhs > rhs }
            val validDiff = report.zipWithNext().fold(true) { acc, (lhs, rhs) -> acc && (abs(lhs - rhs) in 1..3) }

            if (validDiff && (alwaysHigher xor alwaysLower)) {
                return true
            }
        }

        return false
    }
}