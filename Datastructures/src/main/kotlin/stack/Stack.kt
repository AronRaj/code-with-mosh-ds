package stack

class Stack(length:Int) {
    var items = arrayOfNulls<Int>(length)
    var top = 0;

    fun push(value: Int) {
        if(top== items.size){
            val newItems = arrayOfNulls<Int>(items.size*2)
            items.forEachIndexed { index, i ->
                newItems[index] = i
            }
            items = newItems
        }
        items[top] = value
        top++
    }

    fun pop(): Int? {
        if (top == 0)
            return null
        top--
        return items[top]

    }

    fun peek(): Int? {
        if (top == 0)
            return null
        return items[top-1]
    }

    fun isEmpty(): Boolean {
        return top == 0
    }
}