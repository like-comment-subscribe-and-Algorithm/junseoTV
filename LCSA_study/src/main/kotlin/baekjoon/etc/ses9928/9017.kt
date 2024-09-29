package main.kotlin.baekjoon.etc.ses9928

private fun solution(n: Int, result: List<Int>): Int {
    val teams = result.toMutableList()

    for (i in 0 until n) {
        var count = 0
        result.forEach {
            if (result[i] == it) count++
        }
        if (count < 6) teams.removeAll { it == result[i] }
    }

    val validTeams = HashSet<Int>()
    teams.forEach {
        validTeams.add(it)
    }

    val valid = validTeams.toList()
    if (valid.size == 1) return valid[0]
    val results = mutableListOf<Triple<Int, Int, List<Int>>>()

    for (i in 0 until validTeams.size) {
        val scores = mutableListOf<Int>()
        var count = 0
        for (j in 0 until teams.size) {
            if (teams[j] == valid[i]) {
                scores.add(j)
                if (scores.size <= 4) count += j
            }
        }
        results.add(Triple(valid[i], count, scores))
    }

    var awards = listOf<Int>()

    for (i in 0 until results.size) {
        awards = results.map { it.second }.sorted()
    }

    if (awards[0] != awards[1]) return (results.find { it.second == awards[0] }?.first) ?: 1

    val real = mutableListOf<Int>()

    for (i in 0 until results.size) {
        if (results[i].second == awards[0]) {
            real.add(results[i].third[4])
        }
    }

    real.sort()

    return results.find { it.third[4] == real[0] }?.first ?: 1
}

private fun main() {
    val input = readln().toInt()
    val answer = mutableListOf<String>()

    for (i in 0 until input) {
        val n = readln().toInt()
        val result = readln().split(" ").map { it.toInt() }
        answer.add("${solution(n, result)}")
    }

    answer.forEach {
        println(it)
    }
}
