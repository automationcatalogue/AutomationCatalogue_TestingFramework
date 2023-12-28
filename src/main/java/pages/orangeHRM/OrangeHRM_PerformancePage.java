package pages.orangeHRM;

import Utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrangeHRM_PerformancePage extends BaseClass {

    public OrangeHRM_PerformancePage(WebDriver driver){
        super(driver);
    }

    public static By btn_Addappraisal = By.xpath("//i[@class='material-icons' and text()='add']");
    public static By btn_MyAppraisal = By.xpath("//a[@data-automation-id='menu_performance_viewMyAppraisals']");

    public static void clickAddAppraisalBtn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        wait.until(ExpectedConditions.elementToBeClickable(OrangeHRM_PerformancePage.btn_Addappraisal));
        WebElement element_AddAppraisal = driver.findElement(OrangeHRM_PerformancePage.btn_Addappraisal);
        js.executeScript("arguments[0].click();", element_AddAppraisal);
        System.out.println("Add Appraisal button is clicked");
    }

    public static void clickMyAppraisalBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(OrangeHRM_PerformancePage.btn_MyAppraisal));
        WebElement link_MyAppraisal = driver.findElement(OrangeHRM_PerformancePage.btn_MyAppraisal);
        js.executeScript("arguments[0].click()", link_MyAppraisal);
        System.out.println("My Appraisal link is clicked");
    }
}
