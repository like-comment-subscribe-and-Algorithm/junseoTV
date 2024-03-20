package main.kotlin.baekjoon.chapter9

fun main() {
    val number: Int = readln().toInt()
    val list: MutableList<Int> = mutableListOf()
    var first: List<Int> = listOf()
    var second: List<Int> = listOf()
    for (i in 1..number) {
        first = readln().split(" ").map { it.toInt() }
        second = readln().split(" ").map { it.toInt() }
        list.add(solve(first, second))
    }
    for (i in 0..<number) {
        println(list[i])
    }
}

private fun solve(first: List<Int>, second: List<Int>): Int {
    var count: Int = 1
    val temp: MutableList<Int> = second.toMutableList()
    var index: Int = first[1]
    var sorted: List<Int> = second.sortedDescending()
    val firstValue: Int = second[index]

    while (true) {
        sorted = temp.sortedDescending()
        if (sorted[0] != temp[0]) {
            temp.add(temp[0])
            temp.removeAt(0)

            if (index == 0) {
                index = temp.size - 1
            } else {
                index--
            }
        } else {
            if (sorted[0] == firstValue && index == 0) {
                break
            }
            temp.removeAt(0)

            if (index == 0) {
                index = temp.size - 1
            } else {
                index--
            }
            if (sorted[0] >= firstValue) {
                count++
            }
        }
    }
    return count
}