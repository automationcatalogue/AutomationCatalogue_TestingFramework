package testcases.orangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class   TC01_OrangeHRM_Login {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        System.out.println("Chrome Browser is launched");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //Opening OrangeHRM Application
        driver.get("https://automatetest-trials710.orangehrmlive.com/");
        System.out.println("OrangeHRM URL is launched");
        //UserName
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
        System.out.println("Admin is entered as userName");
        //Password
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Admin@123");
        System.out.println("Password is entered");
        //Login
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("Login button is clicked");

        //Title Verification
        String title = driver.getTitle();
        if(title.equalsIgnoreCase("Employee Management")){
            System.out.println("Login is successful");
        }else{
            System.out.println("Login is not successful");
        }

        //Logout
        driver.findElement(By.xpath("//span[text()='Log Out']")).click();
        System.out.println("Logout button is clicked");

        driver.quit();
    }
}
