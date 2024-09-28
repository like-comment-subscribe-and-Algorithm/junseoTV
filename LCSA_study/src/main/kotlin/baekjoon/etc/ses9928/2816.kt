package main.kotlin.baekjoon.etc.ses9928

private fun solution(a: List<String>): String {
    var answer = ""
    val pos1 = a.indexOf("KBS1")
    var pos2 = a.indexOf("KBS2")

    if (pos1 == 1 && pos2 ==0) return "3"
    if (pos2 == 0) answer += "32"

    for (i in 0 until pos1) {
        answer += "1"
    }

    for (i in 0 until pos1) {
        answer += "4"
    }

    if (pos2 == 0) return answer
    if (pos1 > pos2) pos2++

    for (i in 0 until pos2) {
        answer += "1"
    }

    for (i in 0 until pos2 - 1) {
        answer += "4"
    }
    return answer
}

private fun main() {
    val input = readln().toInt()
    val channels = mutableListOf<String>()

    for (i in 0 until input) {
        channels.add(readln())
    }

    println(solution(channels))
}
