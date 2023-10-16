package teachings.selenium.webElementBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WebTableDemo1 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://automatetest-trials710.orangehrmlive.com/");

        driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("Admin@123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        driver.findElement(By.xpath("(//a[@data-automation-id='menu_pim_viewEmployeeList'])[3]")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='addEmployeeButton']/i")));

        List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id='employeeListTable']/tbody/tr"));
        int rowCount = tableRows.size();
        System.out.println("Number of Rows in the table are :"+rowCount);

        List<WebElement> tableColumns = driver.findElements(By.xpath("//table[@id='employeeListTable']/tbody/tr[1]/td"));
        int colCount = tableColumns.size();
        System.out.println("Number of Columns in the table are :"+colCount);

        List<WebElement> elements_EmpNames = driver.findElements(By.xpath("//table[@id='employeeListTable']/tbody/tr/td[3]"));

        for(WebElement element:elements_EmpNames){
            String empName = element.getText();
            if(empName.equalsIgnoreCase("Jenny Fisher")){
                System.out.println("empName is found");
                element.click();
                break;
            }
        }

    }
}
