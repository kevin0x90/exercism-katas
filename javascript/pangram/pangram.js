function getAlphabetSet() {
  const alphabet = new Set();

  for (let i = 'a'.charCodeAt(0); i < 'z'.charCodeAt(0); ++i) {
    alphabet.add(String.fromCharCode(i));
  }

  return alphabet;
}

export const isPangram = (sentence) => {
  const alphabet = getAlphabetSet();

  for (let i = 0; i < sentence.length; ++i) {
    alphabet.delete(sentence[i].toLowerCase());
  }

  return alphabet.size === 0;
};
