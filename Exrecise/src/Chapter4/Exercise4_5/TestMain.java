package Chapter4.Exercise4_5;

public class TestMain {
    public static void main(String[] args) {
        // Test Circle
        Circle c1 = new Circle(5.0, "blue", false);
        System.out.println(c1);
        System.out.println("Area: " + c1.getArea());
        System.out.println("Perimeter: " + c1.getPerimeter());

        // Test Rectangle
        Rectangle r1 = new Rectangle(4.0, 6.0, "green", true);
        System.out.println(r1);
        System.out.println("Area: " + r1.getArea());
        System.out.println("Perimeter: " + r1.getPerimeter());

        // Test Square
        Square s1 = new Square(4.0, "yellow", false);
        System.out.println(s1);
        System.out.println("Area: " + s1.getArea());
        System.out.println("Perimeter: " + s1.getPerimeter());
    }
}
