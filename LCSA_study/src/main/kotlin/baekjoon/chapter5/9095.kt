package main.kotlin.baekjoon.chapter5

fun factorial(n: Int): Int {
    var output: Int = 1

    if (n == 0) {
        return 1
    }
    for (i in 1..n) {
        output *= i
    }
    return output
}

fun countAlign(i: Int, j: Int, k: Int): Int {
    return factorial(i + j + k) / (factorial(i) * factorial(j) * factorial(k))
}

fun solve(n: Int): Int {
    var solved: Int = 0
    for (i in 0..n / 2) {
        for (j in 0..(n - 2 * i) / 3) {
            solved += countAlign(n - 2 * i - 3 * j, i, j)
        }
    }
    return solved
}

fun main() {
    val n: Int = readln().toInt()
    val array: Array<Int> = Array(n) { 0 }
    for (i in 0..<n) {
        array[i] = readln().toInt()
    }
    for (element in array) {
        println(solve(element))
    }
}