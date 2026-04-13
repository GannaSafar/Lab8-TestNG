package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class Exercise2_LoginTest {

    private WebDriver driver;

    @Parameters("browser")
    @BeforeClass
    public void setup(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/login.html");
    }

    @DataProvider(name = "loginData")
    public Object[][] data() {
        return new Object[][]{
                {"test@mail.com", "123", false},
                {"test@mail.com", "152", true}
        };
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String user, String pass, boolean isValid) {
        driver.get("https://demo.guru99.com/test/login.html");

        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(user);

        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys(pass);

        driver.findElement(By.id("SubmitLogin")).click();

        if (isValid) {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.urlContains("success"));
            assertTrue(driver.getCurrentUrl().contains("success"),
                    "Expected valid login to navigate to success page.");
        } else {
            String page = driver.getPageSource().toLowerCase();
            assertTrue(page.contains("invalid")
                            || page.contains("error")
                            || !driver.getCurrentUrl().contains("success"),
                    "Expected invalid login to show an error or remain away from success page.");
        }
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
