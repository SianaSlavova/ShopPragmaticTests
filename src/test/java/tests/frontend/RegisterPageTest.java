package tests.frontend;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.frontend.RegisterPage;
import tests.base.BaseTest;

public class RegisterPageTest extends BaseTest {
    @Test
    public void testRegistrationPage() {
        RegisterPage.goToRegistrationPage();
        RegisterPage.fillRegistrationForm("Siana", "Slavova", "0888777666", "7777777", "7777777");
        String textOfNewAccountCreated = RegisterPage.getTextOfNewAccountCreated();
        Assert.assertTrue(textOfNewAccountCreated.contains("Your Account Has Been Created!"));
    }
}
