import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

class Triangle {

    private final Map<Double, List<Double>> groupedSides;

    Triangle(final double side1, final double side2, final double side3) throws TriangleException {
        groupedSides = DoubleStream.of(side1, side2, side3)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity()));

        if (allSidesAreZero()) {
            throw new TriangleException("side1, side2 and side3 must not be 0");
        }

        if (!hasTriangleInequality()) {
            throw new TriangleException("triangle inequality not fulfilled");
        }
    }

    private boolean hasTriangleInequality() {
        final var sidesDescending = groupedSides.values()
                .stream()
                .flatMap(Collection::stream)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        return sidesDescending.get(0) <= sidesDescending.get(1) + sidesDescending.get(2);
    }

    private boolean allSidesAreZero() {
        return isEquilateral() && groupedSides.containsKey(0d);
    }

    boolean isEquilateral() {
        return groupedSides.size() == 1;
    }

    boolean isIsosceles() {
        return isEquilateral() || groupedSides.size() == 2;
    }

    boolean isScalene() {
        return !isIsosceles();
    }

}
