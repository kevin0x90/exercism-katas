class Triangle {

    private final double side1;
    private final double side2;
    private final double side3;

    Triangle(final double side1, final double side2, final double side3) throws TriangleException {
        if (side1 == 0d && side2 == 0d && side3 == 0d) {
            throw new TriangleException("side1, side2 and side3 must not be 0");
        }

        if (side1 + side2 < side3 || side1 + side3 < side2 || side2 + side3 < side1) {
            throw new TriangleException("triangle inequality not fulfilled");
        }

        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    boolean isEquilateral() {
        return side1 == side2 && side2 == side3;
    }

    boolean isIsosceles() {
        return side1 == side2 || side1 == side3 || side2 == side3;
    }

    boolean isScalene() {
        return side1 != side2 && side1 != side3 && side2 != side3;
    }

}
