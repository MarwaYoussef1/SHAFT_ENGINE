package testPackage.LambdaTest;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_LTDesktopWebWindows {
    SHAFT.GUI.WebDriver driver;
    SHAFT.TestData.JSON testData;

    //locators of test_ClickUsingJavaScript
    By emailField = By.xpath("//input[@name='user-name']");
    By passwordField = By.xpath("//input[@name='password']");
    By loginButton = By.xpath("//input[@name='login-button']");
    By product1 = By.xpath("//button[@name='add-to-cart-sauce-labs-backpack']");
    By shoppingCartButton = By.xpath("//a[@class='shopping_cart_link']");
    By productName = By.xpath("//div[@class='inventory_item_name']");
    @Test
    public void test_ClickUsingJavaScript() {
        driver.browser().navigateToURL("https://www.saucedemo.com")
                .element().type(emailField, "standard_user")
                .type(passwordField, "secret_sauce")
                .clickUsingJavascript(loginButton)
                .clickUsingJavascript(product1)
                .clickUsingJavascript(shoppingCartButton)
                .verifyThat(productName).text().isEqualTo("Sauce Labs Backpack").perform();
    }

    @BeforeMethod
    public void beforeMethod() {
        testData = new SHAFT.TestData.JSON("credentials.json");
        SHAFT.Properties.lambdaTest.set().browserVersion("114.0");
        SHAFT.Properties.platform.set().targetPlatform("WINDOWS");
        SHAFT.Properties.platform.set().executionAddress("lambdatest");
        SHAFT.Properties.web.set().targetBrowserName(Browser.CHROME.browserName());
        SHAFT.Properties.mobile.set().browserName("");
        SHAFT.Properties.lambdaTest.set().osVersion("11");
        SHAFT.Properties.lambdaTest.set().isRealMobile(false);
        SHAFT.Properties.lambdaTest.set().selenium_version("4.8.0");
        SHAFT.Properties.lambdaTest.set().username(testData.getTestData("LambdaTestUserName"));
        SHAFT.Properties.lambdaTest.set().accessKey(testData.getTestData("LambdaTestAccessKey"));
        driver = new SHAFT.GUI.WebDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        driver.quit();
    }
}