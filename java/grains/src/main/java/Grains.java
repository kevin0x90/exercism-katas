import java.math.BigInteger;

class Grains {

    private static final BigInteger TOTAL_GRAINS = new BigInteger("18446744073709551615", 10);

    BigInteger grainsOnSquare(final int square) {
        sanitizeSquare(square);

        // Grains are powers of two so the following applies:
        // 32 16 8 4 2 1
        // 0  0  0 0 0 1 << 0 = 1
        // 0  0  0 0 1 0 << 1 = 2
        // 0  0  0 1 0 0 << 2 = 4
        return BigInteger.valueOf(1L).shiftLeft(square - 1);
    }

    private static void sanitizeSquare(final int square) {
        final boolean isValidSquare = square >= 1 && square <= 64;

        if (!isValidSquare) {
            throw new IllegalArgumentException("square must be between 1 and 64");
        }
    }

    BigInteger grainsOnBoard() {
        return TOTAL_GRAINS;
    }
}
