package main.kotlin.baekjoon.etc.ses9928

private fun solution(n: Int, a: List<List<String>>): String {
    var head: Pair<Int, Int> = Pair(-1, -1)

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (a[i][j] == "*") {
                head = Pair(i, j)
                break
            }
        }
        if (head != Pair(-1, -1)) break
    }

    val heart = Pair(head.first + 1, head.second)
    var lArmLength = 0

    for (i in 0 until heart.second) {
        if (a[heart.first][i] == "*") lArmLength++
    }

    var rArmLength = 0

    for (i in heart.second + 1 until n) {
        if (a[heart.first][i] == "*") rArmLength++
    }

    var bodyLength = 0
    var endOfBody = Pair(-1, -1)

    for (i in heart.first + 1 until n) {
        if (a[i][heart.second] == "*") bodyLength++ else {
            endOfBody = Pair(i, heart.second)
            break
        }
    }

    var lLegLength = 0
    var rLegLength = 0

    for (i in endOfBody.first until n) {
        if (a[i][endOfBody.second - 1] == "*") lLegLength++ else break
    }

    for (i in endOfBody.first until n) {
        if (a[i][endOfBody.second + 1] == "*") rLegLength++ else break
    }

    return "${heart.first + 1} ${heart.second + 1}\n$lArmLength $rArmLength $bodyLength $lLegLength $rLegLength"
}

private fun main() {
    val input = readln().toInt()
    val table = mutableListOf<List<String>>()

    for (i in 0 until input) {
        val list = readln().split("").toMutableList()
        list.removeAt(0)
        list.removeAt(list.size - 1)
        table.add(list)
    }

    println(solution(input, table))
}
