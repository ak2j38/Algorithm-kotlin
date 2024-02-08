fun main() {
  val (n, k) = readln().split(" ").map { it.toInt() }
  val temperatures = readln().split(" ").map { it.toInt() }.toIntArray()

  for (i in 1 until n) {
    temperatures[i] = temperatures[i - 1] + temperatures[i]
  }
  var answer = temperatures[k - 1]
  for (i in 0 until n - k) {
    answer = answer.coerceAtLeast(temperatures[i + k] - temperatures[i])
  }

  println(answer)
}
