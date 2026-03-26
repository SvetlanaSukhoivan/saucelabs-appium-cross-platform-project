package config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class DriverFactory {
    private static String getAbsolutePath(String appPath) {
        File appFile = new File(appPath);
        if (appFile.isAbsolute()) {
            return appFile.getAbsolutePath();
        }
        return new File(System.getProperty("user.dir"), appPath).getAbsolutePath();
    }

    public static AppiumDriver createDriver(String platformName) {
        AppiumDriver driver;
        URL appiumServerUrl;

        try {
            appiumServerUrl = URI.create(Configuration.getProperty("appium.server.url")).toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid Appium server URL", e);
        }

        switch (platformName.toLowerCase()) {
            case "android":
                UiAutomator2Options androidOptions = new UiAutomator2Options()
                        .setDeviceName(Configuration.getProperty("android.deviceName"))
                        .setAvd(Configuration.getProperty("android.deviceName"))
                        .setApp(getAbsolutePath(Configuration.getProperty("android.app.path")))
                        .setAutomationName("UiAutomator2");
                driver = new AndroidDriver(appiumServerUrl, androidOptions);
                break;

            case "ios":
                XCUITestOptions iosOptions = new XCUITestOptions()
                        .setDeviceName(Configuration.getProperty("ios.deviceName"))
                        .setPlatformVersion(Configuration.getProperty("ios.platformVersion"))
                        .setApp(getAbsolutePath(Configuration.getProperty("ios.app.path")))
                        .setBundleId("com.saucelabs.mydemoapp.rn")
                        .setAutomationName("XCUITest")
                        .setWdaLaunchTimeout(java.time.Duration.ofMinutes(5))
                        .setAutoAcceptAlerts(true)
                        .setConnectHardwareKeyboard(false);

                        iosOptions.setCapability("appium:sendKeyStrategy", "grouped");
                driver = new IOSDriver(appiumServerUrl, iosOptions);
                break;

            default:
                throw new IllegalArgumentException("Unsupported platform: " + platformName);
        }
        return driver;
    }
}
