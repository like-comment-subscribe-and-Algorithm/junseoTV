package main.kotlin.baekjoon.etc.ses9928

private fun solution(a: List<Char>): Char {
    val list = a.toMutableList()
    val pairList = mutableListOf<Pair<Char, Int>>()

    while (list.isNotEmpty()) {
        val firstItem = list.first()
        pairList.add(Pair(firstItem, list.count{it == firstItem}))
        list.removeAll{it == firstItem}
    }

    val counts = pairList.map{it.second}.sorted().reversed()
    if (counts.size == 1) return a.first()
    if (counts[0] == counts[1]) return '?'

    return pairList.find {it.second == counts[0]}?.first ?: '?'
}

private fun main() {
    val input = readln().uppercase().toMutableList()
    println(solution(input))
}
