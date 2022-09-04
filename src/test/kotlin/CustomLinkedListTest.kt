import linkedlist.MyCustomLinkedList
import org.junit.Test
import kotlin.test.assertEquals

class CustomLinkedListTest {
    private val list = MyCustomLinkedList()
    @Test
    fun `addFirst should add the item to the first position`() {
        list.addFirst(0)
        list.addFirst(100)

        assertEquals(100, list.first?.value)
    }

    @Test
    fun `addLast should add the item to the last position`() {
        list.addLast(0)
        list.addLast(100)

        assertEquals(100, list.last?.value)
    }

    @Test
    fun `deleteFirst should remove the first node`() {
        list.addFirst(0)
        list.addFirst(100)

        list.deleteFirst()
        assertEquals(0, list.first?.value)
    }

    @Test(expected = NoSuchElementException::class)
    fun `trying to deleteFirst without elements should throw NoSuchElementException`() {
        list.deleteFirst()
    }

    @Test
    fun `deleteLast should remove the last node`() {
        list.addLast(0)
        list.addLast(100)
        list.addLast(200)

        list.deleteLast()
        assertEquals(100, list.last?.value)
    }

    @Test(expected = NoSuchElementException::class)
    fun `trying to deleteLast without elements should throw NoSuchElementException`() {
        list.deleteLast()
    }

    @Test
    fun `contains should return true when number exists in the list`() {
        list.addFirst(0)
        list.addFirst(100)

        val result = list.contains(0)
        assertEquals(true, result)
    }

    @Test
    fun `contains should return false when number doesn't exists in the list`() {
        list.addFirst(0)
        list.addFirst(100)

        val result = list.contains(200)
        assertEquals(false, result)
    }

    @Test
    fun `indexOf should return index of the number when it exists inside list`() {
        list.addFirst(0)
        list.addFirst(100)

        val result = list.indexOf(100)
        assertEquals(0, result)
    }

    @Test
    fun `indexOf should return -1 when number doesn't exists inside list`() {
        list.addFirst(0)
        list.addFirst(100)

        val result = list.indexOf(200)
        assertEquals(-1, result)
    }

    @Test
    fun `size should return the number of inserted items`() {
        list.addFirst(0)
        list.addFirst(100)

        val result = list.size()
        assertEquals(2, result)
    }

    @Test
    fun `size should return zero if no item has been inserted`() {
        val result = list.size()
        assertEquals(0, result)
    }

    @Test
    fun `isEmpty should return true if items were inserted`() {
        list.addFirst(0)
        list.addFirst(100)

        val result = list.isEmpty()
        assertEquals(false, result)
    }

    @Test
    fun `isEmpty should return true if no item has been inserted`() {
        val result = list.isEmpty()
        assertEquals(true, result)
    }
}