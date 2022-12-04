package day01

import java.io.File

fun main() {
    fun parseInput(input: String) = input.split("\n\n").map { str ->
        str.lines().sumOf { it.toInt() }
    }

    fun part1(input: String): Int {
        val data = parseInput(input)
        return data.max()
    }

    fun part2(input: String): Int {
        val data = parseInput(input)
        return data.sortedDescending().take(3).sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = File("src/day01//Day01_test.txt").readText()
    check(part1(testInput) == 24000)

    val input = File("src/day01/Day01.txt").readText()
//    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
