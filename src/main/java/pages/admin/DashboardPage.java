package pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import utils.WaitTool;

public class
DashboardPage extends BasePage {

    private static final By USERNAME_LABEL = By.xpath("//*[@id='user-profile']/ ..");

       public static String getUsernameText() {
        WaitTool.waitForElementVisibility(USERNAME_LABEL, 10);
        return driver.findElement(USERNAME_LABEL).getText();
    }


}
