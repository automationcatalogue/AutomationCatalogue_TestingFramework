package teachings.selenium.Dummy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Demo99 {

    @BeforeMethod
    public void before(){
        System.out.println("I am in Before Method");
    }

    @Test
    public void appLaunch(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
    }

    @Test
    public void appLaunch1(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println(" I am terminating");
    }
}
