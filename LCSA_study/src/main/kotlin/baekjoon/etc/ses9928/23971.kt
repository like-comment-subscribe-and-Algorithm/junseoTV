package main.kotlin.baekjoon.etc.ses9928

private fun solution(h: Int, w: Int, n: Int, m: Int): Int {
    val answer = (1 + ((h - 1) / (n + 1))) * (1 + ((w - 1) / (m + 1)))
    return answer
}

private fun main() {
    val input = readln().split(" ").map { it.toInt() }
    println(solution(input[0], input[1], input[2], input[3]))
}
