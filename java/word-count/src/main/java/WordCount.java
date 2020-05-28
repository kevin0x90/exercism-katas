import java.text.BreakIterator;
import java.util.HashMap;
import java.util.Map;

class WordCount {

    public Map<String, Integer> phrase(final String sentence) {
        final Map<String, Integer> wordCountMap = new HashMap<>();
        final var wordBreakIterator = BreakIterator.getWordInstance();
        wordBreakIterator.setText(sentence);

        for (int wordStartIndex = wordBreakIterator.first(), wordEndIndex = wordBreakIterator.next();
             wordEndIndex != BreakIterator.DONE;
             wordStartIndex = wordEndIndex, wordEndIndex = wordBreakIterator.next()) {
            final String word = sentence.substring(wordStartIndex, wordEndIndex).toLowerCase();

            if (isWord(word)) {
                wordCountMap.merge(word, 1, Math::addExact);
            }
        }

        return wordCountMap;
    }

    private boolean isWord(final String word) {
        if (word.length() == 1) {
            return Character.isLetterOrDigit(word.charAt(0));
        }

        return word.trim().length() > 0;
    }
}