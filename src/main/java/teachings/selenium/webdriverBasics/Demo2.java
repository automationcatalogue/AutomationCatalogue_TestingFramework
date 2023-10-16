package teachings.selenium.webdriverBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo2 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        System.out.println("Chrome browser is launched");

        driver.get("https://www.amazon.com");
        System.out.println("amazon website is loaded");

        driver.manage().window().maximize();
        System.out.println("Chrome browser is maximized");

        String s1 = driver.getTitle();
        System.out.println("Title of the amazon in is :"+s1);

        driver.findElement(By.xpath("(//a[@id='nav-orders'])[1]")).click();
        System.out.println("Returns and orders button is clicked");

        String s2 = driver.getCurrentUrl();
        System.out.println("Changed URL is :"+s2);

        String s3 = driver.getPageSource();
        System.out.println("Page source is :"+s3);

        driver.close();
        System.out.println("Chrome browser is closed");

    }
}
