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

import java.time.Duration;
import java.util.List;

public class TC04_OrangeHRM_Attendance {
    public static void main(String[] args) throws Exception {
        String projectPath = System.getProperty("user.dir");
        String sheetName = "HRM_Attendance";
        ExcelUtils.setExcelFilePath(projectPath+"//TestData//Automation_TestData.xlsx");
        int row = ExcelUtils.getRowNumber(Config.testID_HRM_Attendance,sheetName);

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.manage().window().maximize();

        driver.get("https://automationteste-trials710.orangehrmlive.com/");
        System.out.println("OrangeHRM Application is loaded");

        String title = driver.getTitle();
        System.out.println("Title of the page is :"+title);

        String userName = ExcelUtils.getCellData(sheetName, row, Config.col_UserName);
        driver.findElement(By.name("txtUsername")).sendKeys(userName);
        System.out.println(userName + " is entered");

        String password = ExcelUtils.getCellData(sheetName, row, Config.col_Password);
        driver.findElement(By.id("txtPassword")).sendKeys(password);
        System.out.println(password + " is entered");

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("Login button is clicked");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Employee Management']")));
        WebElement Attendance = driver.findElement(By.xpath("(//div[@id='menu-content']/ul/li[8]/a/span)[1]"));
        js.executeScript("arguments[0].click();", Attendance);
        System.out.println("Attendance is clicked");

        String s3 = driver.getTitle();
        String s4 = "Attendance";
        if(s3.equalsIgnoreCase(s4)){
            System.out.println("Title is Matched and Login is successful");
        }else{
            System.out.println("Title is not Matched and Login is not successful");
        }

        driver.findElement(By.xpath("//top-level-menu-item[@automation-id='menu_attendance_punchIn']/div/a")).click();
        System.out.println("Punch In/Out is clicked");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='attendanceMyPunchInOutDiv']")));

        WebElement Date_Range = driver.findElement(By.xpath("(//sf-decorator[@form='item'])[1]/div/span[1]/span[1]/i"));
        js.executeScript("arguments[0].click();", Date_Range);
        System.out.println("Date range is selected");

        String day = "01/June/2020";
        String date = day.split("/")[0];
        String month = day.split("/")[1];
        String year = day.split("/")[2];


        WebElement Year = driver.findElement(By.xpath("//div[@class='select-wrapper picker__select--year']/input"));
        js.executeScript("arguments[0].click();", Year);
        System.out.println("Year is clicked");

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='select-wrapper picker__select--year']/ul/li/span")));

        List<WebElement> allElementsYear = driver.findElements(By.xpath("//div[@class='select-wrapper picker__select--year']/ul/li/span"));
        for(WebElement element:allElementsYear){
            String actualValue = element.getText();
            if(actualValue.equalsIgnoreCase(year)){
                element.click();
                break;
            }
        }
        System.out.println("Year is selected:"+year);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select-wrapper picker__select--month']/input[@class='select-dropdown']")));
        WebElement Month = driver.findElement(By.xpath("//div[@class='select-wrapper picker__select--month']/input[@class='select-dropdown']"));
        js.executeScript("arguments[0].click();", Month);
        System.out.println("Month is clicked");

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='select-wrapper picker__select--month']/ul/li/span")));

        List<WebElement> allElementsMonth = driver.findElements(By.xpath("//div[@class='select-wrapper picker__select--month']/ul/li/span"));
        for(WebElement element:allElementsMonth){
            String actualValue = element.getText();
            if(actualValue.equalsIgnoreCase(month)){
                element.click();
                break;
            }
        }
        System.out.println("Month is selected:"+month);

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//table[@class='picker__table'])[1]/tbody/tr/td/div[contains(@class,'infocus')]")));

        List<WebElement> allElementsDates = driver.findElements(By.xpath("(//table[@class='picker__table'])[1]/tbody/tr/td/div[contains(@class,'infocus')]"));
        for(WebElement element:allElementsDates){
            String actualValue = element.getText();
            if(actualValue.equalsIgnoreCase(date)){
                element.click();
                break;
            }
        }
        System.out.println("Date is selected:"+date);


        driver.findElement(By.xpath("//input[@id='time']")).click();
        System.out.println("In time is selected");

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@id='time']")));

        driver.findElement(By.xpath("//input[@id='time']")).sendKeys("05:30");
        System.out.println("In time is entered");

        driver.findElement(By.xpath("//textarea[@id='note']")).click();
        driver.findElement(By.xpath("//textarea[@id='note']")).sendKeys("Automation");
        System.out.println("In Note is entered");

        driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
        System.out.println("In button is clicked");

        driver.findElement(By.xpath("//i[text()='date_range']")).click();
        System.out.println("Punch out date is clicked");

        WebElement Date_Range_1 = driver.findElement(By.xpath("(//sf-decorator[@form='item'])[1]/div/span[1]/span[1]/i"));
        js.executeScript("arguments[0].click();", Date_Range_1);
        System.out.println("Date range is selected");


        String day_1 = "01/June/2020";
        String date_1 = day_1.split("/")[0];
        String month_1 = day_1.split("/")[1];
        String year_1 = day_1.split("/")[2];

        driver.findElement(By.xpath("//div[@class='select-wrapper picker__select--year']/input[@class='select-dropdown']")).click();
        System.out.println("Year is clicked");

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='select-wrapper picker__select--year']/ul/li/span")));


        List<WebElement> allElementsYear_1 = driver.findElements(By.xpath("//div[@class='select-wrapper picker__select--year']/ul/li/span"));
        for(WebElement element:allElementsYear_1){
            String actualValue = element.getText();
            if(actualValue.equalsIgnoreCase(year_1)){
                element.click();
                break;
            }
        }
        System.out.println("Year is selected:"+year_1);


        WebElement Month_1 = driver.findElement(By.xpath("//div[@class='select-wrapper picker__select--month']/input[@class='select-dropdown']"));
        js.executeScript("arguments[0].click();", Month_1);
        System.out.println("Month is clicked");

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='select-wrapper picker__select--month']/ul/li/span")));


        List<WebElement> allElementsMonth_1 = driver.findElements(By.xpath("//div[@class='select-wrapper picker__select--month']/ul/li/span"));
        for(WebElement element:allElementsMonth_1){
            String actualValue = element.getText();
            if(actualValue.equalsIgnoreCase(month_1)){
                element.click();
                break;
            }
        }
        System.out.println("Month is selected:"+month_1);


        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@id='time']")));


        List<WebElement> allElementsDates_1 = driver.findElements(By.xpath("(//table[@class='picker__table'])[1]/tbody/tr/td/div[contains(@class,'infocus')]"));
        for(WebElement element:allElementsDates_1){
            String actualValue = element.getText();
            if(actualValue.equalsIgnoreCase(date_1)){
                element.click();
                break;
            }
        }
        System.out.println("Date is selected:"+date_1);

        driver.findElement(By.xpath("//input[@id='time']")).click();
        System.out.println("Out time is selected");

        driver.findElement(By.xpath("//input[@id='time']")).sendKeys("10:30");
        System.out.println("Out time is entered");

        driver.findElement(By.xpath("//textarea[@id='note']")).click();
        driver.findElement(By.xpath("//textarea[@id='note']")).sendKeys("Testing");
        System.out.println("Out Note is entered");

        driver.findElement(By.xpath("//button[text()='Out']")).click();
        System.out.println("Out button is clicked");


    }
}
