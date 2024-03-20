package main.kotlin.baekjoon.etc.ses9928

fun main() {
    val input = readln().toInt()
    println(solution(input))

}

private fun solution(input: Int): Int {
    var temp = 6
    var sum = 0
    var solved = 1
    while (true) {
        sum += temp
        temp += 6
        solved++
        if (input == 1) {
            return 1
        }
        if (input - sum <= 1) {
            break
        }
    }
    return solved
}