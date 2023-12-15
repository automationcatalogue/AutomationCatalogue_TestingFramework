package testcases.orangeHRM;

import Utilities.Config;
import Utilities.ExcelUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.orangeHRM.OrangeHRM_AddUserPage;
import pages.orangeHRM.OrangeHRM_HRAdministrationPage;
import pages.orangeHRM.OrangeHRM_HomePage;
import pages.orangeHRM.OrangeHRM_LoginPage;

import java.time.Duration;
import java.util.List;

public class TC02_OrangeHRM_AddUser {
    public static void main(String[] args) throws Exception{
        String projectPath = System.getProperty("user.dir");
        String sheetName = "HRM_AddUser";
        ExcelUtils.setExcelFilePath(projectPath+"//TestData//Automation_TestData.xlsx");
        int row = ExcelUtils.getRowNumber(Config.testID_HRMAddUser,sheetName);

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        driver.manage().window().maximize();
        System.out.println("The chrome window is been maximized");

        driver.get(Config.orangeHRM_URL);
        System.out.println("Orange HRM Application is been loaded");

        OrangeHRM_LoginPage.orangeHRM_Login(driver, sheetName, row);

        driver.findElement(OrangeHRM_HomePage.link_HRAdministration).click();
        System.out.println("HR administration is been clicked");

        wait.until(ExpectedConditions.visibilityOfElementLocated(OrangeHRM_HRAdministrationPage.table_UserData));

        driver.findElement(OrangeHRM_HRAdministrationPage.btn_AddUser).click();
        System.out.println("Add button is been clicked");

        String empName = ExcelUtils.getCellData(sheetName, row, Config.col_EmployeeName);
        driver.findElement(OrangeHRM_AddUserPage.txtbx_EmployeeName).sendKeys(empName);
        System.out.println("Employee name is been entered as " + empName);

        Thread.sleep(1000);
        driver.findElement(OrangeHRM_AddUserPage.txtbx_EmployeeName).sendKeys(Keys.TAB);
        System.out.println("Tab button is pressed");

        String createUserName = ExcelUtils.getCellData(sheetName, row, Config.col_CreateUserName);
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
        String adminRole = ExcelUtils.getCellData(sheetName, row, Config.col_AdminRole);
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
        String newUserPassword = ExcelUtils.getCellData(sheetName, row, Config.col_NewUserPassword);
        driver.findElement(OrangeHRM_AddUserPage.txtbx_NewPassword).sendKeys(newUserPassword);
        System.out.println("New user Password is been entered as "+newUserPassword);

        String newUserConfirmPassword = ExcelUtils.getCellData(sheetName, row, Config.col_NewUserConfirmPassword);
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

        OrangeHRM_HomePage.logout(driver);

        //Login with New User Credentials
        driver.findElement(OrangeHRM_LoginPage.txtbx_UserName).sendKeys(createUserName);
        System.out.println("New User name is entered");

        //password
        String NewUserPassword = ExcelUtils.getCellData(sheetName, row, Config.col_NewUserPassword);
        driver.findElement(OrangeHRM_LoginPage.txtbx_Password).sendKeys(NewUserPassword);
        System.out.println("New Password is been entered");

        //click on Login
        driver.findElement(OrangeHRM_LoginPage.btn_Login).click();
        System.out.println("Login button is been clicked");

        OrangeHRM_HomePage.verifyTitle(driver);

        //Get the Employee Name
        String actualUserName = driver.findElement(OrangeHRM_HomePage.label_EmployeeName).getText();
        if(actualUserName.equalsIgnoreCase(empName)){
            System.out.println(actualUserName+"Add User testcase is successful");
        }else{
            System.out.println(actualUserName+"Add User testcase is not successful");
        }

        OrangeHRM_HomePage.logout(driver);

        driver.quit();
        System.out.println("Testcase Execution is completed and Driver instance is terminated");
    }
}
