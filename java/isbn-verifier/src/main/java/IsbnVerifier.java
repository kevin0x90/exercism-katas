import java.util.Optional;

class IsbnVerifier {

    boolean isValid(final String stringToVerify) {
        final int checkCharacterIndex = Math.max(0, stringToVerify.length() - 1);

        int sumOfElements = 0;
        int digits = 0;

        for (int i = 0, positionMultiplier = 10; i < stringToVerify.length(); ++i) {
            final Optional<Integer> positionalValue = getPositionalValue(stringToVerify.charAt(i), i == checkCharacterIndex);

            if (positionalValue.isPresent()) {
                sumOfElements += positionalValue.get() * positionMultiplier;
                positionMultiplier = Math.max(1, positionMultiplier - 1);
                ++digits;
            }
        }

        return enoughDigits(digits) && sumOfElements % 11 == 0;
    }

    private static Optional<Integer> getPositionalValue(final char character, final boolean isCheckCharacter) {
        if (Character.isDigit(character)) {
            return Optional.of(Character.getNumericValue(character));
        }

        if (isCheckCharacter && character == 'X') {
            return Optional.of(10);
        }

        return Optional.empty();
    }

    private static boolean enoughDigits(final int digits) {
        return digits == 10;
    }
}
