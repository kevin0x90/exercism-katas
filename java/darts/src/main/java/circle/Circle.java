package circle;

import java.util.Optional;

public abstract class Circle {
    private final double radius;
    private final int points;
    private final Optional<Circle> previousCircle;

    Circle(final double radius, final int points, final Circle previousCircle) {
        this.radius = radius;
        this.points = points;
        this.previousCircle = Optional.ofNullable(previousCircle);
    }

    private double getRadius() {
        return radius;
    }

    public int getPoints() {
        return points;
    }

    public boolean isWithinCircle(final double distanceFromCenter) {
        final double previousCircleRadius = previousCircle.map(Circle::getRadius).orElse(-1.0);

        return distanceFromCenter <= radius && distanceFromCenter > previousCircleRadius;
    }
}
