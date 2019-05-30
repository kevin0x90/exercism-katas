import java.util.Arrays;
import java.util.stream.DoubleStream;

class Triangle {

    private final double[] sidesInAscendingOrder;

    Triangle(final double side1, final double side2, final double side3) throws TriangleException {
        sidesInAscendingOrder = DoubleStream.of(side1, side2, side3)
                .sorted()
                .toArray();

        if (!sidesHavePositiveLength()) {
            throw new TriangleException("all sides must be positive");
        }

        if (!hasTriangleInequality()) {
            throw new TriangleException("triangle inequality not fulfilled");
        }
    }

    boolean isEquilateral() {
        return sidesInAscendingOrder[0] == sidesInAscendingOrder[2];
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

    private boolean sidesHavePositiveLength() {
        return sidesInAscendingOrder[0] > 0;
    }
}
