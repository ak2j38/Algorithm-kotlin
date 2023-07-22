import java.time.LocalDate

fun main() {
  val today = listOf("2022.05.19", "2020.01.01")
  val terms = arrayOf(
    arrayOf("A 6", "B 12", "C 3"),
    arrayOf("Z 3", "D 5")
  )
  val privacies = arrayOf(
    arrayOf("2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"),
    arrayOf("2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z")
  )

  for (i in 0 until today.size) {
    println(solution(today[i], terms[i], privacies[i]).contentToString())
  }
}

fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
  val answer = mutableListOf<Int>()

  val todayDate = today.split(".").let { todaySplit ->
    LocalDate.of(todaySplit[0].toInt(), todaySplit[1].toInt(), todaySplit[2].toInt())
  }
  val newTerms = terms.associate {
    it.split(" ").let { termSplit ->
      termSplit[0] to termSplit[1].toLong()
    }
  }

  privacies.forEachIndexed { index, privacy ->
    privacy.split(" ").let { privacySplit ->
      privacySplit[0].split(".").let { date ->
        LocalDate.of(date[0].toInt(), date[1].toInt(), date[2].toInt()).plusMonths(newTerms.getOrDefault(privacySplit[1], 0)).let { disMissDate ->
          if (todayDate >= disMissDate) {
            answer.add(index + 1)
          }
        }
      }
    }
  }

  return answer.toIntArray()
}
