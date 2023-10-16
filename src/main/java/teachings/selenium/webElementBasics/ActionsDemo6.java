package teachings.selenium.webElementBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Set;

public class ActionsDemo6 {
    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");

        WebElement element_search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        Actions action = new Actions(driver);
        action.sendKeys(element_search,"laptops").perform();
        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
        Thread.sleep(10000);
        WebElement element_firstItem = driver.findElement(By.xpath("//span[@data-component-type='s-search-results']/div/div[2]/div/div/div//h2/a"));
        action.contextClick(element_firstItem).perform();
        System.out.println("Right-Click is performed on first item");
        Thread.sleep(4000);
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_DOWN);
        r.keyRelease(KeyEvent.VK_DOWN);
        Thread.sleep(2000);
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);

        Set<String> sessions = driver.getWindowHandles();
        for(String s:sessions){
            driver.switchTo().window(s);
            String title = driver.getTitle();
            if(title.contains("SGIN Laptop")){
                break;
            }
        }
        System.out.println("Switched to the Latest window");


    }
}
