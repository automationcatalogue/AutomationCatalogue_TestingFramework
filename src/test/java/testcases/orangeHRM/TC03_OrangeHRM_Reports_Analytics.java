package testcases.orangeHRM;

import Utilities.Config;
import Utilities.Config_Data;
import Utilities.ExcelUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.time.Duration;
import java.util.List;

public class TC03_OrangeHRM_Reports_Analytics {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static String sheetName;
    public static int row;
    public static JavascriptExecutor js;
    public static TakesScreenshot ts;
    public static File src, dest;
    public static String projectPath;

    public static void main(String[] args) throws Exception {
        projectPath = System.getProperty("user.dir");
        sheetName = "HRM_Reports";
        ExcelUtils.setExcelFilePath(projectPath + "//TestData//Automation_TestData.xlsx");
        row = ExcelUtils.getRowNumber(Config.testID_HRMReports, sheetName);

        driver = new ChromeDriver();
        System.out.println("Chrome Browser is opened");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();
        js =(JavascriptExecutor)driver;
        ts = (TakesScreenshot) driver;

        driver.get("https://automationteste-trials710.orangehrmlive.com/");
        System.out.println("OrangeHRM Application is loaded");

        //UserName
        String userName = ExcelUtils.getCellData(sheetName, row, Config.col_UserName);
        driver.findElement(By.name("txtUsername")).sendKeys(userName);
        System.out.println("UserName is entered as" + userName);

        //password
        String password = ExcelUtils.getCellData(sheetName, row, Config.col_Password);
        driver.findElement(By.id("txtPassword")).sendKeys(password);
        System.out.println("Password is entered");

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("Login button is clicked");

        src = ts.getScreenshotAs(OutputType.FILE);
        dest = new File(projectPath + "\\Screenshots\\OrangeHRMLogin.jpg");
        FileUtils.copyFile(src, dest);
        System.out.println("OrangeHRMLogin screenshot is captured");

        driver.findElement(By.xpath("(//span[text()='Reports and Analytics'])[1]")).click();
        System.out.println("Reports and analytics link is clicked");

        String actualTitle = driver.getTitle();
        String expectedTitle = "Reports and Analytics";
        if (actualTitle.equalsIgnoreCase(expectedTitle)) {
            System.out.println("Reports and Analytics Title is Matched");
        } else {
            System.out.println("Reports and Analytics Title is not Matched");
        }

        driver.findElement(By.cssSelector(".oxd-button-label-wrapper")).click();
        System.out.println("New Report button is clicked");

        //Report type
        String reportType = ExcelUtils.getCellData(sheetName, row, Config.col_ReportType);
        driver.findElement(By.xpath("//div[text()='Employee Informational Report']")).click();
        System.out.println("Report Type drop-down is clicked");

        List<WebElement> elements_ReportType = driver.findElements(By.xpath("//div[@role='listbox']/div/div"));
        for (WebElement element_Report : elements_ReportType) {
            String reportName = element_Report.getText();
            if (reportName.equalsIgnoreCase(reportType)) {
                element_Report.click();
                System.out.println(reportName+" is selected as Report Type from drop-down");
                break;
            }
        }

        //Folder
        String folderType = ExcelUtils.getCellData(sheetName, row, Config.col_FolderType);
        WebElement element_selectFolder = driver.findElement(By.xpath("(//div[@clear='false'])[2]"));
        js.executeScript("arguments[0].click();",element_selectFolder);
        System.out.println("Select folder drop-down is clicked");

        List<WebElement> elements_Folders = driver.findElements(By.xpath("(//div[@clear='false'])[2]"));
        for (WebElement element_folder : elements_Folders) {
            String folderName = element_folder.getText();
            if (folderName.equalsIgnoreCase(folderType)) {
                element_folder.click();
                System.out.println(folderName+" is selected as Folder Type from drop-down");
                break;
            }
        }

        WebElement element_NextBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        js.executeScript("arguments[0].click();", element_NextBtn);
        System.out.println("Next button is clicked");

        //Report Name
        String reportName = ExcelUtils.getCellData(sheetName, row, Config.col_ReportName);
        driver.findElement(By.cssSelector("#pimDefineReportName")).sendKeys(reportName);
        System.out.println("Report Name is entered as " + reportName);

        src = ts.getScreenshotAs(OutputType.FILE);
        dest = new File(projectPath + "\\Screenshots\\OrangeHRMReportName.jpg");
        FileUtils.copyFile(src, dest);
        System.out.println("OrangeHRMReportName screenshot is captured");

        wait.until((ExpectedConditions.elementToBeClickable(By.xpath("//button[@translate='Next']")))).click();
        System.out.println("Next button is clicked");

        if(reportType.equalsIgnoreCase("Travel and Expense Detailed Report")){
            selectFields_TravelExpenseDetailedReport();

            driver.findElement(By.xpath("//i[text()='arrow_back']")).click();
            System.out.println("Back Arrow button is clicked");
            driver.findElement(By.xpath("(//input[@placeholder='Search'])[2]")).sendKeys(reportName);
            System.out.println(reportName + " is entered in Search text-box");

            validate_TravelExpenseDetailedReport();
        }else if(reportType.equalsIgnoreCase("Employee Informational Report")){
            selectFields_EmployeeInformationalReport();

            driver.findElement(By.xpath("//i[text()='arrow_back']")).click();
            System.out.println("Back Arrow button is clicked");
            driver.findElement(By.xpath("(//input[@placeholder='Search'])[2]")).sendKeys(reportName);
            System.out.println(reportName + " is entered in Search text-box");

            validate_EmployeeInformationalFields();

        }else if(reportType.equalsIgnoreCase("Travel and Expense Summary Report")){
            selectFields_TravelExpenseSummaryReport();

            driver.findElement(By.xpath("//i[text()='arrow_back']")).click();
            System.out.println("Back Arrow button is clicked");
            driver.findElement(By.xpath("(//input[@placeholder='Search'])[2]")).sendKeys(reportName);
            System.out.println(reportName + " is entered in Search text-box");

            validate_TravelExpenseSummaryReport();
        }

        //Logout from the Application
        driver.findElement(By.xpath("(//span[@class='profile-name'])[2]")).click();
        System.out.println("Logout is successfully done from the Website");

        driver.quit();
        System.out.println("Testcase Execution is completed and Driver instance is terminated");
    }

