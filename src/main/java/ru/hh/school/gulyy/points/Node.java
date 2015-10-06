package ru.hh.school.gulyy.points;

import java.util.Set;

/**
 * Created by Константин on 06.10.2015.
 */
public class Node {
    public static int MAX_SIZE_LEAF = 3;

    private Point center;
    private double radius;
    private Set<Point> points;
    private Node left;
    private Node right;

    public Node() {
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
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

    public boolean isLeaf() {
        return points.size() <= MAX_SIZE_LEAF ? true : false;
    }
}
