package circle;

public class OuterCircle extends Circle {
    public OuterCircle() {
        super(10.0, 1, new MiddleCircle());
    }
}