import linkedlist.NewCustomLinkedList
import org.junit.Test
import kotlin.test.assertEquals

class NewCustomLinkedListTest {
    private val list = NewCustomLinkedList()
    @Test
    fun `prepend should add the item to the first position`() {
        list.prepend(0)
        list.prepend(100)

        assertEquals(100, list.head?.value)
    }

    @Test
    fun `append should add the item to the last position`() {
        list.append(0)
        list.append(100)

        assertEquals(100, list.tail?.value)
    }

    @Test
    fun `deleteHead should remove the first node`() {
        list.prepend(0)
        list.prepend(100)

        list.deleteHead()
        assertEquals(0, list.head?.value)
    }

    @Test(expected = NoSuchElementException::class)
    fun `trying to deleteHead without elements should throw NoSuchElementException`() {
        list.deleteHead()
    }

    @Test
    fun `deleteTail should remove the last node`() {
        list.append(0)
        list.append(100)
        list.append(200)

        list.deleteTail()
        assertEquals(100, list.tail?.value)
    }

    @Test(expected = NoSuchElementException::class)
    fun `trying to deleteTail without elements should throw NoSuchElementException`() {
        list.deleteTail()
    }

    @Test
    fun `contains should return true when number exists in the list`() {
        list.prepend(0)
        list.prepend(100)

        val result = list.contains(0)
        assertEquals(true, result)
    }

    @Test
    fun `contains should return false when number doesn't exists in the list`() {
        list.prepend(0)
        list.prepend(100)

        val result = list.contains(200)
        assertEquals(false, result)
    }

    @Test
    fun `indexOf should return index of the number when it exists inside list`() {
        list.prepend(0)
        list.prepend(100)

        val result = list.indexOf(100)
        assertEquals(0, result)
    }

    @Test
    fun `indexOf should return -1 when number doesn't exists inside list`() {
        list.prepend(0)
        list.prepend(100)

        val result = list.indexOf(200)
        assertEquals(-1, result)
    }

    @Test
    fun `length should return the number of inserted items`() {
        list.prepend(0)
        list.prepend(100)

        val result = list.length
        assertEquals(2, result)
    }

    @Test
    fun `length should return zero if no item has been inserted`() {
        val result = list.length
        assertEquals(0, result)
    }

    @Test
    fun `isEmpty should return true if items were inserted`() {
        list.prepend(0)
        list.prepend(100)

        val result = list.isEmpty
        assertEquals(false, result)
    }

    @Test
    fun `isEmpty should return true if no item has been inserted`() {
        val result = list.isEmpty
        assertEquals(true, result)
    }
}