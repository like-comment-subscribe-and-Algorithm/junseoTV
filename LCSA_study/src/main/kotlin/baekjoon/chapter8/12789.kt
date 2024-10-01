package main.kotlin.baekjoon.chapter8

import java.util.Stack

fun main() {
    val number: Int = readln().toInt()
    val list: List<Int> = readln().split(" ").map { it.toInt() }

    if (solve(number, list)) {
        println("Nice")
    } else {
        println("Sad")
    }
}

private fun solve(number: Int, list: List<Int>): Boolean {
    val stack: Stack<Int> = Stack()
    stack.push(0)
    var nowNum: Int = 1
    val mutableList: MutableList<Int> = list.toMutableList()

    while (true) {
        if (nowNum == number) {
            return true
        } else if (mutableList.size != 0 && mutableList[0] == nowNum) {
            mutableList.removeFirst()
            nowNum++
        } else if (mutableList.size != 0 && mutableList[0] != nowNum && stack.peek() != nowNum) {
            stack.push(mutableList[0])
            mutableList.removeFirst()
        } else if (stack.peek() == nowNum) {
            stack.pop()
            nowNum++
        } else {
            return false
        }
    }
}