    public static void selectFields_TravelExpenseDetailedReport() throws Exception{
        wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//label[@for='selectedFilters_request_id']"))));
        driver.findElement(By.xpath("//label[@for='selectedFilters_request_id']")).click();
        System.out.println("Travel Request Id check-box is selected");

        driver.findElement(By.xpath("//label[@for='selectedFilters_job_title']")).click();
        System.out.println("Job Title check-box is selected");

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        System.out.println("window is scrolled down till bottom of the page");

        driver.findElement(By.xpath("//button[text()='Next']")).click();
        System.out.println("Next button is clicked");

        //Add Display
        String displayFields = ExcelUtils.getCellData(sheetName, row, Config.col_DisplayFields);
        driver.findElement(By.cssSelector("#display-group-dropdown-trigger")).click();
        System.out.println("Add display field button is clicked");

        List<WebElement> elements_DisplayFields = driver.findElements(By.xpath("//ul[@id='add-display-group-dropdown']/li"));
        for (WebElement element_DisplayField : elements_DisplayFields) {
            String fieldName = element_DisplayField.getText();
            if (fieldName.equalsIgnoreCase(displayFields)) {
                element_DisplayField.click();
                System.out.println(fieldName + " is clicked from Display Fields");
                break;
            }
        }

        driver.findElement(By.xpath("//label[text()='Estimated Date']")).click();
        System.out.println("Estimated date check-box is selected");

        driver.findElement(By.xpath("//label[text()='Travel Request ID']")).click();
        System.out.println("Travel Request ID check-box is clicked");

        driver.findElement(By.xpath("//label[text()='Cash in Advance']")).click();
        System.out.println("Cash in Advance check-box is clicked");

        driver.findElement(By.xpath("//button[text()='Save']")).click();
        System.out.println("Save button is clicked");
    }
    public static void selectFields_EmployeeInformationalReport() throws Exception{
        WebElement element_EmployeeName = driver.findElement(By.xpath("//input[@id='selectedFilters_employee_name_withgroup']"));
        js.executeScript("arguments[0].click();", element_EmployeeName);
        System.out.println("Employee Name check-box is clicked");

        WebElement element_JobTitle = driver.findElement(By.xpath("//input[@id='selectedFilters_job_title_withgroup']"));
        js.executeScript("arguments[0].click();", element_JobTitle);
        System.out.println("Job Title checkbox is clicked");

        WebElement element_Location = driver.findElement(By.xpath("//input[@id='selectedFilters_location_withgroup']"));
        js.executeScript("arguments[0].click();", element_Location);
        System.out.println("Location checkbox is clicked");

        driver.findElement(By.xpath("//button[text()='Next']")).click();
        System.out.println("Next button is clicked");

        //Add Display
        String displayFields = ExcelUtils.getCellData(sheetName, row, Config.col_DisplayFields);
        driver.findElement(By.cssSelector("#display-group-dropdown-trigger")).click();
        System.out.println("Add display field button is clicked");

        List<WebElement> elements_DisplayFields = driver.findElements(By.xpath("//ul[@id='add-display-group-dropdown']/li"));
        for (WebElement element_DisplayField : elements_DisplayFields) {
            String fieldName = element_DisplayField.getText();
            if (fieldName.equalsIgnoreCase(displayFields)) {
                element_DisplayField.click();
                System.out.println(fieldName + " is clicked from Display Fields");
                break;
            }
        }
        driver.findElement(By.xpath("//label[text()='Employee Id']")).click();
        System.out.println("Employee Id check-box is clicked");

        driver.findElement(By.xpath("//label[text()='Employee Name']")).click();
        System.out.println("Employee Name check-box is clicked");

        driver.findElement(By.xpath("//label[text()='Nationality']")).click();
        System.out.println("Nationality check-box is clicked");

        driver.findElement(By.xpath("//button[text()='Save']")).click();
        System.out.println("Save button is clicked");
    }

