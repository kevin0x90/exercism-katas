class DifferenceOfSquares {
    private int numbersUpTo

    DifferenceOfSquares(num) {
        numbersUpTo = num
    }

    def squareOfSum() {
        (numbersUpTo * (numbersUpTo + 1) / 2) ** 2
    }

    def sumOfSquares() {
        (numbersUpTo * (numbersUpTo + 1) * (2 * numbersUpTo + 1)) / 6
    }

    def difference() {
        squareOfSum() - sumOfSquares()
    }
}
