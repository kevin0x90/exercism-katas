class Matrix(matrixAsString: String) {

    companion object {
        private const val ROW_DELIMITER = '\n'
        private const val ELEMENT_DELIMITER = ' '
    }

    private val rows = matrixAsString
            .split(ROW_DELIMITER)
            .map(this::parseStringListToInt)

    fun column(colNr: Int): List<Int> = rows.flatMap(List<Int>::withIndex)
            .filter { it.index == colNr - 1 }
            .map(IndexedValue<Int>::value)

    fun row(rowNr: Int): List<Int> = rows[rowNr - 1]

    private fun parseStringListToInt(row: String) = row.split(ELEMENT_DELIMITER)
            .map(String::trim)
            .filter(String::isNotEmpty)
            .map(Integer::parseInt)
            .toList()
}
