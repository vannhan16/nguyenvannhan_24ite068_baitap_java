package Chapter6.Exercise6_8;

public class TestMain {
    public static void main(String[] args) {
        MovablePoint point = new MovablePoint(2, 3, 1, 1);
        System.out.println("Before move: " + point);
        point.moveUp();
        point.moveLeft();
        System.out.println("After move: " + point);

        MovableCircle circle = new MovableCircle(5, 5, 2, 2, 10);
        System.out.println("Before move: " + circle);
        circle.moveDown();
        circle.moveRight();
        System.out.println("After move: " + circle);
    }
}
