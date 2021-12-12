package net.speciesm.draget.solution

import kotlin.math.abs

fun fuelRequiredFirst(crabPos: List<Int>, targetPos: Int): Int = crabPos.sumOf { abs(targetPos - it) }

// their fuel raises as a triangular number (see https://en.wikipedia.org/wiki/Triangular_number)
fun fuelRequiredSecond(crabPos: List<Int>, targetPos: Int): Int {
    return crabPos.sumOf {
        val n = abs(targetPos - it)
        (n * (n + 1)) / 2
    }
}

fun minFuel(crabPos: List<Int>, fuelFunction: (List<Int>, Int) -> Int): Int {
    val min = crabPos.minOf { it }
    val max = crabPos.maxOf { it }
    return (min..max).map { fuelFunction(crabPos, it) }
        .minOf { it }
}

fun solve7a(rawInput: String): String {
    val crabPos = rawInput.split(",").map { it.toInt() }
    return minFuel(crabPos, ::fuelRequiredFirst).toString()
}

fun solve7b(rawInput: String): String {
    val crabPos = rawInput.split(",").map { it.toInt() }
    return minFuel(crabPos, ::fuelRequiredSecond).toString()
}
