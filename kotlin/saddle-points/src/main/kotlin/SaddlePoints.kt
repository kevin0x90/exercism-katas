data class MatrixCoordinate(val row: Int, val col: Int)

class Matrix(private val matrix: List<List<Int>>) {

    val saddlePoints: Set<MatrixCoordinate>

    init {
        saddlePoints = matrix.asSequence()
                .withIndex()
                .map { toSaddlePoints(it.index, it.value.asSequence()) }
                .flatten()
                .toSet()
    }

    private fun toSaddlePoints(rowIndex: Int, row: Sequence<Int>) = row
            .withIndex()
            .filter { (currentIndex, currentValue) -> row.excludeIndex(currentIndex).isSaddlePointInRow(currentValue) }
            .filter { (currentIndex, currentValue) -> matrix.column(rowIndex, currentIndex).isSaddlePointInCol(currentValue) }
            .map { MatrixCoordinate(rowIndex + 1, it.index + 1) }

    private fun Sequence<Int>.excludeIndex(indexToExclude: Int) = this.filterIndexed { index, _ -> index != indexToExclude }

    private fun Sequence<Int>.isSaddlePoint(predicate: (Int) -> Boolean) = this.all(predicate)
    private fun Sequence<Int>.isSaddlePointInRow(value: Int) = this.isSaddlePoint { rowValue -> value >= rowValue }
    private fun Sequence<Int>.isSaddlePointInCol(value: Int) = this.isSaddlePoint { colValue -> value <= colValue }

    private fun List<List<Int>>.column(rowIndex: Int, colIndex: Int) = this.asSequence().map { it[colIndex] }.excludeIndex(rowIndex)
}
