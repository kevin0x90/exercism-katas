const ALPHABET = Array.from({ length: 26 }, (_, i) => 'a'.charCodeAt(0) + i)
  .reduce((alphabetSet, currentCharCode) => alphabetSet.add(String.fromCharCode(currentCharCode)), new Set());

export const isPangram = (sentence) => {
  const normalizedSentence = sentence.toLowerCase();
  return Array.from(ALPHABET).every(char => normalizedSentence.includes(char));
};
