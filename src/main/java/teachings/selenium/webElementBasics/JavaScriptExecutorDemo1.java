package teachings.selenium.webElementBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorDemo1 {
    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();

        WebElement element_login = driver.findElement(By.xpath("//a[text()='Log in']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",element_login);
        Thread.sleep(3000);

        js.executeScript("document.getElementById('Email').value='aarosagarch@gmail.com'");
        WebElement element_password = driver.findElement(By.xpath("//input[@name='Password']"));
        js.executeScript("arguments[0].value='Admin@123'",element_password);
    }
}
