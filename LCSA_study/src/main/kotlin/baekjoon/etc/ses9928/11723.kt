package main.kotlin.baekjoon.etc.ses9928

var result = mutableMapOf<Int,Int>()
val empty = mutableMapOf<Int, Int>()
val all = mutableMapOf<Int, Int>()

private fun add(a: Int) {
    result[a] = 1
}

private fun remove(a: Int) {
    result[a] = 0
}

private fun check(a: Int): Int {
    return result.getOrDefault(a,0)
}

private fun toggle(a: Int) {
    if (result.getOrDefault(a,0) == 1) {
        result[a] = 0
    } else {
        result[a] = 1
    }
}

private fun all() {
    result = all
}

private fun empty() {
    result = empty
}

private fun main() {
    val input = readln().toInt()

    for (i in 1..20) {
        empty[i] = 0
        all[i] = 1
    }

    for (i in 0 until input) {
        val task = readln().split(" ")
        val pair = if (task.size == 1) {
            Pair(task[0], 0)
        } else {
            Pair(task[0], task[1].toInt())
        }

        when (pair.first) {
            "add" -> add(pair.second)
            "remove" -> remove(pair.second)
            "check" -> println(check(pair.second))
            "toggle" -> toggle(pair.second)
            "all" -> all()
            "empty" -> empty()
        }
    }
}
