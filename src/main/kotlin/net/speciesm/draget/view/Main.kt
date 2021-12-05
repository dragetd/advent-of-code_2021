package net.speciesm.draget.view

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.time.LocalDateTime

@Preview
@Composable
fun MainView() {
    var input by remember { mutableStateOf("") }
    var day by remember { mutableStateOf("${aocDay()}a") }
    var result by remember { mutableStateOf("") }

    Column {
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            TextField(
                value = input,
                onValueChange = { input = it },
                modifier = Modifier.padding(end = 16.dp).weight(1f).fillMaxHeight(0.5f),
                placeholder = { Text("Please enter the puzzle input…") },
                label = { Text(text = "Aoc 2021 Input") },
                leadingIcon = { Icon(Icons.Default.List, "Input") }
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text("Solution for day: ")
            TextField(
                value = day,
                onValueChange = { day = it }
            )
            Button(onClick = { result = solution(day, input) }) {
                Icon(Icons.Filled.PlayArrow, "Solve")
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text("Result is: ")
            SelectionContainer {
                Text(result)
            }
        }
    }
}

fun solution(task: String, input: String): String {
    try {
        // TODO: Ugly Java Reflection to get the method
        val day = String.format("%02d", task.replace("[^0-9]".toRegex(), "").toInt())
        val solveFunction = Class.forName("net.speciesm.draget.solution.Day${day}Kt").methods.first { it.name == "solve$task" }
        return solveFunction.invoke(null, input.trim()).toString()
    } catch (ex: NoSuchElementException) {
        return "This solution is not yet implemented."
    } catch (ex: Exception) {
        return "Could not solve. ${ex.message}"
    }
}

fun aocDay(): Int {
    val now = LocalDateTime.now()
    return if (now.monthValue != 12) 1 else now.dayOfMonth
}
