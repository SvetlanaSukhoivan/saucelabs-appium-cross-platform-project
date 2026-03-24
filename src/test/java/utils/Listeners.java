package utils;

import core.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

public class Listeners implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("▶ Run the test: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("❌ Test is failed: " + result.getMethod().getMethodName());

        AppiumDriver driver = BaseTest.getDriver();

        if (driver != null) {
            saveScreenshot(driver, result.getName());
        }
    }

    private void saveScreenshot(AppiumDriver driver, String methodName) {
        try {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment(methodName + "_Failure_Screenshot", "image/png", new ByteArrayInputStream(screenshot), ".png");
            System.out.println("📸 Screenshot of the error is attached to Allure report: " + methodName);
        } catch (Exception e) {
            System.err.println("⚠️ Unable to take a screenshot: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("⏭ Test is skipped: " + result.getMethod().getMethodName());
    }
}
