val MULTIPLY_REGEX = Regex("""mul\((\d{1,3}),(\d{1,3})\)""")

fun main() {
    fun getLineSum(line: String): Int {
        val matches = MULTIPLY_REGEX.findAll(line)

        return matches.sumOf { it.groupValues[1].toInt() * it.groupValues[2].toInt() }
    }

    fun sumOfEnabled(line: String): Int {
        val instructions = line.split("do()").map { it.split("don't()").first() }
        return instructions.sumOf { getLineSum(it) }
    }

    fun part1(input: List<String>): Int {
        return input.sumOf { getLineSum(it) }
    }

    fun part2(input: List<String>): Int {
        return sumOfEnabled(input.joinToString("\n"))
    }

    val testInput = readInput("Day03_test")
    check(part1(testInput) == 161)
    check(part2(testInput) == 48)

    // Read the input from the `input/Day01.txt` file.
    val input = readInput("Day03")
    part1(input).println()
    part2(input).println()
}
