package pages.orangeHRM;

import Utilities.BaseClass;
import Utilities.Config;
import Utilities.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class OrangeHRM_HRAdministrationPage extends BaseClass {

    public OrangeHRM_HRAdministrationPage(WebDriver driver){
        super(driver);
    }

    public static WebDriverWait wait;
    public static By table_UserData = By.xpath("//div[@id='systemUserDiv']/crud-panel/div/div/list/table/tbody/tr[1]/td[2]/ng-include/span");
    public static By empNames = By.xpath("//list/table//tbody/tr/td[4]//span");
    public static By chkbx_ChangePassword = By.xpath("//label[@for='changepassword']/span");
    public static By btn_AddUser = By.xpath("//i[text()='add']");

    public static void clickAddUser(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(Config.explicitTimeOut));
        wait.until(ExpectedConditions.visibilityOfElementLocated(OrangeHRM_HRAdministrationPage.table_UserData));
        driver.findElement(OrangeHRM_HRAdministrationPage.btn_AddUser).click();
        System.out.println("Add button is been clicked");
    }

    public static String clickEditEmployee(String empName, String sheetName, int row) throws Exception{
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(OrangeHRM_HRAdministrationPage.empNames));
        List<WebElement> list_EmployeeNames = driver.findElements(OrangeHRM_HRAdministrationPage.empNames);
        String userName_Employee = "";
        for (WebElement element_EmployeeName : list_EmployeeNames) {
            String actualEmployeeName = element_EmployeeName.getText();
            if (actualEmployeeName.equalsIgnoreCase(empName)) {
                userName_Employee = element_EmployeeName.findElement(By.xpath("./../..//preceding-sibling::td[2]//span")).getText();
                element_EmployeeName.findElement(By.xpath("./../..//following-sibling::td[4]/i")).click();
                System.out.println(userName_Employee + " Edit button is clicked");
                break;
            }
        }
        ExcelUtils.setCellData(userName_Employee, sheetName, row, Config.col_Performance_UserName_Employee);
        System.out.println(userName_Employee + " is written in the Excel file for a UserNameEmployee");
        return userName_Employee;
    }

    public static void changePassword(String newUserPassword, String newUserConfirmPassword){
        wait.until(ExpectedConditions.elementToBeClickable(OrangeHRM_HRAdministrationPage.chkbx_ChangePassword));
        driver.findElement(OrangeHRM_HRAdministrationPage.chkbx_ChangePassword).click();
        System.out.println("Change Password check-box is clicked");

        //Password and confirm password
        driver.findElement(OrangeHRM_AddUserPage.txtbx_ConfirmPassword).sendKeys(newUserPassword);
        System.out.println("New user Password is been entered as " + newUserPassword);

        driver.findElement(OrangeHRM_AddUserPage.txtbx_ConfirmPassword).sendKeys(newUserConfirmPassword);
        System.out.println("Confirm New Password is been confirmed as " + newUserConfirmPassword);

        driver.findElement(OrangeHRM_AddUserPage.btn_Save).click();
        System.out.println("Save button is been clicked");

        driver.switchTo().defaultContent();
        System.out.println("Exits from the frame!!!");
    }
}
