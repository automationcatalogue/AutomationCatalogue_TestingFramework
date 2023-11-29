package testcases.orangeHRM;

import Utilities.Config;
import Utilities.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TC06_OrangeHRM_Performance {
    public static void main(String[] args) throws Exception {
        String projectPath = System.getProperty("user.dir");
        String sheetName = "HRM_Performance";
        ExcelUtils.setExcelFilePath(projectPath + "//TestData//Automation_TestData.xlsx");
        int row = ExcelUtils.getRowNumber(Config.testID_HRM_Performance, sheetName);

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();

        driver.get("https://automationteste-trials710.orangehrmlive.com/");
        System.out.println("Orange HRM Website loaded successfully");

        String userName = ExcelUtils.getCellData(sheetName, row, Config.col_UserName);
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(userName);
        System.out.println("Username entered");

        String password = ExcelUtils.getCellData(sheetName, row, Config.col_Password);
        driver.findElement(By.cssSelector("#txtPassword")).sendKeys(password);
        System.out.println("Password entered");

        driver.findElement(By.cssSelector("button[type='submit']")).submit();
        String actualTitle = driver.getTitle();
        if (actualTitle.equalsIgnoreCase("Employee Management")) {
            System.out.println("Title is Verified and Login is successful");
        } else {
            System.out.println("Title is not matched and Login is not successful");
        }

        WebElement element_Performance = driver.findElement(By.xpath("//a[@class=' main-menu-item-1' and @data-tooltip='Performance']/span"));
        js.executeScript("arguments[0].click();", element_Performance);
        System.out.println("Performance link clicked");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='material-icons' and text()='add']")));
        WebElement element_AddAppraisal = driver.findElement(By.xpath("//i[@class='material-icons' and text()='add']"));
        js.executeScript("arguments[0].click();", element_AddAppraisal);
        System.out.println("Add Appraisal button is clicked");

        driver.switchTo().frame("noncoreIframe");
        System.out.println("Switched into iframe");

        String empName = ExcelUtils.getCellData(sheetName, row, Config.col_Performance_EmployeeName);
        driver.findElement(By.cssSelector("input[name='employeeAppraisal[emp_name][empName]']")).sendKeys(empName);
        System.out.println(empName + "Employee name is entered");

        WebElement name = driver.findElement(By.xpath("//div[@class='autoComplete-title']/strong"));
        js.executeScript("arguments[0].click();", name);
        System.out.println("Employee Name is selected from pop-up");

        String description = ExcelUtils.getCellData(sheetName, row, Config.col_Performance_Description);
        driver.findElement(By.cssSelector("#employeeAppraisal_description")).sendKeys(description);
        System.out.println(description + " is entered as Description");

        driver.findElement(By.xpath("//div[@class='select-wrapper']")).click();
        System.out.println("Duration drop-down clicked");
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("(//label[text()='Appraisal Cycle']/..//ul//span[text()])[1]"), "-- Select --"));

        String appraisalCycle = ExcelUtils.getCellData(sheetName, row, Config.col_Performance_AppraisalCycle);
        driver.findElement(By.xpath("//label[text()='Appraisal Cycle']/..//ul//span[text()='" + appraisalCycle + "']")).click();
        System.out.println(appraisalCycle + " is selected from Appraisal Cycle drop-down");

        driver.findElement(By.cssSelector("#date_from")).click();
        System.out.println("Date from calendar is clicked");

        String fromDate = ExcelUtils.getCellData(sheetName, row, Config.col_Performance_FromDate);
        String day_FromDate = fromDate.split("-")[0];
        String month_FromDate = fromDate.split("-")[1];
        String year_FromDate = fromDate.split("-")[2];

        driver.findElement(By.xpath("//div[@class='select-wrapper picker__select--month']")).click();
        System.out.println("Month dropdown clicked");

        List<WebElement> list_months = driver.findElements(By.xpath("//div[@class='select-wrapper picker__select--month']/ul/li/span"));
        for (WebElement element_month : list_months) {
            String actualMonth = element_month.getText();
            if (actualMonth.equalsIgnoreCase(month_FromDate)) {
                element_month.click();
                System.out.println(actualMonth + " is selected as Month for FromDate");
                break;
            }
        }

        driver.findElement(By.xpath("//div[@class='select-wrapper picker__select--year']")).click();
        System.out.println("Year drop-down clicked");

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='select-wrapper picker__select--year']/ul/li/span")));
        List<WebElement> list_years = driver.findElements(By.xpath("//div[@class='select-wrapper picker__select--year']/ul/li/span"));
        for (WebElement element_year : list_years) {
            String actualYear = element_year.getText();
            if (actualYear.equalsIgnoreCase(year_FromDate)) {
                element_year.click();
                System.out.println(actualYear + " is selected as Year for FromDate");
                break;
            }
        }

        List<WebElement> list_Dates = driver.findElements(By.xpath("(//table[@class='picker__table'])[1]/tbody/tr/td/div[contains(@class,'infocus')]"));
        for (WebElement element_Date : list_Dates) {
            String actualDate = element_Date.getText();
            if (actualDate.equalsIgnoreCase(day_FromDate)) {
                element_Date.click();
                System.out.println(actualDate + " is selected as Date for FromDate");
                break;
            }
        }

        driver.findElement(By.cssSelector("#date_to")).click();
        System.out.println("To Date Calendar clicked");

        String toDate = ExcelUtils.getCellData(sheetName, row, Config.col_Performance_ToDate);
        String day_ToDate = toDate.split("-")[0];
        String month_ToDate = toDate.split("-")[1];
        String year_ToDate = toDate.split("-")[2];

        driver.findElement(By.xpath("(//div[@class='select-wrapper picker__select--month'])[2]")).click();
        System.out.println("Month drop-down clicked");

        List<WebElement> list_Months = driver.findElements(By.xpath("(//div[@class='select-wrapper picker__select--month'])[2]/ul/li/span"));
        for (WebElement element_Month : list_Months) {
            String actualMonth = element_Month.getText();
            if (actualMonth.equalsIgnoreCase(month_ToDate)) {
                element_Month.click();
                System.out.println(actualMonth + " Month is selected from ToDate");
                break;
            }
        }

        driver.findElement(By.xpath("(//div[@class='select-wrapper picker__select--year'])[2]")).click();
        System.out.println("Year drop-down clicked");

        List<WebElement> list_Years = driver.findElements(By.xpath("(//div[@class='select-wrapper picker__select--year'])[2]/ul/li/span"));
        for (WebElement element_Year : list_Years) {
            String actualYear = element_Year.getText();
            if (actualYear.equalsIgnoreCase(year_ToDate)) {
                element_Year.click();
                System.out.println(actualYear + " Year is selected from ToDate");
                break;
            }
        }

        List<WebElement> list_ToDates = driver.findElements(By.xpath("(//table[@class='picker__table'])[2]/tbody/tr/td/div[contains(@class,'infocus')]"));
        for (WebElement element_Date : list_ToDates) {
            String actualDate = element_Date.getText();
            if (actualDate.equalsIgnoreCase(day_ToDate)) {
                element_Date.click();
                System.out.println(actualDate + " Date is selected from ToDate");
                break;
            }
        }
        driver.findElement(By.cssSelector("#date_due")).click();
        System.out.println("Due Date drop-down clicked");

        String dueDate = ExcelUtils.getCellData(sheetName, row, Config.col_Performance_DueDate);
        String day_DueDate = dueDate.split("-")[0];
        String month_DueDate = dueDate.split("-")[1];
        String year_DueDate = dueDate.split("-")[2];

        driver.findElement(By.xpath("(//div[@class='select-wrapper picker__select--month'])[3]")).click();
        System.out.println("Month DueDate drop-down clicked");

        List<WebElement> list_DueDateMonths = driver.findElements(By.xpath("(//div[@class='select-wrapper picker__select--month'])[3]/ul/li/span"));
        for (WebElement element_Month : list_DueDateMonths) {
            String actualMonth = element_Month.getText();
            if (actualMonth.equalsIgnoreCase(month_DueDate)) {
                element_Month.click();
                System.out.println(actualMonth + " Month is selected from DueDate");
                break;
            }
        }

        driver.findElement(By.xpath("(//div[@class='select-wrapper picker__select--year'])[3]")).click();
        System.out.println("Year due date dropdown clicked");

        List<WebElement> list_DueDateYears = driver.findElements(By.xpath("(//div[@class='select-wrapper picker__select--year'])[3]/ul/li/span"));
        for (WebElement element_Year : list_DueDateYears) {
            String actualYear = element_Year.getText();
            if (actualYear.equalsIgnoreCase(year_DueDate)) {
                element_Year.click();
                System.out.println(actualYear + " Year is selected from DueDate");
                break;
            }
        }

        List<WebElement> list_DueDateDays = driver.findElements(By.xpath("(//table[@class='picker__table'])[3]/tbody/tr/td/div[contains(@class,'infocus')]"));
        for (WebElement element_Date : list_DueDateDays) {
            String actualDate = element_Date.getText();
            if (actualDate.equalsIgnoreCase(day_DueDate)) {
                element_Date.click();
                System.out.println(actualDate + " Date is selected from DueDate");
                break;
            }
        }

        driver.findElement(By.cssSelector("#saveBtn")).click();
        System.out.println("Next Button clicked");

        driver.findElement(By.xpath("//label[@for='appraisalEval_eval_name_grp_self']")).click();
        System.out.println("Self appraisal check-box checked ");

        driver.findElement(By.cssSelector("#saveBtn")).click();
        System.out.println("Next button in Evaluator Page Clicked");

        driver.findElement(By.xpath("//a[@data-activates='dropdown-7']")).click();
        System.out.println("Final Review dropdown clicked");

        driver.findElement(By.xpath("//a[text()='Submit']")).click();
        System.out.println("Submit button is clicked");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='dialogSubmitBtn']")));
        WebElement element = driver.findElement(By.xpath("//a[@id='dialogSubmitBtn']"));
        js.executeScript("arguments[0].click()", element);
        System.out.println("Ok button is clicked in Alert window");

        WebElement element_HRAdministration = driver.findElement(By.xpath("(//span[text()='HR Administration'])[1]"));
        js.executeScript("arguments[0].click()", element_HRAdministration);
        System.out.println("HR Administration link is clicked");

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//list/table//tbody/tr/td[4]//span")));
        List<WebElement> list_EmployeeNames = driver.findElements(By.xpath("//list/table//tbody/tr/td[4]//span"));
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

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='changepassword']/span")));
        driver.findElement(By.xpath("//label[@for='changepassword']/span")).click();
        System.out.println("Change Password check-box is clicked");

        //Password and confirm password
        String newUserPassword = ExcelUtils.getCellData(sheetName, row, Config.col_Performance_UserName_Password);
        driver.findElement(By.id("password")).sendKeys(newUserPassword);
        System.out.println("New user Password is been entered as " + newUserPassword);

        String newUserConfirmPassword = ExcelUtils.getCellData(sheetName, row, Config.col_Performance_UserName_ConfirmPassword);
        driver.findElement(By.cssSelector("#confirmpassword")).sendKeys(newUserConfirmPassword);
        System.out.println("Confirm New Password is been confirmed as " + newUserConfirmPassword);

        driver.findElement(By.xpath("//button[@id='modal-save-button']")).click();
        System.out.println("Save button is been clicked");

        driver.switchTo().defaultContent();
        System.out.println("Exits from the frame!!!");

        //Logout from the Application
        driver.findElement(By.xpath("//span[text()='Log Out']")).click();
        System.out.println("Logout is successfully done from the Website");

        driver.findElement(By.name("txtUsername")).sendKeys(userName_Employee);
        System.out.println(userName_Employee + " is entered as Username");

        String userPassword = ExcelUtils.getCellData(sheetName, row, Config.col_Performance_UserName_Password);
        driver.findElement(By.id("txtPassword")).sendKeys(userPassword);
        System.out.println("Password entered");

        driver.findElement(By.xpath("//button[@type='submit']")).submit();
        System.out.println("Login button is clicked");

        actualTitle = driver.getTitle();
        if (actualTitle.equalsIgnoreCase("Employee Management")) {
            System.out.println("Page logged in successfully");
        } else {
            System.out.println("Page logged in failed");
        }

        WebElement link_Performance = driver.findElement(By.xpath("//a[@class=' main-menu-item-1' and @data-tooltip='Performance']/span"));
        js.executeScript("arguments[0].click();", link_Performance);
        System.out.println("Performance link clicked");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-automation-id='menu_performance_viewMyAppraisals']")));
        WebElement link_MyAppraisal = driver.findElement(By.xpath("//a[@data-automation-id='menu_performance_viewMyAppraisals']"));
        js.executeScript("arguments[0].click()", link_MyAppraisal);
        System.out.println("My Appraisal link is clicked");

        //Validating the Description
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//list/table//tbody/tr[1]/td[6]//span")));
        String actualDescription = driver.findElement(By.xpath("//list/table//tbody/tr[1]/td[6]//span")).getText();
        if (actualDescription.equalsIgnoreCase(description)) {
            System.out.println("Description data is matched");
        } else {
            System.out.println("Description data is not matched");
        }

        //Validating the Appraisal Status
        String actualAppraisalStatus = driver.findElement(By.xpath("//list/table//tbody/tr[1]/td[7]//span")).getText();
        if (actualAppraisalStatus.equalsIgnoreCase("COMPLETED")) {
            System.out.println("Appraisal Status is COMPLETED");
        } else {
            System.out.println("Appraisal Status is not COMPLETED");
        }

        driver.findElement(By.xpath("//span[text()='Log Out']")).click();
        System.out.println("Logout is successfully done from the Website");

        driver.quit();
        System.out.println("Testcase Execution is completed and Driver instance is terminated");
    }
}
