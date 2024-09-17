package stack

fun main(){
    val stack = Stack(1)
    println( stack.pop())
    println( stack.peek())
    stack.push(10)
    stack.push(20)
    stack.push(30)
    stack.push(40)
    println(stack.peek())
    println(stack.pop())
    println(stack.pop())
    println(stack.pop())
    println(stack.pop())
    println(stack.pop())
}