package main.kotlin.baekjoon.etc.ses9928

private fun solution(a: Int, b: Int, c: Int): String {

    if (!isValid(a, b, c)) return "Invalid"

    when {
        a == b && b == c -> return "Equilateral"

        a == b || b == c || c == a -> return "Isosceles"
    }


    return "Scalene"
}

private fun isValid(a: Int, b: Int, c: Int): Boolean {
    return a < b+c
}

private fun main() {
    var output: String = ""
    val input: MutableList<List<Int>> = mutableListOf()
    while (true) {
        val temp: List<Int> = readln().split(" ").map {it.toInt()}.sorted().reversed()
        if (temp == listOf(0, 0, 0)) break
        input.add(temp)
    }
    input.forEach {
        output += solution(it[0], it[1], it[2])+"\n"
    }
    println(output)
}