    public static void selectFields_TravelExpenseSummaryReport() throws Exception{

        driver.findElement(By.xpath("//label[@for='selectedGroupingField_claim_status']")).click();
        System.out.println("ClaimStatus check-box is clicked");

        driver.findElement(By.xpath("//label[@for='selectedGroupingField_currency_for_reimbursement']")).click();
        System.out.println("Reimbursement Currency (Estimates) check-box is clicked");

        driver.findElement(By.xpath("//button[@class='btn waves-effect waves-light right']")).click();
        System.out.println("Next button is clicked");

        driver.findElement(By.xpath("//label[@for='selectedFilters_claim_id']")).click();
        System.out.println("Expense ClaimID check-box is clicked");

        driver.findElement(By.xpath("//label[@for='selectedFilters_claimed_date']")).click();
        System.out.println("ClaimDate check-box is clicked");

        driver.findElement(By.xpath("//label[@for='selectedFilters_claim_status']")).click();
        System.out.println("ClaimStatus check-box is clicked");

        driver.findElement(By.xpath("//button[@class='btn waves-effect waves-light right']")).click();
        System.out.println("Next button is clicked");

        //Add Display
        String displayFields = ExcelUtils.getCellData(sheetName, row, Config.col_DisplayFields);
        driver.findElement(By.cssSelector("#display-group-dropdown-trigger")).click();
        System.out.println("Add display field button is clicked");

        List<WebElement> elements_DisplayFields = driver.findElements(By.xpath("//ul[@id='add-display-group-dropdown']/li"));
        for (WebElement element_DisplayField : elements_DisplayFields) {
            String fieldName = element_DisplayField.getText();
            if (fieldName.equalsIgnoreCase(displayFields)) {
                element_DisplayField.click();
                System.out.println(fieldName + " is clicked from Display Fields");
                break;
            }
        }

        driver.findElement(By.xpath("//label[text()='Total Estimated Expense (Reimbursement Currency)']")).click();
        System.out.println("Total Estimated Expense (Reimbursement Currency) check-box is clicked");

        WebElement element_SaveBtn=driver.findElement(By.xpath("//button[@class='btn waves-effect waves-light']"));
        js.executeScript("arguments[0].click();", element_SaveBtn);
        System.out.println("Save button is clicked");
    }

