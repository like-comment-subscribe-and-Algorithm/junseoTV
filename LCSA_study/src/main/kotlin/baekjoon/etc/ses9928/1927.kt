package main.kotlin.baekjoon.etc.ses9928

import java.util.*

private fun main() {
    val input = readln().toInt()
    val list = PriorityQueue<Int>()

    repeat(input) {
        val task = readln().toInt()

        when (task) {
            0 -> {
                if (list.isEmpty()) {
                    println(0)
                } else {
                    println(list.poll())
                }
            }

            else -> {
                list.add(task)
            }
        }
    }
}
