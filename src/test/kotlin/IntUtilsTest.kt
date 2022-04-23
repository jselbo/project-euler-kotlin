import com.joshuaselbo.euler.PrimeFactor
import com.joshuaselbo.euler.utils.toDigits
import com.joshuaselbo.euler.toInt
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class IntUtilsTest {

    @Test
    fun isPalindrome() {
        assertTrue(com.joshuaselbo.euler.utils.isPalindrome(1))
        assertTrue(com.joshuaselbo.euler.utils.isPalindrome(1001))
        assertTrue(com.joshuaselbo.euler.utils.isPalindrome(53735))

        assertFalse(com.joshuaselbo.euler.utils.isPalindrome(10))
        assertFalse(com.joshuaselbo.euler.utils.isPalindrome(100))
        assertFalse(com.joshuaselbo.euler.utils.isPalindrome(38823))
    }

    @Test
    fun toDigits() {
        assertEquals(listOf(0), 0.toDigits())
        assertEquals(listOf(5), 5.toDigits())
        assertEquals(listOf(1, 2, 3), 123.toDigits())

        assertThrows<IllegalArgumentException> { (-5).toDigits() }
    }

    @Test
    fun toInt() {
        assertEquals(0, listOf(0).toInt())
        assertEquals(8, listOf(8).toInt())
        assertEquals(52390, listOf(5, 2, 3, 9, 0).toInt())

        // Leading zero is OK
        assertEquals(33, listOf(0, 3, 3).toInt())
        assertEquals(0, listOf(0, 0, 0, 0).toInt())

        // digit not in range 0..9
        assertThrows<IllegalArgumentException> { listOf(1, 99).toInt() }
        assertThrows<IllegalArgumentException> { listOf(-5).toInt() }
    }

    @Test
    fun isPrime() {
        assertFalse(com.joshuaselbo.euler.isPrime(-5))
        assertFalse(com.joshuaselbo.euler.isPrime(0))
        assertFalse(com.joshuaselbo.euler.isPrime(1))
        assertFalse(com.joshuaselbo.euler.isPrime(4))
        assertFalse(com.joshuaselbo.euler.isPrime(65))

        assertTrue(com.joshuaselbo.euler.isPrime(2))
        assertTrue(com.joshuaselbo.euler.isPrime(3))
        assertTrue(com.joshuaselbo.euler.isPrime(5))
        assertTrue(com.joshuaselbo.euler.isPrime(7))
        assertTrue(com.joshuaselbo.euler.isPrime(13))
        assertTrue(com.joshuaselbo.euler.isPrime(17))
        assertTrue(com.joshuaselbo.euler.isPrime(19))
        assertTrue(com.joshuaselbo.euler.isPrime(23))
        assertTrue(com.joshuaselbo.euler.isPrime(29))
        assertTrue(com.joshuaselbo.euler.isPrime(31))
        assertTrue(com.joshuaselbo.euler.isPrime(37))
        assertTrue(com.joshuaselbo.euler.isPrime(41))
    }

    @Test
    fun primeFactors() {
        assertEquals(listOf(PrimeFactor(2, 1)), com.joshuaselbo.euler.primeFactors(2))
        assertEquals(listOf(PrimeFactor(2, 2)), com.joshuaselbo.euler.primeFactors(4))
        assertEquals(listOf(PrimeFactor(3, 2)), com.joshuaselbo.euler.primeFactors(9))
        assertEquals(listOf(PrimeFactor(2, 3), PrimeFactor(3, 1)), com.joshuaselbo.euler.primeFactors(24))

        assertThrows<IllegalArgumentException> { com.joshuaselbo.euler.primeFactors(1) }
    }
}