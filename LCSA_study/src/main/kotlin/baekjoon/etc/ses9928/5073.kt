package main.kotlin.baekjoon.etc.ses9928

fun main() {
    val solved: StringBuilder = StringBuilder()
    val end = List(3) { 0 }
    while (true) {
        val input = readln().split(" ").map { it.toInt() }
        if (input == end) {
            break
        }
        solved.append(solution(input)).append("\n")
    }
    println(solved)
}

private fun solution(list: List<Int>): String {
    val sorted = list.sorted()
    return if (sorted[2] >= sorted[0] + sorted[1]) {
        "Invalid"
    } else if (list[0] == list[1] && list[1] == list[2]) {
        "Equilateral"
    } else if (list[0] == list[1] || list[1] == list[2] || list[0] == list[2]) {
        "Isosceles"
    } else if (list[0] != list[1] && list[1] != list[2] && list[0] != list[2]) {
        "Scalene"
    } else {
        ""
    }
}