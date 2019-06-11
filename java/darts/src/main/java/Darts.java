import circle.Circle;
import circle.InnerCircle;
import circle.MiddleCircle;
import circle.OuterCircle;

import java.util.List;

class Darts {
    private final double x;
    private final double y;

    Darts(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    int score() {
        final double distanceFromCenter = Math.sqrt(x * x + y * y);

        return List.of(new OuterCircle(), new MiddleCircle(), new InnerCircle())
                .stream()
                .filter(circle -> circle.isWithinCircle(distanceFromCenter))
                .findFirst()
                .map(Circle::getPoints)
                .orElse(0);
    }
}
