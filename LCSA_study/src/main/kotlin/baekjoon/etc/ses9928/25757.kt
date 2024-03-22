package main.kotlin.baekjoon.etc.ses9928

fun main() {
    val input = readln().split(" ").map { it }
    val list: MutableList<String> = mutableListOf()

    for (i in 0..<input[0].toInt()) {
        list.add(readln())
    }

    println(solution(list.sorted().toMutableList(), input[0].toInt(), input[1]))
}

private fun solution(list: MutableList<String>, n: Int, game: String): Int {
    val tempList = list
    var count = 0

    for (i in 0..<list.size - 1) {
        for (j in i + 1..<list.size) {
            if (list[i] != list[j]) {
                break
            }
            if (list[i] == list[j]) {
                count++
            }
        }
        for (j in 1..count) {
            tempList.remove(list[i])
        }
        count = 0
    }

    return when (game) {
        "Y" -> tempList.size
        "F" -> tempList.size / 2
        "O" -> tempList.size / 3
        else -> 0
    }
}