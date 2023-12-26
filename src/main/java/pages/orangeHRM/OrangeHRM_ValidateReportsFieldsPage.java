package pages.orangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeHRM_ValidateReportsFieldsPage {
    public static By txt_TravelRequestID = By.xpath("//td[text()='Travel Request ID']");
    public static By txt_EstimatedDate = By.xpath("//td[text()='Estimated Date']");
    public static By txt_CashInAdvance = By.xpath("//td[text()='Cash in Advance']");
    public static By txt_EmployeeID = By.xpath("//span[text()='Employee Id']");
    public static By txt_EmployeeName = By.xpath("//span[text()='Employee Name']");
    public static By txt_Nationality = By.xpath("//span[text()='Nationality']");
    public static By txt_ReiumbersmentCurrency = By.xpath("//td[text()='Total Estimated Expense (Reimbursement Currency)']");

    public static void enterReportDataAndValidate(WebDriver driver, String sheetName, int row, String reportType, String reportName) throws Exception{
        if(reportType.equalsIgnoreCase("Travel and Expense Detailed Report")){
            OrangeHRM_ReportsFieldsPage.selectFields_TravelExpenseDetailedReport(driver, sheetName, row);

            driver.findElement(OrangeHRM_ReportAnalyticsPage.btn_BackArrow).click();
            System.out.println("Back Arrow button is clicked");
            driver.findElement(OrangeHRM_ReportAnalyticsPage.txtbx_Search).sendKeys(reportName);
            System.out.println(reportName + " is entered in Search text-box");

            OrangeHRM_ReportsFieldsPage.validate_TravelExpenseDetailedReport(driver, sheetName, row);
        }else if(reportType.equalsIgnoreCase("Employee Informational Report")){
            OrangeHRM_ReportsFieldsPage.selectFields_EmployeeInformationalReport(driver, sheetName, row);

            driver.findElement(OrangeHRM_ReportAnalyticsPage.btn_BackArrow).click();
            System.out.println("Back Arrow button is clicked");
            driver.findElement(OrangeHRM_ReportAnalyticsPage.txtbx_Search).sendKeys(reportName);
            System.out.println(reportName + " is entered in Search text-box");

            OrangeHRM_ReportsFieldsPage.validate_EmployeeInformationalFields(driver);

        }else if(reportType.equalsIgnoreCase("Travel and Expense Summary Report")){
            OrangeHRM_ReportsFieldsPage.selectFields_TravelExpenseSummaryReport(driver, sheetName, row);

            driver.findElement(OrangeHRM_ReportAnalyticsPage.btn_BackArrow).click();
            System.out.println("Back Arrow button is clicked");
            driver.findElement(OrangeHRM_ReportAnalyticsPage.txtbx_Search).sendKeys(reportName);
            System.out.println(reportName + " is entered in Search text-box");

            OrangeHRM_ReportsFieldsPage.validate_TravelExpenseSummaryReport(driver);
        }
    }


}
