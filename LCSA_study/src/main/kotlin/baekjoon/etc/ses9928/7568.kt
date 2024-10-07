package main.kotlin.baekjoon.etc.ses9928

private fun solution(number: Int, info: List<Pair<Int, Int>>): Int {
    val toFind = info[number]
    var count = 1

    info.forEach {
        when {
            it.first > toFind.first && it.second > toFind.second -> count++
        }
    }

    return count
}

private fun main() {
    val input = readln().toInt()
    val input2 = mutableListOf<Pair<Int, Int>>()
    var answer = ""

    for (i in 0 until input) {
        val input3 = readln().split(" ").map { it.toInt() }
        input2.add(Pair(input3[0], input3[1]))
    }

    for (i in 0 until input2.size) {
        answer += "${solution(i, input2)} "
    }

    println(answer)
}
