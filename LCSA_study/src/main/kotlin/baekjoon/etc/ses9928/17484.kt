package main.kotlin.baekjoon.etc.ses9928

private fun solution(beforeMove: String, beforePrice: Int, list: List<List<Int>>, currentPos: Pair<Int, Int>): Int {
    if (currentPos.first == list.size - 1) return beforePrice + list[currentPos.first][currentPos.second]

    val isEndOfLeft = currentPos.second == 0
    val isEndOfRight = currentPos.second == list[0].size - 1

    val l = solution(
        "l",
        beforePrice + list[currentPos.first][currentPos.second],
        list,
        Pair(currentPos.first + 1, if (isEndOfLeft) 0 else currentPos.second - 1)
    )
    val s = solution(
        "s",
        beforePrice + list[currentPos.first][currentPos.second],
        list,
        Pair(currentPos.first + 1, currentPos.second)
    )
    val r = solution(
        "r",
        beforePrice + list[currentPos.first][currentPos.second],
        list,
        Pair(currentPos.first + 1, if (isEndOfRight) 0 else currentPos.second + 1)
    )

    return when {
        isEndOfRight && beforeMove == "l" -> s
        beforeMove == "l" -> minOf(r, s)

        isEndOfLeft && beforeMove == "r" -> s
        beforeMove == "r" -> minOf(s, l)

        isEndOfLeft && beforeMove == "s" -> r
        isEndOfRight && beforeMove == "s" -> l
        beforeMove == "s" -> minOf(r, l)

        isEndOfRight && beforeMove == "n" -> minOf(s, l)
        isEndOfLeft && beforeMove == "n" -> minOf(s, r)
        beforeMove == "n" -> minOf(s, r, l)

        else -> 10000
    }
}

private fun main() {
    val input = readln().split(" ").map { it.toInt() }
    val matrix = mutableListOf<List<Int>>()
    val result = mutableListOf<Int>()

    for (i in 0 until input[0]) {
        matrix.add(readln().split(" ").map { it.toInt() })
    }

    for (i in 0 until matrix[0].size) {
        result.add(solution("n", 0, matrix, Pair(0, i)))
    }

    println(result.minOf { it })
}
