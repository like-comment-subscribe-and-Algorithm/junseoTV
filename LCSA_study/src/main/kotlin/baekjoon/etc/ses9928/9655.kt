package main.kotlin.baekjoon.etc.ses9928

private fun solution(a: Int): String {
    var left = a
    var turn = 0

    while(left != 0) {
        turn++
        left = play(left)
    }

    return if (turn % 2 == 1) "SK" else "CY"
}

private fun play(left: Int): Int {
    return when {
        left >= 3 -> left - 3
        left == 2 -> left - 1
        left == 1 -> 0
        else -> 0
    }
}

private fun main() {
    val input = readln().toInt()
    println(solution(input))
}
