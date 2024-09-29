package main.kotlin.baekjoon.etc.ses9928

import java.util.*

private fun solution(a: Int): Int {
    val list = LinkedList<Int>()
    for (i in 1..a) {
        list.add(i)
    }
    for (i in 0 until a - 1) {
        list.removeAt(0)
        val temp = list[0]
        list.removeAt(0)
        list.add(temp)
    }

    return list[0]
}

private fun main() {
    println(solution(readln().toInt()))
}
