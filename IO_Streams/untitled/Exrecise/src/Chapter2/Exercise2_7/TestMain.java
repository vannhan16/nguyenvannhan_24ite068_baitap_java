package Chapter2.Exercise2_7;

import Chapter2.Exercise2_6.MyPoint;
public class TestMain {
    public static void main(String[] args) {
        // Tạo đối tượng MyPoint
        MyPoint p1 = new MyPoint(0, 0);
        MyPoint p2 = new MyPoint(3, 4);

        // Tạo đối tượng MyLine
        MyLine line = new MyLine(p1, p2);
        System.out.println(line);

        // Kiểm tra các phương thức của MyLine
        System.out.println("Length: " + line.getLength());
        System.out.println("Gradient: " + Math.toDegrees(line.getGradient()) + " degrees");

        // Thay đổi giá trị điểm bắt đầu và kết thúc
        line.setBeginXY(1, 1);
        line.setEndXY(4, 5);
        System.out.println("New line: " + line);
        System.out.println("New length: " + line.getLength());
        System.out.println("New gradient: " + Math.toDegrees(line.getGradient()) + " degrees");
    }
}

