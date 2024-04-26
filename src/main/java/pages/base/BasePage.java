package pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Browser;
import utils.WaitTool;

public class BasePage {
    protected static WebDriver driver;

    static {
        driver = Browser.getDriver();
    }


    public static void clickOnWebElementByLocator(By locator) {
        driver.findElement(locator).click();
    }


    public static void writeTextInWebElement(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }


}
