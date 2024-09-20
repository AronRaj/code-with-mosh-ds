package queue

import java.util.*

class PriorityQueue {
    val items = arrayOf(0,0,0,0,0)
    var count = 0;

    fun add(element: Int) {
        if(isFull())
            return
        var index = count-1
        while(index>=0){
            if(items[index] >element){
                items[index+1] = items[index]
            }else{
                break
            }
            index--
        }
        items[index+1]=element
        count +=1
    }

    fun remove(): Int? {
        if (isEmpty())
            return null
        count -= 1
       val item =items[count]

        return item
    }

    fun isEmpty(): Boolean {
        return count == 0
    }

    fun isFull(): Boolean {
        return count == items.size
    }

    override fun toString(): String {
        return items.contentToString()
    }
}