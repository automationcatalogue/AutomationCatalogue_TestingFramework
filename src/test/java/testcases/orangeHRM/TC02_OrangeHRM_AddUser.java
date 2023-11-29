package testcases.orangeHRM;

import Utilities.Config;
import Utilities.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

        driver.get("https://automationteste-trials710.orangehrmlive.com/");
        System.out.println("Orange HRM Application is been loaded");

        String userName = ExcelUtils.getCellData(sheetName, row, Config.col_UserName);
        driver.findElement(By.name("txtUsername")).sendKeys(userName);
        System.out.println("User name is been entered as " + userName);

        String password = ExcelUtils.getCellData(sheetName, row, Config.col_Password);
        driver.findElement(By.id("txtPassword")).sendKeys(password);
        System.out.println("Password is been entered as " + password);

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("Login button is been clicked");

        driver.findElement(By.xpath("(//a[@data-automation-id='menu_admin_viewSystemUsers'])[1]/span")).click();
        System.out.println("HR administration is been clicked");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='systemUserDiv']/crud-panel/div/div/list/table/tbody/tr[1]/td[2]/ng-include/span")));

        driver.findElement(By.xpath("//i[text()='add']")).click();
        System.out.println("Add button is been clicked");

        String empName = ExcelUtils.getCellData(sheetName, row, Config.col_EmployeeName);
        driver.findElement(By.id("selectedEmployee_value")).sendKeys(empName);
        System.out.println("Employee name is been entered as " + empName);

        Thread.sleep(1000);
        driver.findElement(By.id("selectedEmployee_value")).sendKeys(Keys.TAB);
        System.out.println("Tab button is pressed");

        String createUserName = ExcelUtils.getCellData(sheetName, row, Config.col_CreateUserName);
        driver.findElement(By.id("user_name")).sendKeys(createUserName);
        System.out.println("User name is been entered");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='modal-save-button']")));

        //ESS role dropdown
        driver.findElement(By.cssSelector("button.btn[aria-owns='bs-select-1']")).click();
        System.out.println("Ess drop down is been selected");

        driver.findElement(By.cssSelector("#bs-select-1-1")).click();
        System.out.println("Default ESS is been selected");

        //supervisor role dropdown with Test HR selected
        driver.findElement(By.xpath("//button[@type='button'][@data-id='supervisorrole']")).click();
        System.out.println("Supervisor role dropdown is been selected");
        driver.findElement(By.xpath("//a[@id='bs-select-2-2']")).click();
        System.out.println("Test HR is been selected");

        //Admin role drop down
        String adminRole = ExcelUtils.getCellData(sheetName, row, Config.col_AdminRole);
        driver.findElement(By.xpath("//button[@data-id='adminrole']/div/div/div")).click();
        System.out.println("Admin Role drop-down is clicked");
        Thread.sleep(2000);
        List<WebElement> AdminRole=driver.findElements(By.xpath("//button[@data-id='adminrole']//following-sibling::div//ul/li//span"));
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
        driver.findElement(By.id("password")).sendKeys(newUserPassword);
        System.out.println("New user Password is been entered as "+newUserPassword);

        String newUserConfirmPassword = ExcelUtils.getCellData(sheetName, row, Config.col_NewUserConfirmPassword);
        driver.findElement(By.cssSelector("#confirmpassword")).sendKeys(newUserConfirmPassword);
        System.out.println("Confirm New Password is been confirmed as "+newUserConfirmPassword);

        Thread.sleep(4000);
        //save button
        driver.findElement(By.xpath("//button[@id='modal-save-button']")).click();
        System.out.println("Save button is been clicked");
        Thread.sleep(3000);

        //save button is clicked again
        driver.findElement(By.xpath("//button[@id='modal-save-button']")).click();
        System.out.println("Save button is been clicked at the end");

        //Logout from OrangeHRM Application
        driver.findElement(By.xpath("(//span[@class='profile-name'])[2]")).click();
        System.out.println("Logout is successfully done from the Website");

        //Login with New User Credentials
        driver.findElement(By.name("txtUsername")).sendKeys(createUserName);
        System.out.println("New User name is entered");

        //password
        String NewUserPassword = ExcelUtils.getCellData(sheetName, row, Config.col_NewUserPassword);
        driver.findElement(By.name("txtPassword")).sendKeys(NewUserPassword);
        System.out.println("New Password is been entered");

        //click on Login
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("Login button is been clicked");

        //Verify the title
        String title = driver.getTitle();

        if (title.equalsIgnoreCase("Employee Management")) {
            System.out.println("Login is successful");
        }else{
            System.out.println("Login is not successful");
        }

        //Get the Employee Name
        String actualUserName = driver.findElement(By.xpath("//a[@class='name'] ")).getText();
        if(actualUserName.equalsIgnoreCase(empName)){
            System.out.println(actualUserName+"Add User testcase is successful");
        }else{
            System.out.println(actualUserName+"Add User testcase is not successful");
        }

        //Logout from the Application
        driver.findElement(By.xpath("(//span[@class='profile-name'])[2]")).click();
        System.out.println("Logout is successfully done from the Website");

        driver.quit();
        System.out.println("Testcase Execution is completed and Driver instance is terminated");
    }
}
