package queue



fun main(){
    val queue = ArrayQueue(5)
   queue.enqueue(10)
   queue.enqueue(20)
   queue.enqueue(30)
   queue.enqueue(40)
   queue.enqueue(50)
    println(queue)
    println(queue.dequeue())
    println(queue.dequeue())
    println(queue)
    queue.enqueue(60)
    println(queue)
    queue.enqueue(70)
    println(queue)
    queue.enqueue(80)
    println(queue)
}

fun reverse(queue:ArrayQueue){
    if(queue.isEmpty())
        return
    val stack = java.util.Stack<Int>()
    while (!queue.isEmpty()){
        stack.push(queue.dequeue())
    }
    while (!stack.isEmpty()){
        queue.enqueue(stack.pop())
    }

}