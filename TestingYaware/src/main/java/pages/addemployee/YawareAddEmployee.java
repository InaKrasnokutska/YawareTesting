package pages.addemployee;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.base.BasePage;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class YawareAddEmployee extends BasePage {

    public YawareAddEmployee (WebDriver driver){
        super(driver);
    }

    private final By importEmployeesButton = By.id("button-1037-btnInnerEl");
    private final By message = By.className("intercom-lightweight-app");
    private final By userLinks = By.xpath("//tbody[@id='gridview-1034-body']/tr[1]/td[5]/div/a[1]");
    private final By userEmail = By.xpath("//tbody[@id='gridview-1034-body']/tr[1]/td[2]/div/span");
    private final By windowsLink = By.id("windows-download-link");
    private final By linuxLink = By.id("linux-download-link");
    private final By macLink = By.id("macos-download-link");
    private final By resend = By.xpath("//tbody[@id='gridview-1034-body']/tr[1]/td[5]/div/a[3]");
    private final By delete = By.xpath("//tbody[@id='gridview-1034-body']/tr[1]/td[5]/div/a[2]");
    private final By totalCount = By.id("tbtext-1027");
    private final By invitationDate = By.id("//tbody[@id='gridview-1034-body']/tr[1]/td[3]/div/span");


    String beforeCount;


    public YawareAddEmployee importEmployeesButtonClick() {
        driver.findElement(importEmployeesButton).click();
        messageIsShown();
        return this;
    }

    public YawareAddEmployee messageIsShown() {
        Assert.assertTrue(driver.findElement(message).isDisplayed(), "Message should be displayed");
        return this;
    }

    public YawareAddEmployee windowsLinkIsCorrect() throws IOException, UnsupportedFlavorException {
        WebElement userEmeilEl = driver.findElement(userEmail);
        String email =  waitElementIsVisible(userEmeilEl).getText();

        WebElement userLinksEl = driver.findElement(userLinks);
        waitElementIsVisible(userLinksEl).click();

        driver.findElement(windowsLink).click();
        messageIsShown();

        email = email.replace("@","%40");
        String correctLink = "https://app.yaware.com.ua/downloads/e6034d97aaec18bf0d056d532bf3ca4c/winqt/AgentSetup.exe/" + email;

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        String clipboardLink = (String)clipboard.getData(DataFlavor.stringFlavor);

        Assert.assertEquals(clipboardLink, correctLink, "Link for Windows should be correct");

        return this;
    }

    public YawareAddEmployee linuxLinkIsCorrect() throws IOException, UnsupportedFlavorException {
        String email = driver.findElement(userEmail).getText();
        driver.findElement(userLinks).click();

        driver.findElement(linuxLink).click();
        messageIsShown();

        email = email.replace("@","%40");
        String correctLink = "https://app.yaware.com.ua/downloads/e6034d97aaec18bf0d056d532bf3ca4c/linux/yaware-installer.sh/" + email;

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        String clipboardLink = (String)clipboard.getData(DataFlavor.stringFlavor);

        Assert.assertEquals(clipboardLink, correctLink, "Link for Windows should be correct");

        return this;
    }

    public YawareAddEmployee macosLinkIsCorrect() throws IOException, UnsupportedFlavorException {
        String email = driver.findElement(userEmail).getText();
        driver.findElement(userLinks).click();

        driver.findElement(macLink).click();
        messageIsShown();

        email = email.replace("@","%40");
        String correctLink = "https://app.yaware.com.ua/downloads/e6034d97aaec18bf0d056d532bf3ca4c/mac/yaware2.0.6.42.dmg/" + email;

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        String clipboardLink = (String)clipboard.getData(DataFlavor.stringFlavor);

        Assert.assertEquals(clipboardLink, correctLink, "Link for Windows should be correct");

        return this;
    }

    public YawareAddEmployee resendInvitation() {

        //String beforeDate =  driver.findElement(invitationDate).getText();

        driver.findElement(resend).click();

        refresh();

        //String afterDate =  driver.findElement(invitationDate).getText();

        //Assert.assertNotEquals(beforeDate, afterDate, "The invitation date should be updated");

        return this;
    }

    public YawareAddEmployee deleteInvitation() {
        beforeCount = driver.findElement(totalCount).getText();

        driver.findElement(delete).click();

        return this;
    }

    public YawareAddEmployee itemIsDeleted() {

        String afterCount = driver.findElement(totalCount).getText();

        Assert.assertNotEquals(beforeCount, afterCount, "Item should be deleted from the list");

        return this;
    }

}
