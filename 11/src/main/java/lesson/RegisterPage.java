package lesson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private final WebDriver driver;
    private final By ageButton = By.xpath("//span[contains(text(),'16 or over')]");
    private final By dayField = By.xpath("//input[@id='day-input']");
    private final By monthField = By.xpath("//input[@id='month-input']");
    private final By yearField = By.xpath("//input[@id='year-input']");
    private final By continueButton = By.xpath("//button[@id='submit-button']");
    private final By passwordField = By.xpath("//input[@id='password-input']");
    private final By registerButton = By.xpath("//button[@id='submit-button']");
    private final By passwordMessageField = By.xpath("//div[@id='form-message-password']");

    RegisterPage(WebDriver driver) {
        this.driver = driver;
    }
    public void ageButtonClick() {
        sleep();
        driver.findElement(ageButton).click();
    }
    public void typeDay(String day) {
        driver.findElement(dayField).sendKeys(day);
    }
    public void typeMonth(String month) {
        driver.findElement(monthField).sendKeys(month);
    }
    public void typeYear(String year) {
        driver.findElement(yearField).sendKeys(year);
    }
    public void dateOfBirthInput(String day, String month, String year) {
        this.typeDay(day);
        this.typeMonth(month);
        this.typeYear(year);
        driver.findElement(continueButton).submit();
        new RegisterPage(driver);
    }
    public void typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickRegisterButton(String password) {
        this.typePassword(password);
        driver.findElement(registerButton).submit();
        new RegisterPage(driver);
    }
    public String getPasswordMessage() {
        return driver.findElement(passwordMessageField).getText();
    }
    private void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
