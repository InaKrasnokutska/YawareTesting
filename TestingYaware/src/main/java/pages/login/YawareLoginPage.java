package pages.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

public class YawareLoginPage extends BasePage {

    public YawareLoginPage(WebDriver driver) {
        super(driver);
    }

    private final By email = By.id("email");
    private final By password = By.id("password");
    private final By enterBtn = By.id("login-submit");

    public YawareLoginPage enterLoginPassword() {
        driver.findElement(email).sendKeys("o.babeniuk+555@yaware.com");
        driver.findElement(password).sendKeys("123456");
        return this;
    }

    public YawareLoginPage clickEnter() {
        WebElement enterButton = driver.findElement(enterBtn);
        waitElementIsVisible(enterButton).click();
        return this;
    }
}
