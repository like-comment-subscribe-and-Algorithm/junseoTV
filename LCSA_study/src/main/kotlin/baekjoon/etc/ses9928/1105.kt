package main.kotlin.baekjoon.etc.ses9928

fun main() {
    val input = readln().split(" ").map { it.toInt() }

    println(solution(input))
}

private fun solution(input: List<Int>): Int {
    val lList = input[0].toString().toList()
    val rList = input[1].toString().toList()
    var count = 0

    if (lList.size != rList.size) {
        return 0
    }

    for (i in 0..<lList.size) {
        if (lList[i] == rList[i] && lList[i] == '8') {
            count++
        } else if (lList[i] != rList[i]) {
            break
        }
    }

    return count
}
