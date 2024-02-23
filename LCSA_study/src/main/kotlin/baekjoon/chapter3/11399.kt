package main.kotlin.baekjoon.chapter3

fun main() {
    val number = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }

    var sum: Int = 0
    val sorted = list.sorted()
    for (i in sorted.indices) {
        sum += sorted[i]*(sorted.size-i)
    }
    println(sum)
}