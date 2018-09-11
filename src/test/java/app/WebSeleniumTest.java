package app;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebSeleniumTest {

    WebDriver driver;

    @Before
    public void setUp () {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Fox02\\Desktop\\DnaTest2\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Test
    public void testWalpappersPage() throws Exception {

        driver.navigate().to("http://localhost:8080/list.html");

        (new WebDriverWait(driver, 10)).until((ExpectedCondition<Boolean>) (WebDriver d) -> d.getPageSource().contains("EMail")
                && d.getPageSource().contains("Name")
                && d.getPageSource().contains("Age")
                && d.getPageSource().contains("Password"));
    }
}
