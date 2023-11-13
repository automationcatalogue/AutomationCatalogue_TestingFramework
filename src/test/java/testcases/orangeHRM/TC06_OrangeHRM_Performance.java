package testcases.orangeHRM;

import Utilities.Config_Data;
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

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        JavascriptExecutor js = (JavascriptExecutor)driver;

        driver.get("https://automationteste-trials710.orangehrmlive.com/");
        System.out.println("Orange HRM Website loaded successfully");

        driver.findElement(PageLocators.txtbx_userName).sendKeys(Config_Data.userName);
        System.out.println("Username entered");

        driver.findElement(PageLocators.txtbx_pass).sendKeys(Config_Data.pass);
        System.out.println("Password entered");

        driver.findElement(PageLocators.butt_Login).submit();
        String s1 = driver.getTitle();
        System.out.println(s1);
        if (s1.equalsIgnoreCase(Config_Data.pageName)) {
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

        driver.findElement(PageLocators.txtbx_Employee).sendKeys(Config_Data.employeeName);
        System.out.println("Employee name is clicked and text aar is entered");

        //Thread.sleep(2000);
        WebElement name = driver.findElement(PageLocators.empName);
        js.executeScript("arguments[0].click();", name);
        System.out.println("Aaron Hamilton clicked");

        driver.findElement(PageLocators.description).sendKeys(Config_Data.description);
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
                appraisalCycle.click();
                break;
            }
        }
        System.out.println("End Year Review 2018- HR Executive is Selected");

        //Thread.sleep(2000);
        driver.findElement(PageLocators.dateFrom).click();
        System.out.println("date from clicked");

        //Thread.sleep(2000);
        driver.findElement(PageLocators.fromMonth).click();
        System.out.println("Month dropdown clicked");

        //Thread.sleep(2000);
        List<WebElement> month = driver.findElements(PageLocators.fromMonth1);
        for(WebElement months: month){
            String s3 = months.getText();
            if(s3.equalsIgnoreCase("January")){
                months.click();
                break;
            }
        }
        System.out.println("Month is selected");

        //Thread.sleep(2000);
        driver.findElement(PageLocators.fromYear).click();
        System.out.println("Year dropdown clicked");

        //Thread.sleep(2000);
        List<WebElement> year = driver.findElements(PageLocators.fromYear1);
        for(WebElement yearsSelect:year){
            String s4 = yearsSelect.getText();
            if(s4.equalsIgnoreCase("2022")){
                yearsSelect.click();
                break;
            }
        }
        System.out.println("Year selected");

        //Thread.sleep(2000);
        List<WebElement> date= driver.findElements(PageLocators.fromDate);
        for(WebElement dateSelect:date){
            String s5 = dateSelect.getText();
            if(s5.equalsIgnoreCase("6")){
                dateSelect.click();
                break;
            }
        }
        System.out.println("date is selected");

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

        //Thread.sleep(4000);
        driver.quit();




    }
}
