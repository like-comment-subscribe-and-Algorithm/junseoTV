package main.kotlin.baekjoon.chapter5

val factorial: MutableList<Int> = mutableListOf()

fun main() {
    val n: Int = readln().toInt()

    preCount(3)

    val list: MutableList<Long> = mutableListOf(solve(1), solve(2))

    for (i in 2..<n) {
        list.add((list[i - 1] + list[i - 2]) % 15746)
    }

    println(list[n - 1])
}

private fun preCount(n: Int) {
    factorial.add(1)

    for (i in 1..n) {
        factorial.add(i * factorial[i - 1])
    }
}

private fun solve(n: Int): Long {
    var temp: Int = 0
    var solved: Long = 0

    for (i in 0..n / 2) {
        temp = factorial[n - i] / (factorial[i] * factorial[n - (2 * i)])
        solved += temp
    }
    return solved
}