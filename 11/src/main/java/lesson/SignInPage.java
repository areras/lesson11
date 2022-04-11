package lesson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
    private final WebDriver driver;

    private final By emailField = By.xpath("//div[@id='username']//input");
    private final By passwordField = By.xpath("//div[@id='password']//input");
    private final By signInButton = By.xpath("//button[@type='submit']");

    SignInPage(WebDriver driver) {
        this.driver = driver;
    }
    public void typeEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }
    public void typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    public Main loginWithCorrectCreds(String email, String password) {
        this.typeEmail(email);
        this.typePassword(password);
        driver.findElement(signInButton).submit();
        return new Main(driver);
    }
}