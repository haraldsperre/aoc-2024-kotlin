import kotlin.math.abs

fun parseInputToReports(name: String): List<List<Int>> = readInput(name).map { it.split(" ").map(String::toInt) }

fun isSafe(report: List<Int>): Boolean {
    val asc = report.sorted()
    val desc = asc.reversed()
    val gradual = (1 until report.size).all { idx -> abs(report[idx] - report[idx - 1]) in 1..3 }
    return (report == asc || report == desc) && gradual
}

fun isSafeWithDampener(report: List<Int>): Boolean {
    if (isSafe(report)) return true

    return report.indices.any { idx -> isSafe(report.filterIndexed { i, _ -> i != idx }) }
}

fun main() {
    fun part1(input: List<List<Int>>): Int = input.count(::isSafe)

    fun part2(input: List<List<Int>>): Int = input.count(::isSafeWithDampener)

    val testInput = parseInputToReports("Day02_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = parseInputToReports("Day02")
    part1(input).println()
    part2(input).println()
}
