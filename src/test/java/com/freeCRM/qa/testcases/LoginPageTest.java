package com.freeCRM.qa.testcases;

import com.freeCRM.qa.base.TestBase;
import com.freeCRM.qa.pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginPageTest extends TestBase {

    LoginPage loginPage;

    public LoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialisation();
        loginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void verifyPageTitleTest() {
        String pageTitle = loginPage.verifyPageTitle();
        assertEquals(pageTitle, "#1 Free CRM software in the cloud for sales and service", "Page title mismatch");
    }

    @Test(priority = 2)
    public void verifyLoginTest() {
        loginPage.verifyLogin();
        String pageTitle = loginPage.verifyPageTitle();
        assertEquals(pageTitle, "CRMPRO", "Page title mismatch.");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
