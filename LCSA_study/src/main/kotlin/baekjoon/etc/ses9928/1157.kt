package main.kotlin.baekjoon.etc.ses9928

fun main() {
    val input = readln()
    println(solution(input))
}

private fun solution(input: String): Char {
    val list = input.toMutableList()
    for (i in 0..<list.size) {
        list[i] = list[i].uppercaseChar()
    }
    val sorted = list.sorted()
    var count = 0
    var tempCount = 1
    var solved = 'a'
    for (i in 0..<sorted.size) {
        if (sorted.size == 1) {
            return sorted[0]
        }
        if (i == 0) {
            count++
        } else if (sorted[i] == sorted[i - 1]) {
            count++
            if (i == sorted.size - 1) {
                if (tempCount < count) {
                    solved = sorted[i]
                } else if (tempCount == count) {
                    solved = '?'
                }
            }
        } else {
            if (tempCount < count) {
                tempCount = count
                count = 1
                solved = sorted[i - 1]
            } else if (tempCount == count) {
                solved = '?'
                count = 1
            } else {
                count = 1
            }
        }
    }
    return solved
}