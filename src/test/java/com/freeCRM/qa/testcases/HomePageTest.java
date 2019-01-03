package com.freeCRM.qa.testcases;

import com.freeCRM.qa.base.TestBase;
import com.freeCRM.qa.pages.HomePage;
import com.freeCRM.qa.pages.LoginPage;
import com.freeCRM.qa.utils.TestUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class HomePageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;

    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialisation();
        loginPage = new LoginPage();
        homePage = new HomePage();
        loginPage.verifyLogin();
        TestUtils.switchFrame();
    }

    @Test(priority = 1)
    public void verifyNewContactsLinkTest() {
        homePage.verifyNewContactsLink();
        assertTrue(homePage.verifyContactsPage());
    }

    @Test(priority = 2)
    public void verifyCombinedContactFormLinkTest() {
        homePage.verifyCombinedContactFormLink();
        assertTrue(homePage.verifyCombinedFormPage());
    }

    @Test(priority = 3)
    public void verifyNewDealsLinkTest() {
        homePage.verifyNewDealsLink();
        assertTrue(homePage.verifyDealsPage());
    }

    @Test(priority = 4)
    public void verifyProductsPageTest() {
        homePage.verifyProductsPage();
        assertTrue(homePage.verifyProductsLabel());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
