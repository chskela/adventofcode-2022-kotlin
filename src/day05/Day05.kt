package day05

import java.io.File

class Stack<T> {
    private val mutableList = mutableListOf<T>()

    fun push(vararg element: T) {
        mutableList.addAll(element)
    }

    fun pop(): T? {
        return if (mutableList.isNotEmpty()) {
            mutableList.removeLast()
        } else {
            null
        }
    }

    fun pop(n: Int): List<T> {
        val result = mutableListOf<T>()
        result.addAll(mutableList.takeLast(n))
        repeat(n) {
            mutableList.removeLast()
        }
        return result
    }

    override fun toString(): String {
        return mutableList.toString()
    }
}

fun main() {

    fun <A, B, R, T> Pair<A, B>.map(transformA: (A) -> R, transformB: (B) -> T): Pair<R, T> {
        return Pair(
            transformA(first),
            transformB(second)
        )
    }

    fun parseMovements(s: String) = s
        .lines()
        .map { row ->
            row.split(" ")
                .filter { it.toIntOrNull() != null }
                .map { it.toInt() }
        }

    fun parseStore(s: String) = s.lines().reversed()
        .foldIndexed(mutableMapOf()) { index, acc: MutableMap<Int, Stack<Char>>, str ->
            str.forEachIndexed { idx, char ->
                if (index == 0 && char.isDigit()) {
                    val i = char.digitToInt()
                    acc[i] = Stack<Char>()
                }

                if (char.isLetter()) {
                    val i = idx / 4 + 1
                    val stack = acc[i]
                    stack?.let { st ->
                        st.push(char)
                        acc[i] = st
                    }
                }
            }
            acc
        }


    fun parseInput(input: String) = input.split("\n\n")
        .foldIndexed("" to "") { index: Int, acc: Pair<String, String>, s: String ->
            if (index % 2 != 0) acc.copy(second = s) else acc.copy(first = s)
        }.map(
            transformA = ::parseStore,
            transformB = ::parseMovements
        )


    fun part1(input: String): String {
        val (storeData, movedData) = parseInput(input)
        movedData.forEach { (move, from, to) ->
            (1..move).forEach { _ ->
                val el = storeData[from]?.pop()
                el?.let {
                    storeData[to]?.push(it)
                }
            }
        }
        return storeData.values.map { it.pop() }.joinToString("")
    }

    fun part2(input: String): String {
        val (storeData, movedData) = parseInput(input)
        movedData.forEach { (move, from, to) ->
            val el = storeData[from]?.pop(move)
            el?.let {
                storeData[to]?.push(*it.toTypedArray())
            }

        }
        return storeData.values.map { it.pop() }.joinToString("")
    }

    val testInput = File("src/day05/Day05_test.txt").readText()

    println(part1(testInput))
    println(part2(testInput))
//
    val input = File("src/day05/Day05.txt").readText()

    println(part1(input))
    println(part2(input))
}
