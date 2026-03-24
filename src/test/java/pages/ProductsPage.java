package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {
    public ProductsPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(accessibility = "Products screen")
    @iOSXCUITFindBy(accessibility = "products screen")
    private WebElement productsScreenContainer;

    public boolean isCatalogDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(productsScreenContainer));
            return productsScreenContainer.isDisplayed();
        } catch (TimeoutException e) {
            System.out.println("The product catalog did not appear within the specified timeout period");
            return false;
        }
    }
}
