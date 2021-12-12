package net.speciesm.draget.solution

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day05KtTest {

    private val fixture = """
                0,9 -> 5,9
                8,0 -> 0,8
                9,4 -> 3,4
                2,2 -> 2,1
                7,0 -> 7,4
                6,4 -> 2,0
                0,9 -> 2,9
                3,4 -> 1,4
                0,0 -> 8,8
                5,5 -> 8,2
                """.trimIndent()

    @Test
    fun firstTask() {
        assertThat(solve5a(fixture)).isEqualTo("5")
    }

    @Test
    fun secondTask() {
        assertThat(solve5b(fixture)).isEqualTo("12")
    }
}
