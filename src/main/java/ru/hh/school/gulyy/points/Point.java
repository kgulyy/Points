package ru.hh.school.gulyy.points;

/**
 * Created by Константин on 06.10.2015.
 */
public class Point {
    private int x;
    private int y;
    private double distanceToCenter;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getDistanceToCenter() {
        return distanceToCenter;
    }

    public void setDistanceToCenter(Point center) {
        distanceToCenter = distanceTo(center);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        return y == point.y;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    public double distanceTo(Point dest) {
        if (dest == null) {
            throw new IllegalArgumentException();
        }
        return Math.sqrt(Math.pow((dest.getX() - x), 2) + Math.pow((dest.getY() - y), 2));
    }

    @Override
    public String toString() {
        return "{" + x + "," + y + "}";
    }
}
