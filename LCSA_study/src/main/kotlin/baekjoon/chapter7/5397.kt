package main.kotlin.baekjoon.chapter7

import java.util.*

fun main() {
    val n: Int = readln().toInt()
    val solved: MutableList<String> = mutableListOf()
    for (i in 0..<n) {
        solved.add(readln())
    }
    for (i in 0..<n) {
        solve(solved[i])
    }
}

private fun solve(input: String) {
    val left: LinkedList<Char> = LinkedList()
    val right: LinkedList<Char> = LinkedList()

    for (char in input) {
        when (char) {
            '>' -> if (right.size != 0) {
                left.addLast(right.first())
                right.removeFirst()
            }

            '<' -> if (left.size != 0) {
                right.addFirst(left.last())
                left.removeLast()
            }

            '-' -> if (left.size != 0) {
                left.removeLast()
            }

            else -> {
                left.add(char)
            }
        }
    }
    println(left.toCharArray() + right.toCharArray())
}
