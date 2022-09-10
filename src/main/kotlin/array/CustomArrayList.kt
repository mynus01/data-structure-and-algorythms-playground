package array

class CustomArrayList(initialCapacity: Int) {
    private var array: IntArray = IntArray(initialCapacity)
    private var count = 0

    fun size() = array.size

    fun add(number: Int) {
        if (count == array.size) {
            val newArray = IntArray(count + 1)

            for ((index, item) in array.withIndex()) {
                newArray[index] = item
            }
            array = newArray
        }
        array[count++] = number
    }

    fun get(position: Int): Int {
        if (position >= array.size || position < 0) {
            throw IllegalArgumentException("Index doesn't exist within array!")
        }
        return array[position]
    }

    fun removeAt(position: Int) {
        if (position >= array.size || position < 0) {
            throw IllegalArgumentException("Index doesn't exist within array!")
        }

        val newArray = IntArray(--count)
        var counter = 0

        for ((index, item) in array.withIndex()) {
            if (index != position) {
                newArray[counter++] = item
            }
        }
        array = newArray
    }

    fun indexOf(number: Int): Int {
        for ((index, item) in array.withIndex()) {
            if (item == number) {
                return index
            }
        }
        return -1
    }
}