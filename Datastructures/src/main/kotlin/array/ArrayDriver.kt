package array

fun main(){
    val array = Array(3)
    array.insert(2)
    array.insert(5)
    array.insert(3)
    array.insert(7)
    array.print()
    println(array.indexOf(3))
    array.removeAt(2)
    println(array.print())
    println(array.indexOf(2))
    array.insert(10)
    println(array.print())
    array.removeAt(10)
}