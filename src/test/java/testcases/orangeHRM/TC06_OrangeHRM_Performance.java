package testcases.orangeHRM;

import Utilities.Config;
import Utilities.Config_Data;
import Utilities.ExcelUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.PageLocators;

import java.time.Duration;
import java.util.List;

public class TC06_OrangeHRM_Performance {
    public static void main(String[] args) throws Exception {
        String projectPath = System.getProperty("user.dir");
        String sheetName = "HRM_Performance";
        ExcelUtils.setExcelFilePath(projectPath+"//TestData//Automation_TestData.xlsx");
        int row = ExcelUtils.getRowNumber(Config.testID_HRM_Performance,sheetName);

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        driver.manage().window().maximize();

        driver.get("https://automationteste-trials710.orangehrmlive.com/");
        System.out.println("Orange HRM Website loaded successfully");

        String userName = ExcelUtils.getCellData(sheetName, row, Config.col_UserName);
        driver.findElement(PageLocators.txtbx_userName).sendKeys(userName);
        System.out.println("Username entered");

        String password = ExcelUtils.getCellData(sheetName, row, Config.col_Password);
        driver.findElement(PageLocators.txtbx_pass).sendKeys(password);
        System.out.println("Password entered");

        driver.findElement(PageLocators.butt_Login).submit();
        String s1 = driver.getTitle();
        System.out.println(s1);
        if (s1.equalsIgnoreCase("Employee Management")) {
            System.out.println("Page logged in successfully");
        } else {
            System.out.println("Page logged in failed");
        }

        WebElement performLoc = driver.findElement(PageLocators.perfor_Tab);
        js.executeScript("arguments[0].click();", performLoc);
        System.out.println("Performance tab clicked");

        wait.until(ExpectedConditions.elementToBeClickable(PageLocators.add_Appraisal));
        WebElement element_AddAppraisal = driver.findElement(PageLocators.add_Appraisal);
        js.executeScript("arguments[0].click();",element_AddAppraisal);
        System.out.println("Add Appraisal clicked");

        //Thread.sleep(6000);
        driver.switchTo().frame("noncoreIframe");
        System.out.println("Switched into iframe");

        String empName = ExcelUtils.getCellData(sheetName, row, Config.col_Performance_EmployeeName);
        driver.findElement(PageLocators.txtbx_Employee).sendKeys(empName);
        System.out.println("Employee name is entered");

        //Thread.sleep(2000);
        WebElement name = driver.findElement(PageLocators.empName);
        js.executeScript("arguments[0].click();", name);
        System.out.println("Employee is clicked");

        String description = ExcelUtils.getCellData(sheetName, row, Config.col_Performance_Description);
        driver.findElement(PageLocators.description).sendKeys(description);
        System.out.println("Performance test case entered");

        //Thread.sleep(2000);
        driver.findElement(PageLocators.durationDropdown).click();
        System.out.println("Duration Dropdown clicked");
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("(//label[text()='Appraisal Cycle']/..//ul//span[text()])[1]"),"-- Select --"));

        String appraisalCycle = ExcelUtils.getCellData(sheetName, row, Config.col_Performance_AppraisalCycle);
        driver.findElement(By.xpath("//label[text()='Appraisal Cycle']/..//ul//span[text()='"+appraisalCycle+"']")).click();
        System.out.println(appraisalCycle + " is selected from Appraisal Cycle drop-down");

        //Thread.sleep(2000);
        driver.findElement(PageLocators.dateFrom).click();
        System.out.println("date from clicked");

        String from_Date = ExcelUtils.getCellData(sheetName, row, Config.col_Performance_FromDate);
        String fromdate = from_Date.split("-")[0];
        String frommonth = from_Date.split("-")[1];
        String fromyear = from_Date.split("-")[2];

        //Thread.sleep(2000);
        driver.findElement(PageLocators.fromMonth).click();
        System.out.println("Month dropdown clicked");

        //Thread.sleep(2000);
        List<WebElement> list_months = driver.findElements(PageLocators.fromMonth1);
        for(WebElement element_month: list_months){
            String actualMonth = element_month.getText();
            if(actualMonth.equalsIgnoreCase(frommonth)){
                element_month.click();
                System.out.println(actualMonth+" is selected as Month for FromDate");
                break;
            }
        }

        //Thread.sleep(2000);
        driver.findElement(PageLocators.fromYear).click();
        System.out.println("Year dropdown clicked");

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(PageLocators.fromYear1));
        List<WebElement> list_years = driver.findElements(PageLocators.fromYear1);
        for(WebElement element_year:list_years){
            String actualYear = element_year.getText();
            if(actualYear.equalsIgnoreCase(fromyear)){
                element_year.click();
                System.out.println(actualYear+" is selected as Year for FromDate");
                break;
            }
        }

        //Thread.sleep(2000);
        List<WebElement> list_dates= driver.findElements(PageLocators.fromDate);
        for(WebElement element_date:list_dates){
            String actualDate = element_date.getText();
            if(actualDate.equalsIgnoreCase(fromdate)){
                element_date.click();
                System.out.println(actualDate+" is selected as Date for FromDate");
                break;
            }
        }


        //Thread.sleep(2000);
        driver.findElement(PageLocators.toDatedrop).click();
        System.out.println("To date dropdown clicked");


        String to_Date = ExcelUtils.getCellData(sheetName, row, Config.col_Performance_ToDate);
        String toDate = to_Date.split("-")[0];
        String toMonth = to_Date.split("-")[1];
        String toYear = to_Date.split("-")[2];

        //Thread.sleep(2000);
        driver.findElement(PageLocators.toMonth).click();
        System.out.println("Month dropdown clicked");

        //Thread.sleep(2000);
        List<WebElement> month1 = driver.findElements(PageLocators.toMonth1);
        for(WebElement months: month1){
            String s6 = months.getText();
            if(s6.equalsIgnoreCase(toMonth)){
                months.click();
                System.out.println(s6+" Month is selected");
                break;
            }
        }


        //Thread.sleep(2000);
        driver.findElement(PageLocators.toYear).click();
        System.out.println("Year dropdown clicked");

        //Thread.sleep(2000);
        List<WebElement> year1 = driver.findElements(PageLocators.toYear1);
        for(WebElement yearsSelect:year1){
            String s7 = yearsSelect.getText();
            if(s7.equalsIgnoreCase(toYear)){
                yearsSelect.click();
                System.out.println(s7+" Year selected");
                break;
            }
        }


        //Thread.sleep(2000);
        List<WebElement> date1= driver.findElements(PageLocators.toDate);
        for(WebElement dateSelect:date1){
            String s8 = dateSelect.getText();
            if(s8.equalsIgnoreCase(toDate)){
                dateSelect.click();
                System.out.println(s8+" To date from table is selected");
                break;
            }
        }


        driver.findElement(PageLocators.dueDateDrop).click();
        System.out.println("Due date dropdown clicked");


        String due_Date = ExcelUtils.getCellData(sheetName, row, Config.col_Performance_DueDate);
        String dueDate = due_Date.split("-")[0];
        String dueMonth = due_Date.split("-")[1];
        String dueYear = due_Date.split("-")[2];


        driver.findElement(PageLocators.dueMonth).click();
        System.out.println("Month due date dropdown clicked");

        //Thread.sleep(2000);
        List<WebElement> month2 = driver.findElements(PageLocators.dueMonth1);
        for(WebElement months: month2){
            String s9 = months.getText();
            if(s9.equalsIgnoreCase(dueMonth)){
                months.click();
                System.out.println(s9+" Month is selected");
                break;
            }
        }


        //Thread.sleep(2000);
        driver.findElement(PageLocators.dueYear).click();
        System.out.println("Year due date dropdown clicked");

        //Thread.sleep(2000);
        List<WebElement> year2 = driver.findElements(PageLocators.dueYear1);
        for(WebElement yearsSelect:year2){
            String s10 = yearsSelect.getText();
            if(s10.equalsIgnoreCase(dueYear)){
                yearsSelect.click();
                System.out.println(s10+" Year due date selected");
                break;
            }
        }


        //Thread.sleep(2000);
        List<WebElement> date2= driver.findElements(PageLocators.dueDate);
        for(WebElement dateSelect:date2){
            String s11 = dateSelect.getText();
            if(s11.equalsIgnoreCase(dueDate)){
                dateSelect.click();
                System.out.println("Due date from table is selected");
                break;
            }
        }


        //Thread.sleep(2000);
        driver.findElement(PageLocators.nextButton).click();
        System.out.println("Next Button clicked");

        //Thread.sleep(2000);
        driver.findElement(PageLocators.appraisal).click();
        System.out.println("Self appraisal box checked ");

        //Thread.sleep(2000);
        driver.findElement(PageLocators.nextButton1).click();
        System.out.println("Next button in Evaluator Page Clicked");


        driver.findElement(PageLocators.final_Review).click();
        System.out.println("Final review dropdown clicked");

        driver.findElement(PageLocators.butt_Submit).click();
        System.out.println("Submit clicked");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='dialogSubmitBtn']")));
        WebElement element = driver.findElement(By.xpath("//a[@id='dialogSubmitBtn']"));
        js.executeScript("arguments[0].click()",element);
        System.out.println("Ok button clicked in Alert window");

        WebElement element_HRAdministration = driver.findElement(By.xpath("(//span[text()='HR Administration'])[1]"));
        js.executeScript("arguments[0].click()",element_HRAdministration);
        System.out.println("HR Administration link is clicked");

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//list/table//tbody/tr/td[4]//span")));
        List<WebElement> list_EmployeeNames = driver.findElements(By.xpath("//list/table//tbody/tr/td[4]//span"));
        String userName_Employee ="";
        for (WebElement element_EmployeeName: list_EmployeeNames){
            String actualEmployeeName = element_EmployeeName.getText();
            if (actualEmployeeName.equalsIgnoreCase(empName)){
                userName_Employee = element_EmployeeName.findElement(By.xpath("./../..//preceding-sibling::td[2]//span")).getText();
                element_EmployeeName.findElement(By.xpath("./../..//following-sibling::td[4]/i")).click();
                System.out.println(userName_Employee+" Edit button is clicked");
                break;
            }
        }

        ExcelUtils.setCellData(userName_Employee, sheetName, row, Config.col_Performance_UserName_Employee);
        System.out.println(userName_Employee+" is written in the Excel file for a UserNameEmployee");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='changepassword']/span")));
        driver.findElement(By.xpath("//label[@for='changepassword']/span")).click();
        System.out.println("Change Password check-box is clicked");

        //Password and confirm password
        String newUserPassword = ExcelUtils.getCellData(sheetName, row, Config.col_Performance_UserName_Password);
        driver.findElement(By.id("password")).sendKeys(newUserPassword);
        System.out.println("New user Password is been entered as "+newUserPassword);

        String newUserConfirmPassword = ExcelUtils.getCellData(sheetName, row, Config.col_Performance_UserName_ConfirmPassword);
        driver.findElement(By.cssSelector("#confirmpassword")).sendKeys(newUserConfirmPassword);
        System.out.println("Confirm New Password is been confirmed as "+newUserConfirmPassword);

        driver.findElement(By.xpath("//button[@id='modal-save-button']")).click();
        System.out.println("Save button is been clicked");

        driver.switchTo().defaultContent();
        System.out.println("Exits from the frame!!!");

        //Logout from the Application
        driver.findElement(By.xpath("//span[text()='Log Out']")).click();
        System.out.println("Logout is successfully done from the Website");

        driver.findElement(PageLocators.txtbx_userName).sendKeys(userName_Employee);
        System.out.println(userName_Employee + " is entered as Username");

        String userPassword = ExcelUtils.getCellData(sheetName, row, Config.col_Performance_UserName_Password);
        driver.findElement(PageLocators.txtbx_pass).sendKeys(userPassword);
        System.out.println("Password entered");

        driver.findElement(PageLocators.butt_Login).submit();
        String actualTitle = driver.getTitle();
        if (actualTitle.equalsIgnoreCase("Employee Management")) {
            System.out.println("Page logged in successfully");
        } else {
            System.out.println("Page logged in failed");
        }

        WebElement link_Performance = driver.findElement(PageLocators.perfor_Tab);
        js.executeScript("arguments[0].click();", link_Performance);
        System.out.println("Performance tab clicked");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-automation-id='menu_performance_viewMyAppraisals']")));
        WebElement link_MyAppraisal = driver.findElement(By.xpath("//a[@data-automation-id='menu_performance_viewMyAppraisals']"));
        js.executeScript("arguments[0].click()",link_MyAppraisal);
        System.out.println("My Appraisal link is clicked");

        //Validating the Description
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//list/table//tbody/tr[1]/td[6]//span")));
        String actualDescription = driver.findElement(By.xpath("//list/table//tbody/tr[1]/td[6]//span")).getText();
        if(actualDescription.equalsIgnoreCase(description)){
            System.out.println("Description data is matched");
        }else{
            System.out.println("Description data is not matched");
        }

        //Validating the Appraisal Status
        String actualAppraisalStatus = driver.findElement(By.xpath("//list/table//tbody/tr[1]/td[7]//span")).getText();
        if(actualAppraisalStatus.equalsIgnoreCase("COMPLETED")){
            System.out.println("Appraisal Status is COMPLETED");
        }else{
            System.out.println("Appraisal Status is not COMPLETED");
        }

        driver.findElement(By.xpath("//span[text()='Log Out']")).click();
        System.out.println("Logout is successfully done from the Website");

       // driver.quit();




    }
}
