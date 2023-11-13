package testcases.orangeHRM;

import Utilities.Config;
import Utilities.Config_Data;
import Utilities.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='material-icons' and text()='add']")));
        WebElement element_AddAppraisal = driver.findElement(PageLocators.add_Appraisal);
        js.executeScript("arguments[0].click();",element_AddAppraisal);
        System.out.println("Add Appraisal clicked");

        //Thread.sleep(6000);
        driver.switchTo().frame("noncoreIframe");
        System.out.println("Switched into iframe");

        String empName = ExcelUtils.getCellData(sheetName, row, Config.col_Performance_EmployeeName);
        driver.findElement(PageLocators.txtbx_Employee).sendKeys(empName);
        System.out.println("Employee name is clicked and text aar is entered");

        //Thread.sleep(2000);
        WebElement name = driver.findElement(PageLocators.empName);
        js.executeScript("arguments[0].click();", name);
        System.out.println("Aaron Hamilton clicked");

        String description = ExcelUtils.getCellData(sheetName, row, Config.col_Performance_Description);
        driver.findElement(PageLocators.description).sendKeys(description);
        System.out.println("Performance test case entered");

        //Thread.sleep(2000);
        driver.findElement(PageLocators.durationDropdown).click();
        System.out.println("Duration Dropdown clicked");

        //Thread.sleep(2000);
        //driver.findElement(By.xpath("//div[@class='select-wrapper']/ul/li/span[text()='End Year Review 2018- HR Executive']")).click();
        List<WebElement> cycleDropdown = driver.findElements(PageLocators.timePeriod);
        for (WebElement appraisalCycle : cycleDropdown) {
            String s2 = appraisalCycle.getText();
            if(s2.equalsIgnoreCase("End Year Review 2018- HR Executive")){
                js.executeScript("arguments[0].click();", appraisalCycle);
                break;
            }
        }
        System.out.println("End Year Review 2018- HR Executive is Selected");

        //Thread.sleep(2000);
        driver.findElement(PageLocators.dateFrom).click();
        System.out.println("date from clicked");

        String fromDate = ExcelUtils.getCellData(sheetName, row, Config.col_Performance_FromDate);
        String date = fromDate.split("-")[0];
        String month = fromDate.split("-")[1];
        String year = fromDate.split("-")[2];

        //Thread.sleep(2000);
        driver.findElement(PageLocators.fromMonth).click();
        System.out.println("Month dropdown clicked");

        //Thread.sleep(2000);
        List<WebElement> list_months = driver.findElements(PageLocators.fromMonth1);
        for(WebElement element_month: list_months){
            String actualMonth = element_month.getText();
            if(actualMonth.equalsIgnoreCase(month)){
                element_month.click();
                System.out.println(actualMonth+" is selected as Month for FromDate");
                break;
            }
        }

        //Thread.sleep(2000);
        driver.findElement(PageLocators.fromYear).click();
        System.out.println("Year dropdown clicked");

        //Thread.sleep(2000);
        List<WebElement> list_years = driver.findElements(PageLocators.fromYear1);
        for(WebElement element_year:list_years){
            String actualYear = element_year.getText();
            if(actualYear.equalsIgnoreCase(year)){
                element_year.click();
                System.out.println(actualYear+" is selected as Year for FromDate");
                break;
            }
        }

        //Thread.sleep(2000);
        List<WebElement> list_dates= driver.findElements(PageLocators.fromDate);
        for(WebElement element_date:list_dates){
            String actualDate = element_date.getText();
            if(actualDate.equalsIgnoreCase(date)){
                element_date.click();
                System.out.println(actualDate+" is selected as Date for FromDate");
                break;
            }
        }


        //Thread.sleep(2000);
        driver.findElement(PageLocators.toDatedrop).click();
        System.out.println("To date dropdown clicked");

        //Thread.sleep(2000);
        driver.findElement(PageLocators.toMonth).click();
        System.out.println("Month dropdown clicked");

        //Thread.sleep(2000);
        List<WebElement> month1 = driver.findElements(PageLocators.toMonth1);
        for(WebElement months: month1){
            String s6 = months.getText();
            if(s6.equalsIgnoreCase("March")){
                months.click();
                break;
            }
        }
        System.out.println("Month is selected");

        //Thread.sleep(2000);
        driver.findElement(PageLocators.toYear).click();
        System.out.println("Year dropdown clicked");

        //Thread.sleep(2000);
        List<WebElement> year1 = driver.findElements(PageLocators.toYear1);
        for(WebElement yearsSelect:year1){
            String s7 = yearsSelect.getText();
            if(s7.equalsIgnoreCase("2023")){
                yearsSelect.click();
                break;
            }
        }
        System.out.println("Year selected");

        //Thread.sleep(2000);
        List<WebElement> date1= driver.findElements(PageLocators.toDate);
        for(WebElement dateSelect:date1){
            String s8 = dateSelect.getText();
            if(s8.equalsIgnoreCase("8")){
                dateSelect.click();
                break;
            }
        }
        System.out.println("To date from table is selected");

        driver.findElement(PageLocators.dueDateDrop).click();
        System.out.println("Due date dropdown clicked");

        driver.findElement(PageLocators.dueMonth).click();
        System.out.println("Month due date dropdown clicked");

        //Thread.sleep(2000);
        List<WebElement> month2 = driver.findElements(PageLocators.dueMonth1);
        for(WebElement months: month2){
            String s9 = months.getText();
            if(s9.equalsIgnoreCase("December")){
                months.click();
                break;
            }
        }
        System.out.println("Month is selected");

        //Thread.sleep(2000);
        driver.findElement(PageLocators.dueYear).click();
        System.out.println("Year due date dropdown clicked");

        //Thread.sleep(2000);
        List<WebElement> year2 = driver.findElements(PageLocators.dueYear1);
        for(WebElement yearsSelect:year2){
            String s10 = yearsSelect.getText();
            if(s10.equalsIgnoreCase("2023")){
                yearsSelect.click();
                break;
            }
        }
        System.out.println("Year due date selected");

        //Thread.sleep(2000);
        List<WebElement> date2= driver.findElements(PageLocators.dueDate);
        for(WebElement dateSelect:date2){
            String s11 = dateSelect.getText();
            if(s11.equalsIgnoreCase("10")){
                dateSelect.click();
                break;
            }
        }
        System.out.println("Due date from table is selected");

        //Thread.sleep(2000);
        driver.findElement(PageLocators.nextButton).click();
        System.out.println("Next Button clicked");

        //Thread.sleep(2000);
        driver.findElement(PageLocators.appraisal).click();
        System.out.println("Self appraisal box checked ");

        //Thread.sleep(2000);
        driver.findElement(PageLocators.nextButton1).click();
        System.out.println("Next button in Evaluator Page Clicked");


        //Select the Jaquline drop-down and click on Submit
        //Go back to the Appraisal List link
        //Validate EMployeeName, Description and Appraisal Status


        //Thread.sleep(4000);
        driver.quit();




    }
}
