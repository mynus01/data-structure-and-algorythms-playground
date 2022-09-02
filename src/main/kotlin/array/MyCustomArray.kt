package array

class MyCustomArray(initialCapacity: Int) {
    private var array: IntArray = IntArray(initialCapacity)
    private var currentPosition = 0

    fun size() = array.size

    fun add(number: Int) {
        if (currentPosition == array.size) {
            val newArray = IntArray(currentPosition + 1)

            for ((position, item) in array.withIndex()) {
                newArray[position] = item
            }
            array = newArray
        }
        array[currentPosition] = number
        currentPosition++
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
        array[position] = 0
    }

    fun indexOf(number: Int): Int {
        for ((position, item) in array.withIndex()) {
            if (item == number) {
                return position
            }
        }
        return -1
    }
}