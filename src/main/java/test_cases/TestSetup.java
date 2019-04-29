package test_cases;

import wrappers.BrowserWrapper;

public class TestSetup {

    public static void setupTest(String url) {
        System.out.println("Pre-condition");
        BrowserWrapper browserWrapper = new BrowserWrapper();
        browserWrapper.maximizeWindow();
        browserWrapper.get(url);
    }

    public static void cleanUpTest() {
        System.out.println("CleanUp");
        BrowserWrapper.getDriverInstance().quit();
    }
}
