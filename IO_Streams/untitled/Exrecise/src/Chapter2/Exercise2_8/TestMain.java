package Chapter2.Exercise2_8;

class TestMain {
    public static void main(String[] args) {
        MyCircle c1 = new MyCircle(1, 1, 3);
        MyCircle c2 = new MyCircle(4, 5, 2);

        System.out.println("Testing MyCircle class:");
        System.out.println("Circle 1: " + c1);
        System.out.println("Circle 2: " + c2);
        System.out.println("Distance between centers: " + c1.distance(c2));

        c1.setRadius(5);
        System.out.println("Updated Circle 1 radius: " + c1.getRadius());
        System.out.println("New area of Circle 1: " + c1.getArea());
    }
}