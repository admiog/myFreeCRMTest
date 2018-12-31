package com.freeCRM.qa.pages;

import com.freeCRM.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    @FindBy(name = "username")
    WebElement username;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement loginBtn;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyPageTitle() {
        return driver.getTitle();
    }

    public void verifyLogin() {
        username.sendKeys(prop.getProperty("username"));
        password.sendKeys(prop.getProperty("password"));
        loginBtn.submit();
    }
}
