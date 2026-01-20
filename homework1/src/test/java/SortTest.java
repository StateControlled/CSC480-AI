
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class SortTest {

    public static void main(String[] args) {
        pointSorting();
    }

    public static void pointSorting() {
        Point p0 = new Point(-3, 4);
        Point p1 = new Point(-7, -4);
        Point p2 = new Point(-5, 6);
        Point p3 = new Point(-3, -6);
        Point p4 = new Point(-1, 2);
        Point p5 = new Point(2, 5);
        Point p6 = new Point(3, -2);
        Point p7 = new Point(5, 2);
        Point p8 = new Point(9, 0);
        Point p9 = new Point(0, 9);
        Point pa = new Point(0, 7);
        Point pb = new Point(5, 5);

        Queue<Point> q = new PriorityQueue<>();
        q.addAll(List.of(p9, p3, p1, pb, p0, p8, p5, p2, p4, pa, p7, p6));

        for (Point p : q) {
            System.out.println(p);
        }

    }



    public static class Point implements Comparable<Point> {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point other) {
            // First compare by x
            int cmp = Integer.compare(this.x, other.x);
            if (cmp != 0) {
                return cmp;
            }
            // If x is equal, compare by y
            return Integer.compare(this.y, other.y);
        }

        @Override
        public String toString() {
            return "Point (" + x + ',' + y + ')';
        }

    }

}
