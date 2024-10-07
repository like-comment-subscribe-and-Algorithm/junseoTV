package main.kotlin.baekjoon.etc.ses9928

private fun solution(a: String): String {
    return when (isValid(a)) {
        true -> "<${a}> is acceptable."
        false -> "<${a}> is not acceptable."
    }
}

private fun isValid(a: String): Boolean {
    val vowel = listOf('a', 'e', 'i', 'o', 'u')
    val input = a.toList()
    val list = mutableListOf<Char>()

    vowel.forEach { item ->
        val find = input.find { it == item }
        if (find != null) list.add(find)
    }

    if (list.size == 0) return false

    var beforeIsVowel = vowel.find { it == input[0] } != null
    var count = 1

    for (i in 1 until input.size) {
        if (beforeIsVowel) {
            if (vowel.find { it == input[i] } != null) {
                count++
            } else {
                count = 1
                beforeIsVowel = false
            }
        } else {
            if (vowel.find { it == input[i] } != null) {
                count = 1
                beforeIsVowel = true
            } else {
                count++
            }
        }
        if (count == 3) return false
    }

    var beforeChar = input[0]

    for (i in 1 until input.size) {
        if (input[i] == 'o' || input[i] == 'e') beforeChar = '.'
        if (input[i] == beforeChar) return false
        beforeChar = input[i]
    }

    return true
}

private fun main() {
    val input = mutableListOf<String>()
    var answer = ""

    while (true) {
        val input2 = readln()
        if (input2 == "end") break
        input.add(input2)
    }

    input.forEach {
        answer += solution(it) + "\n"
    }

    println(answer)
}
