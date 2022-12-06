package day01

import java.io.File
import java.util.PriorityQueue

fun main() {
    fun parseInput(input: String) = input.split("\n\n").map { str ->
        str.lines().map { it.toInt() }
    }

    fun List<List<Int>>.topNElves(n: Int): Int {
        val best = PriorityQueue<Int>()
        for (calories in map { it.sum() }) {
            best.add(calories)
            if (best.size > n) {
                best.poll()
            }
        }
        return best.sum()
    }

    fun part1(input: String): Int {
        val data = parseInput(input)
        return data.topNElves(1)
    }

    fun part2(input: String): Int {
        val data = parseInput(input)
        return data.topNElves(3)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = File("src/day01//Day01_test.txt").readText()
    check(part1(testInput) == 24000)
    println(part1(testInput))
    println(part2(testInput))

    val input = File("src/day01/Day01.txt").readText()
    println(part1(input))
    println(part2(input))
}
