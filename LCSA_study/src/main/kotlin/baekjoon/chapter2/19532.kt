package main.kotlin.baekjoon.chapter2

fun main() {
    val array: Array<Int> = Array(6) { 0 }
    val input = readln()
    val item = input.split(" ").map { it.toInt() }
    for (i in 0..5){
        array[i] = item[i]
    }

    val solved = solve(array)
    print(solved.first)
    print(" ")
    print(solved.second)
}

fun solve(array: Array<Int>): Pair<Int, Int>{
    val list: MutableList<Pair<Int, Int>> = mutableListOf()

    for (i in -999..999){
        for (j in -999..999){
            if(i*array[0] + j*array[1] == array[2]){
                list.add(Pair(i,j))
            }
        }
    }

    var listItem: Pair<Int, Int> = Pair(0,0)
    for (i in 0..<list.size){
        listItem = list[i]
        if(listItem.first*array[3] + listItem.second*array[4] == array[5]){
            break
        }
    }
    return listItem
}