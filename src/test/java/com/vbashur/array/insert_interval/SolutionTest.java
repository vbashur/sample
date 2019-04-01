package com.vbashur.array.insert_interval;

import com.vbashur.array.repeat_and_missing.*;
import com.vbashur.common.Interval;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by vic on 4/1/19.
 */
public class SolutionTest {
    @Test
    public void insert() throws Exception {

        Interval interval12 = new Interval(1, 2);
        Interval interval812 = new Interval(8, 12);

        Interval interval29 = new Interval(2, 9);
        Solution s = new Solution();

        List<Interval> intervalRes = s.insert(Arrays.asList(interval12, interval812), interval29);
        Assert.assertNotNull(intervalRes);
        Assert.assertEquals(1, intervalRes.size());
        Assert.assertEquals(1, intervalRes.get(0).start);
        Assert.assertEquals(12, intervalRes.get(0).end);


    }

    @Test
    public void insertOutOfBound() throws Exception {

        Interval interval12 = new Interval(1, 2);
        Interval interval812 = new Interval(8, 12);

        Interval interval29 = new Interval(2, 90);
        Solution s = new Solution();

        List<Interval> intervalRes = s.insert(Arrays.asList(interval12, interval812), interval29);
        Assert.assertNotNull(intervalRes);
        Assert.assertEquals(1, intervalRes.size());
        Assert.assertEquals(1, intervalRes.get(0).start);
        Assert.assertEquals(90, intervalRes.get(0).end);


    }

    @Test
    public void insertInMiddle() throws Exception {

        Interval interval13 = new Interval(1, 3);
        Interval interval812 = new Interval(6, 9);

        Interval interval25 = new Interval(2, 5);
        Solution s = new Solution();

        List<Interval> intervalRes = s.insert(Arrays.asList(interval13, interval812), interval25);
        Assert.assertNotNull(intervalRes);
        Assert.assertEquals(2, intervalRes.size());
        Assert.assertEquals(1, intervalRes.get(0).start);
        Assert.assertEquals(5, intervalRes.get(0).end);
        Assert.assertEquals(8, intervalRes.get(1).start);
        Assert.assertEquals(12, intervalRes.get(1).end);


    }


}