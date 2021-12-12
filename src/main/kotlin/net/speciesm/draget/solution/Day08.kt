package net.speciesm.draget.solution

private val uniqueDigits: Map<Int, Int> = mapOf(
    1 to 2,
    4 to 4,
    7 to 3,
    8 to 7
)

private data class Entry(val signal: String, val output: String)

private fun String.toEntry(): Entry {
    val (signal, output) = this.split("|")
    return Entry(signal.trim(), output.trim())
}

private fun Entry.countUniqueOutputDigits(): Int =
    this.output.split(" ").count { uniqueDigits.values.contains(it.length) }


fun solve8a(rawInput: String): String {
    val entries = rawInput.lines().map { it.toEntry() }
    return entries.sumOf { it.countUniqueOutputDigits() }
        .toString()
}

fun solve8b(rawInput: String): String {
    TODO("Not yet implemented")
}
