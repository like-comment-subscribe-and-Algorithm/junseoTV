package main.kotlin.baekjoon.etc.ses9928

private fun solution(n: Int, m: Int, x: List<Int>): Int {
    if (m == 1) return maxOf(x[0], n - x[0])
    var h = 0

    while (x[0] - h > 0 || x[m - 1] + h < n) {
        h++
    }

    for (i in 1 until m) {
        if (x[i - 1] + h < x[i] - h) {
            val offset = (x[i] - h - x[i - 1] - h)
            h += if (offset % 2 == 1) (offset / 2) + 1 else offset / 2
        }
    }

    return h
}

private fun main() {
    val input = readln().toInt()
    val input2 = readln().toInt()
    val input3 = readln().split(" ").map { it.toInt() }

    println(solution(input, input2, input3))
}
