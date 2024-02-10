import kotlin.math.max

private var n: Int = 0
private var k: Int = 0
private var answer: Int = 0
private var items: MutableList<Pair<Int, Int>> = mutableListOf()


fun main() {
    val br = System.`in`.bufferedReader()
    val (n1, k1) = br.readLine().split(" ").map { it.toInt() }
    n = n1
    k = k1

    for (i in 0 until n) {
        val (w, v) = br.readLine().split(" ").map { it.toInt() }
        items.add(Pair(w, v))
    }
    recur(0, 0, 0)

    println(answer)
}

fun recur(index: Int, weight: Int, value: Int) {
    if (weight > k) {
        return
    }
    if (index == n) {
        answer = max(answer, value)
        return
    }

    recur(index + 1, weight + items[index].first, value + items[index].second)
    recur(index + 1, weight, value)
}
