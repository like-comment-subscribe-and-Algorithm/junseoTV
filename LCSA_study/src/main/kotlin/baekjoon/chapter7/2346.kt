package main.kotlin.baekjoon.chapter7

fun main() {
    val number: Int = readln().toInt()
    val innerNumbers: List<Int> = readln().split(" ").map { it.toInt() }

    val solved = solve(number, innerNumbers)
    val output: StringBuilder = StringBuilder()
    output.append(solved[0])
    for (i in 1..<solved.size) {
        output.append(" ").append(solved[i])
    }
    println(output)
}

private fun solve(number: Int, innerNumbers: List<Int>): MutableList<Int> {
    val list = innerNumbers.toMutableList()
    val firstIndex: MutableList<Int> = mutableListOf()
    val solved: MutableList<Int> = mutableListOf()
    solved.add(1)
    var index: Int = 0

    for (i in 1..number) {
        firstIndex.add(i)
    }

    for (i in 0..<number - 1) {
        val inner = list[index]
        list.removeAt(index)
        firstIndex.removeAt(index)
        index += if (inner >= 0) {
            inner - 1
        } else {
            inner
        }
        while (true) {
            if (index < 0) {
                index += list.size
            } else if (index >= list.size) {
                index -= list.size
            } else {
                break
            }
        }
        solved.add(firstIndex[index])
    }
    return solved
}