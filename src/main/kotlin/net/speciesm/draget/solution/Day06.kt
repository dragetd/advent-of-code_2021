package net.speciesm.draget.solution

const val REPRODUCE_DAYS = 6
const val NEWBORN_DAYS = 8

private fun MutableList<Int>.sizeAfterDay(days: Int): Long {
    // count for each age group
    val ageGroup = List(NEWBORN_DAYS + 1) { 0L }.toMutableList()
    val initialFlock = this.groupingBy { it }.eachCount()
    initialFlock.forEach { ageGroup[it.key] = it.value.toLong() }

    for (day in 1..days) {
        val reproducingFish = ageGroup[0]

        // Other fish age one day
        for (age in 0 until ageGroup.size - 1) {
            ageGroup[age] = ageGroup[age + 1]
        }
        ageGroup[REPRODUCE_DAYS] += reproducingFish
        ageGroup[NEWBORN_DAYS] = reproducingFish
    }
    return ageGroup.sum()
}

fun solve6a(rawInput: String): String {
    val fish = rawInput.split(",").map { it.toInt() }.toMutableList()
    return fish.sizeAfterDay(80).toString()
}

fun solve6b(rawInput: String): String {
    val fish = rawInput.split(",").map { it.toInt() }.toMutableList()
    return fish.sizeAfterDay(256).toString()
}
