import java.util.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Objects.requireNonNull;

class Matrix {

    final int[][] rows;
    final int[][] columns;

    Matrix(final String matrixAsString) {
        requireNonNull(matrixAsString, "matrixAsString must not be null");
        final String[] rowStrings = MatrixStringUtils.getRowStrings(matrixAsString);
        final int numberOfRows = rowStrings.length;
        final int numberOfColumns = MatrixStringUtils.getNumberOfRowColumns(rowStrings)
                .orElseThrow(() -> new IllegalArgumentException("A matrix must have at least one dimension"));

        rows = new int[numberOfRows][numberOfColumns];
        columns = new int[numberOfColumns][numberOfRows];

        if (!isValidMatrix(rowStrings)) {
            throw new IllegalArgumentException("The provided matrix is malformed");
        }

        IntStream.range(0, numberOfRows)
                .mapToObj(rowIndex ->
                        new SimpleEntry<>(rowIndex, MatrixStringUtils.getColumnsFromRowString(rowStrings[rowIndex])))
                .forEach(this::setRowColumnValues);
    }

    int[] getRow(final int rowNumber) {
        if (rowNumber < 0) {
            throw new IndexOutOfBoundsException("rowNumber must be non negative");
        }
        if (rowNumber >= rows.length) {
            throw new IndexOutOfBoundsException(String.format(Locale.ENGLISH,
                    "rowNumber must be less than %d", rows.length));
        }

        return rows[rowNumber].clone();
    }

    int[] getColumn(final int columnNumber) {
        if (columnNumber < 0) {
            throw new IndexOutOfBoundsException("columnNumber must be non negative");
        }
        if (columnNumber >= columns.length) {
            throw new IndexOutOfBoundsException(String.format(Locale.ENGLISH,
                    "columnNumber must be less than %d", columns.length));
        }

        return columns[columnNumber].clone();
    }

    private boolean isValidMatrix(final String[] rowStrings) {
        return Arrays.stream(rowStrings)
                .map(MatrixStringUtils::getColumnsFromRowString)
                .allMatch(this::hasValidColumnCount);
    }

    private boolean hasValidColumnCount(final List<String> columns) {
        return columns.size() == this.columns.length;
    }

    private void setRowColumnValues(final SimpleEntry<Integer, List<String>> rowIndexWithColumns) {
        IntStream.range(0, columns.length)
                .forEach(columnIndex -> {
                    final var rowIndex = rowIndexWithColumns.getKey();
                    final var column = rowIndexWithColumns.getValue().get(columnIndex);
                    final var parsedElementValue = Integer.parseInt(column);
                    rows[rowIndex][columnIndex] = parsedElementValue;
                    columns[columnIndex][rowIndex] = parsedElementValue;
                });
    }

    private static class MatrixStringUtils {
        private static List<String> getColumnsFromRowString(final String rowString) {
            return Arrays.stream(rowString.split(" ")).collect(Collectors.toList());
        }

        private static String[] getRowStrings(final String matrixAsString) {
            return matrixAsString.split("\n");
        }

        private static Optional<Integer> getNumberOfRowColumns(final String[] rowStrings) {
            return Arrays.stream(rowStrings)
                    .findFirst()
                    .map(MatrixStringUtils::getColumnsFromRowString)
                    .map(List::size);
        }
    }
}
