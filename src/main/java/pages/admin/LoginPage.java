package pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import utils.WaitTool;

public class LoginPage extends BasePage {
    private static final By USERNAME_INPUT_FIELD = By.id("input-username");
    private static final By PASSWORD_INPUT_FIELD = By.id("input-password");
    private static final By LOGIN_BUTTON = By.cssSelector(".btn-primary");
    private static final String LOGIN_PAGE_URL = "https://shop.pragmatic.bg/admin";

       public static void goToLoginPage() {
        driver.get(LOGIN_PAGE_URL);
    }

    public static void login(String username, String password) {
        writeInUsernameInputField(username);
        writeInPasswordInputField(password);
        clickLoginButton();
    }
    private static void writeInUsernameInputField(String username) {
        writeTextInWebElement(USERNAME_INPUT_FIELD, username);
    }

    private static void writeInPasswordInputField(String password) {
        writeTextInWebElement(PASSWORD_INPUT_FIELD, password);
    }

    private static void clickLoginButton() {
        clickOnWebElementByLocator(LOGIN_BUTTON);
    }
}
