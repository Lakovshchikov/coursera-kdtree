import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.Queue;
import java.util.Iterator;

public class PointSET {

    private SET<Point2D> set;

    public PointSET() {
        set = new SET<Point2D>();
    }

    public boolean isEmpty() {
        return set.isEmpty();
    }

    public int size() {
        return set.size();
    }

    public void insert(Point2D p) {
        if (p == null) {
            throw new java.lang.IllegalArgumentException();
        }
        if (!set.contains(p)) {
            set.add(p);
        }
    }

    public boolean contains(Point2D p) {
        if (p == null) {
            throw new java.lang.IllegalArgumentException();
        }
        return set.contains(p);
    }

    public void draw() {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.01);
        for (Iterator<Point2D> i = set.iterator(); i.hasNext(); ) {
            Point2D currentPoint = i.next();
            StdDraw.point(currentPoint.x(), currentPoint.y());
        }
    }

    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null) {
            throw new java.lang.IllegalArgumentException();
        }
        Queue<Point2D> q = new Queue<Point2D>();
        for (Iterator<Point2D> i = set.iterator(); i.hasNext(); ) {
            Point2D currentPoint = i.next();
            if (rect.contains(currentPoint)) {
                q.enqueue(currentPoint);
            }
        }
        return q;
    }

    public Point2D nearest(Point2D p) {
        if (p == null) {
            throw new java.lang.IllegalArgumentException();
        }
        double prevDistance = Double.POSITIVE_INFINITY;
        Point2D minPoint = null;
        for (Iterator<Point2D> i = set.iterator(); i.hasNext(); ) {
            Point2D currentPoint = i.next();
            if (currentPoint.distanceTo(p) < prevDistance) {
                prevDistance = currentPoint.distanceTo(p);
                minPoint = currentPoint;
            }
        }
        return minPoint;
    }

    public static void main(String[] args) {

    }
}
