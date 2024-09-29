package main.kotlin.baekjoon.etc.ses9928

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

private fun solution(length: Int, words: List<String>): List<String> {
    val wordMap = mutableMapOf<String, Int>()

    words.filter { it.length >= length }.forEach {
        wordMap[it] = wordMap.getOrDefault(it, 0) + 1
    }

    return wordMap.entries.sortedWith(
        compareByDescending<Map.Entry<String, Int>> { it.value }
            .thenByDescending { it.key.length }
            .thenBy { it.key })
        .map { it.key }
}

private fun main() {
    val input = readln().split(" ").map { it.toInt() }
    val list = LinkedList<String>()

    val bw = BufferedWriter(OutputStreamWriter(System.out))

    for (i in 0 until input[0]) {
        list.addLast(readln())
    }

    val result = solution(input[1], list)

    result.forEach {
        bw.write(it + "\n")
    }
    bw.flush()
    bw.close()
}
