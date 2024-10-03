package main.kotlin.baekjoon.etc.ses9928

import java.util.*

data class Convey(
    val ability: Int = 0,
    val isRobot: Boolean = false,
)

private fun solution(length: Int, maxUn: Int, list: List<Convey>): Int {
    var count = 0
    val linked = LinkedList<Convey>()
    list.forEach {
        linked.add(it)
    }

    while (true) {
        count++

        // 회전
        val last = linked.last()
        linked.removeLast()
        linked.addFirst(last)

        // 로봇 버리기
        if (linked[length - 1].isRobot) linked[length - 1] = linked[length - 1].copy(isRobot = false)

        // 로봇 이동하기
        for (i in 0 until length) {
            if (linked[length - i - 1].isRobot && !linked[length - i].isRobot && linked[length - i].ability >= 1) {
                linked[length - i] = linked[length - i].copy(linked[length - i].ability - 1, true)
                linked[length - i - 1] = linked[length - i - 1].copy(isRobot = false)
            }
        }

        // 로봇 버리기
        if (linked[length - 1].isRobot) linked[length - 1] = linked[length - 1].copy(isRobot = false)

        // 로봇 놓기
        if (linked[0].ability >= 1) linked[0] = linked[0].copy(linked[0].ability - 1, true)

        if (getInvalid(linked, maxUn)) return count
    }
}

fun getInvalid(list: List<Convey>, maxUn: Int): Boolean {
    var count = 0
    list.forEach {
        if (it.ability <= 0) count++
    }
    return count >= maxUn
}

private fun main() {
    val input = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { Convey(it.toInt(), false) }

    println(solution(input[0], input[1], list))
}
