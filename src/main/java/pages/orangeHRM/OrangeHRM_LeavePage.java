package pages.orangeHRM;

import Utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrangeHRM_LeavePage extends BaseClass {

    public OrangeHRM_LeavePage(WebDriver driver){
        super(driver);
    }

    public static By link_Configure=By.xpath("//a[@data-automation-id='more_menu_child_menu_leave_Configure' or @data-automation-id='menu_leave_Configure']");
    public static By link_Workingweekends = By.xpath("//a[contains(@data-automation-id,'menu_leave_viewWorkingWeekendList')]");

    public static void clickConfigureLink(){
        driver.findElement(OrangeHRM_LeavePage.link_Configure).click();
        System.out.println("configure link is clicked");
    }

    public static void clickWorkingWeekends(){
        WebElement element_configure = driver.findElement(OrangeHRM_LeavePage.link_Workingweekends);
        js.executeScript("arguments[0].click();", element_configure);
        System.out.println("Working Weekends is clicked");
    }
}
