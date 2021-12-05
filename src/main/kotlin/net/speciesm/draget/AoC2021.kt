
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import net.speciesm.draget.view.MainView

fun main() = application {
    Window(
        title = "Advent of Code 2021",
        onCloseRequest = ::exitApplication
    ) {
        MaterialTheme { MainView() }
    }
}
