package ru.hh.school.gulyy.points;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by Константин on 06.10.2015.
 */
public class SearcherVpTree {

    public static Point searchNearNeighbor(Node node) {
        if (node == null)
            throw new IllegalArgumentException();

        while (!node.isLeaf()) {
            node = node.getLeft();
        }
        return node.getFirstPoint();
    }

    public static Set<Point> searchNearNeighbor(Node node, double radius) {
        if (node == null)
            throw new IllegalArgumentException();

        Set<Point> result = new HashSet<Point>();
        Stack<Node> stack = new Stack<Node>();
        while (node != null || !stack.isEmpty()) {
            if (!stack.isEmpty()) {
                node = stack.pop();
            }
            while (node != null) {
                if (node.isLeaf())
                    if (node.getFirstPoint().getDistanceToCenter() <= radius) {
                        result.addAll(node.getPoints());
                    } else
                        return result;
                if (node.getRight() != null)
                    stack.push(node.getRight());
                node = node.getLeft();
            }
        }

        return result;
    }
}
