package main.kotlin.baekjoon.etc.ses9928

private fun solution(a: Int, b: List<List<Int>>): Int {
    var count = 1
    val toFind = b.find { it[0] == a } ?: emptyList()

    b.forEach {
        if (it[1] > toFind[1]) {
            count++
        }
        if (it[1] == toFind[1] && it[2] > toFind[2]) {
            count++
        }
        if (it[1] == toFind[1] && it[2] == toFind[2] && it[3] > toFind[3]) {
            count++
        }
    }

    return count
}

private fun main() {
    val input = readln().split(" ").map { it.toInt() }
    val input2 = mutableListOf<List<Int>>()

    for (i in 0 until input[0]) {
        input2.add(readln().split(" ").map { it.toInt() })
    }

    println(solution(input[1], input2).toString())
}
