package view

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*

@Composable
@Preview
fun MainView() {
    var text by remember { mutableStateOf("Hello…?") }

    MaterialTheme {
        Button(onClick = {
            text = "Hello, AoC2021!"
        }) {
            Text(text)
        }
    }
}
