package com.example.tests;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import java.util.Collections;

public class TestRunner {
    public static void main(String[] args) {
        // Create a TestNG instance
        TestNG testng = new TestNG();

        // Optionally, add a listener to capture detailed test results
        TestListenerAdapter tla = new TestListenerAdapter();
        testng.addListener(tla);

        // Option 1: Specify the test classes directly
        testng.setTestClasses(new Class[] { ValuationTest.class });

        // Option 2: Alternatively, you can run a TestNG XML suite:
        // Uncomment the following line if you prefer to use your testng.xml configuration file
        // testng.setTestSuites(Collections.singletonList("src/test/resources/testng.xml"));

        // Run TestNG tests
        testng.run();
    }
}
