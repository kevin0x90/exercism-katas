import java.util.Optional;

class RotationalCipher {
    private final static int CHARACTERS_IN_ALPHABET = 26;
    private final int shiftKey;

    RotationalCipher(final int shiftKey) {
        this.shiftKey = shiftKey;
    }

    String rotate(final String data) {
        return Optional.ofNullable(data)
                .orElse("")
                .chars()
                .mapToObj(RotationalCipher::intToChar)
                .map(this::rotateAlphabetCharacter)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

    private static char intToChar(final int charCode) {
        return (char) charCode;
    }

    private char rotateAlphabetCharacter(final char character) {
        final int alphabetStartCharacterCode = getAlphabetStartCharacterCode(character);
        final int zeroBasedCharIndex = ((int) character) - alphabetStartCharacterCode;

        return isInAlphabetRange(zeroBasedCharIndex)
                ? intToChar(getShiftedIndex(zeroBasedCharIndex) + alphabetStartCharacterCode)
                : character;
    }

    private static int getAlphabetStartCharacterCode(final char character) {
        return Character.isUpperCase(character) ? (int) 'A' : (int) 'a';
    }

    private static boolean isInAlphabetRange(final int characterRangeIndex) {
        return characterRangeIndex >= 0 && characterRangeIndex < CHARACTERS_IN_ALPHABET;
    }

    private int getShiftedIndex(final int currentIndex) {
        return (currentIndex + this.shiftKey) % CHARACTERS_IN_ALPHABET;
    }
}
