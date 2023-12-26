package pages.orangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrangeHRM_HRAdministrationPage {
    public static WebDriverWait wait;
    public static By table_UserData = By.xpath("//div[@id='systemUserDiv']/crud-panel/div/div/list/table/tbody/tr[1]/td[2]/ng-include/span");
    public static By empNames = By.xpath("//list/table//tbody/tr/td[4]//span");
    public static By chkbx_ChangePassword = By.xpath("//label[@for='changepassword']/span");
    public static By btn_AddUser = By.xpath("//i[text()='add']");

    public static void clickAddUser(WebDriver driver){
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(OrangeHRM_HRAdministrationPage.table_UserData));
        driver.findElement(OrangeHRM_HRAdministrationPage.btn_AddUser).click();
        System.out.println("Add button is been clicked");
    }
}
