package pages.timetracker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;



public class YawareTimeTrackerPage extends BasePage {

    public YawareTimeTrackerPage(WebDriver driver) {
        super(driver);
    }

    private final By dropdownToggle = By.xpath("//*[@id=\"app\"]/section[1]/div/ul/li[6]/a");

    public YawareTimeTrackerPage dropdownToggleClick(){
        driver.findElement(dropdownToggle).click();
        return this;
    }

}
