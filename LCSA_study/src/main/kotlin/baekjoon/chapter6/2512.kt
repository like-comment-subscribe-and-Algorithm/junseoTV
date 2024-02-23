package main.kotlin.baekjoon.chapter6

import kotlin.math.pow

fun main() {
    val n: Int = readln().toInt()
    val inputList: List<Int> = readln().split(" ").map { it.toInt() }
    val list = inputList.sorted()
    val total: Int = readln().toInt()
    var totalWish: Int = 0

    var tempTotal: Int = total
    var tempList: MutableList<Int> = list.toMutableList()

    for (i in list.indices) {
        totalWish += list[i]
    }

    var solved: Int = 1

    if (totalWish > total) {
        var tempSolved: Int = 0
        var boolean: Boolean = false

        for (i in 0..total) {
            for (j in list.indices) {
                if (list[j] <= tempSolved) {
                    tempTotal -= list[j]
                } else {
                    tempList.add(list[j])
                }
            }

            boolean = tempList.size > tempTotal - tempSolved * tempList.size && tempTotal - tempSolved * tempList.size >= 0

            if (boolean) {
                tempSolved++

                for (k in 0..total){

                    tempTotal = total
                    tempList = mutableListOf()

                    for (l in list.indices) {
                        if (list[l] <= tempSolved) {
                            tempTotal -= list[l]
                        } else {
                            tempList.add(list[l])
                        }
                    }

                    boolean = tempList.size > tempTotal - tempSolved * tempList.size && tempTotal - tempSolved * tempList.size >= 0

                    if(boolean){
                        tempSolved++
                    } else {
                        tempSolved--
                        break
                    }
                }

                solved = tempSolved
                break
            }

            if (tempSolved * tempList.size <= tempTotal) {
                if (total / 2.0.pow(i.toDouble()).toInt() <= 2) {
                    tempSolved ++
                } else {
                    tempSolved += total / 2.0.pow(i.toDouble()).toInt()
                }
            } else {
                if (total / 2.0.pow(i.toDouble()).toInt() <= 2) {
                    tempSolved --
                } else {
                    tempSolved -= total / 2.0.pow(i.toDouble()).toInt()
                }
            }

            tempTotal = total
            tempList = mutableListOf()
        }
    } else {
        solved = list[n - 1]
    }

    println(solved)
}