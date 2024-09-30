package main.kotlin.baekjoon.etc.ses9928

private fun solution(n: Int, list: List<Int>, price: Int): Int {

    var totalPrice = 0

    list.forEach {
        totalPrice += it
    }

    if (totalPrice <= price) return list.last()

    var index = 0
    totalPrice = 0

    for (i in 0 until list.size) {
        if (list[i] * (n - i) <= price - totalPrice) {
            totalPrice += list[i]
        } else {
            index = i
            break
        }
    }

    val leftPrice = price - totalPrice
    val tempIndex = if (index < 1) 0 else index - 1
    var tempPrice = if (index < 1) 1 else list[tempIndex]

    for (i in tempPrice..price) {
        if (i * (n - index) > leftPrice) {
            break
        } else {
            tempPrice = i
        }
    }

    return tempPrice
}

private fun main() {
    val n = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    val price = readln().toInt()

    println(solution(n, list.sorted(), price))
}
