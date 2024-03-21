package main.kotlin.baekjoon.etc.ses9928

fun main() {
    val solved: StringBuilder = StringBuilder()
    while (true) {
        val input = readln()
        if (input == "end") {
            break
        }
        if (solution(input.toList())) {
            solved.append("<$input> is acceptable.\n")
        } else {
            solved.append("<$input> is not acceptable.\n")
        }
    }
    print(solved)
}

private fun solution(input: List<Char>): Boolean {
    val list: MutableList<Boolean> = mutableListOf()

    for (i in 0..<input.size) {
        if (input[i] == 'a' || input[i] == 'e' || input[i] == 'i' || input[i] == 'o' || input[i] == 'u') {
            list.add(true)
        } else {
            list.add(false)
        }
    }

    for (i in 0..<input.size) {
        if (list[i]) {
            break
        } else if (i == input.size - 1) {
            return false
        }
    }

    for (i in 2..<input.size) {
        if (list[i - 2] == list[i - 1] && list[i - 1] == list[i]) {
            return false
        }
    }

    for (i in 1..<input.size) {
        if (input[i - 1] == input[i] && input[i] != 'e' && input[i] != 'o') {
            return false
        }
    }

    return true
}