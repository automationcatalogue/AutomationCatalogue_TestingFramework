package teachings.selenium.webElementBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class DropdownSelectionDemo {
    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://automatetest-trials710.orangehrmlive.com/");

        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Admin@123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("(//a[@data-automation-id='menu_pim_viewEmployeeList'])[1]")).click();
        driver.findElement(By.xpath("//i[text()='add']")).click();
        driver.findElement(By.xpath("//input[@id='first-name-box']")).sendKeys("Automation");
        driver.findElement(By.cssSelector("#last-name-box")).sendKeys("Catalogue");
        driver.findElement(By.xpath("//button[@data-id='location']")).click();
        List<WebElement> allElements = driver.findElements(By.xpath("//ul[@class='dropdown-menu inner show']/li/a/span"));
        for(WebElement element:allElements){
            String actualValue = element.getText();
            if(actualValue.equalsIgnoreCase("Mexico Office")){
                element.click();
                break;
            }
        }
        System.out.println("Selection of the Location drop-down is completed");
        driver.findElement(By.cssSelector("#modal-save-button")).click();
        driver.findElement(By.xpath("(//i[@class='material-icons action-icon date-picker-open-icon'])[1]")).click();
        driver.findElement(By.xpath("//div[@class='select-wrapper picker__select--year']/input")).click();
        //Select Year --1990
        List<WebElement> eleAllYears = driver.findElements(By.xpath("//div[@class='select-wrapper picker__select--year']/ul/li/span"));
        for(WebElement eleYear:eleAllYears){
            String year = eleYear.getText();
            if(year.equalsIgnoreCase("1990")){
                eleYear.click();
                break;
            }
        }
        driver.findElement(By.xpath("//div[@class='select-wrapper picker__select--month']/input")).click();
        //Select Month - June
        List<WebElement> eleAllMonths = driver.findElements(By.xpath("//div[@class='select-wrapper picker__select--month']/ul/li/span"));
        for(WebElement eleMonth:eleAllMonths){
            String month = eleMonth.getText();
            if(month.equalsIgnoreCase("June")){
                eleMonth.click();
                break;
            }
        }
        //Select Date -15
        List<WebElement> eleAllDates = driver.findElements(By.xpath("(//table[@class='picker__table'])[1]/tbody/tr/td/div[contains(@class,'infocus')]"));
        for(WebElement eleDate: eleAllDates){
            String date = eleDate.getText();
            if(date.equalsIgnoreCase("15")){
                eleDate.click();
                break;
            }
        }

    }
}
