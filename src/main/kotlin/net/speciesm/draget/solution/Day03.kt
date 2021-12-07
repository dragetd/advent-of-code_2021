package net.speciesm.draget.solution

fun solve3a(rawInput: String): String {
    val dataLength = rawInput.lines()[0].length
    val input = rawInput.lines().filter { it.length == dataLength }

    val counted = input.fold(IntArray(dataLength) { 0 }) { accumulator, entry ->
        entry.forEachIndexed { index, char ->
            accumulator[index] += char.digitToInt()
        }
        accumulator
    }

    val gammaBits = counted.map { if (it > input.size / 2) 1 else 0 }
    val gamma = gammaBits.joinToString(separator = "").toInt(2)
    val epsilonBits = gammaBits.map { if (it == 1) 0 else 1 }
    val epsilon = epsilonBits.joinToString(separator = "").toInt(2)
    return (gamma * epsilon).toString()
}

//fun solve3b(rawInput: String): String {
//    TODO("")
//}
