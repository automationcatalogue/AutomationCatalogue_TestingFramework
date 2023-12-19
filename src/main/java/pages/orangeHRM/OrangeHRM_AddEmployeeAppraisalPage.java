package pages.orangeHRM;

import org.openqa.selenium.By;

public class OrangeHRM_AddEmployeeAppraisalPage {

    public static By txtbx_EmpName= By.cssSelector("input[name='employeeAppraisal[emp_name][empName]']");
    public static By drpdwn_EmpName = By.xpath("//div[@class='autoComplete-title']/strong");
    public static By txtbx_Description = By.cssSelector("#employeeAppraisal_description");
    public static By drpdwn_AppraisalCycle = By.xpath("//div[@class='select-wrapper']");
    public static By appraisalCycle (String appraisalCycle){
        return By.xpath("//label[text()='Appraisal Cycle']/..//ul//span[text()='" + appraisalCycle + "']");
    }
    public static By txtbx_Template = By.xpath("//input[@id='employeeAppraisal_headerTemplate_headerName']");
    public static By from_Date = By.cssSelector("#date_from");
    public static By drpdwn_FromMonth = By.xpath("//div[@class='select-wrapper picker__select--month']");
    public static By fromMonth = By.xpath("//div[@class='select-wrapper picker__select--month']/ul/li/span");
    public static By drpdwn_FromYear = By.xpath("//div[@class='select-wrapper picker__select--year']");
    public static By fromyear = By.xpath("//div[@class='select-wrapper picker__select--year']/ul/li/span");
    public static By fromDate = By.xpath("(//table[@class='picker__table'])[1]/tbody/tr/td/div[contains(@class,'infocus')]");
    public static By calendar_ToDate = By.cssSelector("#date_to");
    public static By drpdwn_ToMonth = By.xpath("(//div[@class='select-wrapper picker__select--month'])[2]");
    public static By toMonth = By.xpath("(//div[@class='select-wrapper picker__select--month'])[2]/ul/li/span");
    public static By drpdwn_Toyear = By.xpath("(//div[@class='select-wrapper picker__select--year'])[2]");
    public static By toYear = By.xpath("(//div[@class='select-wrapper picker__select--year'])[2]/ul/li/span");
    public static By toDate = By.xpath("(//table[@class='picker__table'])[2]/tbody/tr/td/div[contains(@class,'infocus')]");
    public static By drpdwn_DueDate = By.cssSelector("#date_due");
    public static By drpdwn_DueMonth = By.xpath("(//div[@class='select-wrapper picker__select--month'])[3]");
    public static By dueMonth = By.xpath("(//div[@class='select-wrapper picker__select--month'])[3]/ul/li/span");
    public static By drpdwn_Dueyear = By.xpath("(//div[@class='select-wrapper picker__select--year'])[3]");
    public static By dueYear = By.xpath("(//div[@class='select-wrapper picker__select--year'])[3]/ul/li/span");
    public static By dueDate = By.xpath("(//table[@class='picker__table'])[3]/tbody/tr/td/div[contains(@class,'infocus')]");
    public static By btn_Next = By.cssSelector("#saveBtn");




}
