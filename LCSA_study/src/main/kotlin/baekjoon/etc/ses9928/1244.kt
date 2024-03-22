package main.kotlin.baekjoon.etc.ses9928

val list: MutableList<Int> = mutableListOf()
fun main() {
    val switchN = readln().toInt()
    val switch = readln().split(" ").map { it.toInt() }
    val studentsN = readln().toInt()
    val info: MutableList<List<Int>> = mutableListOf()

    list.add(3)
    for (i in 0..<switch.size) {
        list.add(switch[i])
    }

    for (i in 0..<studentsN) {
        info.add(readln().split(" ").map { it.toInt() })
    }

    for (i in 0..<studentsN) {
        if (info[i][0] == 1) {
            searchMan(info[i][1])
        } else {
            searchWoman(info[i][1])
        }
    }

    val solution = StringBuilder()

    for (i in 0..4) {
        if (20 * i >= list.size) {
            break
        }
        for (j in 1 + (20 * i)..20 + (20 * i)) {
            if (j >= list.size) {
                break
            }
            solution.append(list[j]).append(" ")
        }
        solution.append("\n")
    }

    println(solution)
}

private fun searchMan(n: Int) {
    for (i in 1..100) {
        if (n * i >= list.size) {
            break
        }
        if (list[n * i] == 1) {
            list[n * i] = 0
        } else if (list[n * i] == 0) {
            list[n * i] = 1
        }
    }
}

private fun searchWoman(n: Int) {
    if (list[n] == 1) {
        list[n] = 0
    } else {
        list[n] = 1
    }

    for (i in 1..100) {
        if (n - i == 0 || n + i == list.size) {
            break
        }

        if (list[n - i] != list[n + i]) {
            break
        }

        if (list[n - i] == 0) {
            list[n - i] = 1
            list[n + i] = 1
        } else {
            list[n - i] = 0
            list[n + i] = 0
        }
    }
}