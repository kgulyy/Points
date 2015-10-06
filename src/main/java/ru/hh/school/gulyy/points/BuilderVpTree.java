package ru.hh.school.gulyy.points;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Константин on 06.10.2015.
 */
public class BuilderVpTree {

    public static Node build(Point center, Set<Point> source) {
        Set<Point> points = new HashSet<Point>(source);
        if(points.contains(center)) {
            points.remove(center);
        }
        calculateDist(center, points);
        return makeVpTree(center, points);
    }

    private static void calculateDist(Point center, Set<Point> points) {
        for (Point point : points) {
            point.setDistanceToCenter(center);
        }
    }

    private static Node makeVpTree(Point center, Set<Point> points) {
        if (points.isEmpty())
            return null;

        Node node = new Node();
        node.setPoints(points);
        node.setRadius(Points.getAverageDist(center, points));

        if(points.size() == 1 || Points.areAllEquidistant(points)) {
            return node;
        }

        Set<Point> left = new HashSet<Point>();
        Set<Point> right = new HashSet<Point>();
        for (Point point : points) {
            if (point.distanceTo(center) <= node.getRadius()) {
                left.add(point);
            } else {
                right.add(point);
            }
        }
        node.setLeft(makeVpTree(center, left));
        node.setRight(makeVpTree(center, right));

        return node;
    }
}
