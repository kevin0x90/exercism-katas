import java.util.stream.IntStream;

import static java.util.Objects.requireNonNull;

class Hamming {

    private final String leftStrand;
    private final String rightStrand;
    private final int strandLength;

    Hamming(final String leftStrand, final String rightStrand) {
        this.leftStrand = requireNonNull(leftStrand, "leftStrand must not be null");
        this.rightStrand = requireNonNull(rightStrand, "rightStrand must not be null");

        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

        strandLength = leftStrand.length();
    }

    int getHammingDistance() {
        return (int) IntStream
                .range(0, strandLength)
                .filter(this::strandsDifferAtPosition)
                .count();
    }

    private boolean strandsDifferAtPosition(final int position) {
        return leftStrand.charAt(position) != rightStrand.charAt(position);
    }
}
