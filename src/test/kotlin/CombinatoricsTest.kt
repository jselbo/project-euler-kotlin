import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException
import kotlin.test.assertEquals

class CombinatoricsTest {

    @Test
    fun allCombinations() {
        assertEquals(listOf(listOf(1), listOf(2), listOf(3)),
            com.joshuaselbo.euler.utils.allCombinations(listOf(1, 2, 3), 1)
        )
        assertEquals(listOf(listOf(1, 2), listOf(1, 3), listOf(2, 3)),
            com.joshuaselbo.euler.utils.allCombinations(listOf(1, 2, 3), 2)
        )
        assertEquals(listOf(listOf(1, 2, 3)), com.joshuaselbo.euler.utils.allCombinations(listOf(1, 2, 3), 3))

        assertThrows<IllegalArgumentException> { com.joshuaselbo.euler.utils.allCombinations(listOf(1, 2, 3), 0) }
        assertThrows<IllegalArgumentException> { com.joshuaselbo.euler.utils.allCombinations(listOf(1, 2, 3), 4) }
    }
}