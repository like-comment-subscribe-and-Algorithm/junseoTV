package main.kotlin.baekjoon.etc.ses9928

fun main() {
    val input = readln().toInt()
    val solved = StringBuilder()

    for (i in 0..<input) {
        val output = solution(readln().split(" ").map { it.toInt() })
        solved.append(i + 1).append(" ").append(output).append("\n")
    }

    println(solved)
}

private fun solution(input: List<Int>): Int {
    val tempList: MutableList<Int> = mutableListOf()
    var nowList = input.toMutableList()
    var count = 0
    var temp = 0

    for (i in 2..20) {
        tempList.clear()
        tempList.add(input[0])
        for (j in 1..<i) {
            tempList.add(nowList[j])
        }
        tempList.add(input[i])

        nowList.clear()
        for (j in 0..<tempList.size) {
            nowList.add(tempList[j])
        }

        for (j in 1..<tempList.size) {
            if (tempList[tempList.size - 1] < tempList[j]) {
                tempList.clear()
                tempList.add(input[0])
                for (k in 1..<j) {
                    tempList.add(nowList[k])
                }
                tempList.add(nowList[nowList.size - 1])
                for (k in j..<nowList.size - 1) {
                    tempList.add(nowList[k])
                    count++
                }
                nowList.clear()
                for (k in 0..<tempList.size) {
                    nowList.add(tempList[k])
                }
                break
            }
        }
    }
    return count
}