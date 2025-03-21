package Chapter5.Exercise5_2;

public class Circle {
    private double radius ;
    private String color ;
    public Circle(){
        this.radius =1.0;
        this.color = "red";
    }
    public Circle(double radius,String color){
        this.radius = radius;
        this.color = color;
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
    public double getArea(){
        return radius*radius*Math.PI;
    }

    @Override
    public String toString() {
        return "Circle[" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                ']';
    }
}
