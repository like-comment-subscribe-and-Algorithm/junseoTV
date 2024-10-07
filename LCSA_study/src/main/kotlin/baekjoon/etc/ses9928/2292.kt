package main.kotlin.baekjoon.etc.ses9928

private fun solution(a: Int): Int {
    if (a == 1) return 1
    var count = 1
    var temp = a
    var offset = 1

    while(true) {
        temp -= offset
        if (temp <= 0) return count
        count++
        offset = 6+(6*(count-2))
    }
}

private fun main() {
    val input = readln().toInt()
    println(solution(input))
}
