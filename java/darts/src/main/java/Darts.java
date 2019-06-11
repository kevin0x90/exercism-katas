import circle.Circle;
import circle.InnerCircle;
import circle.MiddleCircle;
import circle.OuterCircle;

import java.util.List;

class Darts {
    private final double distanceFromCenter;
    private static final List<Circle> dartCircles = List.of(new OuterCircle(), new MiddleCircle(), new InnerCircle());

    Darts(final double x, final double y) {
        distanceFromCenter = Math.sqrt(x * x + y * y);
    }

    int score() {
        return dartCircles
                .stream()
                .filter(circle -> circle.isWithinCircle(distanceFromCenter))
                .findFirst()
                .map(Circle::getPoints)
                .orElse(0);
    }
}
