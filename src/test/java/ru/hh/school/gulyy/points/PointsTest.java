package ru.hh.school.gulyy.points;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Константин on 06.10.2015.
 */
public class PointsTest {
    private Set<Point> points;
    private Point point;

    @Before
    public void before() {
        point = new Point(0,0);

        points = new HashSet<Point>();
        points.add(point);
        points.add(new Point(3,4));
        points.add(new Point(-2,0));
        points.add(new Point(0,3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAverageDist_caseNull() {
        Points.getAverageDist(null, null);
    }

    @Test
    public void testGetAverageDist_case() {
        Assert.assertEquals(2.5, Points.getAverageDist(point, points), 0.00001);
    }

    @Test
     public void testGetRandomSample_caseNull() {
        Assert.assertNull(Points.getRandomSample(null));
    }

    @Test
    public void testGetRandomSample_case() {
        Assert.assertTrue(Points.getRandomSample(points).size() <= 3);
    }

    @Test
    public void testGetStandardDeviation() {
        Assert.assertEquals(1.80277, Points.getStandardDeviation(point, points), 0.00001);
    }
}