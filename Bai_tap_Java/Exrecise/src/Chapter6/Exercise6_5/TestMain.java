package Chapter6.Exercise6_5;

public class TestMain {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        System.out.println(circle);
        System.out.println("Perimeter: " + circle.getPerimeter());
        System.out.println("Area: " + circle.getArea());

        ResizableCircle resizableCircle = new ResizableCircle(10.0);
        System.out.println(resizableCircle);
        resizableCircle.resize(50); // Reduce size by 50%
        System.out.println("After resizing: " + resizableCircle);
        System.out.println("Perimeter: " + resizableCircle.getPerimeter());
        System.out.println("Area: " + resizableCircle.getArea());
    }
}
