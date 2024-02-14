package main.kotlin.baekjoon.chapter2

fun solve(number:Int, called:Int, array: Array<Int>): Int{
    var newSum: Int = -300000
    var currentSum: Int = 0

    for(i in 0..number-3){
        for(j in i+1..number-2){
            for(k in j+1..number-1){
                currentSum = array[i] + array[j] + array[k] - called
                if (currentSum in newSum..0 ){
                    newSum = currentSum
                }
            }
        }
    }

    return newSum+called
}

fun main(){
    val numbers = readln().split(" ").map { it.toInt() }
    val (firstNumber, secondNumber) = numbers

    val array: Array<Int> = Array(firstNumber) {0}

    val listItem = readln()
    for (i in 0..firstNumber-1) {
        val item = listItem.split(" ").map { it.toInt() }
        array[i] = item[i]
    }

    println(solve(firstNumber,secondNumber, array))
}