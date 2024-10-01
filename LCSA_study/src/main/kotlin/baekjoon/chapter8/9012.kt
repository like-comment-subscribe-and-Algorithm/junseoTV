package main.kotlin.baekjoon.chapter8

import java.util.*

fun main() {
    val inputNumber: Int = readln().toInt()
    val inputList: Array<String> = Array(inputNumber) { readln() }

    for (element in inputList) {
        if (solve(element)) {
            println("YES")
        } else {
            println("NO")
        }
    }
}

private fun solve(input: String): Boolean {
    val list = input.split("").map { it }
    val stack: Stack<String> = Stack()
    for (element in list) {
        if (element == "(") {
            stack.push(element)
        } else if (element == ")" && stack.size == 0) {
            return false
        } else if (element == ")" && stack.peek() == "(") {
            stack.pop()
        }
    }
    return stack.size == 0
}