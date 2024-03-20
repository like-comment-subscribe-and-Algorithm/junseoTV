package main.kotlin.baekjoon.chapter4

lateinit var array: Array<IntArray>
var white: Int = 0
var blue: Int = 0

private fun count(size: Int, first: Int, second: Int) {
    var boolean: Boolean = true
    for (i in first..<first + size) {
        for (j in second..<second + size) {
            if (array[first][second] != array[i][j]) {
                boolean = false
                break
            }
        }
    }

    if (!boolean) {
        count(size / 2, first, second)
        count(size / 2, first + size / 2, second)
        count(size / 2, first, second + size / 2)
        count(size / 2, first + size / 2, second + size / 2)
    } else {
        sum(array[first][second])
    }
}

private fun sum(input: Int) {
    if (input == 0) {
        white++
    } else {
        blue++
    }
}

fun main() {
    val n = readln().toInt()
    array = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }

    count(n, 0, 0)
    println(white)
    println(blue)
}