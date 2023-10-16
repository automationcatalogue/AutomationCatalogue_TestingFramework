package teachings.selenium.webElementBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo4 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationo-trials710.orangehrmlive.com/");

        Actions action = new Actions(driver);
        WebElement element_UserName = driver.findElement(By.xpath("//input[@name='txtUsername']"));
        action.click(element_UserName);
        action.sendKeys("Admin").build().perform();

        WebElement element_password = driver.findElement(By.xpath("//input[@name='txtPassword']"));
        action.sendKeys(element_password,"Admin@123").perform();

        WebElement element_LoginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        action.click(element_LoginBtn).build().perform();
    }
}
