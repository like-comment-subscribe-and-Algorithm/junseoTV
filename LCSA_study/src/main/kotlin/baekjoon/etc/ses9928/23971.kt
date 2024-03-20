package main.kotlin.baekjoon.etc.ses9928

private fun solution(h: Int, w: Int, n: Int, m: Int): Int {
    var tempH = 0
    var tempW = 0
    var solved = 0

    while (true) {
        tempH += n + 1
        solved++
        if (tempH >= h) {
            tempH = solved
            solved = 0
            break
        }
    }

    while (true) {
        tempW += m + 1
        solved++
        if (tempW >= w) {
            tempW = solved
            break
        }
    }

    return tempH * tempW
}

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    println(solution(input[0], input[1], input[2], input[3]))
}