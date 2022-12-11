package day06

import java.io.File

fun main() {

    fun parseInput(input: String) = input

    fun search(data: String, n: Int) = (n - 1 until data.length).first {
        val candidate = data.substring(it - n + 1, it + 1)
        candidate.toSet().size == candidate.length
    }

    fun part1(input: String): Int {
        val data = parseInput(input)
        val result = search(data, 4)
        return result + 1
    }

    fun part2(input: String): Int {
        val data = parseInput(input)
        val result = search(data, 14)
        return result + 1
    }

    val testInput = File("src/day06/Day06_test.txt").readText()

    println(part1(testInput))
    println(part2(testInput))
//
    val input = File("src/day06/Day06.txt").readText()

    println(part1(input))
    println(part2(input))
}
