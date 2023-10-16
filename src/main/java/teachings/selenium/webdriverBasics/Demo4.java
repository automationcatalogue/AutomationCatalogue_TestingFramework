package teachings.selenium.webdriverBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo4 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        System.out.println("Chrome browser is launched");

        driver.navigate().to("https://www.amazon.com");
        System.out.println("Amazon website is loaded");

        String s1 = driver.getTitle();
        System.out.println("Title of the page is :"+s1);

        driver.navigate().to("https://www.facebook.com");
        System.out.println("facebook site is loaded");

        driver.quit();
        System.out.println("Close the Chrome browser");

    }
}
