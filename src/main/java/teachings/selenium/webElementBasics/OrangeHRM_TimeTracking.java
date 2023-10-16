package teachings.selenium.webElementBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRM_TimeTracking {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationo-trials710.orangehrmlive.com/auth/login");
        driver.findElement(By.xpath("//form[@id='frmLogin']/div[1]/input")).sendKeys("Admin");
        driver.findElement(By.xpath("//div[@class='login-form shadow']/form/div[2]/input")).sendKeys("Admin@123");
        driver.findElement(By.xpath("//div[@id='divLogin']/div[2]/div/form/div[4]/button")).submit();

        driver.findElement(By.xpath("//div[@id='menu-content']/ul/li[7]/a[1]/span")).click();
        driver.findElement(By.cssSelector("a[data-automation-id='menu_time_viewMyTimesheet']")).click();
        driver.findElement(By.xpath("//div[@id='listOfActivities']/timesheet-items-day[1]/div[1]/div[2]/div[1]/a")).click();
        driver.findElement(By.cssSelector("input[placeholder='Project']")).click();
        driver.findElement(By.cssSelector("input[placeholder='Project']")).sendKeys("Apache");
        driver.findElement(By.cssSelector("#projectId_dropdown")).click();

        driver.findElement(By.xpath("//div[@id='activityId_inputfileddiv']/div/input")).click();
        driver.findElement(By.xpath("//div[@id='activityId_inputfileddiv']/div/ul/li[6]/span")).click();
        driver.findElement(By.cssSelector("#startTime")).sendKeys("05:00");
        driver.findElement(By.cssSelector("#endTime")).sendKeys("12:00");

    }
}
