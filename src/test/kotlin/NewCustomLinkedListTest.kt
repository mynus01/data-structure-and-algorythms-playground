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
    fun `insert should add the value at the given position`() {
        list.append(0)
        list.append(100)
        list.append(200)
        list.append(400)
        list.insert(3, 300)

        assertEquals(3, list.indexOf(300))
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
    fun `get should return the item at the given position`() {
        list.append(0)
        list.append(100)
        list.append(200)
        list.append(300)

        val result = list.get(2).value
        assertEquals(200, result)
    }

    @Test(expected = NoSuchElementException::class)
    fun `trying to get with a position greater than the size of the list minus one should throw NoSuchElementException`() {
        list.append(0)
        list.append(100)

        list.get(4)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `trying to get with a negative position should throw NoSuchElementException`() {
        list.get(-1)
    }

    @Test
    fun `set should set the value to the given position`() {
        list.append(0)
        list.append(100)
        list.append(300)
        list.append(300)

        list.set(2, 200)
        assertEquals(200, list.get(2).value)
    }

    @Test(expected = NoSuchElementException::class)
    fun `trying to set with a position greater than the size of the list minus one should throw NoSuchElementException`() {
        list.append(0)
        list.append(100)

        list.set(2, 200)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `trying to set with a negative position should throw NoSuchElementException`() {
        list.append(0)

        list.set(-1, 100)
    }

    @Test
    fun `remove should delete the item at the given position`() {
        list.append(0)
        list.append(100)
        list.append(200)
        list.append(300)

        list.remove(1)
        assertEquals(200, list.get(1).value)
    }

    @Test(expected = NoSuchElementException::class)
    fun `trying to remove with a position greater than the size of the list minus one should throw NoSuchElementException`() {
        list.append(0)
        list.append(100)

        list.remove(2)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `trying to remove with a negative position should throw NoSuchElementException`() {
        list.append(0)

        list.remove(-1)
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