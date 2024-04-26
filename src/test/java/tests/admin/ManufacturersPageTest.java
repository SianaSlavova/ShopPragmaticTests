package tests.admin;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.admin.LoginPage;
import pages.admin.ManufacturersPage;
import tests.base.BaseTest;

public class ManufacturersPageTest extends BaseTest {
    @Test
    public void testManufacturersPageActions() {
        LoginPage.goToLoginPage();
        LoginPage.login("admin", "parola123!");

        addNewManufacturer();
        editManufacturer();
        deleteManufacturer();
    }

    public void addNewManufacturer() {
        ManufacturersPage.addNewManufacturer();
        verifyAlertMessage();
    }

    public void editManufacturer() {
        ManufacturersPage.editManufacturer();
        verifyAlertMessage();
    }

    public void deleteManufacturer() {
        ManufacturersPage.deleteManufacture();
        verifyAlertMessage();
    }
    public void verifyAlertMessage() {
        String textOfAlert = ManufacturersPage.getTextOfAlert();
        Assert.assertEquals(textOfAlert, "Success: You have modified manufacturers!\n" +
                "×");
    }
}
