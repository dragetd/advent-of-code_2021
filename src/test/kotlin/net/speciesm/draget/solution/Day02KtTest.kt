package net.speciesm.draget.solution

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day02KtTest {

    private val fixture = """
                forward 5
                down 5
                forward 8
                up 3
                down 8
                forward 2
                """.trimIndent()

    @Test
    fun solve2a() {
        assertThat(solve2a(fixture)).isEqualTo("150")
    }

    @Test
    fun solve2b() {
        assertThat(solve2b(fixture)).isEqualTo("900")
    }
}
