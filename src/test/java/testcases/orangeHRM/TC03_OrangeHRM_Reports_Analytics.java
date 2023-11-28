package testcases.orangeHRM;

import Utilities.Config;
import Utilities.Config_Data;
import Utilities.ExcelUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.PageLocators;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class TC03_OrangeHRM_Reports_Analytics {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static String sheetName;
    public static int row;

    public static void main(String[] args) throws Exception {

        String projectPath = System.getProperty("user.dir");

        sheetName = "HRM_Reports";
        ExcelUtils.setExcelFilePath(projectPath + "//TestData//Automation_TestData.xlsx");
        row = ExcelUtils.getRowNumber(Config.testID_HRMReports, sheetName);

        driver = new ChromeDriver();
        System.out.println("Browser is launched");

        String projectpath = System.getProperty("user.dir");
        System.out.println(projectpath + "Screenshots");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println("Implicit timeout is given");

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        System.out.println("Webdriver timeout is given");

        driver.get("https://automationteste-trials710.orangehrmlive.com/");
        System.out.println("OrangeHRM Application is loaded");

        driver.manage().window().maximize();
        System.out.println("browser is maximized");

        String title = driver.getTitle();
        System.out.println("Title of the page is :" + title);

        //user name is selected from test data

        String userName = ExcelUtils.getCellData(sheetName, row, Config.col_UserName);
        driver.findElement(PageLocators.usrnmbx).sendKeys(userName);
        System.out.println("UserName is entered as" + userName);

        //password is selected from test data

        String password = ExcelUtils.getCellData(sheetName, row, Config.col_Password);
        driver.findElement(PageLocators.pwdbx).sendKeys(password);
        System.out.println("Password is entered");

        driver.findElement(PageLocators.btn_login).click();
        System.out.println("Login button is clicked");

        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File(projectPath + "\\Screenshots\\Login.jpg");
        FileUtils.copyFile(src, dest);
        System.out.println("login screenshot is captured");

        driver.findElement(PageLocators.reportstxtbx).click();
        System.out.println("reports and analytics is clicked");

        String s1 = driver.getTitle();
        String s2 = Config_Data.Titel1;
        if (s1.equalsIgnoreCase(s2)) {
            System.out.println("Title is Matched and Login is successful");
        } else {
            System.out.println("Title is not Matched and Login is not successful");
        }

        driver.findElement(PageLocators.newreportbtn).click();
        System.out.println("new report is clicked");

        //report type is selected from test data

        String ReportType = ExcelUtils.getCellData(sheetName, row, Config.col_SelectReportType);
        driver.findElement(PageLocators.empinfobtn).click();
        System.out.println("employ add report type drop-down  is clicked");


        List<WebElement> elements_ReportType = driver.findElements(PageLocators.reportsDrpdwn);
        for (WebElement element : elements_ReportType) {
            String Report = element.getText();
            if (Report.equalsIgnoreCase(ReportType)) {
                element.click();
                System.out.println("Add Reports Type drop-down is selected as " + ReportType);
                break;
            }
        }

        //folder is selected from test data

        String SelectFolder = ExcelUtils.getCellData(sheetName, row, Config.col_SelectFolder);
        WebElement element_selectFldr = driver.findElement(PageLocators.selfolderBtn);
        JavascriptExecutor js4 =(JavascriptExecutor) driver;
        js4.executeScript("arguments[0].click();",element_selectFldr);
        System.out.println("select folders is clicked");

        List<WebElement> elements_Folders = driver.findElements(PageLocators.folderDrpdwn);
        for (WebElement element : elements_Folders) {
            String Folder = element.getText();
            if (Folder.equalsIgnoreCase(SelectFolder)) {
                element.click();
                System.out.println("Folder drop-down is selected as " + SelectFolder);
                break;
            }
        }

        WebElement element_nextclick = driver.findElement(PageLocators.nxtBtn1);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element_nextclick);
        System.out.println("next button is clicked");

        //report name is selected from test data

        String ReportName = ExcelUtils.getCellData(sheetName, row, Config.col_ReportName);
        driver.findElement(PageLocators.repnameBtn).sendKeys(ReportName);
        System.out.println("report name is entered as " + ReportName);

        TakesScreenshot ts1 = (TakesScreenshot) driver;
        File src_rep = ts1.getScreenshotAs(OutputType.FILE);
        File dest_rep = new File(projectPath + "\\Screenshots\\reportname.jpg");
        FileUtils.copyFile(src_rep, dest_rep);
        System.out.println("report screenshot is captured");

        wait.until((ExpectedConditions.elementToBeClickable(PageLocators.nxtBtn2))).click();
        System.out.println("next button is clicked");

        if(ReportType.equalsIgnoreCase("Travel and Expense Detailed Report")){
            selectFields_TravelExpenseDetailedReport();

            driver.findElement(PageLocators.backarrowbtn).click();
            System.out.println("one step back button is clicked");
            driver.findElement(PageLocators.searchbx).sendKeys(ReportName);
            System.out.println("clicked on search bar and entered report name");

            validate_TravelExpenseDetailedReport();

        }else if(ReportType.equalsIgnoreCase("Employee Informational Report")){
            selectFields_EmployeeInformationalReport();

            driver.findElement(PageLocators.backarrowbtn).click();
            System.out.println("one step back button is clicked");
            driver.findElement(PageLocators.searchbx).sendKeys(ReportName);
            System.out.println("clicked on search bar and entered report name");
            driver.findElement(By.xpath("//button[@class='btn btn-secondary']")).click();
            System.out.println("clicked on generate button");

            validate_EmployeeInformationalFields();

        }else if(ReportType.equalsIgnoreCase("Travel and Expense Summary Report")){
            selectFields_TravelExpenseSummaryReport();

            driver.findElement(PageLocators.backarrowbtn).click();
            System.out.println("one step back button is clicked");
            driver.findElement(PageLocators.searchbx).sendKeys(ReportName);
            System.out.println("clicked on search bar and entered report name");

            validate_TravelExpenseSummaryReport();
        }

        //driver.quit();
        //System.out.println("browser is closed");


    }

    public static void selectFields_TravelExpenseDetailedReport() throws Exception{
        driver.findElement(PageLocators.trvlreqBtn).click();
        System.out.println("Travel request Id  is selected");

        WebElement element_jobttl = driver.findElement(By.xpath("//label[@for='selectedFilters_job_title']"));
        System.out.println("job title  is selected");
        wait.until(ExpectedConditions.elementToBeClickable(element_jobttl));


        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        System.out.println("window is scrolled to down");

        driver.findElement(PageLocators.nxtBtn3).click();
        System.out.println("next button is clicked");

        //add display fields is selected from test data

        String DisplayFields = ExcelUtils.getCellData(sheetName, row, Config.col_DisplayFields);
        driver.findElement(PageLocators.disfieldBx).click();
        System.out.println("Add display field group is clicked");

        List<WebElement> elements_Displayfields = driver.findElements(PageLocators.displaydrpdwn);
        for (WebElement element : elements_Displayfields) {
            String Folder = element.getText();
            if (Folder.equalsIgnoreCase(DisplayFields)) {
                element.click();
                System.out.println("Display fields dropdown is selected as " + DisplayFields);
                break;
            }
        }

        driver.findElement(PageLocators.slctEstDt).click();
        System.out.println("Travel request Estimation date is selected");

        TakesScreenshot ts2 = (TakesScreenshot) driver;
        File src_trvlreq = ts2.getScreenshotAs(OutputType.FILE);
        File dest_trvlreq = new File("C:projectpath+\\trvlreq_est.jpg");
        FileUtils.copyFile(src_trvlreq, dest_trvlreq);
        System.out.println(" Travel request Estimation date is captured");

        driver.findElement(PageLocators.trvlreqbx).click();
        System.out.println("travel request btn is clicked");

        driver.findElement(PageLocators.cashadvbx).click();
        System.out.println("cash in advance button is clicked");

        driver.findElement(PageLocators.saveBtn).click();
        System.out.println("save button is clicked");
    }
    public static void selectFields_EmployeeInformationalReport() throws Exception{
        WebElement element_EmployeeName = driver.findElement(By.xpath("//input[@id='selectedFilters_employee_name_withgroup']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element_EmployeeName);
        System.out.println("Employee Name check-box is clicked");

        WebElement element_JobTitle = driver.findElement(By.xpath("//input[@id='selectedFilters_job_title_withgroup']"));
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element_JobTitle);
        System.out.println("Job Title checkbox is clicked");


        WebElement element_Location = driver.findElement(By.xpath("//input[@id='selectedFilters_location_withgroup']"));
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element_Location);
        System.out.println("Location checkbox is clicked");

        driver.findElement(By.xpath("//button[text()='Next']")).click();
        System.out.println("Next button is clicked");

        String DisplayFields = ExcelUtils.getCellData(sheetName, row, Config.col_DisplayFields);
        driver.findElement(PageLocators.disfieldBx).click();
        System.out.println("Add display field group is clicked");

        List<WebElement> elements_Displayfields = driver.findElements(PageLocators.displaydrpdwn);
        for (WebElement element : elements_Displayfields) {
            String Folder = element.getText();
            if (Folder.equalsIgnoreCase(DisplayFields)) {
                element.click();
                System.out.println("Display fields dropdown is selected as " + DisplayFields);
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
        System.out.println("Check-box is clicked");


    }

    public static void selectFields_TravelExpenseSummaryReport() throws Exception{

        WebElement element_ClaimStatus = driver.findElement(By.xpath("//label[@for='selectedGroupingField_claim_status']"));
        element_ClaimStatus.click();
        System.out.println("ClaimStatus check-box is clicked");

        WebElement element_CurencyReimbursement = driver.findElement(By.xpath("//label[@for='selectedGroupingField_currency_for_reimbursement']"));
        element_CurencyReimbursement.click();
        System.out.println("Reimbursement Currency (Estimates) check-box is clicked");

        driver.findElement(By.xpath("//button[@class='btn waves-effect waves-light right']")).click();
        System.out.println("Next button is clicked");

        WebElement element_ExpenceClaimID = driver.findElement(By.xpath("//label[@for='selectedFilters_claim_id']"));
        element_ExpenceClaimID.click();
        System.out.println("ExpenceClaimID check-box is clicked");

        WebElement element_ClaimDate = driver.findElement(By.xpath("//label[@for='selectedFilters_claimed_date']"));
        element_ClaimDate.click();
        System.out.println("ClaimDate check-box is clicked");

        WebElement element_Claimstatus = driver.findElement(By.xpath("//label[@for='selectedFilters_claim_status']"));
        element_Claimstatus.click();
        System.out.println("Claimstatus check-box is clicked");

        driver.findElement(By.xpath("//button[@class='btn waves-effect waves-light right']")).click();
        System.out.println("Next button is clicked");

        String DisplayFields = ExcelUtils.getCellData(sheetName, row, Config.col_DisplayFields);
        driver.findElement(PageLocators.disfieldBx).click();
        System.out.println("Add display field group is clicked");

        wait.until((ExpectedConditions.elementToBeClickable(PageLocators.disfieldBx))).click();


        List<WebElement> elements_Displayfields = driver.findElements(PageLocators.displaydrpdwn);
        for (WebElement element : elements_Displayfields) {
            String Folder = element.getText();
            if (Folder.equalsIgnoreCase(DisplayFields)) {
                element.click();
                System.out.println("Display fields dropdown is selected as " + DisplayFields);
                break;
            }
        }

        driver.findElement(By.xpath("//label[text()='Total Estimated Expense (Reimbursement Currency)']")).click();
        System.out.println("Total Estimated Expense (Reimbursement Currency) check-box is clicked");

        WebElement element_Savebtn=driver.findElement(By.xpath("//button[@class='btn waves-effect waves-light']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element_Savebtn);
        System.out.println("Save Check-box is clicked");

    }

    public static void validate_TravelExpenseDetailedReport() throws Exception{
        WebElement element = driver.findElement(PageLocators.texttrvlreq);
        String s3 = element.getText();
        String s4 = Config_Data.texttrvlreq;
        if (s3.equalsIgnoreCase(s4)) {
            System.out.println("text is Matched as travel request ");
        } else {
            System.out.println("Text is not matched");
        }

        TakesScreenshot ts3 = (TakesScreenshot) driver;
        File src_trvltxt = ts3.getScreenshotAs(OutputType.FILE);
        String projectPath = System.getProperty("user.dir");
        File dest_trvltxt = new File(projectPath + "\\Screenshots\\travelreq_text.jpg");
        FileUtils.copyFile(src_trvltxt, dest_trvltxt);
        System.out.println("travel request text screenshot is captured");

        WebElement element_EstDt = driver.findElement(PageLocators.textEstdt);
        String s5 = element_EstDt.getText();
        String s6 = Config_Data.textEstdt;
        if (s5.equalsIgnoreCase(s6)) {
            System.out.println("text is Matched as Estimated Date ");
        } else {
            System.out.println("Text is not matched");
        }

        TakesScreenshot ts4 = (TakesScreenshot) driver;
        File src_Estdt = ts4.getScreenshotAs(OutputType.FILE);
        File dest_Estdt = new File(projectPath + "\\Screenshots\\Estdt_text.jpg");
        FileUtils.copyFile(src_Estdt, dest_Estdt);
        System.out.println("Estimated Date text screenshot is captured");

        WebElement element_Cash = driver.findElement(PageLocators.textCash);
        String s7 = element_Cash.getText();
        String s8 = Config_Data.textCashadv;
        if (s7.equalsIgnoreCase(s8)) {
            System.out.println("text is Matched as Cash in Advance ");
        } else {
            System.out.println("Text is not matched");
        }

        TakesScreenshot ts5 = (TakesScreenshot) driver;
        File src_Cashadv = ts5.getScreenshotAs(OutputType.FILE);
        File dest_Cashadv = new File(projectPath + "\\Screenshots\\Cashadv_text.jpg");
        FileUtils.copyFile(src_Cashadv, dest_Cashadv);
        System.out.println("Estimated Date text screenshot is captured");

        System.out.println("TC03-02 execution is completed");
    }

    public static void validate_EmployeeInformationalFields(){
        WebElement element = driver.findElement(PageLocators.EmpId);
        String s9 = element.getText();
        String s10 = Config_Data.textEmpId;
        if (s9.equalsIgnoreCase(s10)) {
            System.out.println("text is Matched as Employee Id ");
        } else {
            System.out.println("Text is not matched");
        }


        WebElement element_EmpName = driver.findElement(PageLocators.EmpName);
        String s11 = element_EmpName.getText();
        String s12 = Config_Data.textEmpName;
        if (s11.equalsIgnoreCase(s12)) {
            System.out.println("text is Matched as Employee Name");
        } else {
            System.out.println("Text is not matched");
        }

        WebElement element_Nationality = driver.findElement(PageLocators.Nationality);
        String s13 = element_Nationality.getText();
        String s14 = Config_Data.textNationality;
        if (s13.equalsIgnoreCase(s14)) {
            System.out.println("text is Matched as Nationality");
        } else {
            System.out.println("Text is not matched");
            System.out.println("TC03-01 execution completed");
        }


    }

    public static void validate_TravelExpenseSummaryReport(){
        WebElement element_ReimbursementCurrency = driver.findElement(PageLocators.ReimbursementCurrency);
        String s15 = element_ReimbursementCurrency.getText();
        String s16 = Config_Data.textReimbursementCurrency;
        if (s15.equalsIgnoreCase(s16)) {
            System.out.println("text is Matched as ReimbursementCurrency");
        } else {
            System.out.println("Text is not matched");
        }
        System.out.println("TC03-03 execution is completed");


    }
}

