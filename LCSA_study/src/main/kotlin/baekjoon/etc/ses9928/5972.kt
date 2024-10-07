package main.kotlin.baekjoon.etc.ses9928

import java.util.*

data class Edge(
    val edge: Int,
    val cost: Int,
)

data class Node(
    val index: Int,
    val distance: Int,
) : Comparable<Node> {
    override fun compareTo(other: Node) = this.distance - other.distance
}

private fun solution(n: Int, list: List<List<Edge>>): Int {
    val distances = IntArray(n) { Int.MAX_VALUE }
    distances[0] = 0
    val pq = PriorityQueue<Node>()
    pq.add(Node(0, 0))

    while (pq.isNotEmpty()) {
        val currentNode = pq.poll()
        if (currentNode.distance > distances[currentNode.index]) continue
        for (i in 0 until list[currentNode.index].size) {
            val newDistance = list[currentNode.index][i].cost + currentNode.distance
            if (distances[list[currentNode.index][i].edge - 1] > newDistance) {
                pq.add(Node(list[currentNode.index][i].edge - 1, newDistance))
                distances[list[currentNode.index][i].edge - 1] = newDistance
            }
        }
    }

    return distances[n - 1]
}

private fun main() {
    val input = readln().split(" ").map { it.toInt() }
    val list = MutableList<List<Edge>>(input[0]) { emptyList() }

    repeat(input[1]) {
        val temp = readln().split(" ").map { it.toInt() }
        val first = temp[0]
        val second = temp[1]

        list[first - 1] = list[first - 1] + listOf(Edge(second, temp[2]))
        list[second - 1] = list[second - 1] + listOf(Edge(first, temp[2]))
    }

    println(solution(input[0], list))
}