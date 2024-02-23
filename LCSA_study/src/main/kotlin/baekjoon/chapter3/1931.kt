package main.kotlin.baekjoon.chapter3

fun main() {
    val number:Int = readln().toInt()
    val list:MutableList<Pair<Int, Int>> = mutableListOf()
    var inputList:List<Int>
    val solvedList:MutableList<Pair<Int, Int>> = mutableListOf()

    for(i in 1..number){
        inputList = readln().split(" ").map {it.toInt()}
        list.add(Pair(inputList[0], inputList[1]))
    }

    list.sortWith (compareBy<Pair<Int, Int>> {it.second}.thenBy {it.first}.thenBy {it.second - it.first})

    solvedList.add(list[0])

    var temp: Int = 0
    for(i in 1..<list.size){
        if (solvedList[temp].second <= list[i].first){
            solvedList.add(list[i])
            temp += 1
        }
    }
    println(solvedList.size)
}