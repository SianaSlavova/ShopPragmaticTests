package pages.frontend;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;
import utils.WaitTool;

public class RegisterPage extends BasePage {
    private static final By MY_ACCOUNT_BUTTON = By.className("caret");
    private static final By REGISTRATION_BUTTON = By.xpath("//*[@id='top-links']//li[2]//li[1]/a");
    private static final By FIRST_NAME_INPUT_FIELD = By.id("input-firstname");
    private static final By LAST_NAME_INPUT_FIELD = By.id("input-lastname");
    private static final By EMAIL_INPUT_FIELD = By.id("input-email");
    private static final By TELEPHONE_INPUT_FIELD = By.id("input-telephone");
    private static final By PASSWORD_INPUT_FIELD = By.id("input-password");
    private static final By CONFIRM_PASSWORD = By.id("input-confirm");
    private static final By AGREE_CHECKBOX = By.name("agree");
    private static final By CONTINUE_BUTTON = By.cssSelector(".btn.btn-primary");
    private static final By TEXT_NEW_ACCOUNT_CREATED = By.id("content");
    private static final String FRONTEND_PAGE_URL = "http://shop.pragmatic.bg/";

    public static void goToRegistrationPage() {
        driver.get(FRONTEND_PAGE_URL);
        driver.findElement(MY_ACCOUNT_BUTTON).click();
        driver.findElement(REGISTRATION_BUTTON).click();
    }

    public static void fillRegistrationForm(String firstName, String lastName, String telephoneNumber, String password, String confirmPassword) {
        WaitTool.waitForElementVisibility(FIRST_NAME_INPUT_FIELD,10);
        driver.findElement(FIRST_NAME_INPUT_FIELD).sendKeys(firstName);
        driver.findElement(LAST_NAME_INPUT_FIELD).sendKeys(lastName);
        driver.findElement(TELEPHONE_INPUT_FIELD).sendKeys(telephoneNumber);
        driver.findElement(PASSWORD_INPUT_FIELD).sendKeys(password);
        driver.findElement(CONFIRM_PASSWORD).sendKeys(confirmPassword);
        driver.findElement(AGREE_CHECKBOX).click();

        String emailPrefix = RandomStringUtils.randomAlphabetic(5);
        String emailSuffix = RandomStringUtils.randomAlphabetic(3);
        String emailAddress = emailPrefix + "@" + emailSuffix + ".com";
        WebElement emailInputField = driver.findElement(EMAIL_INPUT_FIELD);
        emailInputField.sendKeys(emailAddress);

        WaitTool.waitForElementVisibility(CONTINUE_BUTTON,10);
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public static String getTextOfNewAccountCreated() {
        WaitTool.waitForElementVisibility(TEXT_NEW_ACCOUNT_CREATED, 10);

        return driver.findElement(TEXT_NEW_ACCOUNT_CREATED).getText();
    }
}
