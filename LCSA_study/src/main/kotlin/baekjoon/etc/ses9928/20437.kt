package main.kotlin.baekjoon.etc.ses9928

private fun solution1(w: List<Char>, k: Int): String {
    val map = mutableMapOf<Char, List<Int>>()

    for (i in 0 until w.size) {
        map[w[i]] = map.getOrDefault(w[i], listOf()) + listOf(i)
    }

    val answer = mutableListOf<Int>()

    map.forEach {
        val list = it.value
        if (list.size >= k) {
            for (i in 0 until list.size - k + 1) {
                answer.add(list[i + k - 1] - list[i] + 1)
            }
        }
    }

    if (answer.isEmpty()) return "-1"

    answer.sort()

    return "${answer.first()} ${answer.last()}"
}

private fun main() {
    val t = readln().toInt()
    var output = ""

    repeat(t) {
        val w = readln().toList()
        val k = readln().toInt()
        output += solution1(w, k) + "\n"
    }

    println(output)
}
