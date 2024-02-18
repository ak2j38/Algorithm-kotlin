class Ipt_1 {
    fun solution(targetNumber: Int): Int {
        var answer: Int = 0
        var number = targetNumber

        while (number >= 5) {
            answer += number / 5
            number /= 5
        }

        return answer
    }
}

fun main() {
    val solution: Ipt_1 = Ipt_1()

    val number1: Int = 10
    val number2: Int = 3

    println(solution.solution(number1)) // 2
    println(solution.solution(number2)) // 0
}