package Chapter7.Exercise7_2;

public class TestMain {
    public static void main(String[] args) {
        PolyLine polyline = new PolyLine();
        polyline.appendPoint(1, 2);
        polyline.appendPoint(3, 4);
        polyline.appendPoint(5, 6);

        System.out.println("Polyline: " + polyline);
        System.out.println("Length: " + polyline.getLength());
    }
}
