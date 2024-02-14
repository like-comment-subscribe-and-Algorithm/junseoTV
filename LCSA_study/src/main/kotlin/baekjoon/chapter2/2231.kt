package main.kotlin.baekjoon.chapter2

fun getSum (n: Int): Int {
    var new: Int = n
    var left: Int = 0
    var pow: Int = 0
    var sum: Int = n

    for(i in 0..6){
        pow = Math.pow(10.0, i.toDouble()).toInt()
        left = new%(10*pow)
        sum += left/pow
        new -= left
        if (new==0){
            break
        }
    }

    return sum
}

fun solve (n: Int): Int{
    var solved: Int = 0
    var temp: Int = 0
    for (i in 1..n){
        temp = getSum(i)
        if(temp == n){
            solved = i
            break
        }
    }
    return solved
}

fun main() {
    val n: Int = readln().toInt()
    println(solve(n))
}