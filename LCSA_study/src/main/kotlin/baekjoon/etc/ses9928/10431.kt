package main.kotlin.baekjoon.etc.ses9928

private fun solution(a: List<Int>): String {
    val input = a.toMutableList()
    val number = a[0]
    input.removeAt(0)
    var count = 0

    for (i in 1 until 20) {
        for (j in 0 until i) {
            val student = input[i]
            if (input[j] > student) {
                input.removeAt(i)
                input.add(j, student)
                count += i - j
            }
        }
    }

    return "$number $count"
}

private fun main() {
    val input = readln().toInt()
    var answer = ""

    for (i in 0 until input) {
        val input2 = readln().split(" ").map{it.toInt()}
        answer += solution(input2) + "\n"
    }

    println(answer)
}
