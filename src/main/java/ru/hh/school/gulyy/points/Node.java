package ru.hh.school.gulyy.points;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by Константин on 06.10.2015.
 */
public class Node {
    public static int MAX_SIZE_LEAF = 1;

    //private Point center;
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

    public Point getFirstPoint() {
        Iterator<Point> iterator = points.iterator();
        return iterator.next();
    }

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
