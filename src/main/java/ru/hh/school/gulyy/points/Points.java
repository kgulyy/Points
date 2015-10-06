package ru.hh.school.gulyy.points;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by Константин on 06.10.2015.
 */
public class Points {

    public static double getAverageDist(Point source, Set<Point> destinations) {
        if(source == null || destinations == null || destinations.isEmpty()) {
            throw new IllegalArgumentException();
        }

        double sum = 0;
        for (Point dest : destinations) {
            sum += source.distanceTo(dest);
        }
        return sum / destinations.size();
    }

    public static boolean areAllEquidistant(Set<Point> points) {
        if(points == null || points.isEmpty()) {
            throw new IllegalArgumentException();
        }

        for(Point point : points)
            for (Point pnt: points) {
                if(Double.compare(point.getDistanceToCenter(), pnt.getDistanceToCenter()) != 0) {
                    return false;
                }
            }
        return true;
    }
}
