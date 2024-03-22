package main.kotlin.baekjoon.etc.ses9928

fun main() {
    val n = readln().toInt()
    val input: MutableList<List<Char>> = mutableListOf()

    for (i in 1..n) {
        input.add(readln().toList())
    }

    val head = head(input, n)
    val heart = Pair(head.first + 1, head.second)

    println("${heart.first + 1} ${heart.second + 1}")

    val arm = arm(input, n, heart)
    val body = body(input, n, heart)

    println("${arm.first} ${arm.second} ${body.first} ${body.second} ${body.third}")
}

private fun head(input: MutableList<List<Char>>, n: Int): Pair<Int, Int> {
    for (i in 0..<n) {
        for (j in 0..<n) {
            if (input[i][j] == '*')
                return Pair(i, j)
        }
    }
    return Pair(0, 0)
}

private fun arm(input: MutableList<List<Char>>, n: Int, heart: Pair<Int, Int>): Pair<Int, Int> {
    var lArm = 0
    var rArm = 0

    for (i in 0..<heart.second) {
        if (input[heart.first][i] == '*') {
            lArm++
        }
    }

    for (i in heart.second + 1..<n) {
        if (input[heart.first][i] == '*') {
            rArm++
        } else {
            break
        }
    }

    return Pair(lArm, rArm)
}

private fun body(input: MutableList<List<Char>>, n: Int, heart: Pair<Int, Int>): Triple<Int, Int, Int> {
    var body = 0
    var lLeg = 0
    var rLeg = 0

    for (i in heart.first + 1..<n) {
        if (input[i][heart.second] == '*') {
            body++
        } else {
            break
        }
    }

    for (i in heart.first + body + 1..<n) {
        if (input[i][heart.second - 1] == '*') {
            lLeg++
        } else {
            break
        }
    }
    for (i in heart.first + body + 1..<n) {
        if (input[i][heart.second + 1] == '*') {
            rLeg++
        } else {
            break
        }
    }

    return Triple(body, lLeg, rLeg)
}