class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(final int input) {
        final int sumOfNumbersUpToInput = input * (input + 1) / 2;

        return sumOfNumbersUpToInput * sumOfNumbersUpToInput;
    }

    int computeSumOfSquaresTo(final int input) {
        return input * (input + 1) * (2 * input + 1) / 6;
    }

    int computeDifferenceOfSquares(final int input) {
        return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
    }

}
