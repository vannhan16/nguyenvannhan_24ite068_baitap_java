package Chapter6.Exrecise6_4;

public class TestMain {
    public static void main(String[] args) {
        MovablePoint p1 = new MovablePoint(2, 3, 1, 1);
        System.out.println(p1);
        p1.moveUp();
        System.out.println("After moving up: " + p1);
        p1.moveRight();
        System.out.println("After moving right: " + p1);

        MovableCircle c1 = new MovableCircle(5, 5, 2, 2, 10);
        System.out.println(c1);
        c1.moveDown();
        System.out.println("After moving down: " + c1);
        c1.moveLeft();
        System.out.println("After moving left: " + c1);
    }
}
