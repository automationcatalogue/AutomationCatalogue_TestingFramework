package teachings.selenium.webElementBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FaceBookCreateNewAccountTest {
    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");

        driver.findElement(By.xpath("//a[contains(text(),'gotten passwor')]/../../div[5]/a")).click();
        System.out.println("Create New Account button is clicked");
        Thread.sleep(4000);

        driver.findElement(By.xpath("(//div[contains(text(),'quick and')]/../../div[2]/div/div/div/form/div[1]/div/div/div[1]/div[1]/input)[1]")).sendKeys("Automation");
        driver.findElement(By.cssSelector("#u_e_d_dl")).sendKeys("Catalogue");
        driver.findElement(By.cssSelector("input[aria-label='Mobile number or email address']")).sendKeys("7895623410");

        WebElement element_day = driver.findElement(By.cssSelector("select[name='birthday_day']"));
        Select ob_select = new Select(element_day);
        ob_select.selectByVisibleText("22");


        driver.findElement(By.cssSelector("button[name^='websub']")).click();
        System.out.println("Signup button is clicked");





    }
}
