package net.speciesm.draget.solution

private fun counted(input: List<String>, dataLength: Int) =
    input.fold(IntArray(dataLength) { 0 }) { accumulator, entry ->
        entry.forEachIndexed { index, char ->
            accumulator[index] += char.digitToInt()
        }
        accumulator
    }

fun solve3a(rawInput: String): String {
    val dataLength = rawInput.lines()[0].length
    val input = rawInput.lines().filter { it.length == dataLength }

    val counted = counted(input, dataLength)

    val gammaBits = counted.map { if (it > input.size / 2) 1 else 0 }
    val gamma = gammaBits.joinToString(separator = "").toInt(2)
    val epsilonBits = gammaBits.map { if (it == 1) 0 else 1 }
    val epsilon = epsilonBits.joinToString(separator = "").toInt(2)
    return (gamma * epsilon).toString()
}

fun solve3b(rawInput: String): String {
    val dataLength = rawInput.lines()[0].length
    val input = rawInput.lines().filter { it.length == dataLength }

    var oxygenCandidates = input
    for (i in 0 until dataLength) {
        val counted = counted(oxygenCandidates, dataLength)
        val commonBit = if (counted[i] >= oxygenCandidates.size / 2f) 1 else 0
        oxygenCandidates = oxygenCandidates.filter { it[i].digitToInt() == commonBit }
        if (oxygenCandidates.size <= 1) break
    }

    var co2Candidates = input
    for (i in 0 until dataLength) {
        val counted = counted(co2Candidates, dataLength)
        val commonBit = if (counted[i] < co2Candidates.size / 2f) 1 else 0
        co2Candidates = co2Candidates.filter { it[i].digitToInt() == commonBit }
        if (co2Candidates.size <= 1) break
    }

    val oxygen = oxygenCandidates[0].toInt(2)
    val co2 = co2Candidates[0].toInt(2)
    return (oxygen * co2).toString()
}
