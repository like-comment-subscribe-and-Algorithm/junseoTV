package main.kotlin.baekjoon.etc.ses9928

private fun solution(input: Int): Int {
    var answer = 0

    for (i in 0..input / 3) {
        for (j in 0..input / 2) {
            if ((i * 3) + (j * 2) <= input) {
                answer++
            } else break
        }
    }

    return answer
}

private fun main() {
    val n = readln().toInt()

    repeat(n) {
        println(solution(readln().toInt()))
    }
}
