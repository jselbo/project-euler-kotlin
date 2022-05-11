import com.joshuaselbo.euler.utils.Rational
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RationalTest {
    @Test
    fun reduction() {
        assertEquals(Rational(1, 2), Rational(2, 4))
    }

    @Test
    fun reciprocal() {
        assertEquals(Rational(2, 1), Rational(1, 2).reciprocal())
    }

    @Test
    fun add() {
        assertEquals(Rational(1), Rational(1, 2) + Rational(1, 2))
        assertEquals(Rational(5, 6), Rational(1, 2) + Rational(1, 3))
    }

    @Test
    fun unaryMinus() {
        assertEquals(Rational(-1), -Rational(1))
    }

    @Test
    fun subtract() {
        assertEquals(Rational(0, 4), Rational(1, 2) - Rational(1, 2))
        assertEquals(Rational(1, 6), Rational(1, 2) - Rational(1, 3))
    }

    @Test
    fun multiply() {
        assertEquals(Rational(3, 8), Rational(3,4) * Rational(1, 2))
    }

    @Test
    fun divide() {
        assertEquals(Rational(1, 4), Rational(1, 2) / Rational(2))
    }
}