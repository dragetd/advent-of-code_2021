package net.speciesm.draget.solution

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class Day14KtTest {

    private val fixture = """
                NNCB

                CH -> B
                HH -> N
                CB -> H
                NH -> C
                HB -> C
                HC -> B
                HN -> C
                NN -> C
                BH -> H
                NC -> B
                NB -> B
                BN -> B
                BB -> N
                BC -> B
                CC -> N
                CN -> C
                """.trimIndent()

    @Test
    fun firstTask() {
        assertThat(solve14a(fixture)).isEqualTo("1588")
    }

    @Test
    @Disabled
    fun secondTask() {
        assertThat(solve14b(fixture)).isEqualTo("2188189693529")
    }
}
