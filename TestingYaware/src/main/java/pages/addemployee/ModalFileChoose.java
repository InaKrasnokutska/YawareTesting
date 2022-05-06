package pages.addemployee;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.base.BasePage;

public class ModalFileChoose extends BasePage {

    public ModalFileChoose(WebDriver driver) {
        super(driver);
    }

    private final By selectFileInput = By.id("file");
    private final By modalButton = By.id("yaware-modal-button-0");
    private final By inviteCheckbox = By.className("import-users-notifying-label");

    public ModalFileChoose modalFileChooseSendKeys() {
        driver.findElement(selectFileInput).sendKeys("D:\\work\\TestingSeleniumTestNGMaven\\Generate\\employees.csv");
        return this;
    }

    public ModalFileChoose modalButtonClick() {
        driver.findElement(modalButton).click();
        return this;
    }

    public ModalFileChoose inviteCheckboxCheck() {
        WebElement checkbox = driver.findElement(inviteCheckbox);
        Assert.assertTrue(checkbox.isDisplayed(), "Employees already are in the list. Please generate new file.");
        checkbox.click();
        return this;
    }

}
