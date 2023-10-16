package teachings.selenium.webElementBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo3 {
    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/droppable/");

        WebElement element_iframe = driver.findElement(By.cssSelector(".demo-frame"));
        driver.switchTo().frame(element_iframe);
        Thread.sleep(3000);
        WebElement element_source = driver.findElement(By.cssSelector("#draggable"));
        WebElement element_destination = driver.findElement(By.cssSelector("#droppable"));
        Actions ob1= new Actions(driver);
        ob1.clickAndHold(element_source);
        ob1.release(element_destination);
        ob1.build().perform();

        //ob1.clickAndHold(element_source).release(element_destination).build().perform();
    }
}
