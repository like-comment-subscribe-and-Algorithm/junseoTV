package main.kotlin.baekjoon.etc.ses9928

private fun solution(list: List<Int>): List<Int> {

    val result = mutableListOf<Int>()
    val numbers = (1..list.size).toList().reversed()
    result.add(numbers[0])

    var count = list[0]

    for (i in 1 until list.size) {
        count = list[i]
        for (j in 0 until 100) {
            if (count == 0) {
                result.add(j, numbers[i])
                break
            }
            if (result[j] > numbers[i]) count--
        }
    }

    return result
}

private fun main() {
    readln().toInt()
    val result = solution(readln().split(" ").map { it.toInt() }.reversed())

    result.forEach {
        print("$it ")
    }
}
