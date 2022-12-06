package day02

import java.io.File

fun main() {

    fun parseInput(input: String) = input.lines().map { it.split(" ") }.map { it.first() to it.last() }

    val points = mapOf("X" to 1, "Y" to 2, "Z" to 3)
    val winsPlayer = listOf("A" to "Y", "B" to "Z", "C" to "X")
    val drawPlayer = listOf("A" to "X", "B" to "Y", "C" to "Z")
    val lossPlayer = listOf("A" to "Z", "B" to "X", "C" to "Y")

    fun getPointPerRound(pair: Pair<String, String>): Int = when (pair) {
        in winsPlayer -> 6
        in drawPlayer -> 3
        else -> 0
    }

    fun part1(input: String): Int {
        val data = parseInput(input)
            .fold(0) { acc, pair ->
                acc + getPointPerRound(pair) + points.getOrDefault(pair.second, 0)
            }
        return data
    }

    fun part2(input: String): Int {
        val data = parseInput(input)
            .map { (first, second) ->
                when (second) {
                    "Z" -> winsPlayer.first { it.first == first }
                    "Y" -> drawPlayer.first { it.first == first }
                    else -> lossPlayer.first { it.first == first }
                }
            }
            .fold(0) { acc, pair ->
                acc + getPointPerRound(pair) + points.getOrDefault(pair.second, 0)
            }
        return data
    }

    val testInput = File("src/day02/Day02_test.txt").readText()

    println(part1(testInput))
    println(part2(testInput))

    val input = File("src/day02/Day02.txt").readText()

    println(part1(input))
    println(part2(input))
}
