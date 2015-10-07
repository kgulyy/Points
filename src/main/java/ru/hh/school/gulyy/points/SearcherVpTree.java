package ru.hh.school.gulyy.points;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * SearcherVpTree class for searching nearest neighbor in the tree
 */
public class SearcherVpTree {

    /**
     * Method search the nearest point
     * @param node is the top node of the tree
     * @return the nearest point
     */
    public static Point searchNearNeighbor(Node node) {
        if (node == null)
            throw new IllegalArgumentException();

        while (!node.isLeaf()) {
            node = node.getLeft();
        }

        return node.getFirstPoint();
    }

    /**
     * Method search nearest neighbors in radius including border
     * @param node is the top node of the tree
     * @param radius is radius for searching
     * @return set of nearest points
     */
    public static Set<Point> searchNearNeighbor(Node node, double radius) {
        if (node == null)
            throw new IllegalArgumentException();

        Set<Point> result = new HashSet<Point>();
        // stack for non recursive tree traversal
        Stack<Node> stack = new Stack<Node>();
        while (node != null || !stack.isEmpty()) {
            if (!stack.isEmpty()) {
                node = stack.pop();
            }
            while (node != null) {
                if (node.isLeaf())
                    // check if distance in radius
                    if (node.getFirstPoint().getDistanceToCenter() <= radius) {
                        // add all points to result
                        result.addAll(node.getPoints());
                    } else
                        // early return of the method
                        return result;
                if (node.getRight() != null)
                    stack.push(node.getRight());
                node = node.getLeft();
            }
        }

        return result;
    }
}
