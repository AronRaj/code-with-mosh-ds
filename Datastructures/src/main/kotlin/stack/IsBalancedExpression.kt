package stack

import java.util.Stack

fun main() {
    val expressionOne = "[1 + {2} - <2>]"
    val expressionTwo = ")1("
    val expressionThree = ")1("
        println(isBalancedExpression(expressionOne))
        println(isBalancedExpression(expressionTwo))
        println(isBalancedExpression(expressionThree))
}

fun isBalancedExpression(expression: String):Boolean {
    val expressionStack = Stack<Char>()
    for (char in expression) {
        when(char){
            '{','[','<','('-> expressionStack.push(char)
            '}' -> if(expressionStack.isEmpty() || expressionStack.pop()!='{') return false
            ']' -> if(expressionStack.isEmpty() || expressionStack.pop()!='[') return false
            '>' -> if(expressionStack.isEmpty() || expressionStack.pop()!='<') return false
            ')' -> if(expressionStack.isEmpty() || expressionStack.pop()!='(') return false

        }
    }
    return expressionStack.isEmpty()
}