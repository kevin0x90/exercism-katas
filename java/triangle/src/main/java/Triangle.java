import java.util.Arrays;
import java.util.function.DoublePredicate;
import java.util.stream.DoubleStream;

class Triangle {

    private final double[] sidesInAscendingOrder;

    Triangle(final double side1, final double side2, final double side3) throws TriangleException {
        sidesInAscendingOrder = DoubleStream.of(side1, side2, side3)
                .sorted()
                .toArray();

        if (anySideIsInvalid()) {
            throw new TriangleException("all sides must be > 0");
        }

        if (!hasTriangleInequality()) {
            throw new TriangleException("triangle inequality not fulfilled");
        }
    }

    boolean isEquilateral() {
        return getNumberOfDistinctSides() == 1L;
    }

    boolean isIsosceles() {
        return getNumberOfDistinctSides() <= 2L;
    }

    boolean isScalene() {
        return !isIsosceles();
    }

    private long getNumberOfDistinctSides() {
        return Arrays.stream(sidesInAscendingOrder)
                .distinct()
                .count();
    }

    private boolean hasTriangleInequality() {
        return sidesInAscendingOrder[2] <= (sidesInAscendingOrder[1] + sidesInAscendingOrder[0]);
    }

    private boolean anySideIsInvalid() {
        return Arrays.stream(sidesInAscendingOrder)
                .anyMatch(isSmallerOrEqualTo(0d));
    }

    private DoublePredicate isSmallerOrEqualTo(final double compareValue) {
        return side -> side <= compareValue;
    }
}
