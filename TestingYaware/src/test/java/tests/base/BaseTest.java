package tests.base;

import common.CommonActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import pages.addemployee.ModalFileChoose;
import pages.addemployee.YawareAddEmployee;
import pages.base.BasePage;
import pages.timetracker.YawareTimeTrackerPage;
import pages.login.YawareLoginPage;

import static common.Config.CLEAR_COOKIES_AND_STORAGE;
import static common.Config.HOLD_BROWSERS_OPEN;

public class BaseTest {
    protected WebDriver driver = CommonActions.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected YawareLoginPage yawareLoginPage = new YawareLoginPage(driver);
    protected YawareTimeTrackerPage yawareTimeTrackerPage = new YawareTimeTrackerPage(driver);
    protected YawareAddEmployee yawareAddEmployee = new YawareAddEmployee(driver);
    protected ModalFileChoose modalFileChoose = new ModalFileChoose(driver);

    @AfterTest
    public void clearCookiesAndLocalStorage() {
        if (CLEAR_COOKIES_AND_STORAGE) {
            JavascriptExecutor javascriptExecutor= (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    @AfterSuite (alwaysRun = true)
    public void close() {
        if (HOLD_BROWSERS_OPEN) {
            driver.quit();
        }
    }
}
