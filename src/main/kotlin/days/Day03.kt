package dev.ketkev.days

import dev.ketkev.utils.readInputAsString

class Day03 : Day {
    override fun part1(): Int {
        val program = readInputAsString("input/day03.txt")

        val regex = Regex("mul\\((\\d{1,3}),(\\d{1,3})\\)")

        val results = regex.findAll(program)

        val sum = results.sumOf { match ->
            val (lhs, rhs) = match.destructured

            val a = lhs.toInt()
            val b = rhs.toInt()
            a * b
        }

        return sum
    }

    override fun part2(): Int {
        val program = readInputAsString("input/day03.txt")

        val regex = Regex("(?:(mul)\\((\\d{1,3}),(\\d{1,3})\\))|(?:(don't)\\(\\))|(?:(do)\\(\\))")

        val results = regex.findAll(program)

        var sum = 0
        var multiplying = true

        for (result in results) {
            val (mul, lhs, rhs, dontInstr, doInstr) = result.destructured

            if (mul == "mul" && multiplying) {
                sum += lhs.toInt() * rhs.toInt()
            } else if (dontInstr == "don't") {
                multiplying = false
            } else if (doInstr == "do") {
                multiplying = true
            }
        }

        return sum
    }

    override fun getDayNumber(): Int {
        return 3
    }
}