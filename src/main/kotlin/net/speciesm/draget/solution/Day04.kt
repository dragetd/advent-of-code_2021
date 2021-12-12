package net.speciesm.draget.solution

data class BoardNumber(val number: Int, var marked: Boolean)
typealias BoardRow = Array<BoardNumber>
typealias Board = Array<BoardRow>


private fun String.toBoard(): Board {
    return this.lines()
        .map { row ->
            row.split(" ")
                .filter { it.isNotEmpty() }
                .map { BoardNumber(it.toInt(), false) }.toTypedArray()
        }
        .toTypedArray()
}

private fun Board.markNumber(draw: Int) {
    for (row in this) {
        for (boardNumber in row) {
            if (boardNumber.number == draw) boardNumber.marked = true
        }
    }
}

private fun Board.isWinning(): Boolean {
    for (row in this) {
        if (row.none { !it.marked }) return true
    }
    for (x in this[0].indices) {
        if (this.map { it[x].marked }.all { it }) return true
    }
    return false
}

private fun Board.unmarkedSum(): Int {
    return this.sumOf { row ->
        row.filter { !it.marked }
            .sumOf { it.number }
    }
}

fun solve4a(rawInput: String): String {
    val inputElements = rawInput.split("\n\n")
    val draws = inputElements[0].split(",").map { it.toInt() }
    val boards = inputElements.subList(1, inputElements.size).map { it.toBoard() }

    for (draw in draws) {
        for (board in boards) {
            board.markNumber(draw)
            if (board.isWinning()) return (draw * board.unmarkedSum()).toString()
        }
    }
    return "0"
}

fun solve4b(rawInput: String): String {
    val inputElements = rawInput.split("\n\n")
    val draws = inputElements[0].split(",").map { it.toInt() }
    val boards = inputElements.subList(1, inputElements.size).map { it.toBoard() }

    val winningBoards = HashMap<Board, Boolean>()
    for (board in boards) {
        winningBoards[board] = false
    }
    for (draw in draws) {
        for (board in boards) {
            if (winningBoards[board] == true) continue
            board.markNumber(draw)
            if (board.isWinning()) winningBoards[board] = true
            if (winningBoards.values.all { it }) return (draw * board.unmarkedSum()).toString()
        }
    }
    return "0"
}
