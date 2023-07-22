fun main() {
  val names = arrayOf("may", "kein", "kain", "radi")
  val yearnings = intArrayOf(5, 10, 1, 3)
  val photoes = arrayOf(
    arrayOf("may", "kein", "kain", "radi"),
    arrayOf("may", "kein", "brin", "deny"),
    arrayOf("kon", "kain", "may", "coni")
  )

  solution(names, yearnings, photoes)
}

fun solution(names: Array<String>, yearnings: IntArray, photoes: Array<Array<String>>): IntArray {
  val answer = IntArray(photoes.size) {0}

  val yearningByName = mutableMapOf<String, Int>()
  names.forEachIndexed { index, it ->
    yearningByName[it] = yearnings[index]
  }

  photoes.forEachIndexed { index, eachPhoto ->
    var yearningSum = 0
    eachPhoto.forEach { person ->
      yearningSum += yearningByName.getOrDefault(person, 0)
    }
    answer[index] = yearningSum
  }

  return answer
}

// 다른 사람 풀이
fun solution2(names: Array<String>, yearnings: IntArray, photoes: Array<Array<String>>): IntArray {
  val map = names.zip(yearnings.toTypedArray()).toMap()
  return photoes.map { photo -> photo.sumOf { map[it] ?: 0 } }.toIntArray()
}


