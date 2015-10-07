package ru.hh.school.gulyy.points;

import java.util.HashSet;
import java.util.Set;

/**
 * BuilderVpTree class for build tree for searching nearest points
 */
public class BuilderVpTree {

    /**
     * Method build tree for searching
     * @param src is source Point of searching nearest neighbor
     * @param dest is set of destination points
     * @return the top node of tree
     */
    public static Node build(Point src, Set<Point> dest) {
        // copy set of points
        Set<Point> points = new HashSet<Point>(dest);
        if(points.contains(src)) {
            // delete source point from set
            points.remove(src);
        }
        calculateDist(src, points);
        return makeVpTree(src, points);
    }

    /**
     * Method calculate distance to source point for all the points in set
     * @param src is source Point
     * @param dest is set of destination points
     */
    private static void calculateDist(Point src, Set<Point> dest) {
        for (Point point : dest) {
            point.setDistanceToCenter(src);
        }
    }

    /**
     * Recursive method for building tree
     * @param src is source Point of searching nearest neighbor
     * @param dest is set of destination points
     * @return current node of tree
     */
    private static Node makeVpTree(Point src, Set<Point> dest) {
        if (dest.isEmpty())
            return null;

        Node node = new Node();
        node.setPoints(dest);
        // radius is average distance to all destination points
        node.setRadius(Points.getAverageDist(src, dest));

        if(node.isLeaf()) {
            // return method back
            return node;
        }

        Set<Point> left = new HashSet<Point>();
        Set<Point> right = new HashSet<Point>();
        for (Point point : dest) {
            // if point in radius
            if (point.distanceTo(src) <= node.getRadius()) {
                left.add(point);
            } else {
                right.add(point);
            }
        }
        node.setLeft(makeVpTree(src, left));
        node.setRight(makeVpTree(src, right));

        return node;
    }
}
