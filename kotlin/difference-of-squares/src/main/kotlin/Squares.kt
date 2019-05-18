class Squares(private val number: Int) {
    fun squareOfSum(): Int {
        val sum = (number * (number + 1) / 2)

        return sum * sum
    }

    fun sumOfSquares(): Int = number * (number + 1) * (2 * number + 1) / 6

    fun difference(): Int = squareOfSum() - sumOfSquares()
}