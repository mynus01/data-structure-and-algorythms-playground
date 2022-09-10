import array.CustomArrayList
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class CustomArrayListTest {
    private val array = CustomArrayList(3)

    @Before
    fun setup() {
        array.add(0)
        array.add(100)
        array.add(200)
    }

    @Test
    fun `adding one more item than initial capacity should increase array size by one`() {
        array.add(300)

        assertEquals(4, array.size())
    }

    @Test
    fun `getting a valid position should return its value`() {
        assertEquals(200, array.get(2))
    }

    @Test(expected = IllegalArgumentException::class)
    fun `getting a position that doesn't exist should throw IllegalArgumentException`() {
        array.get(3)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `getting a negative position should throw IllegalArgumentException`() {
        array.get(3)
    }

    @Test
    fun `removing a valid position should decrease array size by one`() {
        array.removeAt(2)

        assertEquals(2, array.size())
    }

    @Test(expected = IllegalArgumentException::class)
    fun `removing a position that doesn't exist should throw IllegalArgumentException`() {
        array.removeAt(3)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `removing a negative number should throw IllegalArgumentException`() {
        array.removeAt(-1)
    }

    @Test
    fun `if in array, indexOf should return position of the number`() {
        val result = array.indexOf(200)

        assertEquals(2, result)
    }

    @Test
    fun `if not in array, indexOf should return -1`() {
        val result = array.indexOf(300)

        assertEquals(-1, result)
    }
}