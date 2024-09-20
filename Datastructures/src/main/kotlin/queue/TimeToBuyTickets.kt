package queue

import kotlin.contracts.contract

fun timeRequiredToBuy(tickets: IntArray, k: Int): Int {
    var timeTaken = 0
    val peopleQueue = ArrayDeque<Int>()
    tickets.forEachIndexed { index, item ->
        peopleQueue.add(index)
    }
    while (tickets[k] > 0) {
        val front = peopleQueue.removeFirst()
        if (k == front && tickets[k] == 0) {
            return timeTaken
        } else {
            if (tickets[front] != 0) {
                tickets[front] = tickets[front] - 1
                timeTaken += 1
            }
            peopleQueue.add(front)
        }
    }
    return timeTaken
}
//

fun main() {
    val ticketsArrayOne = intArrayOf(2, 3, 2)
    println(timeRequiredToBuy(ticketsArrayOne, 2))
    val ticketsArrayTwo = intArrayOf(5, 1, 1, 1)
    println(timeRequiredToBuy(ticketsArrayTwo, 0))
    val ticketsArrayThree = intArrayOf(84, 49, 5, 24, 70, 77, 87, 8)
    println(timeRequiredToBuy(ticketsArrayThree, 3))
}