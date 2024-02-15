package main.kotlin.baekjoon.chapter3

fun main() {
    val item = readln().split(" ").map { it.toInt() }
    val coinType: MutableList<Int> = mutableListOf()
    var input: Int = 0

    var coins: Int = 0
    var left: Int = item[1]

    for (i in 1..item[0]){
        input = readln().toInt()
        coinType.add(input)
    }

    var n: Int = 0

    for (i in 1..item[0]){
        n = left/coinType[item[0]-i]
        coins += n
        if(n != 0) {
            left -= n*coinType[item[0]-i]
        }

        if(left == 0){
            break
        }
    }

    println(coins)
}