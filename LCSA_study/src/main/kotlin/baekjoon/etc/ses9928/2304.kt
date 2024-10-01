package main.kotlin.baekjoon.etc.ses9928

private fun solution(list: List<Pair<Int, Int>>): Int {

    if (list.size == 1) return list[0].second

    val sortedList = list.sortedBy { it.first }
    val spots = mutableListOf<Pair<Int, Int>>()

    spots.add(Pair(sortedList[0].first, sortedList[0].second))

    var beforeSpot = sortedList[0]

    for (i in 1 until sortedList.size) {
        when {
            beforeSpot.second < sortedList[i].second -> {
                spots.add(Pair(sortedList[i].first, beforeSpot.second))
                spots.add(Pair(sortedList[i].first, sortedList[i].second))
                if (i == sortedList.size - 1) {
                    spots.add(Pair(sortedList[i].first + 1, sortedList[i].second))
                }
                beforeSpot = sortedList[i]
            }

            beforeSpot.second > sortedList[i].second -> {
                if (sortedList.find { it.first > sortedList[i].first && it.second > sortedList[i].second } != null) {
                    continue
                }
                spots.add(Pair(beforeSpot.first + 1, beforeSpot.second))
                spots.add(Pair(beforeSpot.first + 1, sortedList[i].second))
                spots.add(Pair(sortedList[i].first + 1, sortedList[i].second))
                beforeSpot = Pair(sortedList[i].first + 1, sortedList[i].second)
            }

            beforeSpot.second == sortedList[i].second -> {
                if (i == sortedList.size - 1) {
                    spots.add(Pair(sortedList[i].first + 1, sortedList[i].second))
                } else if (beforeSpot.first != sortedList[i].first) {
                    spots.add(Pair(sortedList[i].first, sortedList[i].second))
                    beforeSpot = sortedList[i]
                }
            }
        }
    }

    var result = 0

    for (i in 0 until spots.size / 2) {
        result += (spots[2 * i + 1].first - spots[2 * i].first) * spots[2 * i].second
    }

    return result
}

private fun main() {
    val input = readln().toInt()
    val list = mutableListOf<Pair<Int, Int>>()

    repeat(input) {
        val poll = readln().split(" ").map { it.toInt() }
        list.add(Pair(poll[0], poll[1]))
    }

    println(solution(list))
}
