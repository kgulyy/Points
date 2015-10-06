package ru.hh.school.gulyy.points;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Константин on 06.10.2015.
 */
public class PointTest {
    private static Point point;

    @BeforeClass
    public static void before() {
        point = new Point(1,1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDistanceTo_caseNull() {
        point.distanceTo(null);
    }

    @Test
    public void testDistanceTo_caseSamePoint() {
        Assert.assertEquals(0, point.distanceTo(point), 0.00001);
    }

    @Test
    public void testDistanceTo_caseNegative() {
        Assert.assertEquals(2.82842, point.distanceTo(new Point(-1,-1)), 0.00001);
        Assert.assertEquals(2, point.distanceTo(new Point(1,-1)), 0.00001);
        Assert.assertEquals(2, point.distanceTo(new Point(-1, 1)), 0.00001);
    }

    @Test
    public void testDistanceTo_casePositive() {
        Assert.assertEquals(9, point.distanceTo(new Point(10,1)), 0.00001);
        Assert.assertEquals(5, point.distanceTo(new Point(4,5)), 0.00001);
        Assert.assertEquals(1.41421, point.distanceTo(new Point(0,0)), 0.00001);
    }
}