package lesson;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SignInPageTest {
    private WebDriver driver;
    private SignInPage signInPage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://session.bbc.com/session?ptrt=https%3A%2F%2Fwww.bbc.com%2F&context=homepage&userOrigin=HOMEPAGE_GNL");
        signInPage = new SignInPage(driver);
    }

    @Test
    public void authorization() {
        Main homePage = signInPage.loginWithCorrectCreds("baron2703@yandex.ru", "s9470157x");
        Assert.assertEquals("BBC - Homepage", homePage.getTitle());
        Assert.assertEquals("Your account", homePage.getAccountButtonText());
    }

    @After
    public void tearDown() {
        driver.close();
    }
}