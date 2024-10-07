package main.kotlin.baekjoon.etc.ses9928

private fun solution(h: Int, w: Int, list: List<Int>): Int {
    var answer = 0
    for (i in 1..list.maxOf { it }) {
        val temp = mutableListOf<Int>()
        for (j in 0 until list.size) {
            if (list[j] >= i) temp.add(j)
        }
        if (temp.size <= 1) {
            continue
        } else {
            for (k in 0 until temp.size - 1) {
                answer += temp[k + 1] - temp[k] - 1
            }
        }
    }

    return answer
}

private fun main() {
    val size = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toInt() }
    println(solution(size[0], size[1], list))
}
