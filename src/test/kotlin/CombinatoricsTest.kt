import com.joshuaselbo.euler.utils.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException
import kotlin.test.assertEquals

class CombinatoricsTest {

    @Test
    fun allCombinations() {
        assertEquals(listOf(listOf(1), listOf(2), listOf(3)),
            allCombinations(listOf(1, 2, 3), 1)
        )
        assertEquals(listOf(listOf(1, 2), listOf(1, 3), listOf(2, 3)),
            allCombinations(listOf(1, 2, 3), 2)
        )
        assertEquals(listOf(listOf(1, 2, 3)), allCombinations(listOf(1, 2, 3), 3))

        assertThrows<IllegalArgumentException> { allCombinations(listOf(1, 2, 3), 0) }
        assertThrows<IllegalArgumentException> { allCombinations(listOf(1, 2, 3), 4) }
    }

    @Test
    fun allPermutations() {
        assertEquals(
            listOf(
                listOf(1, 2, 3),
                listOf(1, 3, 2),
                listOf(2, 1, 3),
                listOf(2, 3, 1),
                listOf(3, 1, 2),
                listOf(3, 2, 1)),
            allPermutations(listOf(1, 2, 3))
        )
    }
}