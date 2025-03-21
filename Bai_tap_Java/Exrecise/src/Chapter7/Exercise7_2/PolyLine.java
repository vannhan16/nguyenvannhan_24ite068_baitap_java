package Chapter7.Exercise7_2;

import java.util.ArrayList;
import java.util.List;
public class PolyLine {
    private List<Point> points = new ArrayList<>();

    public PolyLine() {}

    public PolyLine(List<Point> points) {
        this.points = new ArrayList<>(points);
    }

    public void appendPoint(int x, int y) {
        points.add(new Point(x, y));
    }

    public void appendPoint(Point point) {
        points.add(point);
    }

    public double getLength() {
        double length = 0.0;
        for (int i = 1; i < points.size(); i++) {
            Point p1 = points.get(i - 1);
            Point p2 = points.get(i);
            length += Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
        }
        return length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Point p : points) {
            sb.append(p.toString());
        }
        sb.append("}");
        return sb.toString();
    }
}
