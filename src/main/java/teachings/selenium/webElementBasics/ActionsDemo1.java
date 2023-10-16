package teachings.selenium.webElementBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo1 {
    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");

        driver.findElement(By.xpath("//span[text()='Login']/../../../../../button")).click();
        System.out.println("Clicking on close pop-up");
        Thread.sleep(3000);

        WebElement eleElectronics = driver.findElement(By.xpath("//div[text()='Electronics']"));
        Actions ob = new Actions(driver);
        ob.moveToElement(eleElectronics).perform();
        System.out.println("Mouse hovered on Electronics link");
        Thread.sleep(6000);

        driver.findElement(By.linkText("Laptop and Desktop")).click();
        System.out.println("Laptop and Desktop is clicked");
    }
}
