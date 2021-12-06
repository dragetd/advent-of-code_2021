package net.speciesm.draget.solution

val COMMAND_REGEX = """(\w+) (\d+)""".toRegex()

private operator fun Pair<Int, Int>.plus(other: Pair<Int, Int>): Pair<Int, Int> =
    Pair(this.first + other.first, this.second + other.second)

// Functional style
fun solve2a(rawInput: String): String {
    val newPos = rawInput.lines().asSequence()
        .mapNotNull { COMMAND_REGEX.find(it)?.destructured }
        .map { (direction, value) ->
            when (direction) {
                "forward" -> Pair(value.toInt(), 0)
                "down" -> Pair(0, value.toInt())
                "up" -> Pair(0, -value.toInt())
                else -> Pair(0, 0)
            }
        }
        .fold(Pair(0, 0)) { total, new -> total + new }
    return (newPos.first * newPos.second).toString()
}

// Objective style
fun solve2b(rawInput: String): String {
    val submarine = Submarine()
    for (command in rawInput.lines()) {
        submarine.execute(command)
    }
    return (submarine.positionX * submarine.positionY).toString()
}

private class Submarine() {
    var positionX = 0
        private set
    var positionY = 0
        private set
    var aim = 0
        private set

    /**
     * Executes the provided list of movement commands and returns the Manhattan-distance of the final position
     */
    fun execute(command: String) {
        val find = COMMAND_REGEX.find(command) ?: return

        val (direction, value) = find.destructured
        when (direction) {
            "forward" -> {
                positionX += value.toInt()
                positionY += value.toInt() * aim
            }
            "down" -> aim += value.toInt()
            "up" -> aim -= value.toInt()
        }
    }
}
