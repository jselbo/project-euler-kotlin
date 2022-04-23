import com.joshuaselbo.euler.utils.toBigInteger
import com.joshuaselbo.euler.utils.toDigits
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BigIntUtilsTest {
    
    @Test
    fun toDigits() {
        assertEquals(listOf(0), 0.toBigInteger().toDigits())
        assertEquals(listOf(5), 5.toBigInteger().toDigits())
        assertEquals(listOf(1, 2, 3), 123.toBigInteger().toDigits())

        assertThrows<IllegalArgumentException> { (-5).toBigInteger().toDigits() }
    }

    @Test
    fun toBigInteger() {
        assertEquals(0.toBigInteger(), listOf(0).toBigInteger())
        assertEquals(8.toBigInteger(), listOf(8).toBigInteger())
        assertEquals(52390.toBigInteger(), listOf(5, 2, 3, 9, 0).toBigInteger())

        // Leading zero is OK
        assertEquals(33.toBigInteger(), listOf(0, 3, 3).toBigInteger())
        assertEquals(0.toBigInteger(), listOf(0, 0, 0, 0).toBigInteger())

        // digit not in range 0..9
        assertThrows<IllegalArgumentException> { listOf(1, 99).toBigInteger() }
        assertThrows<IllegalArgumentException> { listOf(-5).toBigInteger() }
    }

    @Test
    fun factorial() {
        assertEquals(1.toBigInteger(), com.joshuaselbo.euler.utils.factorial(0.toBigInteger()))
        assertEquals(1.toBigInteger(), com.joshuaselbo.euler.utils.factorial(1.toBigInteger()))
        assertEquals(362880.toBigInteger(), com.joshuaselbo.euler.utils.factorial(9.toBigInteger()))

        assertThrows<IllegalArgumentException> { com.joshuaselbo.euler.utils.factorial((-1).toBigInteger()) }
    }

    @Test
    fun choose() {
        // 15C3
        assertEquals(455.toBigInteger(), com.joshuaselbo.euler.utils.choose(15.toBigInteger(), 3.toBigInteger()))
        // 4C0
        assertEquals(1.toBigInteger(), com.joshuaselbo.euler.utils.choose(4.toBigInteger(), 0.toBigInteger()))
        // 4C4
        assertEquals(1.toBigInteger(), com.joshuaselbo.euler.utils.choose(4.toBigInteger(), 4.toBigInteger()))
        // 4C5
        assertEquals(0.toBigInteger(), com.joshuaselbo.euler.utils.choose(4.toBigInteger(), 5.toBigInteger()))
    }

    @Test
    fun isPalindrome() {
        assertTrue(com.joshuaselbo.euler.utils.isPalindrome(1.toBigInteger()))
        assertTrue(com.joshuaselbo.euler.utils.isPalindrome(1001.toBigInteger()))
        assertTrue(com.joshuaselbo.euler.utils.isPalindrome(53735.toBigInteger()))

        assertFalse(com.joshuaselbo.euler.utils.isPalindrome(10.toBigInteger()))
        assertFalse(com.joshuaselbo.euler.utils.isPalindrome(100.toBigInteger()))
        assertFalse(com.joshuaselbo.euler.utils.isPalindrome(38823.toBigInteger()))
    }
}