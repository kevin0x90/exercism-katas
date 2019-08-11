import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Matrix {
    private final List<List<Integer>> matrix;

    Matrix(final List<List<Integer>> values) {
        matrix = values;
    }

    Set<MatrixCoordinate> getSaddlePoints() {
        return IntStream.range(0, matrix.size())
                .mapToObj(this::getSaddlePointsInRow)
                .flatMap(Function.identity())
                .collect(Collectors.toUnmodifiableSet());
    }

    private Stream<MatrixCoordinate> getSaddlePointsInRow(final int rowIndex) {
        return getMaxValuesWithIndex(matrix.get(rowIndex))
                .map(maxWithIndex -> getSaddlePoint(maxWithIndex, rowIndex))
                .filter(Optional::isPresent)
                .map(Optional::get);
    }

    private Stream<MaxValueWithIndex> getMaxValuesWithIndex(final List<Integer> row) {
        final int max = row.stream().max(Comparator.naturalOrder()).orElse(0);

        return IntStream.range(0, row.size())
                .filter(index -> row.get(index) == max)
                .mapToObj(index -> new MaxValueWithIndex(row.get(index), index));
    }

    private Optional<MatrixCoordinate> getSaddlePoint(final MaxValueWithIndex maxValueWithIndex, final int rowIndex) {
        final int maxValue = maxValueWithIndex.getMaxValue();
        final int columnIndex = maxValueWithIndex.getIndex();

        return matrix.stream().allMatch(row -> maxValue <= row.get(columnIndex)) ?
                Optional.of(new MatrixCoordinate(rowIndex + 1, columnIndex + 1)) :
                Optional.empty();
    }
}
