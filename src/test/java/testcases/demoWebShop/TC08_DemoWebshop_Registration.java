package testcases.demoWebShop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC08_DemoWebshop_Registration {
    public static void main(String[] args) {
        WebDriver driver= new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        driver.findElement(By.xpath("//input[@id='gender-male']")).click();
        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Anupreddy");
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Desai");
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("anupreddy.desai@gmail.com");
        System.out.println("Email ID is Entered");
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Automation@123");
        System.out.println("password is entered");
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("Automation@123");
        System.out.println("confirm password is entered");
        driver.findElement(By.xpath("//input[@id='register-button']")).click();
        System.out.println("Register button is selected");
        driver.findElement(By.xpath("//a[@class='ico-login']")).click();
        System.out.println("Login is selected");
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("anupreddy.desai@gmail.com");
        System.out.println("Email is entered for Login");
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Automation@123");
        System.out.println("Passowrd is entered for Login");
        driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
        System.out.println("Login button is clicked");
    }
}
