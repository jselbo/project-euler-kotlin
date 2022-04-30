
import com.joshuaselbo.euler.utils.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class IntUtilsTest {

    @Test
    fun isPalindrome() {
        assertTrue(isPalindrome(1))
        assertTrue(isPalindrome(1001))
        assertTrue(isPalindrome(53735))

        assertFalse(isPalindrome(10))
        assertFalse(isPalindrome(100))
        assertFalse(isPalindrome(38823))
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
        assertFalse(isPrime(-5))
        assertFalse(isPrime(0))
        assertFalse(isPrime(1))
        assertFalse(isPrime(4))
        assertFalse(isPrime(25))
        assertFalse(isPrime(65))

        assertTrue(isPrime(2))
        assertTrue(isPrime(3))
        assertTrue(isPrime(5))
        assertTrue(isPrime(7))
        assertTrue(isPrime(13))
        assertTrue(isPrime(17))
        assertTrue(isPrime(19))
        assertTrue(isPrime(23))
        assertTrue(isPrime(29))
        assertTrue(isPrime(31))
        assertTrue(isPrime(37))
        assertTrue(isPrime(41))
    }

    @Test
    fun primeFactors() {
        assertEquals(listOf(PrimeFactor(2, 1)), primeFactors(2))
        assertEquals(listOf(PrimeFactor(2, 2)), primeFactors(4))
        assertEquals(listOf(PrimeFactor(3, 2)), primeFactors(9))
        assertEquals(listOf(PrimeFactor(2, 3), PrimeFactor(3, 1)), primeFactors(24))

        assertThrows<IllegalArgumentException> { primeFactors(1) }
    }
}