package Chapter2.Exercise2_10;

public class TestMain {
    public static void main(String[] args) {
        MyRectangle r1 = new MyRectangle(1, 5, 6, 2);
        MyRectangle r2 = new MyRectangle(new MyPoint(2, 8), new MyPoint(7, 3));

        System.out.println("Rectangle 1: " + r1);
        System.out.println("Width: " + r1.getWidth() + ", Height: " + r1.getHeight());
        System.out.println("Area: " + r1.getArea());
        System.out.println("Perimeter: " + r1.getPerimeter());

        System.out.println("\nRectangle 2: " + r2);
        System.out.println("Width: " + r2.getWidth() + ", Height: " + r2.getHeight());
        System.out.println("Area: " + r2.getArea());
        System.out.println("Perimeter: " + r2.getPerimeter());
    }
}
