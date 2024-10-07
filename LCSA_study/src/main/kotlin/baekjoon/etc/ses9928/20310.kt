package main.kotlin.baekjoon.etc.ses9928

private fun solution(list: List<Int>): String {
    var result = ""
    var zeroCount = 0
    var oneCount = 0

    list.forEach {
        when (it) {
            0 -> zeroCount++
            1 -> oneCount++
        }
    }

    repeat(zeroCount / 2) {
        result += "0"
    }

    repeat(oneCount / 2) {
        result += "1"
    }

    return result
}

private fun main() {
    val input = readln().split("").filter { it == "0" || it == "1" }.map { it.toInt() }
    println(solution(input))
}
