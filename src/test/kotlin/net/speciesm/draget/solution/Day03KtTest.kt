package net.speciesm.draget.solution

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day03KtTest {

    private val fixture = """
                00100
                11110
                10110
                10111
                10101
                01111
                00111
                11100
                10000
                11001
                00010
                01010
                """.trimIndent()

    @Test
    fun firstTask() {
        assertThat(solve3a(fixture)).isEqualTo("198")
    }

    @Test
    fun secondTask() {
        assertThat(solve3b(fixture)).isEqualTo("230")
    }
}
