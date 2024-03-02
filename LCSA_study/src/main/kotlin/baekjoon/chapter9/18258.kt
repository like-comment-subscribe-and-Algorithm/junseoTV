package main.kotlin.baekjoon.chapter9

import java.util.*

val deque: Deque<Int> = LinkedList()

fun main() {
    val number: Int = readln().toInt()
    val solvedOutput: StringBuilder = StringBuilder()

    for (i in 0..<number) {
        val solved = solve(readln().split(" "))
        if (solved != -5) {
            solvedOutput.append(solved).append("\n")
        }
    }

    println(solvedOutput)
}

private fun solve(list: List<String>): Int {
    when (list[0]) {
        "pop" -> {
            return if (!deque.isEmpty()) {
                deque.removeFirst()
            } else {
                -1
            }
        }

        "size" -> {
            return deque.size
        }

        "empty" -> {
            return if (deque.isEmpty()) {
                1
            } else {
                0
            }
        }

        "front" -> {
            return deque.firstOrNull() ?: -1
        }

        "back" -> {
            return deque.lastOrNull() ?: -1
        }

        "push" -> {
            deque.addLast(list[1].toInt())
        }

        else -> {
            return -5
        }
    }
    return -5
}
