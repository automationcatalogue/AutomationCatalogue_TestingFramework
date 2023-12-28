package pages.orangeHRM;

import Utilities.BaseClass;
import Utilities.Config;
import Utilities.ExcelUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class OrangeHRM_AddUserPage extends BaseClass {

    public OrangeHRM_AddUserPage(WebDriver driver){
        super(driver);
    }

    public static By txtbx_EmployeeName = By.id("selectedEmployee_value");
    public static By txtbx_UserName = By.id("user_name");
    public static By drpdwn_Ess = By.cssSelector("button.btn[aria-owns='bs-select-1']");
    public static By label_DefaultEss= By.cssSelector("#bs-select-1-1");
    public static By drpdwn_Supervisor = By.xpath("//button[@type='button'][@data-id='supervisorrole']");
    public static By txt_DefaultSupervisor = By.xpath("//span[text()='Default Supervisor']");
    public static By drpdwn_Admin= By.xpath("//button[@data-id='adminrole']/div/div/div");
    public static By label_Admin = By.xpath("//button[@data-id='adminrole']//following-sibling::div//ul/li//span");
    public static By txtbx_NewPassword = By.id("password");
    public static By txtbx_ConfirmPassword = By.cssSelector("#confirmpassword");
    public static By btn_Save = By.xpath("//button[@id='modal-save-button']");

    public static void enterAddUserDetails(String createUserName, String empName, String adminRole, String newUserPassword, String newUserConfirmPassword) throws Exception{
        driver.findElement(OrangeHRM_AddUserPage.txtbx_EmployeeName).sendKeys(empName);
        System.out.println("Employee name is been entered as " + empName);

        Thread.sleep(1000);
        driver.findElement(OrangeHRM_AddUserPage.txtbx_EmployeeName).sendKeys(Keys.TAB);
        System.out.println("Tab button is pressed");

        driver.findElement(OrangeHRM_AddUserPage.txtbx_UserName).sendKeys(createUserName);
        System.out.println("User name is been entered");

        wait.until(ExpectedConditions.elementToBeClickable(OrangeHRM_AddUserPage.btn_Save));

        //ESS role dropdown
        driver.findElement(OrangeHRM_AddUserPage.drpdwn_Ess).click();
        System.out.println("Ess drop down is been selected");

        driver.findElement(OrangeHRM_AddUserPage.label_DefaultEss).click();
        System.out.println("Default ESS is been selected");

        //supervisor role dropdown with Test HR selected
        driver.findElement(OrangeHRM_AddUserPage.drpdwn_Supervisor).click();
        System.out.println("Supervisor role dropdown is been selected");
        driver.findElement(OrangeHRM_AddUserPage.txt_DefaultSupervisor).click();
        System.out.println("Test HR is been selected");

        //Admin role drop down
        driver.findElement(OrangeHRM_AddUserPage.drpdwn_Admin).click();
        System.out.println("Admin Role drop-down is clicked");
        Thread.sleep(2000);
        List<WebElement> AdminRole=driver.findElements(OrangeHRM_AddUserPage.label_Admin);
        for (WebElement element: AdminRole){
            String actualValue = element.getText();
            if (actualValue.equalsIgnoreCase(adminRole)) {
                element.click();
                System.out.println("Admin role drop down is been selected as "+adminRole);
                break;
            }
        }

        //Password and confirm password
        driver.findElement(OrangeHRM_AddUserPage.txtbx_NewPassword).sendKeys(newUserPassword);
        System.out.println("New user Password is been entered as "+newUserPassword);

        driver.findElement(OrangeHRM_AddUserPage.txtbx_ConfirmPassword).sendKeys(newUserConfirmPassword);
        System.out.println("Confirm New Password is been confirmed as "+newUserConfirmPassword);

        Thread.sleep(4000);
        //save button
        driver.findElement(OrangeHRM_AddUserPage.btn_Save).click();
        System.out.println("Save button is been clicked");
        Thread.sleep(3000);

        //save button is clicked again
        try{
            driver.findElement(OrangeHRM_AddUserPage.btn_Save).click();
            System.out.println("Save button is been clicked at the end");
        }catch(NoSuchElementException ne){
            System.out.println("There is no another Save button displayed");
        }
    }

    public static void validateUserName(String empName){
        String actualUserName = driver.findElement(OrangeHRM_HomePage.label_EmployeeName).getText();
        if(actualUserName.equalsIgnoreCase(empName)){
            System.out.println(actualUserName+"Add User testcase is successful");
        }else{
            System.out.println(actualUserName+"Add User testcase is not successful");
        }
    }

}
