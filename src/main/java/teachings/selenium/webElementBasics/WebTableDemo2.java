package teachings.selenium.webElementBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WebTableDemo2 {
    public static void main(String[] args) {

        //ChromeOptions option = new ChromeOptions();
        FirefoxOptions option = new FirefoxOptions();
        option.addArguments("start-maximized");
        option.addArguments("--incognito");
        option.addArguments("--disable-popup-blocking");
        option.addArguments("--ignore-certificate-errors");
        option.setAcceptInsecureCerts(true);
        option.addArguments("--headless");

        //WebDriver driver = new ChromeDriver(option);
        WebDriver driver = new FirefoxDriver(option);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://automatetest-trials710.orangehrmlive.com/");

        driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("Admin@123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        driver.findElement(By.xpath("(//a[@data-automation-id='menu_pim_viewEmployeeList'])[3]")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='addEmployeeButton']/i")));

        List<WebElement> elements_Names = driver.findElements(By.xpath("//table[@id='employeeListTable']/tbody/tr/td[3]"));
        for(WebElement element:elements_Names){
            String empName = element.getText();
            System.out.println(empName);
            if(empName.equalsIgnoreCase("Paul Collings")){
                String subUnit = element.findElement(By.xpath("./../td[6]")).getText();
                System.out.println("Sub Unit of "+empName+" is "+subUnit);
                break;
            }
        }

    }
}
