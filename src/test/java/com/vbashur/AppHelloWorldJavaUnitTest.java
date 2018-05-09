package com.vbashur;

import static org.junit.Assert.assertNotEquals;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple AppHelloWorldJava.
 */
public class AppHelloWorldJavaUnitTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppHelloWorldJavaUnitTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppHelloWorldJavaUnitTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue(true);
    }

    public void testSimple() {
        AppHelloWorldJava app = new AppHelloWorldJava();
        assertEquals("java", app.simpleTest());
        assertNotEquals("scala", app.simpleTest());

    }
}
