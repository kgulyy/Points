package ru.hh.school.gulyy.points;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class PointsTest {
    private static Set<Point> points;
    private static Point point;

    @BeforeClass
    public static void before() {
        point = new Point(0,0);

        points = new HashSet<Point>();
        points.add(new Point(3,4));
        points.add(new Point(-3,-4));
        points.add(new Point(4,3));
        points.add(new Point(-4,3));
        points.add(new Point(-2,0));
        points.add(new Point(0,3));

        for (Point pnt : points) {
            pnt.setDistanceToCenter(point);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAverageDist_caseNull() {
        Points.getAverageDist(null, null);
    }

    @Test
    public void testGetAverageDist_case() {
        Assert.assertEquals(4.16666, Points.getAverageDist(point, points), 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAreAllEquidistant_caseNull() {
        Points.areAllEquidistant(null);
    }

    @Test
    public void testAreAllEquidistant_caseFalse() {
        Assert.assertFalse(Points.areAllEquidistant(points));
    }

    @Test
    public void testAreAllEquidistant_caseTrue() {
        Set<Point> testCase = new HashSet<Point>(points);
        testCase.remove(new Point(-2,0));
        testCase.remove(new Point(0, 3));
        Assert.assertTrue(Points.areAllEquidistant(testCase));
    }
}