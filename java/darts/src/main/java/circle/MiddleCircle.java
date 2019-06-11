package circle;

public class MiddleCircle extends Circle {
    public MiddleCircle() {
        super(5.0, 5, new InnerCircle());
    }
}