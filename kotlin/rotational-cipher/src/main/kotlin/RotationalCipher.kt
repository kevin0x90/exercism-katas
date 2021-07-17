class RotationalCipher(private val numberOfShifts: Int) {

    companion object {
        private const val NUMBER_OF_CHARS_ALPHABET = 26
        private const val LOWER_CASE_LOWER_BOUND = 'a'.toInt()
        private const val UPPER_CASE_LOWER_BOUND = 'A'.toInt()

        private fun isInAlphabet(alphabetIndex: Int): Boolean = alphabetIndex in 0..NUMBER_OF_CHARS_ALPHABET

        private fun getAlphabetStartChar(character: Char) =
            if (character.isLowerCase()) LOWER_CASE_LOWER_BOUND else UPPER_CASE_LOWER_BOUND

        private fun shiftAlphabetChar(zeroBasedAlphabetIndex: Int, alphabetStartCharCode: Int, numberOfShifts: Int) =
            (((zeroBasedAlphabetIndex + numberOfShifts) % NUMBER_OF_CHARS_ALPHABET) + alphabetStartCharCode).toChar()
    }

    fun encode(text: String) = text
        .map(::rotateCharacter)
        .joinToString(separator = "")

    private fun rotateCharacter(character: Char): Char {
        val alphabetStartCharCode = getAlphabetStartChar(character)
        val zeroBasedIndex = (character - alphabetStartCharCode).toInt()

        return if (isInAlphabet(zeroBasedIndex))
            shiftAlphabetChar(zeroBasedIndex, alphabetStartCharCode, numberOfShifts)
        else character
    }
}
