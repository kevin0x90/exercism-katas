class Hamming {

    def distance(final String strand1, final String strand2) {
        if (strand1.size() != strand2.size()) {
            throw new ArithmeticException("strand lengths must be equal");
        }

        [strand1, strand2]*.toList()
                .transpose()
                .count { firstChar, secondChar -> firstChar != secondChar }
    }
}