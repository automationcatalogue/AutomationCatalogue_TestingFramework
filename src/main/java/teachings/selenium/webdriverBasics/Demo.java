package teachings.selenium.webdriverBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {
    public static void main(String[] args) {
        System.out.println("WebDriver Initial Program!!!");

        WebDriver ob = new ChromeDriver();
        ob.get("https://www.amazon.co.in");
        ob.manage().window().maximize();
        ob.get("https://facebook.com");
        ob.quit();

    }
}