    public static void validate_TravelExpenseDetailedReport() throws Exception{
        WebElement element_TravelRequestID = driver.findElement(By.xpath("//td[text()='Travel Request ID']"));
        String actualTravelRequestID = element_TravelRequestID.getText();
        String expectedTravelRequestID = "Travel Request ID";
        if (actualTravelRequestID.equalsIgnoreCase(expectedTravelRequestID)) {
            System.out.println("Travel Request ID column is verified in the Report");
        }else{
            System.out.println("Travel Request ID column is not present in the Report");
        }

        WebElement element_EstimatedDate = driver.findElement(By.xpath("//td[text()='Estimated Date']"));
        String actualEstimatedDate = element_EstimatedDate.getText();
        String expectedEstimatedDate = "Estimated Date";
        if (actualEstimatedDate.equalsIgnoreCase(expectedEstimatedDate)) {
            System.out.println("EstimatedDate column is verified in the Report");
        }else{
            System.out.println("EstimatedDate column is not present in the Report");
        }

        WebElement element_CashInAdvance = driver.findElement(By.xpath("//td[text()='Cash in Advance']"));
        String actualCashInAdvance = element_CashInAdvance.getText();
        String expectedCashInAdvance = "Cash in Advance";
        if (actualCashInAdvance.equalsIgnoreCase(expectedCashInAdvance)) {
            System.out.println("Cash In Advance column is verified in the Report");
        }else{
            System.out.println("Cash In Advance column is not present in the Report");
        }

        src = ts.getScreenshotAs(OutputType.FILE);
        dest = new File(projectPath + "\\Screenshots\\OrangeHRMTravelExpenseDetailedReport.jpg");
        FileUtils.copyFile(src, dest);
        System.out.println("OrangeHRMTravelExpenseDetailedReport screenshot is captured");
    }

    public static void validate_EmployeeInformationalFields(){
        WebElement element = driver.findElement(By.xpath("//span[text()='Employee Id']"));
        String actualEmployeeId = element.getText();
        String expectedEmployeeId = "Employee Id";
        if (actualEmployeeId.equalsIgnoreCase(expectedEmployeeId)) {
            System.out.println("Employee Id column is verified in the Report");
        } else {
            System.out.println("Employee Id column is not present in the Report");
        }

        WebElement element_EmpName = driver.findElement(By.xpath("//span[text()='Employee Name']"));
        String actualEmployeeName = element_EmpName.getText();
        String expectedEmployeeName = "Employee Name";
        if (actualEmployeeName.equalsIgnoreCase(expectedEmployeeName)) {
            System.out.println("Employee Name column is verified in the Report");
        } else {
            System.out.println("Employee Name column is not present in the Report");
        }

        WebElement element_Nationality = driver.findElement(By.xpath("//span[text()='Nationality']"));
        String actualNationality = element_Nationality.getText();
        String expectedNationality = Config_Data.textNationality;
        if (actualNationality.equalsIgnoreCase(expectedNationality)) {
            System.out.println("Nationality column is verified in the Report");
        } else {
            System.out.println("Nationality column is not present in the Report");
        }
    }

    public static void validate_TravelExpenseSummaryReport(){
        WebElement element_ReimbursementCurrency = driver.findElement(By.xpath("//td[text()='Total Estimated Expense (Reimbursement Currency)']"));
        String actualReimbursementCurrency = element_ReimbursementCurrency.getText();
        String expectedReimbursementCurrency= "Total Estimated Expense (Reimbursement Currency)";
        if (actualReimbursementCurrency.equalsIgnoreCase(expectedReimbursementCurrency)) {
            System.out.println("Total Estimated Expense (Reimbursement Currency) column is verified in the Report");
        }else{
            System.out.println("Total Estimated Expense (Reimbursement Currency column is not present in the Report");
        }
    }
}

