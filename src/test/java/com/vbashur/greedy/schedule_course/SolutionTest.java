package com.vbashur.greedy.schedule_course;

import com.vbashur.array.repeat_and_missing.*;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vic on 4/2/19.
 */
public class SolutionTest {
    Solution s = new Solution();
    @Test
    public void scheduleCourse() throws Exception {

        int[][] input = new int[][]{{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}};
        int res = s.scheduleCourse(input);
        Assert.assertEquals(3, res);

    }

    @Test
    public void scheduleCourseSimple() throws Exception {

        int[][] input = new int[][]{{5, 5}, {4, 6}, {2, 6}};
        int res = s.scheduleCourse(input);
        Assert.assertEquals(3, res);

    }

}