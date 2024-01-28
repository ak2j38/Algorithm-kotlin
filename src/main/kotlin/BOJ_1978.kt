fun isPrime(number: Int): Boolean {
  if (number < 2) {
    return false
  }
  for (i in 2 until number ) {
    if (number % i == 0) {
      return false
    }
  }
  return true
}

fun main() {
  var answer = 0;
  readln()
  val numbers = ArrayList<Int>()
  numbers.addAll(readln().split(" ").map { it.toInt() })

  numbers.forEach {
    if (isPrime(it)) {
      answer++
    }
  }

  print(answer)
}

