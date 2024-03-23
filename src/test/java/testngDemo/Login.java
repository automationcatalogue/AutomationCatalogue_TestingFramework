package testngDemo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;

public class Login {

    static WebDriver driver;
    static FileInputStream fis;



    @BeforeClass
    public void openExcelFile() throws Exception{
        System.out.println("I am in BEFORE CLASS block!!!!");
        String projectPath = System.getProperty("user.dir");
        fis = new FileInputStream(projectPath+"//TestData//Automation_TestData.xlsx");
        System.out.println("Excel file is opened to read the data");
    }

    @BeforeMethod
    public void launchBrowser(){
        System.out.println("I am in BEFORE METHOD block!!!");
        driver = new ChromeDriver();
        System.out.println("Chrome browser is launched");
    }

    @Test(priority = 3)
    public void demoWebShop_Login() throws Exception{
        driver.get("https://demowebshop.tricentis.com/");
        System.out.println("DemoWebShop website is loaded");

        driver.findElement(By.xpath("//a[text()='Log in']")).click();
        System.out.println("Login link is clicked");

        driver.findElement(By.id("Email")).sendKeys("aarosagarch@gmail.com");
        System.out.println("Email is entered");

        driver.findElement(By.id("Password")).sendKeys("Admin@123");
        System.out.println("Password is entered");

        driver.findElement(By.xpath("//input[@value='Log in']")).click();
        System.out.println("Login button is clicked");

        Thread.sleep(5000);
    }

    @Test(priority = 1)
    public void openApplicationURLs() {
        driver.get("https://www.gmail.com");
        System.out.println("Gmail URL is opened");

        String s1=driver.getTitle();
        System.out.println("Title of the Gmail application is :"+s1);

        driver.get("https:/www.amazon.com");
        String s2= driver.getTitle();
        System.out.println("Title of the Amazon website is :"+s2);

        boolean b= s1.equals(s2);
        if(b){
            System.out.println("Both the titles are same");
        }else{
            System.out.println("Both the title are not same");
        }
    }

    @Test(priority = 2)
    public void alertDemo() throws Exception{
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

    }

    @AfterMethod
    public void closeDriver(){
        System.out.println("I am in AFTER METHOD block!!!");
        driver.quit();
        System.out.println("Driver instance is terminated");
    }

    @AfterClass
    public void closeExcelFile() throws Exception{
        System.out.println("I am in AFTER CLASS block!!!");
        fis.close();
    }

    @AfterTest
    public void closeHtmlReport(){
        System.out.println("I am in AFTER TEST block!!!!");
    }

}
