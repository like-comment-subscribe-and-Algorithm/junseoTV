package main.kotlin.baekjoon.etc.ses9928

import java.util.*

private fun solution(n: Int, x: Int, list: List<Int>): String {

    var total = 0
    val prices = LinkedList<Int>()

    for (i in 0 until x) {
        total += list[i]
    }

    if (n == x && total == 0) return "SAD"

    if (n == x) return "$total\n1"
    prices.add(total)

    for (i in 1..n - x) {
        total = total - list[i - 1] + list[i + x - 1]
        prices.add(total)
    }

    val sortedPrices = prices.sorted().reversed()
    var count = 0

    if (sortedPrices[0] == 0) return "SAD"

    sortedPrices.forEach {
        if (sortedPrices[0] == it) count++ else return "${sortedPrices[0]}\n$count"
    }

    return "${sortedPrices[0]}\n$count"
}

private fun main() {
    val input = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toInt() }

    println(solution(input[0], input[1], list))
}
