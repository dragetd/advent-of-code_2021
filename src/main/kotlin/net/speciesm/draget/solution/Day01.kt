package net.speciesm.draget.solution

fun solve1a(rawInput: String): String {
    val input = rawInput.lines().map { it.toInt() }
    println(object{}.javaClass.name)
    return input.asSequence()
        .windowed(2)
        .count { (first, second) -> second > first }
        .toString()
}

fun solve1b(rawInput: String): String {
    val input = rawInput.lines().map { it.toInt() }
    return input.asSequence()
        .windowed(3)
        .map { it.sum() }
        .windowed(2)
        .count { (first, second) -> second > first }
        .toString()
}
