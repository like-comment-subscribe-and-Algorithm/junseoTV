package main.kotlin.baekjoon.chapter8

import java.util.Stack

var stack: Stack<String> = Stack()

fun main() {
    val output: StringBuilder = StringBuilder()
    var input: List<String> = listOf()


    while (true) {
        input = readln().split("").map { it }
        if (input[1] == "." && input.size == 3) {
            break
        }
        if (solve(input)) {
            output.append("yes").append("\n")
        } else {
            output.append("no").append("\n")
        }
    }

    println(output)
}

private fun solve(input: List<String>): Boolean {
    stack = Stack()

    for (i in 0..<input.size) {
        when (input[i]) {
            "(" -> if (!check("(")) {
                return false
            }

            ")" -> if (!check(")")) {
                return false
            }

            "[" -> if (!check("[")) {
                return false
            }

            "]" -> if (!check("]")) {
                return false
            }

            else -> {}
        }
    }
    return stack.isEmpty()
}

private fun check(item: String): Boolean {
    if (stack.isEmpty() && item == "(") {
        stack.push(item)
    } else if (stack.isEmpty() && item == "[") {
        stack.push(item)
    } else if (stack.isEmpty()) {
        return false
    } else if (stack.peek() == "(" && item == "]") {
        return false
    } else if (stack.peek() == "[" && item == ")") {
        return false
    } else if (stack.peek() == "(" && item == ")") {
        stack.pop()
    } else if (stack.peek() == "[" && item == "]") {
        stack.pop()
    } else {
        stack.push(item)
        return true
    }

    return true
}