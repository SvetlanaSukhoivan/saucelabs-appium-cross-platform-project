package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class MenuPage extends BasePage {
    public MenuPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(accessibility = "open menu")
    @iOSXCUITFindBy(accessibility = "tab bar option menu")
    private WebElement menuButton;

    @AndroidFindBy(accessibility = "menu item log in")
    @iOSXCUITFindBy(accessibility = "menu item log in")
    private WebElement loginMenuItem;

    public void navigateToLogin() {
        click(menuButton);
        click(loginMenuItem);
    }
}
