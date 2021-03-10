private val PUNCTUATION = setOf('!', '&', '@', '$', '%', '^', ':', '.')
private val DELIMITERS = charArrayOf(' ', ',')

private fun String.sanitize() = this.trim().filterNot { c -> c in PUNCTUATION }

private fun String.isEnclosedWithParenthesis() = this.startsWith("'") && this.endsWith("'")

private fun String.removeParenthesis() = this.substring(1, this.length - 1)

private fun putWordIntoMap(map: MutableMap<String, Int>, word: String): MutableMap<String, Int> {
    map.merge(
        if (word.isEnclosedWithParenthesis()) word.removeParenthesis() else word,
        1,
        Math::addExact
    )

    return map
}

object WordCount {
    fun phrase(phrase: String) = phrase
        .toLowerCase()
        .split(*DELIMITERS)
        .map(String::sanitize)
        .filter(String::isNotEmpty)
        .fold(mutableMapOf(), ::putWordIntoMap)
}
