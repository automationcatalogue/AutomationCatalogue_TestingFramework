package teachings.selenium.webElementBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorDemo {
    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://automatetest-trials710.orangehrmlive.com");

        js.executeScript("document.getElementById('txtUsername').value='Admin'");
        WebElement element_Password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        js.executeScript("arguments[0].value='Admin@123'",element_Password);

        WebElement element_login = driver.findElement(By.xpath("//button[@type='submit']"));
        js.executeScript("arguments[0].click();",element_login);
        System.out.println("Login button is clicked");
        Thread.sleep(5000);
        js.executeScript("window.location='https://www.amazon.co.in/'");
        System.out.println("Amazon website is loaded");
        Thread.sleep(5000);
        js.executeScript("history.go(0)");
        System.out.println("Amazon website is refreshed");
        Thread.sleep(5000);
        js.executeScript("window.scrollBy(0,300)");
        Thread.sleep(5000);
        js.executeScript("window.scrollBy(0,-150)");
        Thread.sleep(5000);
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        Thread.sleep(5000);
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
        Thread.sleep(5000);
        WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div[9]/div/div/div[1]/h2/span"));
        js.executeScript("arguments[0].scrollIntoView(true);",element);

        String title = js.executeScript("return document.title").toString();
        System.out.println("Title of the page is :"+title);

        String URL = js.executeScript("return document.URL").toString();
        System.out.println("URL is :"+URL);

        String domain = js.executeScript("return document.domain").toString();
        System.out.println("domain is :"+domain);


    }
}
