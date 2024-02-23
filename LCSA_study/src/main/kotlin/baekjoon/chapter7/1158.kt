package main.kotlin.baekjoon.chapter7

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    val list: MutableList<Int> = mutableListOf()
    val solved: MutableList<Int> = mutableListOf()
    var x: Int = input[1] - 1

    for (i in 1..input[0]) {
        list.add(i)
    }

    for (i in 1..input[0]) {
        solved.add(list[x])
        list.remove(list[x])
        while (true) {
            if (list.size == 0) {
                x = x + input[1] - 1
                break
            } else if (x + input[1] - 1 >= list.size) {
                x -= list.size
            } else {
                x = x + input[1] - 1
                break
            }
        }
    }
    print("<")
    for (i in 0..input[0] - 2) {
        print(solved[i])
        print(", ")
    }
    print(solved[input[0] - 1])
    print(">")
}