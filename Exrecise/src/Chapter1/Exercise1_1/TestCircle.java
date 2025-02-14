package Chapter1.Exercise1_1;

public class TestCircle {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        System.out.println("The circle has radius " + c1.getRadius() + " and the area " + c1.getArea());
        Circle c2 = new Circle();
        System.out.println("The circle has radius " + c2.getRadius() + " and the area " + c2.getArea());
        Circle c3 = new Circle();
        c3.setRadius(5.5);
        System.out.println("radius is: " + c3.getRadius());
        c3.setColor("green");
        System.out.println("color is: " + c3.getColor());
    }
}
