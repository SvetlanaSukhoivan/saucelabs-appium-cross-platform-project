package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;


public class ProductsPage extends BasePage {
    public ProductsPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(accessibility = "products screen")
    @iOSXCUITFindBy(accessibility = "products screen")
    private WebElement productsScreenContainer;

    public boolean isCatalogDisplayed() {
        return waitForIsDisplayed(productsScreenContainer);
    }
}
