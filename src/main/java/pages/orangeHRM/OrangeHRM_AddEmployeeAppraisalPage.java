package pages.orangeHRM;

import Utilities.BaseClass;
import Utilities.Config;
import Utilities.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class OrangeHRM_AddEmployeeAppraisalPage extends BaseClass {

    public OrangeHRM_AddEmployeeAppraisalPage(WebDriver driver){
        super(driver);
    }

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


    public static void enterAddAppraisalEmployeeDetails(String empName, String description, String appraisalCycle){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Config.explicitTimeOut));

        driver.switchTo().frame("noncoreIframe");
        System.out.println("Switched into iframe");

        driver.findElement(OrangeHRM_AddEmployeeAppraisalPage.txtbx_EmpName).sendKeys(empName);
        System.out.println(empName + "Employee name is entered");

        WebElement name = driver.findElement(OrangeHRM_AddEmployeeAppraisalPage.drpdwn_EmpName);
        js.executeScript("arguments[0].click();", name);
        System.out.println("Employee Name is selected from pop-up");

        driver.findElement(OrangeHRM_AddEmployeeAppraisalPage.txtbx_Description).sendKeys(description);
        System.out.println(description + " is entered as Description");

        driver.findElement(OrangeHRM_AddEmployeeAppraisalPage.drpdwn_AppraisalCycle).click();
        System.out.println("Duration drop-down clicked");
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("(//label[text()='Appraisal Cycle']/..//ul//span[text()])[1]"), "-- Select --"));

        driver.findElement(OrangeHRM_AddEmployeeAppraisalPage.appraisalCycle(appraisalCycle)).click();
        System.out.println(appraisalCycle + " is selected from Appraisal Cycle drop-down");
    }

    public static void selectFromDate(String fromDate){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Config.explicitTimeOut));
        driver.findElement(OrangeHRM_AddEmployeeAppraisalPage.from_Date).click();
        System.out.println("Date from calendar is clicked");

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
    }

    public static void selectToDate(String toDate){
        driver.findElement(OrangeHRM_AddEmployeeAppraisalPage.calendar_ToDate).click();
        System.out.println("To Date Calendar clicked");

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
    }

    public static void selectDueDate(String dueDate){
        driver.findElement(OrangeHRM_AddEmployeeAppraisalPage.drpdwn_DueDate).click();
        System.out.println("Due Date drop-down clicked");

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
    }

}
