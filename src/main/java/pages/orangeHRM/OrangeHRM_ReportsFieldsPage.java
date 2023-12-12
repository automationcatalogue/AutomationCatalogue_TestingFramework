package pages.orangeHRM;

import org.openqa.selenium.By;

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

}
