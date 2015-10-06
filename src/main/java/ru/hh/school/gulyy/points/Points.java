package ru.hh.school.gulyy.points;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by Константин on 06.10.2015.
 */
public class Points {
    private static int MAX_NUMBER_RANDOM_POINTS = 3;

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

    public static Set<Point> getRandomSample(Set<Point> points) {
        if(points == null || points.isEmpty())
            return null;

        Random random = new Random();
        Set<Integer> items = new HashSet<Integer>();
        for (int i = 0; i < MAX_NUMBER_RANDOM_POINTS; i++) {
            items.add(random.nextInt(points.size()));
        }

        Set<Point> resultSet = new HashSet<Point>();
        int i = 0;
        for(Point point : points) {
            if (items.contains(++i))
                resultSet.add(point);
        }

        return resultSet;
    }

    public static double getStandardDeviation(Point source, Set<Point> destinations) {
        if(source == null || destinations == null || destinations.isEmpty()) {
            return 0;
        }

        double averageDist = getAverageDist(source, destinations);

        double sum = 0;
        for (Point point : destinations) {
            double dist = source.distanceTo(point);
            sum += Math.pow((dist - averageDist), 2);
        }

        return Math.sqrt(sum / destinations.size());
    }
}
