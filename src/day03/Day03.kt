package day03

import java.io.File

fun main() {

    fun Char.getPriorities(): Int = when {
        isLowerCase() -> code - 96
        isUpperCase() -> code - 38
        else -> 0
    }

    fun parseInput(input: String) = input.lines()

    fun part1(input: String): Int {
        val data = parseInput(input)
            .map {
                it.take(it.length / 2).toSet() to it.takeLast(it.length / 2).toSet()
            }
            .sumOf { (first, second) ->
                first.fold(0) { acc: Int, c ->
                    acc + if (second.contains(c)) c.getPriorities() else 0
                }
            }
        return data
    }

    fun part2(input: String): Int {
        val data = parseInput(input).chunked(3)
            .map { it.map { s -> s.toSet() } }
            .map { (a, b, c) -> Triple(a, b, c) }
            .sumOf { (a, b, c) ->
                a.fold(0) { acc: Int, char: Char ->
                    acc + if (b.contains(char) && c.contains(char)) char.getPriorities() else 0
                }
            }
        return data
    }

    val testInput = File("src/day03/Day03_test.txt").readText()

    println(part1(testInput))
    println(part2(testInput))

    val input = File("src/day03/Day03.txt").readText()

    println(part1(input))
    println(part2(input))
}
