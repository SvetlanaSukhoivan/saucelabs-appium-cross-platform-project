package core;

import config.Configuration;
import config.DriverFactory;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>(); //for running tests in parallel
    public static AppiumDriver getDriver() {
        return driver.get();
    }

    @BeforeMethod
    @Parameters({"platformName"})
    public void setUp(@Optional String platformName) {
        // 1. Highest priority: Maven command-line variable (for CI/CD)
        String platform = System.getProperty("platformName");

        // 2. Medium priority: parameter from testng.xml
        if (platform == null || platform.isEmpty()) {
            platform = platformName;
        }

        // 3. Lowest priority: default value from config.properties (for local runs)
        if (platform == null || platform.isEmpty()) {
            platform = Configuration.getProperty("platform");
        }

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
