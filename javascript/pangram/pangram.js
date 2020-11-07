const ALPHABET = [...'abcdefghijklmnopqrstuvwxyz'];

export const isPangram = (sentence) => {
  const normalizedSentence = sentence.toLowerCase();
  return Array.from(ALPHABET).every(char => normalizedSentence.includes(char));
};
