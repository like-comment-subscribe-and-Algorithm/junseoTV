package main.kotlin.baekjoon.etc.ses9928

private fun solution(n: Int, k: Int, l: List<Pair<String, Int>>): Int {
    val list = l.toMutableList()
    var count = 0

    for (i in 0 until list.size) {
        if (list[i].first == "H" && list[i].second == 1) {
            val temp1 = if (i - k < 0) 0 else i - k
            val temp2 = if (i + k > list.size - 1) list.size - 1 else i + k
            for (j in temp1..temp2) {
                if (list[j].first == "P" && list[j].second == 1) {
                    list[j] = Pair("P", 0)
                    list[i] = Pair("H", 0)
                    count++
                    break
                }
            }
        }
    }

    return count
}

private fun main() {
    val input = readln().split(" ").map { it.toInt() }
    val list = readln().split("").filter { it == "H" || it == "P" }.map { Pair(it, 1) }

    println(solution(input[0], input[1], list))
}
