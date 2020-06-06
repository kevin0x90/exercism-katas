class Hamming {

    def distance(final String strand1, final String strand2) {
        if (strand1.size() != strand2.size()) {
            throw new ArithmeticException("strand lengths must be equal");
        }

        [strand1.toList(), strand2.toList()]
                .transpose()
                .sum(0) { subList -> subList[0] == subList[1] ? 0 : 1 }
    }
}