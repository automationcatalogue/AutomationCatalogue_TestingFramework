package teachings.selenium.webElementBasics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitDemo1 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        System.out.println("Chrome Browser is loaded");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.manage().window().maximize();
        System.out.println("Chrome browser is maximized");

        driver.get("https://netbanking.hdfcbank.com/netbanking/");
        System.out.println("HDFC NetBanking website is loaded");

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.name("login_page")));
        System.out.println("Switched into iframe");

        driver.findElement(By.xpath("//a[text()='CONTINUE']")).click();
        System.out.println("Continue button is clicked");

        wait.until(ExpectedConditions.alertIsPresent());

        Alert al = driver.switchTo().alert();
        al.accept();
        System.out.println("Alert is accepted");
    }
}
