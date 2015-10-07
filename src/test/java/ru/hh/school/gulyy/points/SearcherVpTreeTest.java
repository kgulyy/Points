package ru.hh.school.gulyy.points;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Константин on 06.10.2015.
 */
public class SearcherVpTreeTest {
    Node start = null;

    @Before
    public void before() {
        Set<Point> points = new HashSet<Point>();
        points.add(new Point(0,0));
        points.add(new Point(3,2));
        points.add(new Point(2,3));
        points.add(new Point(-2,0));
        points.add(new Point(3,-3));
        points.add(new Point(-2,2));
        points.add(new Point(-4,-4));
        points.add(new Point(0, 3));

        start = BuilderVpTree.build(new Point(0,0), points);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSearchNearNeighbor_caseNull() {
        SearcherVpTree.searchNearNeighbor(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSearchNearNeighbor_caseNullWithRadius() {
        SearcherVpTree.searchNearNeighbor(null, 0);
    }

    @Test
    public void testSearchNearNeighbor() {
        Point nearestPoint = SearcherVpTree.searchNearNeighbor(start);

        Assert.assertEquals(new Point(-2, 0), nearestPoint);
        Assert.assertEquals(2.0, nearestPoint.getDistanceToCenter(), 0.0000001);

        Set<Point> actualSet = SearcherVpTree.searchNearNeighbor(start, nearestPoint.getDistanceToCenter() * 2);
        Assert.assertEquals(5, actualSet.size());

        Set<Point> expectedSet = new HashSet<Point>();
        expectedSet.add(new Point(3,2));
        expectedSet.add(new Point(2,3));
        expectedSet.add(new Point(-2,0));
        expectedSet.add(new Point(0,3));
        expectedSet.add(new Point(-2,2));

        Assert.assertEquals(expectedSet, actualSet);
    }

}