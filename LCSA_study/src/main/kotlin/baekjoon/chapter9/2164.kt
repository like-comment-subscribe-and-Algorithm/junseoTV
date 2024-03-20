package main.kotlin.baekjoon.chapter9

import java.util.Deque
import java.util.LinkedList

fun main() {
    println(solve(readln().toInt()))
}

private fun solve(input: Int): Int {
    val deque: Deque<Int> = LinkedList()

    for (i in 1..input) {
        deque.addLast(i)
    }

    while (true) {
        if (deque.size == 1) {
            return deque.peek()
        }
        deque.pop()
        deque.addLast(deque.peekFirst())
        deque.pop()
    }
}