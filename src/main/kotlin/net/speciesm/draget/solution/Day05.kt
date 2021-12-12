package net.speciesm.draget.solution

import kotlin.math.max

typealias FloorRow = Array<Int>
typealias Floor = Array<FloorRow>

private fun sign(value: Int): Int = if (value < 0) -1 else if (value > 0) 1 else 0

private fun Floor.paintLine(line: Line) {
    val start = line.p1
    val end = line.p2
    val step = Point(sign(end.x - start.x), sign(end.y - start.y))
    var current = start
    this[current.y][current.x]++
    while (true) {
        current += step
        this[current.y][current.x]++
        if (current == end) break
    }
}

private fun floorToString(floor: Floor) = floor.joinToString("\n") { it.joinToString() }

private data class Point(val x: Int, val y: Int) {
    operator fun plus(delta: Point): Point = Point(this.x + delta.x, this.y + delta.y)

    companion object {
        fun ofString(point: String) = Point(
            point.split(",")[0].toInt(),
            point.split(",")[1].toInt()
        )
    }
}

private data class Line(var p1: Point, var p2: Point) {
    fun isAxisAligned() = (p1.x == p2.x || p1.y == p2.y)

    companion object {
        private val LINE_REGEX = """(\d+,\d+) -> (\d+,\d+)""".toRegex()

        fun ofString(line: String): Line {
            val points = LINE_REGEX.matchEntire(line)?.groups ?: throw IllegalArgumentException("Not a valid line: $line")
            return Line(Point.ofString(points[1]!!.value), Point.ofString(points[2]!!.value))
        }

        fun getMaxExtend(lines: List<Line>): Pair<Int, Int> {
            val maxX = lines.maxOf { max(it.p1.x, it.p2.x) } + 1
            val maxY = lines.maxOf { max(it.p1.y, it.p2.y) } + 1
            return Pair(maxX, maxY)
        }
    }
}

private fun dangerousSpots(lines: List<Line>): Int {
    val (maxX, maxY) = Line.getMaxExtend(lines)
    val floor = Floor(maxY) { FloorRow(maxX) { 0 } }
    lines.forEach { floor.paintLine(it) }
    return floor.sumOf { row -> row.count { it >= 2 } }

}

fun solve5a(rawInput: String): String {
    val lines = rawInput.split("\n")
        .map { Line.ofString(it) }
        .filter { it.isAxisAligned() }
    return dangerousSpots(lines).toString()
}

fun solve5b(rawInput: String): String {
    val lines = rawInput.split("\n")
        .map { Line.ofString(it) }
    return dangerousSpots(lines).toString()
}
