import kotlin.math.abs

fun parseInputColumnsToSortedInts(name: String): List<List<Int>> =
    readInputColumns(name).map { it.map(String::toInt).sorted() }

fun main() {
    fun part1(input: List<List<Int>>): Int {
        return input.first().zip(input.last()) { first, last -> +abs(first - last) }.sum()
    }

    fun part2(input: List<List<Int>>): Int {
        return input[0].indices.fold(0) { sum, idx ->
            val number = input.first()[idx]
            val occurrences = input.last().count { it == number }
            sum + number * occurrences
        }
    }

    // Read test inputs
    val testInput = readInputColumns("Day01_test").map { it.map { it.toInt() }.sorted() }
    check(part1(testInput) == 11)
    check(part2(testInput) == 31)

    // Read real input
    val input = readInputColumns("Day01").map { it.map { it.toInt() }.sorted() }
    part1(input).println()
    part2(input).println()
}
