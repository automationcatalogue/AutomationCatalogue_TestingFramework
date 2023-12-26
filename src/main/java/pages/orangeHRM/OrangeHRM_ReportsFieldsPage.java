package pages.orangeHRM;

import Utilities.CommonMethods;
import Utilities.Config;
import Utilities.ExcelUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class OrangeHRM_ReportsFieldsPage {
    public static By chkbx_TravelRequestID = By.xpath("//label[text()='Travel Request ID']");
    public static By chkbx_JobTitle = By.xpath("//label[@for='selectedFilters_job_title']");
    public static By btn_Next = By.xpath("//button[text()='Next']");
    public static By btn_AddDisplayFields = By.cssSelector("#display-group-dropdown-trigger");
    public static By drpdwn_SelectAddDisplayFields = By.xpath("//ul[@id='add-display-group-dropdown']/li");
    public static By chkbx_EstimatedDate = By.xpath("//label[text()='Estimated Date']");
    public static By chbx_CashInAdvance = By.xpath("//label[text()='Cash in Advance']");
    public static By btn_Save = By.xpath("//button[text()='Save']");
    public static By chkbx_EmployeeName = By.xpath("//label[text()='Employee Name ']");
    public static By chkbx_SelectionCriteriaJobtitle = By.xpath("//label[text()='Job Title ']");
    public static By chkbx_Location = By.xpath("//label[text()='Location ']");
    public static By chkbx_EmployeeID = By.xpath("//label[text()='Employee Id']");
    public static By chkbx_PersonalEmployeeName = By.xpath("//label[text()='Employee Name']");
    public static By chkbx_Nationality = By.xpath("//label[text()='Nationality']");
    public static By chkbx_ClaimStatus = By.xpath("//label[text()='Claim Status']");
    public static By chkbx_Reiumbersment = By.xpath("//label[@for='selectedGroupingField_currency_for_reimbursement']");
    public static By btn_TrvlReqSummaryReportNext = By.xpath("//button[@class='btn waves-effect waves-light right']");
    public static By chkbx_ExpenseClaimID = By.xpath("//label[@for='selectedFilters_claim_id']");
    public static By chkbx_ClaimDate = By.xpath("//label[@for='selectedFilters_claimed_date']");
    public static By chkbx_ReiumbersmentCurrency = By.xpath("//label[text()='Total Estimated Expense (Reimbursement Currency)']");

    public static void selectReportType(WebDriver driver, String sheetName, int row, String reportType){

        driver.findElement(OrangeHRM_ReportAnalyticsPage.drpdwn_ReportType).click();
        System.out.println("Report Type drop-down is clicked");

        List<WebElement> elements_ReportType = driver.findElements(OrangeHRM_ReportAnalyticsPage.drpdwn_SelectReportType);
        for (WebElement element_Report : elements_ReportType) {
            String reportName = element_Report.getText();
            if (reportName.equalsIgnoreCase(reportType)) {
                element_Report.click();
                System.out.println(reportName+" is selected as Report Type from drop-down");
                break;
            }
        }
    }

    public static void selectFolder(WebDriver driver, String sheetName, int row){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String folderType = ExcelUtils.getCellData(sheetName, row, Config.col_FolderType);
        WebElement element_selectFolder = driver.findElement(OrangeHRM_ReportAnalyticsPage.drpdwn_FolderType);
        js.executeScript("arguments[0].click();",element_selectFolder);
        System.out.println("Folder drop-down is clicked");

        List<WebElement> elements_Folders = driver.findElements(OrangeHRM_ReportAnalyticsPage.drpdwn_SelectFolderType);
        for (WebElement element_folder : elements_Folders) {
            String folderName = element_folder.getText();
            if (folderName.equalsIgnoreCase(folderType)) {
                element_folder.click();
                System.out.println(folderName+" is selected as Folder Type from drop-down");
                break;
            }
        }
        WebElement element_NextBtn = driver.findElement(OrangeHRM_ReportAnalyticsPage.btn_Next);
        js.executeScript("arguments[0].click();", element_NextBtn);
        System.out.println("Next button is clicked");
    }

    public static void enterReportName(WebDriver driver, String sheetName, int row, String reportName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.findElement(OrangeHRM_ReportAnalyticsPage.txtbx_ReportName).sendKeys(reportName);
        System.out.println("Report Name is entered as " + reportName);
        wait.until((ExpectedConditions.elementToBeClickable(OrangeHRM_ReportAnalyticsPage.btn_ReportsNext))).click();
        System.out.println("Next button is clicked");
    }

    public static void selectFields_TravelExpenseDetailedReport(WebDriver driver, String sheetName, int row) throws Exception{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        JavascriptExecutor js = (JavascriptExecutor)driver;

        wait.until(ExpectedConditions.elementToBeClickable(OrangeHRM_ReportsFieldsPage.chkbx_TravelRequestID));
        driver.findElement(OrangeHRM_ReportsFieldsPage.chkbx_TravelRequestID).click();
        System.out.println("Travel Request Id check-box is selected");

        driver.findElement(OrangeHRM_ReportsFieldsPage.chkbx_JobTitle).click();
        System.out.println("Job Title check-box is selected");

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        System.out.println("window is scrolled down till bottom of the page");

        driver.findElement(OrangeHRM_ReportsFieldsPage.btn_Next).click();
        System.out.println("Next button is clicked");

        //Add Display
        String displayFields = ExcelUtils.getCellData(sheetName, row, Config.col_DisplayFields);
        driver.findElement(OrangeHRM_ReportsFieldsPage.btn_AddDisplayFields).click();
        System.out.println("Add display field button is clicked");

        List<WebElement> elements_DisplayFields = driver.findElements(OrangeHRM_ReportsFieldsPage.drpdwn_SelectAddDisplayFields);
        for (WebElement element_DisplayField : elements_DisplayFields) {
            String fieldName = element_DisplayField.getText();
            if (fieldName.equalsIgnoreCase(displayFields)) {
                element_DisplayField.click();
                System.out.println(fieldName + " is clicked from Display Fields");
                break;
            }
        }

        driver.findElement(OrangeHRM_ReportsFieldsPage.chkbx_EstimatedDate).click();
        System.out.println("Estimated date check-box is selected");

        driver.findElement(OrangeHRM_ReportsFieldsPage.chkbx_TravelRequestID).click();
        System.out.println("Travel Request ID check-box is clicked");

        driver.findElement(OrangeHRM_ReportsFieldsPage.chbx_CashInAdvance).click();
        System.out.println("Cash in Advance check-box is clicked");

        driver.findElement(OrangeHRM_ReportsFieldsPage.btn_Save).click();
        System.out.println("Save button is clicked");
    }
    public static void selectFields_EmployeeInformationalReport(WebDriver driver, String sheetName, int row) throws Exception{
        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement element_EmployeeName = driver.findElement(OrangeHRM_ReportsFieldsPage.chkbx_EmployeeName);
        js.executeScript("arguments[0].click();", element_EmployeeName);
        System.out.println("Employee Name check-box is clicked");

        WebElement element_JobTitle = driver.findElement(OrangeHRM_ReportsFieldsPage.chkbx_SelectionCriteriaJobtitle);
        js.executeScript("arguments[0].click();", element_JobTitle);
        System.out.println("Job Title checkbox is clicked");

        WebElement element_Location = driver.findElement(OrangeHRM_ReportsFieldsPage.chkbx_Location);
        js.executeScript("arguments[0].click();", element_Location);
        System.out.println("Location checkbox is clicked");

        driver.findElement(OrangeHRM_ReportsFieldsPage.btn_Next).click();
        System.out.println("Next button is clicked");

        //Add Display
        String displayFields = ExcelUtils.getCellData(sheetName, row, Config.col_DisplayFields);
        driver.findElement(OrangeHRM_ReportsFieldsPage.btn_AddDisplayFields).click();
        System.out.println("Add display field button is clicked");

        List<WebElement> elements_DisplayFields = driver.findElements(OrangeHRM_ReportsFieldsPage.drpdwn_SelectAddDisplayFields);
        for (WebElement element_DisplayField : elements_DisplayFields) {
            String fieldName = element_DisplayField.getText();
            if (fieldName.equalsIgnoreCase(displayFields)) {
                element_DisplayField.click();
                System.out.println(fieldName + " is clicked from Display Fields");
                break;
            }
        }
        driver.findElement(OrangeHRM_ReportsFieldsPage.chkbx_EmployeeID).click();
        System.out.println("Employee Id check-box is clicked");

        driver.findElement(OrangeHRM_ReportsFieldsPage.chkbx_PersonalEmployeeName).click();
        System.out.println("Employee Name check-box is clicked");

        driver.findElement(OrangeHRM_ReportsFieldsPage.chkbx_Nationality).click();
        System.out.println("Nationality check-box is clicked");

        driver.findElement(OrangeHRM_ReportsFieldsPage.btn_Save).click();
        System.out.println("Save button is clicked");
    }

    public static void selectFields_TravelExpenseSummaryReport(WebDriver driver, String sheetName, int row) throws Exception{
        JavascriptExecutor js = (JavascriptExecutor)driver;
        driver.findElement(OrangeHRM_ReportsFieldsPage.chkbx_ClaimStatus).click();
        System.out.println("ClaimStatus check-box is clicked");

        driver.findElement(OrangeHRM_ReportsFieldsPage.chkbx_Reiumbersment).click();
        System.out.println("Reimbursement Currency (Estimates) check-box is clicked");

        driver.findElement(OrangeHRM_ReportsFieldsPage.btn_TrvlReqSummaryReportNext).click();
        System.out.println("Next button is clicked");

        driver.findElement(OrangeHRM_ReportsFieldsPage.chkbx_ExpenseClaimID).click();
        System.out.println("Expense ClaimID check-box is clicked");

        driver.findElement(OrangeHRM_ReportsFieldsPage.chkbx_ClaimDate).click();
        System.out.println("ClaimDate check-box is clicked");

        driver.findElement(OrangeHRM_ReportsFieldsPage.chkbx_ClaimStatus).click();
        System.out.println("ClaimStatus check-box is clicked");

        driver.findElement(OrangeHRM_ReportsFieldsPage.btn_TrvlReqSummaryReportNext).click();
        System.out.println("Next button is clicked");

        //Add Display
        String displayFields = ExcelUtils.getCellData(sheetName, row, Config.col_DisplayFields);
        driver.findElement(OrangeHRM_ReportsFieldsPage.btn_AddDisplayFields).click();
        System.out.println("Add display field button is clicked");

        List<WebElement> elements_DisplayFields = driver.findElements(OrangeHRM_ReportsFieldsPage.drpdwn_SelectAddDisplayFields);
        for (WebElement element_DisplayField : elements_DisplayFields) {
            String fieldName = element_DisplayField.getText();
            if (fieldName.equalsIgnoreCase(displayFields)) {
                element_DisplayField.click();
                System.out.println(fieldName + " is clicked from Display Fields");
                break;
            }
        }

        driver.findElement(OrangeHRM_ReportsFieldsPage.chkbx_ReiumbersmentCurrency).click();
        System.out.println("Total Estimated Expense (Reimbursement Currency) check-box is clicked");

        WebElement element_SaveBtn=driver.findElement(OrangeHRM_ReportsFieldsPage.btn_Save);
        js.executeScript("arguments[0].click();", element_SaveBtn);
        System.out.println("Save button is clicked");
    }

    public static void validate_TravelExpenseDetailedReport(WebDriver driver, String sheetName, int row) throws Exception{
        WebElement element_TravelRequestID = driver.findElement(OrangeHRM_ValidateReportsFieldsPage.txt_TravelRequestID);
        String actualTravelRequestID = element_TravelRequestID.getText();
        String expectedTravelRequestID = "Travel Request ID";
        if (actualTravelRequestID.equalsIgnoreCase(expectedTravelRequestID)) {
            System.out.println("Travel Request ID column is verified in the Report");
        }else{
            System.out.println("Travel Request ID column is not present in the Report");
        }

        WebElement element_EstimatedDate = driver.findElement(OrangeHRM_ValidateReportsFieldsPage.txt_EstimatedDate);
        String actualEstimatedDate = element_EstimatedDate.getText();
        String expectedEstimatedDate = "Estimated Date";
        if (actualEstimatedDate.equalsIgnoreCase(expectedEstimatedDate)) {
            System.out.println("EstimatedDate column is verified in the Report");
        }else{
            System.out.println("EstimatedDate column is not present in the Report");
        }

        WebElement element_CashInAdvance = driver.findElement(OrangeHRM_ValidateReportsFieldsPage.txt_CashInAdvance);
        String actualCashInAdvance = element_CashInAdvance.getText();
        String expectedCashInAdvance = "Cash in Advance";
        if (actualCashInAdvance.equalsIgnoreCase(expectedCashInAdvance)) {
            System.out.println("Cash In Advance column is verified in the Report");
        }else{
            System.out.println("Cash In Advance column is not present in the Report");
        }

        CommonMethods.takeScreenshot(driver, "OrangeHRMTravelExpenseDetailedReport");
    }

    public static void validate_EmployeeInformationalFields(WebDriver driver){
        WebElement element = driver.findElement(OrangeHRM_ValidateReportsFieldsPage.txt_EmployeeID);
        String actualEmployeeId = element.getText();
        String expectedEmployeeId = "Employee Id";
        if (actualEmployeeId.equalsIgnoreCase(expectedEmployeeId)) {
            System.out.println("Employee Id column is verified in the Report");
        } else {
            System.out.println("Employee Id column is not present in the Report");
        }

        WebElement element_EmpName = driver.findElement(OrangeHRM_ValidateReportsFieldsPage.txt_EmployeeName);
        String actualEmployeeName = element_EmpName.getText();
        String expectedEmployeeName = "Employee Name";
        if (actualEmployeeName.equalsIgnoreCase(expectedEmployeeName)) {
            System.out.println("Employee Name column is verified in the Report");
        } else {
            System.out.println("Employee Name column is not present in the Report");
        }

        WebElement element_Nationality = driver.findElement(OrangeHRM_ValidateReportsFieldsPage.txt_Nationality);
        String actualNationality = element_Nationality.getText();
        String expectedNationality = "Nationality";
        if (actualNationality.equalsIgnoreCase(expectedNationality)) {
            System.out.println("Nationality column is verified in the Report");
        } else {
            System.out.println("Nationality column is not present in the Report");
        }
    }

    public static void validate_TravelExpenseSummaryReport(WebDriver driver){
        WebElement element_ReimbursementCurrency = driver.findElement(OrangeHRM_ValidateReportsFieldsPage.txt_ReiumbersmentCurrency);
        String actualReimbursementCurrency = element_ReimbursementCurrency.getText();
        String expectedReimbursementCurrency= "Total Estimated Expense (Reimbursement Currency)";
        if (actualReimbursementCurrency.equalsIgnoreCase(expectedReimbursementCurrency)) {
            System.out.println("Total Estimated Expense (Reimbursement Currency) column is verified in the Report");
        }else{
            System.out.println("Total Estimated Expense (Reimbursement Currency column is not present in the Report");
        }
    }



}
