package net.speciesm.draget.solution

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day07KtTest {

    private val fixture = """
                16,1,2,0,4,2,7,1,2,14
                """.trimIndent()

    @Test
    fun firstTask() {
        assertThat(solve7a(fixture)).isEqualTo("37")
    }

    @Test
    fun secondTask() {
        assertThat(solve7b(fixture)).isEqualTo("168")
    }
}
