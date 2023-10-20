package testcases;

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
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.manage().window().maximize();

        driver.get("https://automatetest-trials710.orangehrmlive.com/auth/login");
        System.out.println("OrangeHRM Application is loaded");

        String title = driver.getTitle();
        System.out.println("Title of the page is :"+title);

        driver.findElement(By.name("txtUsername")).sendKeys("Admin");
        System.out.println("UserName is entered");

        driver.findElement(By.id("txtPassword")).sendKeys("Admin@123");
        System.out.println("Password is entered");

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

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//sf-decorator[@form='item'])[1]/div/span[1]/span[1]/i")));


        WebElement Year = driver.findElement(By.xpath("//div[@class='select-wrapper picker__select--year']/input"));
        js.executeScript("arguments[0].click();", Year);
        System.out.println("Year is clicked");


        List<WebElement> allElementsYear = driver.findElements(By.xpath("//div[@class='select-wrapper picker__select--year']/ul/li/span"));
        for(WebElement element:allElementsYear){
            String actualValue = element.getText();
            if(actualValue.equalsIgnoreCase("2020")){
                element.click();
                break;
            }
        }
        System.out.println("Year is selected");
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='select-wrapper picker__select--year']/ul/li/span")));


        WebElement Month = driver.findElement(By.xpath("//div[@class='select-wrapper picker__select--month']/input"));
        js.executeScript("arguments[0].click;", Month);
        System.out.println("Month is clicked");


        List<WebElement> allElementsMonth = driver.findElements(By.xpath("//div[@class='select-wrapper picker__select--month']/ul/li/span"));
        for(WebElement element:allElementsMonth){
            String actualValue = element.getText();
            if(actualValue.equalsIgnoreCase("June")){
                element.click();
                break;
            }
        }
        System.out.println("Month is selected");
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='select-wrapper picker__select--month']/ul/li/span")));

        List<WebElement> allElementsDates = driver.findElements(By.xpath("(//table[@class='picker__table'])[1]/tbody/tr/td/div[contains(@class,'infocus')]"));
        for(WebElement element:allElementsDates){
            String actualValue = element.getText();
            if(actualValue.equalsIgnoreCase("1")){
                element.click();
                break;
            }
        }
        System.out.println("Date is selected");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table[@class='picker__table'])[1]/tbody/tr/td/div[@role='gridcell']")));

        driver.findElement(By.xpath("//button[text()='Close']")).click();
        System.out.println("Close button is clicked");






    }
}
