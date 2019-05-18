import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static java.util.Objects.requireNonNull;

class Scrabble {

    private final static Map<Character, Integer> LETTER_SCORE_LOOKUP = new HashMap<>(26);

    static {
        LETTER_SCORE_LOOKUP.put('A', 1);
        LETTER_SCORE_LOOKUP.put('E', 1);
        LETTER_SCORE_LOOKUP.put('I', 1);
        LETTER_SCORE_LOOKUP.put('O', 1);
        LETTER_SCORE_LOOKUP.put('U', 1);
        LETTER_SCORE_LOOKUP.put('L', 1);
        LETTER_SCORE_LOOKUP.put('N', 1);
        LETTER_SCORE_LOOKUP.put('R', 1);
        LETTER_SCORE_LOOKUP.put('S', 1);
        LETTER_SCORE_LOOKUP.put('T', 1);

        LETTER_SCORE_LOOKUP.put('D', 2);
        LETTER_SCORE_LOOKUP.put('G', 2);

        LETTER_SCORE_LOOKUP.put('B', 3);
        LETTER_SCORE_LOOKUP.put('C', 3);
        LETTER_SCORE_LOOKUP.put('M', 3);
        LETTER_SCORE_LOOKUP.put('P', 3);

        LETTER_SCORE_LOOKUP.put('F', 4);
        LETTER_SCORE_LOOKUP.put('H', 4);
        LETTER_SCORE_LOOKUP.put('V', 4);
        LETTER_SCORE_LOOKUP.put('W', 4);
        LETTER_SCORE_LOOKUP.put('Y', 4);

        LETTER_SCORE_LOOKUP.put('K', 5);

        LETTER_SCORE_LOOKUP.put('J', 8);
        LETTER_SCORE_LOOKUP.put('X', 8);

        LETTER_SCORE_LOOKUP.put('Q', 10);
        LETTER_SCORE_LOOKUP.put('Z', 10);
    }

    private final String word;

    Scrabble(final String word) {
        this.word = requireNonNull(word, "word must not be null");
    }

    int getScore() {
        return word.chars()
                .mapToObj(charAsInt -> (char) charAsInt)
                .map(Character::toUpperCase)
                .mapToInt(Scrabble::getCharacterScore)
                .sum();
    }

    private static int getCharacterScore(final char character) {
        return Optional.ofNullable(LETTER_SCORE_LOOKUP.get(character))
                .orElse(0);
    }
}
