package net.speciesm.draget.solution

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day01KtTest {

    private val fixture = """
                199
                200
                208
                210
                200
                207
                240
                269
                260
                263
                """.trimIndent()

    @Test
    fun solve1a() {
        assertThat(solve1a(fixture)).isEqualTo("7")
    }

    @Test
    fun solve1b() {
        assertThat(solve1b(fixture)).isEqualTo("5")
    }
}
