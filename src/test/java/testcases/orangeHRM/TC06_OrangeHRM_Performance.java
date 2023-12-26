package testcases.orangeHRM;

import Utilities.CommonMethods;
import Utilities.Config;
import Utilities.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.orangeHRM.*;
import pages.orangeHRM.OrangeHRM_HomePage;
import pages.orangeHRM.OrangeHRM_LoginPage;
import java.time.Duration;
import java.util.List;

public class TC06_OrangeHRM_Performance {
    public static void main(String[] args) throws Exception {
        String projectPath = System.getProperty("user.dir");
        String sheetName = "HRM_Performance";
        ExcelUtils.setExcelFilePath(projectPath + "//TestData//Automation_TestData.xlsx");
        int row = ExcelUtils.getRowNumber(Config.testID_HRM_Performance, sheetName);
        String userName = ExcelUtils.getCellData(sheetName, row, Config.col_UserName);
        String password = ExcelUtils.getCellData(sheetName, row, Config.col_Password);

        WebDriver driver = CommonMethods.openBrowser();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        JavascriptExecutor js = (JavascriptExecutor) driver;


        driver.get(Config.orangeHRM_URL);
        System.out.println("Orange HRM Website loaded successfully");

        OrangeHRM_LoginPage.orangeHRM_Login(driver, sheetName, row, userName, password);

        OrangeHRM_HomePage.verifyTitle(driver);

        WebElement element_Performance = driver.findElement(OrangeHRM_HomePage.link_Performance);
        js.executeScript("arguments[0].click();", element_Performance);
        System.out.println("Performance link clicked");

        wait.until(ExpectedConditions.elementToBeClickable(OrangeHRM_PerformancePage.btn_Addappraisal));
        WebElement element_AddAppraisal = driver.findElement(OrangeHRM_PerformancePage.btn_Addappraisal);
        js.executeScript("arguments[0].click();", element_AddAppraisal);
        System.out.println("Add Appraisal button is clicked");

        driver.switchTo().frame("noncoreIframe");
        System.out.println("Switched into iframe");

        String empName = ExcelUtils.getCellData(sheetName, row, Config.col_Performance_EmployeeName);
        driver.findElement(OrangeHRM_AddEmployeeAppraisalPage.txtbx_EmpName).sendKeys(empName);
        System.out.println(empName + "Employee name is entered");

        WebElement name = driver.findElement(OrangeHRM_AddEmployeeAppraisalPage.drpdwn_EmpName);
        js.executeScript("arguments[0].click();", name);
        System.out.println("Employee Name is selected from pop-up");

        String description = ExcelUtils.getCellData(sheetName, row, Config.col_Performance_Description);
        driver.findElement(OrangeHRM_AddEmployeeAppraisalPage.txtbx_Description).sendKeys(description);
        System.out.println(description + " is entered as Description");

        driver.findElement(OrangeHRM_AddEmployeeAppraisalPage.drpdwn_AppraisalCycle).click();
        System.out.println("Duration drop-down clicked");
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("(//label[text()='Appraisal Cycle']/..//ul//span[text()])[1]"), "-- Select --"));

        String appraisalCycle = ExcelUtils.getCellData(sheetName, row, Config.col_Performance_AppraisalCycle);
        driver.findElement(OrangeHRM_AddEmployeeAppraisalPage.appraisalCycle(appraisalCycle)).click();
        System.out.println(appraisalCycle + " is selected from Appraisal Cycle drop-down");

        //driver.findElement(OrangeHRM_AddEmployeeAppraisalPage.txtbx_Template).sendKeys("sales");


        driver.findElement(OrangeHRM_AddEmployeeAppraisalPage.from_Date).click();
        System.out.println("Date from calendar is clicked");

        String fromDate = ExcelUtils.getCellData(sheetName, row, Config.col_Performance_FromDate);
        String day_FromDate = fromDate.split("-")[0];
        String month_FromDate = fromDate.split("-")[1];
        String year_FromDate = fromDate.split("-")[2];

        driver.findElement(OrangeHRM_AddEmployeeAppraisalPage.drpdwn_FromMonth).click();
        System.out.println("From Month dropdown clicked");

        List<WebElement> list_months = driver.findElements(OrangeHRM_AddEmployeeAppraisalPage.fromMonth);
        for (WebElement element_month : list_months) {
            String actualMonth = element_month.getText();
            if (actualMonth.equalsIgnoreCase(month_FromDate)) {
                element_month.click();
                System.out.println(actualMonth + " is selected as Month for FromDate");
                break;
            }
        }

        driver.findElement(OrangeHRM_AddEmployeeAppraisalPage.drpdwn_FromYear).click();
        System.out.println("Year drop-down clicked");

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(OrangeHRM_AddEmployeeAppraisalPage.fromyear));
        List<WebElement> list_years = driver.findElements(OrangeHRM_AddEmployeeAppraisalPage.fromyear);
        for (WebElement element_year : list_years) {
            String actualYear = element_year.getText();
            if (actualYear.equalsIgnoreCase(year_FromDate)) {
                element_year.click();
                System.out.println(actualYear + " is selected as Year for FromDate");
                break;
            }
        }

        List<WebElement> list_Dates = driver.findElements(OrangeHRM_AddEmployeeAppraisalPage.fromDate);
        for (WebElement element_Date : list_Dates) {
            String actualDate = element_Date.getText();
            if (actualDate.equalsIgnoreCase(day_FromDate)) {
                element_Date.click();
                System.out.println(actualDate + " is selected as Date for FromDate");
                break;
            }
        }

        driver.findElement(OrangeHRM_AddEmployeeAppraisalPage.calendar_ToDate).click();
        System.out.println("To Date Calendar clicked");

        String toDate = ExcelUtils.getCellData(sheetName, row, Config.col_Performance_ToDate);
        String day_ToDate = toDate.split("-")[0];
        String month_ToDate = toDate.split("-")[1];
        String year_ToDate = toDate.split("-")[2];

        driver.findElement(OrangeHRM_AddEmployeeAppraisalPage.drpdwn_ToMonth).click();
        System.out.println("Month drop-down clicked");

        List<WebElement> list_Months = driver.findElements(OrangeHRM_AddEmployeeAppraisalPage.toMonth);
        for (WebElement element_Month : list_Months) {
            String actualMonth = element_Month.getText();
            if (actualMonth.equalsIgnoreCase(month_ToDate)) {
                element_Month.click();
                System.out.println(actualMonth + " Month is selected from ToDate");
                break;
            }
        }

        driver.findElement(OrangeHRM_AddEmployeeAppraisalPage.drpdwn_Toyear).click();
        System.out.println("Year drop-down clicked");

        List<WebElement> list_Years = driver.findElements(OrangeHRM_AddEmployeeAppraisalPage.toYear);
        for (WebElement element_Year : list_Years) {
            String actualYear = element_Year.getText();
            if (actualYear.equalsIgnoreCase(year_ToDate)) {
                element_Year.click();
                System.out.println(actualYear + " Year is selected from ToDate");
                break;
            }
        }

        List<WebElement> list_ToDates = driver.findElements(OrangeHRM_AddEmployeeAppraisalPage.toDate);
        for (WebElement element_Date : list_ToDates) {
            String actualDate = element_Date.getText();
            if (actualDate.equalsIgnoreCase(day_ToDate)) {
                element_Date.click();
                System.out.println(actualDate + " Date is selected from ToDate");
                break;
            }
        }
        driver.findElement(OrangeHRM_AddEmployeeAppraisalPage.drpdwn_DueDate).click();
        System.out.println("Due Date drop-down clicked");

        String dueDate = ExcelUtils.getCellData(sheetName, row, Config.col_Performance_DueDate);
        String day_DueDate = dueDate.split("-")[0];
        String month_DueDate = dueDate.split("-")[1];
        String year_DueDate = dueDate.split("-")[2];

        driver.findElement(OrangeHRM_AddEmployeeAppraisalPage.drpdwn_DueMonth).click();
        System.out.println("Month DueDate drop-down clicked");

        List<WebElement> list_DueDateMonths = driver.findElements(OrangeHRM_AddEmployeeAppraisalPage.dueMonth);
        for (WebElement element_Month : list_DueDateMonths) {
            String actualMonth = element_Month.getText();
            if (actualMonth.equalsIgnoreCase(month_DueDate)) {
                element_Month.click();
                System.out.println(actualMonth + " Month is selected from DueDate");
                break;
            }
        }

        driver.findElement(OrangeHRM_AddEmployeeAppraisalPage.drpdwn_Dueyear).click();
        System.out.println("Year due date dropdown clicked");

        List<WebElement> list_DueDateYears = driver.findElements(OrangeHRM_AddEmployeeAppraisalPage.dueYear);
        for (WebElement element_Year : list_DueDateYears) {
            String actualYear = element_Year.getText();
            if (actualYear.equalsIgnoreCase(year_DueDate)) {
                element_Year.click();
                System.out.println(actualYear + " Year is selected from DueDate");
                break;
            }
        }

        List<WebElement> list_DueDateDays = driver.findElements(OrangeHRM_AddEmployeeAppraisalPage.dueDate);
        for (WebElement element_Date : list_DueDateDays) {
            String actualDate = element_Date.getText();
            if (actualDate.equalsIgnoreCase(day_DueDate)) {
                element_Date.click();
                System.out.println(actualDate + " Date is selected from DueDate");
                break;
            }
        }

        driver.findElement(OrangeHRM_AddEmployeeAppraisalPage.btn_Next).click();
        System.out.println("Next Button clicked");

        driver.findElement(OrangeHRM_Evaluator.chkbx_SelfAppraisal).click();
        System.out.println("Self appraisal check-box checked ");

        driver.findElement(OrangeHRM_Evaluator.btn_Next).click();
        System.out.println("Next button in Evaluator Page Clicked");

        driver.findElement(OrangeHRM_AppraisalMultipleView.drpdwn_FinalReview).click();
        System.out.println("Final Review dropdown clicked");

        driver.findElement(OrangeHRM_AppraisalMultipleView.drpdwn_Submit).click();
        System.out.println("Submit button is clicked");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='dialogSubmitBtn']")));
        WebElement element = driver.findElement(By.xpath("//a[@id='dialogSubmitBtn']"));
        js.executeScript("arguments[0].click()", element);
        System.out.println("Ok button is clicked in Alert window");

        WebElement element_HRAdministration = driver.findElement(OrangeHRM_HomePage.link_HRAdministration);
        js.executeScript("arguments[0].click()", element_HRAdministration);
        System.out.println("HR Administration link is clicked");

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

        wait.until(ExpectedConditions.elementToBeClickable(OrangeHRM_HRAdministrationPage.chkbx_ChangePassword));
        driver.findElement(OrangeHRM_HRAdministrationPage.chkbx_ChangePassword).click();
        System.out.println("Change Password check-box is clicked");

        //Password and confirm password
        String newUserPassword = ExcelUtils.getCellData(sheetName, row, Config.col_Performance_UserName_Password);
        driver.findElement(OrangeHRM_AddUserPage.txtbx_ConfirmPassword).sendKeys(newUserPassword);
        System.out.println("New user Password is been entered as " + newUserPassword);

        String newUserConfirmPassword = ExcelUtils.getCellData(sheetName, row, Config.col_Performance_UserName_ConfirmPassword);
        driver.findElement(OrangeHRM_AddUserPage.txtbx_ConfirmPassword).sendKeys(newUserConfirmPassword);
        System.out.println("Confirm New Password is been confirmed as " + newUserConfirmPassword);

        driver.findElement(OrangeHRM_AddUserPage.btn_Save).click();
        System.out.println("Save button is been clicked");

        driver.switchTo().defaultContent();
        System.out.println("Exits from the frame!!!");

        //Logout from the Application
        driver.findElement(OrangeHRM_HomePage.link_Logout).click();
        System.out.println("Logout is successfully done from the Website");

        driver.findElement(OrangeHRM_LoginPage.txtbx_UserName).sendKeys(userName_Employee);
        System.out.println(userName_Employee + " is entered as Username");

        String userPassword = ExcelUtils.getCellData(sheetName, row, Config.col_Performance_UserName_Password);
        driver.findElement(OrangeHRM_LoginPage.txtbx_Password).sendKeys(userPassword);
        System.out.println("Password entered");

        driver.findElement(By.xpath("//button[@type='submit']")).submit();
        System.out.println("Login button is clicked");

        OrangeHRM_HomePage.verifyTitle(driver);

        WebElement link_Performance = driver.findElement(OrangeHRM_HomePage.link_Performance);
        js.executeScript("arguments[0].click();", link_Performance);
        System.out.println("Performance link clicked");

        wait.until(ExpectedConditions.elementToBeClickable(OrangeHRM_PerformancePage.btn_MyAppraisal));
        WebElement link_MyAppraisal = driver.findElement(OrangeHRM_PerformancePage.btn_MyAppraisal);
        js.executeScript("arguments[0].click()", link_MyAppraisal);
        System.out.println("My Appraisal link is clicked");

        //Validating the Description
        wait.until(ExpectedConditions.visibilityOfElementLocated(OrangeHRM_MyAppraisalPage.emp_Description));
        String actualDescription = driver.findElement(OrangeHRM_MyAppraisalPage.emp_Description).getText();
        if (actualDescription.equalsIgnoreCase(description)) {
            System.out.println("Description data is matched");
        } else {
            System.out.println("Description data is not matched");
        }

        //Validating the Appraisal Status
        String actualAppraisalStatus = driver.findElement(OrangeHRM_MyAppraisalPage.appraisal_Status).getText();
        if (actualAppraisalStatus.equalsIgnoreCase("COMPLETED")) {
            System.out.println("Appraisal Status is COMPLETED");
        } else {
            System.out.println("Appraisal Status is not COMPLETED");
        }

        OrangeHRM_HomePage.logout(driver);

        driver.quit();
        System.out.println("Testcase Execution is completed and Driver instance is terminated");
    }
}
