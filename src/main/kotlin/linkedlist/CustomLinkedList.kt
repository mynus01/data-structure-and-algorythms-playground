package linkedlist

class CustomLinkedList {
    var first: CustomNode? = null
    var last: CustomNode? = null
    private var nodeNumber = 0

    fun addFirst(num: Int) {
        if (!isEmpty()) {
            last = first
            first = CustomNode(num, first)
        } else {
            first = CustomNode(num)
            last = first
        }
        nodeNumber++
    }

    fun addLast(num: Int) {
        val newLast = CustomNode(num)

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
            if (size() == 1) {
                first = null
                last = null
            } else {
                first?.next = null
                first = newFirst
            }
            nodeNumber--
        } else {
            throw NoSuchElementException("First cannot be removed if the list is empty!")
        }
    }

    fun deleteLast() {
        if (!isEmpty()) {
            if (size() == 1) {
                first = null
                last = null
            } else {
                var newLast = first
                while (newLast != null) {
                    if (newLast.next == last) {
                        break
                    }
                    newLast = newLast.next
                }
                last?.next = null
                last = newLast
            }
        } else {
            throw NoSuchElementException("Last cannot be removed if the list is empty!")
        }
    }

    fun indexOf(num: Int): Int {
        var currentNode: CustomNode? = first
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