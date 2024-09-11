package array

class Array(private val length: Int) {
    var items = arrayOfNulls<Int>(length)
    var count = 0

    fun insert(item: Int) {
        if (isFull()) {
            val newItems = arrayOfNulls<Int>(length*2)
            items.forEachIndexed { index, i ->
                newItems[index]=i
            }
            items = newItems
        }
        items[count] = item
        count++
    }

    fun indexOf(item: Int): Int {
        if (isEmpty())
            return -1
        items.forEachIndexed { index, i ->
            if (i == item)
                return index
        }
        return -1
    }

    fun removeAt(position: Int) {
        if (isEmpty())
            throw IllegalArgumentException("Array is empty")
        if (position<0 || position >= count)
            throw IndexOutOfBoundsException()
        for(i in position until items.size-1){
            items[i] = items[i+1]
        }
        count--
    }

    fun insertAt(item: Int, position: Int) {

    }

    fun isEmpty(): Boolean {
        return count == 0
    }

    fun isFull(): Boolean {
        return items.size == count
    }

    fun print() {
        items.forEachIndexed { index, i ->
            if(index<count)
            println(i) }
    }
}