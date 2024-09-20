package queue

import java.util.Stack

class StackQueue {
    val stackOne = Stack<Int>()
    val stackTwo = Stack<Int>()
    fun enqueue(element: Int) {
        stackOne.push(element)
    }

    fun dequeue(): Int? {
        if(isEmpty())
            return null
        populate()
        return stackTwo.pop()
    }

    fun peek(): Int {
        populate()
        return stackTwo.peek()
    }

    fun isEmpty(): Boolean {
        return stackTwo.isEmpty() && stackOne.isEmpty()
    }

    override fun toString(): String {
        return "$stackTwo---$stackOne"
    }

    private fun populate(){
        if(!stackTwo.isEmpty())
            return
        while (!stackOne.isEmpty()){
            stackTwo.push(stackOne.pop())
        }
    }
}