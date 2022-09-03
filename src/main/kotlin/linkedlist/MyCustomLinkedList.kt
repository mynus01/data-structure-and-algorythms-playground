package linkedlist

class MyCustomLinkedList {
    data class MyNode(
        var value: Int,
        var next: MyNode? = null
    )

    var first: MyNode? = null
    var last: MyNode? = null
    private var nodeNumber = 0

    fun addFirst(num: Int) {
        if (!isEmpty()) {
            last = first
            first = MyNode(num, first)
        } else {
            first = MyNode(num)
            last = first
        }
        nodeNumber++
    }

    fun addLast(num: Int) {
        val newLast = MyNode(num)

        if (!isEmpty()) {
            last?.next = newLast
            first = last
        } else {
            first = newLast
        }
        last = newLast

        nodeNumber++
    }

    fun deleteFirst() {
        val newFirst = first?.next
        if (!isEmpty()) {
            first?.next = null
            first = newFirst
            nodeNumber--
        } else {
            throw NoSuchElementException("First cannot be removed if it is the only node!")
        }
    }

    fun deleteLast() {
        // TODO
    }

    fun indexOf(num: Int): Int {
        var currentNode: MyNode? = first
        var counter = 0

        while (true) {
            if (currentNode != null) {
                if (currentNode.value == num) {
                    return counter
                } else {
                    currentNode = currentNode.next
                    counter++
                }
            } else {
                return -1
            }
        }
    }

    fun contains(num: Int): Boolean = indexOf(num) != -1
    fun isEmpty(): Boolean = nodeNumber == 0
    fun size(): Int = nodeNumber
}