package teachings.selenium.webElementBasics;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;

public class ScreenshotDemo {
    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationo-trials710.orangehrmlive.com");

        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File("C:\\AutomationCatalogue\\Projects\\TestAutomationCatalogue_Batch42\\src\\Screenshots\\OrangeHRMLogin.jpg");
        FileUtils.copyFile(src, dest);

        driver.findElement(By.cssSelector("#txtUsername")).sendKeys("Admin");
        src = ts.getScreenshotAs(OutputType.FILE);
        dest = new File("C:\\AutomationCatalogue\\Projects\\TestAutomationCatalogue_Batch42\\src\\Screenshots\\OrangeHRMUserName.png");
        FileUtils.copyFile(src, dest);

        driver.findElement(By.xpath("//form[@id='frmLogin']/div[2]/input")).sendKeys("Admin@123");
        src = ts.getScreenshotAs(OutputType.FILE);
        dest = new File("C:\\AutomationCatalogue\\Projects\\TestAutomationCatalogue_Batch42\\src\\Screenshots\\OrangeHRMPassword.jpg");
        FileUtils.copyFile(src, dest);

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(8000);
        src = ts.getScreenshotAs(OutputType.FILE);
        dest = new File("C:\\AutomationCatalogue\\Projects\\TestAutomationCatalogue_Batch42\\src\\Screenshots\\OrangeHRMHomePage.png");
        FileUtils.copyFile(src, dest);

        driver.findElement(By.xpath("//input[@id='menuQuickSearch_menuQuickSearch']")).click();
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_T);
        Thread.sleep(1000);
        r.keyPress(KeyEvent.VK_T);
        Thread.sleep(1000);
        r.keyPress(KeyEvent.VK_E);
        Thread.sleep(1000);
        r.keyRelease(KeyEvent.VK_E);
        Thread.sleep(1000);
        r.keyPress(KeyEvent.VK_S);
        Thread.sleep(1000);
        r.keyRelease(KeyEvent.VK_S);
        Thread.sleep(1000);
        r.keyPress(KeyEvent.VK_T);
        Thread.sleep(1000);
        r.keyRelease(KeyEvent.VK_T);

    }
}
