package main.kotlin.baekjoon.etc.ses9928

private fun solution(n: Int, k: Int, t: Int, list: List<Triple<Int, Int, Int>>): Int {
    val teams: MutableList<Team> = mutableListOf()

    for (i in 1..n) {
        var totalScore = 0
        var count = 0
        val answers = mutableListOf<Int>()

        val teamResults = list.filter { it.first == i }

        for (j in 1..k) {
            val answersOfEach = teamResults.filter { it.second == j }.map { it.third }
            if (answersOfEach.isEmpty()) continue
            totalScore += answersOfEach.sorted().reversed().first()
            count += answersOfEach.size
            answers.add(j)
        }

        val lastIndex = list.indexOf(list.reversed().find { it.first == i })

        teams.add(Team(i, answers, totalScore, count, lastIndex))
    }

    val teamsForRank = mutableListOf<Team>()

    teams.filter { it.score > teams[t - 1].score }.forEach {
        teamsForRank.add(it)
    }

    teams.filter { it.score == teams[t - 1].score && it.count < teams[t - 1].count }.forEach {
        teamsForRank.add(it)
    }

    teams.filter { it.score == teams[t - 1].score && it.count == teams[t - 1].count && it.lastIndex < teams[t - 1].lastIndex }
        .forEach {
            teamsForRank.add(it)
        }

    return teamsForRank.size + 1
}

private fun main() {
    val times = readln().toInt()
    var output = ""

    repeat(times) {
        val input = readln().split(" ").map { it.toInt() }
        val inputList = mutableListOf<Triple<Int, Int, Int>>()
        for (i in 0 until input[3]) {
            val currentInput = readln().split(" ").map { it.toInt() }
            inputList.add(Triple(currentInput[0], currentInput[1], currentInput[2]))
        }
        output += "${solution(input[0], input[1], input[2], inputList)}\n"
    }

    println(output)
}

data class Team(
    val name: Int,
    val answers: List<Int> = emptyList(),
    val score: Int = 0,
    val count: Int = 0,
    val lastIndex: Int = 0,
)