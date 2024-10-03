package main.kotlin.baekjoon.etc.ses9928

import java.util.*

private fun solution(input: List<Char>): Int {
    if (input.isEmpty()) return 0

    val aCount = input.count { it == 'a' }
    val bCount = input.size - aCount

    val all = mutableListOf<List<Char>>()

    for (i in 0..aCount) {
        val temp = mutableListOf<Char>()

        repeat(i) {
            temp.add('a')
        }

        repeat(bCount) {
            temp.add('b')
        }

        repeat(aCount - i) {
            temp.add('a')
        }

        all.add(temp)
    }

    for (i in 0..bCount) {
        val temp = mutableListOf<Char>()

        repeat(i) {
            temp.add('b')
        }

        repeat(aCount) {
            temp.add('a')
        }

        repeat(bCount - i) {
            temp.add('b')
        }

        all.add(temp)
    }

    val counts = PriorityQueue<Int>()

    for (i in 0 until all.size) {
        var count = 0

        for (j in 0 until input.size) {
            if (all[i][j] != input[j]) count++
        }

        if (count == 0) return 0

        counts.add(count)
    }

    return counts.first() / 2
}

private fun main() {
    val input = readln().toList()
    println(solution(input))
}
