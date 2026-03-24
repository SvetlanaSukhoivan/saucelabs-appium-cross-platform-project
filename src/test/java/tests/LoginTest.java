package tests;

import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MenuPage;
import pages.ProductsPage;

public class LoginTest extends BaseTest {
    @Test(description = "Verify successful login to the application")
    public void testSuccessfulLogin() {
        MenuPage menuPage = new MenuPage(getDriver());
        menuPage.navigateToLogin();

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.enterUsername("bob@example.com")
                .enterPassword("10203040\n")
                .clickLogin();

        ProductsPage productsPage = new ProductsPage(getDriver());
        Assert.assertTrue(productsPage.isCatalogDisplayed(), "Product catalog is not displayed after logging in");

        System.out.println("The login steps have been completed! Visually check the simulator/emulator.");
    }
}
