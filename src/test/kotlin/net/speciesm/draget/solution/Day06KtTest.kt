package net.speciesm.draget.solution

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day06KtTest {

    private val fixture = """
                3,4,3,1,2
                """.trimIndent()

    @Test
    fun firstTask() {
        assertThat(solve6a(fixture)).isEqualTo("5934")
    }

    @Test
    fun secondTask() {
        assertThat(solve6b(fixture)).isEqualTo("26984457539")
    }
}
