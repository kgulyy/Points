package ru.hh.school.gulyy.points;

import java.util.Iterator;
import java.util.Set;

/**
 * POJO class is representing node of tree
 */
public class Node {
    private double radius;
    private Set<Point> points;
    private Node left;
    private Node right;

    public Node() {
    }

    public Node(Set<Point> points) {
        this.points = points;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Set<Point> getPoints() {
        return points;
    }

    public void setPoints(Set<Point> points) {
        this.points = points;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    /**
     * Method get first point of set
     * @return the first point of set
     */
    public Point getFirstPoint() {
        Iterator<Point> iterator = points.iterator();
        return iterator.next();
    }

    /**
     * Method check if node is leaf
     * @return true if node is leaf, false otherwise
     */
    public boolean isLeaf() {
        return (points.size() == 1 || Points.areAllEquidistant(points)) && left == null && right == null ? true : false;
    }

    @Override
    public String toString() {
        return "Node{" +
                ", radius=" + radius +
                ", points=" + points +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
