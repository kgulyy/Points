package ru.hh.school.gulyy.points;

import java.util.Set;

/**
 * Created by Константин on 06.10.2015.
 */
public class Main {

    public static void main(String[] args) {
        String fileName = System.getProperty("user.dir") + "/src/main/resources/source.json";

        Set<Point> points = JsonSourceFileParser.parse(fileName);

        for (Point center : points) {
            System.out.println("Point: " + center);
            Node start = BuilderVpTree.build(center, points);
            Point result = SearcherVpTree.searchNearNeighbor(start);
            System.out.println("Nearest point: " + result);
            System.out.println("Radius = " + result.getDistanceToCenter());
            Set<Point> pointSet = SearcherVpTree.searchNearNeighbor(start, result.getDistanceToCenter() * 2);
            System.out.println("Nearest neighbors: " + pointSet);
            System.out.println("----------------------------------");
        }
    }

}
