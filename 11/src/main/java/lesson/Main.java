package lesson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Main {
    private final WebDriver driver;

    private final By accountButton = By.xpath("//span[@id='idcta-username']");

    Main(WebDriver driver) {
        this.driver = driver;
    }
    public String getTitle() {
        return driver.getTitle();
    }
    public String getAccountButtonText() {
        return driver.findElement(accountButton).getText();
    }
}