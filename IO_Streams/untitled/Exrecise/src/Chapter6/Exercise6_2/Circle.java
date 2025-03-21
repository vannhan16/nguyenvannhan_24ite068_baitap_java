package Chapter6.Exercise6_2;

public class Circle implements GeometricObject {
    private double radius;

    public Circle(double radiu) {
        this.radius = radiu;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return Math.PI * 2 * radius;
    }

    public String toString() {
        return "[radiu " + radius + "]";
    }
}
