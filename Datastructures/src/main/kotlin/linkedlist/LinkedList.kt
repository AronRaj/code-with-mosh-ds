package linkedlist

class LinkedList {
    //contains
    //indexOf
    var first: Node? = null
    var last: Node? = null
    var size = 0

    fun addFirst(value: Int) {
        val node = Node(value, null)
        if (isEmpty()) {
            first = node
            last = node
        } else {
            val currentNode = first
            node.next = currentNode
            first = node
        }
        increment()
    }

    fun addLast(value: Int) {
        val newNode = Node(value, null)
        if (isEmpty()) {
            first = newNode
            last = newNode
        } else {
            last?.next = newNode
            last = newNode
        }
        increment()
    }

    fun deleteFirst() {
        if (isEmpty())
            return
        decrement()
        if (first == last) {
            first = null
            last = null
            return
        }
        val currentNode = first?.next
        first?.next = null
        first = currentNode
    }

    fun deleteLast() {
        if (isEmpty())
            return
        decrement()
        if (first == last) {
            first = null
            last = null
            return
        }
        val prevNode = getLastPrevNode(first, null)
        prevNode?.next = null
        last = prevNode

    }

    fun indexOf(value: Int): Int {
        if (isEmpty())
            return -1
        var index = 0
        var currentNode = first
        while (currentNode != null) {
            if (currentNode.value == value)
                return index
            else {
                index += 1
                currentNode = currentNode.next
            }
        }
        return -1
    }

    fun contains(value: Int): Boolean {
        return indexOf(value) >= 0
    }

    fun reverse() {
        if(isEmpty())
            return

        var prevNode = first
        var currentNode = first?.next

        while (currentNode!=null){
            val next = currentNode.next
            currentNode.next = prevNode

            prevNode = currentNode
            currentNode = next
        }
        last = first
        last?.next = null
        first = prevNode


    }

    fun findKthNodeFromEnd(position:Int):Node? {
        //[10,20,30,40,50]
        //        c ,   n
        if(isEmpty())
            return null
        if(position>size)
            return null
        var currentNode = first
        var nextNode:Node? = first
        var index =0
        while (index<position){
            nextNode = nextNode?.next
            index++
        }
        while(nextNode?.next!=null){
            currentNode = currentNode?.next
            nextNode = nextNode.next
        }
        return currentNode
    }

    fun increment() {
        size += 1
    }

    fun decrement() {
        size -= 1
    }

    fun size(): Int {
        return size
    }

    fun print() {
        printRecursive(first)
    }

    fun printRecursive(node: Node?) {
        println(node?.value)
        if (node?.next == null)
            return
        printRecursive(node.next)
    }

    private fun getLastPrevNode(currentNode: Node?, prevNode: Node?): Node? {
        return if (currentNode?.next == null)
            prevNode
        else
            getLastPrevNode(currentNode.next, currentNode)
    }

    private fun isEmpty(): Boolean {
        return first == null && last == null
    }

}