#include "isogram.h"
#include <stddef.h>
#include <ctype.h>

#define NUM_ALPHABET_CHARS 26

static inline bool is_within_alphabet_range(const int alphabetIndex) {
  return alphabetIndex >= 0 && alphabetIndex < NUM_ALPHABET_CHARS;
}

bool is_isogram(const char phrase[]) {
  if (phrase == NULL) {
    return false;
  }

  bool alphabetCharOccurences[NUM_ALPHABET_CHARS] = { false };

  for (; *phrase != '\0'; ++phrase) {
    const unsigned char currentCharacter = *phrase;
    const int alphabetIndex = tolower(currentCharacter) - 'a';

    if (!is_within_alphabet_range(alphabetIndex)) {
      continue;
    }

    if (alphabetCharOccurences[alphabetIndex]) {
      return false;
    }

    alphabetCharOccurences[alphabetIndex] = true;
  }

  return true;
}
