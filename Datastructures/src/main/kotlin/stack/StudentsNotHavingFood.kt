package stack


import java.util.Stack

fun countStudents(students: IntArray, sandwiches: IntArray): Int {
    val studentQueue = ArrayDeque<Int>()
    val sandwichStack = Stack<Int>()
    for (student in students) {
        studentQueue.addLast(student)
    }
    var count = sandwiches.size - 1
    while (count >= 0) {
        sandwichStack.push(sandwiches[count])
        count--
    }
    while (studentQueue.isNotEmpty()) {
        if (studentQueue.contains(sandwichStack.peek())) {
            val firstStudent = studentQueue.removeFirst()
            if (firstStudent == sandwichStack.peek()) {
                sandwichStack.pop()
            } else {
                studentQueue.addLast(firstStudent)
            }
        } else {
            return studentQueue.size
        }
    }

    return studentQueue.size
}

fun main() {
    println(countStudents(intArrayOf(1,1,0,0), intArrayOf(0, 1, 0, 1)))
    println(countStudents(intArrayOf(1, 1, 1, 0, 0, 1), intArrayOf(1, 0, 0, 0, 1, 1)))
}