package day04

import java.io.File

fun main() {

    fun parseInput(input: String) = input
        .lines()
        .map {
            it.split(",")
                .map { s ->
                    s.split("-")
                }
                .map { (a, b) -> (a.toInt()..b.toInt()).toSet() }
        }

    fun part1(input: String): Int {
        val data = parseInput(input).fold(0) { acc: Int, (l1, l2) ->
            acc + if (l1.union(l2).size == l1.size || l2.union(l1).size == l2.size) 1 else 0
        }
        return data
    }

    fun part2(input: String): Int {
        val data = parseInput(input).fold(0) { acc: Int, (l1, l2) ->
            acc + if (l1.intersect(l2).isNotEmpty()) 1 else 0
        }
        return data
    }

    val testInput = File("src/day04/Day04_test.txt").readText()

    println(part1(testInput))
    println(part2(testInput))

    val input = File("src/day04/Day04.txt").readText()

    println(part1(input))
    println(part2(input))
}
