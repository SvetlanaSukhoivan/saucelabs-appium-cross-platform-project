package core;

import config.Configuration;
import config.DriverFactory;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>(); //for running tests in parallel
    public static AppiumDriver getDriver() {
        return driver.get();
    }

    @BeforeMethod
    @Parameters({"platformName"})
    public void setUp(String platformName) {
        // If the parameter is not specified in testng.xml, we retrieve it from the configuration
        String platform = (platformName != null) ? platformName : Configuration.getProperty("platform");

        driver.set(DriverFactory.createDriver(platform));
    }

    @AfterMethod
    public void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }
}
