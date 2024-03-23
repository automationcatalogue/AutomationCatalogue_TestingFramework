package teachings.selenium.webElementBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AutomationDemo {
    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("India");
        driver.findElement(By.name("q")).submit();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[text()='Images']")).click();
    }
}
