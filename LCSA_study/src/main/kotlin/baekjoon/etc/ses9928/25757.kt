package main.kotlin.baekjoon.etc.ses9928

private fun solution(n: Int, g: String): Int {
    return when (g) {
        "Y" -> n
        "F" -> n / 2
        "O" -> n / 3
        else -> 0
    }
}

private fun main() {
    val input = readln().split(" ")
    val players = HashSet<String>()

    for (i in 0 until input[0].toInt()) {
        players.add(readln())
    }

    println(solution(players.size, input[1]))
}
