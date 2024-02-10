fun main() {
    val br = System.`in`.bufferedReader()
    val (n, k) = br.readLine().split(" ").map { it.toInt() }

    for (i in 0 until n) {
        val (w, v) = br.readLine().split(" ").map { it.toInt() }

    }
    recur(0, 0, 0, k, n)
}

fun recur(index: Int, weight: Int, value: Int, maxWeight: Int, count: Int) {
    if (weight > maxWeight) {

    }
    if (index == count) {

    }

    recur(index + 1, weight +, value +, maxWeight, count)
    recur(index + 1, weight, value, maxWeight, count)
}
