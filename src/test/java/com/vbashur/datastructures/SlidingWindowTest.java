package com.vbashur.datastructures;

import org.junit.Test;

import static org.junit.Assert.*;

public class SlidingWindowTest {

    @Test
    public void add() {
        SlidingWindow window = new SlidingWindow(3);
        window.add(1);
        assertEquals(1, window.getProduct());
        assertEquals(1, window.getProduct());
        window.add(2);
        assertEquals(2, window.getProduct());
        window.add(3);
        assertEquals(6, window.getProduct());
        window.add(4);
        assertEquals(24, window.getProduct());
        window.add(0);
        assertEquals(0, window.getProduct());
        window.add(5);
        assertEquals(0, window.getProduct());
        window.add(1);
        window.add(4);
        assertEquals(20, window.getProduct());
        window.add(0);
        assertEquals(0, window.getProduct());
        window.add(0);
        assertEquals(0, window.getProduct());
        window.add(1);
        window.add(-2);
        assertEquals(0, window.getProduct());
        window.add(-2);
        assertEquals(4, window.getProduct());

        window = new SlidingWindow(1);
        window.add(-2);
        assertEquals(-2, window.getProduct());
        window.add(0);
        assertEquals(0, window.getProduct());
        window.add(110);
        assertEquals(110, window.getProduct());
        window.add(0);
        window.add(0);
        window.add(0);
        window.add(110);
        assertEquals(110, window.getProduct());

        window = new SlidingWindow(0);
        window.add(-2);
        assertEquals(0, window.getProduct());
        window.add(10);
        window.add(110);
        assertEquals(0, window.getProduct());
    }
}
