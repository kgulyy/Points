package ru.hh.school.gulyy.points;

import java.util.Set;

/**
 * Main class implemented higher logic of the application
 */
public class Run {

    public static void main(String[] args) {
        // hardcore specify name of json file with source data
        String fileName = System.getProperty("user.dir") + "/src/main/resources/source.json";

        // parse json file
        Set<Point> points = JsonSourceFileParser.parse(fileName);

        for (Point center : points) {
            System.out.println("Point: " + center);
            // build tree for searching
            Node start = BuilderVpTree.build(center, points);
            // search nearest point
            Point nearestPoint = SearcherVpTree.searchNearNeighbor(start);
            System.out.println("Nearest point: " + nearestPoint);
            System.out.println("Radius = " + nearestPoint.getDistanceToCenter());
            // search nearest neighbors in double radius
            Set<Point> pointSet = SearcherVpTree.searchNearNeighbor(start, nearestPoint.getDistanceToCenter() * 2);
            System.out.println("Nearest neighbors: " + pointSet);
            System.out.println("----------------------------------");
        }
    }

}
