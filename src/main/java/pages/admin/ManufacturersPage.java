package pages.admin;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import pages.base.BasePage;
import utils.WaitTool;

import static org.testng.Assert.assertEquals;

public class ManufacturersPage extends BasePage {
    private static final String ADD_MANUFACTURER_NAME = "TEST MANUFACTURER";
    private static final String EDIT_MANUFACTURER_NAME = "EDITED TEST MANUFACTURER";
    private static final By CATALOG_DROPDOWN = By.xpath("//*[@id='menu-catalog']/a");
    private static final By MANUFACTURER_BUTTON = By.xpath("//*[@id='collapse1']/li[7]/a");
    private static final By ADD_NEW_BUTTON = By.xpath("//*[@id='content']/div[1]/div/div/a");
    private static final By MANUFACTURER_NAME_INPUT_FIELD = By.id("input-name");
    private static final By SAVE_BUTTON = By.cssSelector(".fa.fa-save");
    private static final By CHECKBOX_NEW_EDIT_MANUFACTURER = By.xpath("//td[text()='" + EDIT_MANUFACTURER_NAME + "']/ ..  / .//input");
    private static final By NEW_MANUFACTURER_ROW_EDIT_BUTTON = By.xpath("//td[text()='" + ADD_MANUFACTURER_NAME + "']/ .. / .//a");
    private static final By DELETE_BUTTON = By.cssSelector(".fa.fa-trash-o");
    private static final By SUCCESSFUL_ADD_MANUFACTURER = By.cssSelector(".alert.alert-success.alert-dismissible");

    public static void GoToTheManufacturerPage(){
        WaitTool.waitForElementVisibility(CATALOG_DROPDOWN,10);
        driver.findElement(CATALOG_DROPDOWN).click();

        WaitTool.waitForElementVisibility(MANUFACTURER_BUTTON,10);
        driver.findElement(MANUFACTURER_BUTTON).click();
    }

    public static void addNewManufacturer() {
        GoToTheManufacturerPage();

        driver.findElement(ADD_NEW_BUTTON).click();

        WaitTool.waitForElementVisibility(MANUFACTURER_NAME_INPUT_FIELD,10);
        driver.findElement(MANUFACTURER_NAME_INPUT_FIELD).sendKeys(ADD_MANUFACTURER_NAME);

        driver.findElement(SAVE_BUTTON).click();
    }

    public static String getTextOfAlert() {
        WaitTool.waitForElementVisibility(SUCCESSFUL_ADD_MANUFACTURER, 10);
        return driver.findElement(SUCCESSFUL_ADD_MANUFACTURER).getText();
    }

    public static void editManufacturer() {
        GoToTheManufacturerPage();

        driver.findElement(NEW_MANUFACTURER_ROW_EDIT_BUTTON).click();

        WaitTool.waitForElementVisibility(MANUFACTURER_NAME_INPUT_FIELD,10);
        driver.findElement(MANUFACTURER_NAME_INPUT_FIELD).clear();
        driver.findElement(MANUFACTURER_NAME_INPUT_FIELD).sendKeys(EDIT_MANUFACTURER_NAME);

        driver.findElement(SAVE_BUTTON).click();
    }

    public static void deleteManufacture() {
        GoToTheManufacturerPage();

        WaitTool.waitForElementVisibility(CHECKBOX_NEW_EDIT_MANUFACTURER,10);
        driver.findElement(CHECKBOX_NEW_EDIT_MANUFACTURER).click();
        driver.findElement(DELETE_BUTTON).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
