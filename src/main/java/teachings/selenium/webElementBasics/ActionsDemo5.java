package teachings.selenium.webElementBasics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo5 {
    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");

        WebElement element_btn = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
        Actions action = new Actions(driver);
        action.doubleClick(element_btn).perform();
        Thread.sleep(2000);
        /*Alert al =driver.switchTo().alert();
        String str = al.getText();
        System.out.println("Alert text is :"+str);
        al.accept();
        System.out.println("Alter is accepted");*/

    }
}
