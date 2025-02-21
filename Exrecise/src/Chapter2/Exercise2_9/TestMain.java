package Chapter2.Exercise2_9;

import Chapter2.Exercise2_6.MyPoint;
public class TestMain {
    public static void main(String[] args) {
        MyTriangle t1 = new MyTriangle(0, 0, 3, 0, 3, 4);
        MyTriangle t2 = new MyTriangle(new MyPoint(1, 1), new MyPoint(4, 1), new MyPoint(2, 5));

        System.out.println("Triangle 1: " + t1);
        System.out.println("Perimeter: " + t1.getPerimeter());
        System.out.println("Type: " + t1.getType());

        System.out.println("Triangle 2: " + t2);
        System.out.println("Perimeter: " + t2.getPerimeter());
        System.out.println("Type: " + t2.getType());
    }
}
