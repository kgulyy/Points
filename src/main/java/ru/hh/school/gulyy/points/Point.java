package ru.hh.school.gulyy.points;

/**
 * Created by Константин on 06.10.2015.
 */
public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
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
}
