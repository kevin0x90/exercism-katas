class Hamming {

    def distance(final String strand1, final String strand2) {
        if (strand1.size() != strand2.size()) {
            throw new ArithmeticException("strand lengths must be equal");
        }

        if (strand1.isEmpty()) {
            return 0
        }

        (0..(strand1.size() - 1))
                .inject(0) { diffCount, index -> diffCount + (strand1[index] == strand2[index] ? 0 : 1) }
    }
}