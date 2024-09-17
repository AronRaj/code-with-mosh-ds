package queue

import java.util.*

class ArrayQueue(private val size: Int) {
    val data = arrayOfNulls<Int>(size)
    var front = 0
    var rear = 0
    var count =0
    fun enqueue(element: Int) {
        if (isFull())
            throw IllegalStateException("Queue is full")
        data[rear] = element
        rear =(rear+1) % data.size
        count+=1
    }

    fun dequeue(): Int? {
        if (isEmpty())
            throw IllegalStateException("Queue is empty")
        val item = data[front]
        data[front]=0
        front =(front+1)%data.size
        count-=1
        return item
    }

    fun peek(): Int? {
        return data[front]
    }

    fun isEmpty(): Boolean {
        return count ==0
    }

    fun isFull(): Boolean {
        return count == data.size
    }

    override fun toString():String{
       return data.contentToString()
    }
}