package main.kotlin.baekjoon.etc.ses9928

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    val list: MutableList<MutableList<Int>> = mutableListOf()

    for (i in 1..input[0]) {
        list.add(readln().split(" ").map { it.toInt() }.toMutableList())
    }

    println(solution(list, input[1]))
}

fun solution(list: MutableList<MutableList<Int>>, country: Int): Int {
    var count = 1
    for (i in 0..<list.size) {
        if (list[i][0] == country) {
            list.add(list[i])
            list.removeAt(i)
            break
        }
    }

    for (i in 0..<list.size - 1) {
        if (list[list.size - 1][1] < list[i][1]) {
            count++
        }
        if (list[list.size - 1][1] == list[i][1] && list[list.size - 1][2] < list[i][2]) {
            count++
        }
        if (list[list.size - 1][1] == list[i][1] && list[list.size - 1][2] == list[i][2] && list[list.size - 1][3] < list[i][3]) {
            count++
        }
    }

    return count
}