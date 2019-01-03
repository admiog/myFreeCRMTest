package com.freeCRM.qa.pages;

import com.freeCRM.qa.base.TestBase;
import com.freeCRM.qa.utils.TestUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    TestUtils testUtils;

    @FindBy(xpath = "//a[contains(text(), 'Contacts')]")
    WebElement contactsLink;

    @FindBy(xpath = "//a[contains(text(), 'New Contact')]")
    WebElement newContactLink;

    //@FindBy(xpath = "//a[contains(text(), 'Combined Form')]")
    @FindBy(linkText = "Combined Form")
    WebElement combinedFormLink;

    @FindBy(xpath = "//legend[contains(text(), 'Combined Contact and Company Form')]")
    WebElement combinedContactFormPage;

    @FindBy(xpath = "//a[contains(text(), 'Deals')]")
    WebElement dealsLink;

    @FindBy(xpath = "//a[contains(text(), 'New Deal')]")
    WebElement newDealsLink;

    @FindBy(xpath = "//legend[contains(text(), 'Contact Information')]")
    WebElement contactInformation;

    @FindBy(xpath = "//legend[contains(text(), 'Deal')]")
    WebElement deal;

    @FindBy(xpath = "//a[contains(text(), 'Products')]")
    WebElement productsLink;

    @FindBy(xpath = "//td[contains(text(), Products)]")
    WebElement productsLabel;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public ContactsPage verifyNewContactsLink() {
        testUtils.mouseOver(contactsLink);
        newContactLink.click();
        return new ContactsPage();
    }

    public boolean verifyContactsPage(){
        return contactInformation.isDisplayed();
    }

    public ContactsPage verifyCombinedContactFormLink() {
        testUtils.mouseOver(contactsLink);
        combinedFormLink.click();
        return new ContactsPage();
    }

    public boolean verifyCombinedFormPage(){
        return combinedContactFormPage.isDisplayed();
    }

    public DealsPage verifyNewDealsLink() {
        testUtils.mouseOver(dealsLink);
        newDealsLink.click();
        return new DealsPage();
    }

    public boolean verifyDealsPage(){
        return deal.isDisplayed();
    }

    public ProductsPage verifyProductsPage() {
        testUtils.mouseOver(dealsLink);
        productsLink.click();
        return new ProductsPage();
    }

    public boolean verifyProductsLabel() {
        return productsLabel.isDisplayed();
    }

}
