import java.io.File

fun main() {
    fun part1(input: String): Int {
        val data = input.split("\n\n").map {str ->
            str.lines().sumOf { it.toInt() }
        }
        return data.max()
    }

    fun part2(input: String): Int {
        val data = input.split("\n\n").map {str ->
            str.lines().sumOf { it.toInt() }
        }
        return data.sortedDescending().take(3).sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = File("src/Day01_test.txt").readText()
    check(part1(testInput) == 24000)

    val input = File("src/Day01.txt").readText()
//    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}