package net.speciesm.draget.solution

typealias Rule = Pair<String, String>

private fun String.grow(rules: List<Rule>, iterations: Int): String {
    var newPolymere = this
    for (i in 1..iterations) {
        newPolymere = newPolymere
            .windowed(2)
            .joinToString("") { pair -> "${pair[0]}${rules.find { it.first == pair }!!.second}" } + newPolymere.last()
    }
    return newPolymere
}

private fun String.toRules(): List<Pair<String, String>> =
    this.split("\n")
        .map { it.split(" -> ") }
        .map { (template, insertion) -> Pair(template, insertion) }

fun solve14a(rawInput: String): String {
    val (polymere, ruleInput) = rawInput.split("\n\n")
    val rules = ruleInput.toRules()

    val newPolymere = polymere.grow(rules, 10)
    val sorted = newPolymere.groupingBy { it }.eachCount()
    return (sorted.maxOf { it.value } - sorted.minOf { it.value }).toString()
}

fun solve14b(rawInput: String): String {
    val (polymere, ruleInput) = rawInput.split("\n\n")
    val rules = ruleInput.toRules()

    val newPolymere = polymere.grow(rules, 40)
    val sorted = newPolymere.groupingBy { it }.eachCount()
    return (sorted.maxOf { it.value } - sorted.minOf { it.value }).toString()
}
