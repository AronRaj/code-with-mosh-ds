package linkedlist

fun main(){
    val linkedList = LinkedList()
    linkedList.addLast(10)
    linkedList.addLast(20)
    linkedList.addLast(30)
    linkedList.addLast(40)
    //linkedList.addLast(50)
    linkedList.print()
    println("----------")
    //linkedList.reverse()
    //linkedList.print()
    println(linkedList.findKthNodeFromEnd(4)?.value)
}