package teachings.selenium.webElementBasics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertDemo {
    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();
        System.out.println("Chrome Browser is launched");

        driver.manage().window().maximize();
        System.out.println("Browser window is maximized");

        driver.get("https://demo.guru99.com/test/delete_customer.php");
        System.out.println("Demo Guru99 website is loaded");

        Thread.sleep(3000);
        driver.findElement(By.name("submit")).click();
        System.out.println("Submit button is clicked");

        Thread.sleep(3000);
        Alert ob1 = driver.switchTo().alert();
        ob1.accept();
        System.out.println("OK button is clicked in the Alert");

        Thread.sleep(3000);
        Alert ob2 = driver.switchTo().alert();
        String s = ob2.getText();
        System.out.println("Alert Text is :"+s);
        ob2.accept();
        System.out.println("Ok button is clicked");

        Thread.sleep(3000);
        driver.findElement(By.name("submit")).click();
        System.out.println("Submit button is clicked");
        Thread.sleep(3000);
        Alert ob3 = driver.switchTo().alert();
        ob3.dismiss();
        System.out.println("Cancel button is clicked");

        Thread.sleep(3000);
        driver.quit();

    }
}
