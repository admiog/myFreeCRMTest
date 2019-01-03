package com.freeCRM.qa.utils;

import com.freeCRM.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TestUtils extends TestBase {

    public static long PAGE_LOAD_TIMEOUTS = 20;
    public static long IMPLICITLY_WAIT = 10;

    public static void mouseOver(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    public static void switchFrame() {
        driver.switchTo().frame("mainpanel");
    }
}
