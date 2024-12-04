package dev.ketkev

import dev.ketkev.days.Day01
import dev.ketkev.days.Day02
import dev.ketkev.days.Day03

fun main() {
    val days = listOf(
        Day01(),
        Day02(),
        Day03()
    )

    for (day in days) {
        println("Day ${day.getDayNumber()}:")
        println("Part 1 = ${day.part1()}")
        println("Part 2 = ${day.part2()}")
    }
}