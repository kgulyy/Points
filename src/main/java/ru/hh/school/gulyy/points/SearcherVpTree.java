package ru.hh.school.gulyy.points;

/**
 * Created by Константин on 06.10.2015.
 */
public class SearcherVpTree {
    public static Point searchNearNeighbor(Point source, Node node) {
        if (source.distanceTo(node.getCenter()) <= node.getRadius()) {
            if (node.getLeft().isLeaf()) {
                return linearSearch(source, node.getLeft());
            } else {
                return searchNearNeighbor(source, node.getLeft());
            }
        } else if (node.getRight().isLeaf()) {
            return linearSearch(source, node.getRight());
        } else {
            return searchNearNeighbor(source, node.getRight());
        }
    }

    public static Point searchNearNeighbor(Point source, Node node, double radius) {
        if (source.distanceTo(node.getCenter()) - radius <= node.getRadius()) {
            if (node.getLeft().isLeaf()) {
                return linearSearch(source, node.getLeft(), radius);
            } else {
                return searchNearNeighbor(source, node.getLeft(), radius);
            }
        }
        if (source.distanceTo(node.getCenter()) + radius >= node.getRadius()) {
            if (node.getRight().isLeaf()) {
                return linearSearch(source, node.getRight(), radius);
            } else {
                return searchNearNeighbor(source, node.getRight(), radius);
            }
        }

        return null;
    }

    private static Point linearSearch(Point source, Node node) {
        double nearestDist = 0;
        Point nearestPoint = null;

        for(Point point : node.getPoints()) {
            double dist = source.distanceTo(point);
            if (dist > nearestDist) {
                nearestDist = dist;
                nearestPoint = point;
            }
        }

        return nearestPoint;
    }

    private static Point linearSearch(Point source, Node node, double radius) {
        return null;
    }
}
