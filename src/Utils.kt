import java.math.BigInteger
import java.security.MessageDigest
import kotlin.io.path.Path
import kotlin.io.path.readText

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = Path("input/$name.txt").readText().trim().lines()

/**
 * Reads input as a columnar structure where columns are space-separated.
 */
fun readInputColumns(name: String, delimiter: Regex = "\\s+".toRegex()): List<List<String>> {
    val lines = readInput(name)
    val matrix = lines.map { line -> line.split(delimiter) }
    return matrix[0].indices.map { col -> matrix.map { it[col] } }
}

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')

/**
 * The cleaner shorthand for printing output.
 */
fun Any?.println() = println(this)
