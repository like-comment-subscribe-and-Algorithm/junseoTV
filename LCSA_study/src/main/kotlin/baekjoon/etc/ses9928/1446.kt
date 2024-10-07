package main.kotlin.baekjoon.etc.ses9928

val prices = mutableListOf<Int>()

data class Short(
    val start: Int = 0,
    val end: Int = 0,
    val price: Int = 0,
)

private fun solution(d: Int, list: List<Short>): Int {

    for (i in 0..d) {
        if (i >= 1) prices[i] = minOf(prices[i], prices[i - 1] + 1)

        if (list.find { it.start == i } != null) {
            for (j in 0 until list.size) {
                if (prices[list[j].start] + list[j].price < prices[list[j].end]) {
                    prices[list[j].end] = prices[list[j].start] + list[j].price
                }
            }
        }
    }

    return prices[d]
}

private fun main() {
    val setting = readln().split(" ").map { it.toInt() }

    for (i in 0..setting[1]) {
        prices.add(i)
    }

    val list = mutableListOf<Short>()

    for (i in 0 until setting[0]) {
        val short = readln().split(" ").map { it.toInt() }
        if (setting[1] < short[1]) continue
        list.add(Short(short[0], short[1], short[2]))
    }

    println(solution(setting[1], list))
}
