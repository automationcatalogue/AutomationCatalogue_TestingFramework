package pages.orangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrangeHRM_LeavePage {
    public static By link_Configure=By.xpath("//a[@data-automation-id='more_menu_child_menu_leave_Configure']");
    public static By link_Workingweekends = By.xpath("//a[contains(@data-automation-id,'menu_leave_viewWorkingWeekendList')]");

    public static void clickConfigureLink(WebDriver driver){
        driver.findElement(OrangeHRM_LeavePage.link_Configure).click();
        System.out.println("configure link is clicked");
    }

    public static void clickWorkingWeekends(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement element_configure = driver.findElement(OrangeHRM_LeavePage.link_Workingweekends);
        js.executeScript("arguments[0].click();", element_configure);
        System.out.println("Working Weekends is clicked");
    }
}
