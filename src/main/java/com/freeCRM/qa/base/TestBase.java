package com.freeCRM.qa.base;

import com.freeCRM.qa.utils.TestUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;

    public TestBase() {

        try {
            prop = new Properties();
            FileInputStream file = new FileInputStream("C:\\Users\\bolas\\IdeaProjects\\" +
                    "myFreeCRMTest\\src\\main\\java\\com\\freeCRM\\qa\\config\\config.properties");
            prop.load(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialisation() {
        String browserName = prop.getProperty("browser");
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\bolas\\Downloads\\" +
                    "chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equals("FF")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\bolas\\Downloads\\" +
                    "geckodriver-v0.23.0-win64\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browserName.equals("IE")) {
            System.setProperty("webdriver.IE.driver", "C:\\Users\\bolas\\Downloads\\" +
                    "IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUTS, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICITLY_WAIT, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
    }
}
