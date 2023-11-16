package testcases.orangeHRM;

import Utilities.Config;
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

public class TC05_OrangeHRM_Leave {
    public static void main(String[] args) throws Exception {
        String projectPath = System.getProperty("user.dir");
        String sheetName = "HRM_Leave";
        ExcelUtils.setExcelFilePath(projectPath+"//TestData//Automation_TestData.xlsx");
        int row = ExcelUtils.getRowNumber(Config.testID_HRMLeave,sheetName);

        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        System.out.println("Chrome browser is launched");

        driver.manage().window().maximize();
        System.out.println("Chrome browser is maximized");

        driver.get("https://automationteste-trials710.orangehrmlive.com/");
        System.out.println("Orange HRM Application is loaded");

        String userName = ExcelUtils.getCellData(sheetName, row, Config.col_UserName);
        driver.findElement(By.name("txtUsername")).sendKeys(userName);
        System.out.println("User name is been entered as " + userName);

        String password = ExcelUtils.getCellData(sheetName, row, Config.col_Password);
        driver.findElement(By.id("txtPassword")).sendKeys(password);
        System.out.println("Password is been entered as " + password);

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("Login button is been clicked");

        String title = driver.getTitle();
        if (title.equalsIgnoreCase("Employee Management")) {
            System.out.println("Login is Successful");
        } else {
            System.out.println("Login is not Successful");
        }
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div[4]/div/div/div/ul/li[6]/a[1]/span")).click();
        System.out.println("leave option is clicked");
        try{
            WebElement element_More = driver.findElement(By.xpath("//a[@class='top-level-menu-item '][@data-automation-id='more_menu_child_menu_top_more']"));
            js.executeScript("arguments[0].click();", element_More);
            System.out.println("more option is clicked");
        }catch(Exception e){
            System.out.println("Exception Occurred and More button is not available!!!");
        }
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@data-automation-id='menu_leave_Configure']")).click();
        System.out.println("configure option is clicked");

        WebElement element_configure = driver.findElement(By.xpath("//a[contains(@data-automation-id,'menu_leave_viewWorkingWeekendList')]"));
        js.executeScript("arguments[0].click();", element_configure);

        driver.switchTo().frame("noncoreIframe");
        System.out.println("Switched into iframe");

        WebElement element_add = driver.findElement(By.xpath("//*[@id='addItemBtn']/i"));
        js.executeScript("arguments[0].click();", element_add);
        System.out.println("add option is clicked");

        //driver.switchTo().defaultContent();
        // System.out.println("Exited from the frame");
        String name=ExcelUtils.getCellData(sheetName, row, Config.col_Name);
        driver.findElement(By.xpath("//input[@id='addWorkingWeekend_description']")).sendKeys(name);
        System.out.println("Name is entered");

        WebElement element_date = driver.findElement(By.xpath("/html/body/div[1]/div[2]/section/div/div[3]/div[2]/form/div/div[1]/div[2]/label"));
        js.executeScript("arguments[0].click();", element_date);
        System.out.println("date is clicked");

        String date =ExcelUtils.getCellData(sheetName, row, Config.col_Date);
        String day = date.split("/")[0];
        String month = date.split("/")[1];
        String year = date.split("/")[2];
        driver.findElement(By.xpath("//div[@class='select-wrapper picker__select--year']/input")).click();
        System.out.println("year is clicked");
        Thread.sleep(2000);
        List<WebElement> element_year = driver.findElements(By.xpath("//div[@class='select-wrapper picker__select--year']/ul/li/span"));
        for (WebElement element : element_year) {
            String actualYear = element.getText();
            if (actualYear.equalsIgnoreCase(year)) {
                element.click();
                System.out.println("Year is Selected");
                break;
            }
        }
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='select-wrapper picker__select--month']/input")).click();
        System.out.println("month is clicked");
        wait.until((ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='select-wrapper picker__select--month']/ul/li/span"))));
        List<WebElement> element_month = driver.findElements(By.xpath("//div[@class='select-wrapper picker__select--month']/ul/li/span"));
        for (WebElement element : element_month) {
            String actualmonth = element.getText();
            if (actualmonth.equalsIgnoreCase(month)) {
                element.click();
                System.out.println("month is Selected");
                break;
            }
        }
        Thread.sleep(2000);
        List<WebElement> element_day = driver.findElements(By.xpath("//table[@id='addWorkingWeekend_date_table']/tbody/tr/td/div[contains(@class,'infocus')]"));
        for (WebElement element : element_day) {
            String actualday = element.getText();
            if (actualday.equalsIgnoreCase(day)) {
                element.click();
                System.out.println("day is Selected");
                break;
            }
        }

        driver.findElement(By.xpath("//*[@id='addForm']/div/div[2]/div[1]/div/input")).click();
        System.out.println("hours drop-down is clicked");
        String hours = ExcelUtils.getCellData(sheetName, row, Config.col_Workinghours);
        Thread.sleep(5000);
        if(hours.equalsIgnoreCase("Full Day")){
            js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//label[@for='addWorkingWeekend_length']/..//li[1]/span")));
        }else if(hours.equalsIgnoreCase("Half Day")){
            js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//label[@for='addWorkingWeekend_length']/..//li[2]/span")));
        }else{
            System.out.println("Invalid data is given in Excel sheet");
        }

        List<WebElement> element_hours = driver.findElements(By.xpath("//form[@id='addForm']/div/div[2]/div[1]/div/ul/li/span"));
        for (WebElement element : element_hours) {
            String actualhours = element.getText();
            if (actualhours.equalsIgnoreCase(hours)) {
                element.click();
                System.out.println("hours is Selected");
                break;
            }
        }

        driver.findElement(By.xpath("//form[@id='addForm']/div/div[2]/div[2]/div/input")).click();
        System.out.println("country is clicked");


        String country = ExcelUtils.getCellData(sheetName, row, Config.col_country);
        wait.until((ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@class='dropdown-content select-dropdown active']/li/span"))));
        List<WebElement> allElements = driver.findElements(By.xpath("//ul[@class='dropdown-content select-dropdown active']/li/span"));
        for (WebElement element : allElements) {
            String actualValue = element.getText();
            if (actualValue.equalsIgnoreCase(country)) {
                element.click();
                System.out.println("Selection of the Location drop-down is completed");
                break;
            }
        }
        driver.findElement(By.xpath("//a[@id='saveItemBtn']")).click();
        System.out.println("details are saved");


        }
    }

