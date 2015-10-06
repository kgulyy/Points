package ru.hh.school.gulyy.points;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Константин on 06.10.2015.
 */
public class BuilderVpTree {

    public static Node build(Set<Point> points) {
        if (points.isEmpty() || points.size() <= Node.MAX_SIZE_LEAF)
            return null;

        Node node = new Node();
        node.setPoints(points);
        node.setCenter(selectVP(points));
        node.setRadius(Points.getAverageDist(node.getCenter(), points));

        Set<Point> left = new HashSet<Point>();
        left.add(node.getCenter());
        Set<Point> right = new HashSet<Point>();
        right.add(node.getCenter());
        for (Point point : points) {
            if (point.distanceTo(node.getCenter()) <= node.getRadius()) {
                left.add(point);
            } else {
                right.add(point);
            }
        }
        node.setLeft(build(left));
        node.setRight(build(right));

        return node;
    }

    private static Point selectVP(Set<Point> points) {
        Set<Point> firstRandomSample = Points.getRandomSample(points);
        double bestSpread = 0;
        Point bestPoint = null;
        for (Point point : firstRandomSample) {
            Set<Point> secondRandomSample = Points.getRandomSample(firstRandomSample);
            double spread = Points.getStandardDeviation(point, secondRandomSample);
            if (spread > bestSpread) {
                bestSpread = spread;
                bestPoint = point;
            }
        }

        return bestPoint;
    }
}
