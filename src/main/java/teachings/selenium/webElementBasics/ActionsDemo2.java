package teachings.selenium.webElementBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo2 {
    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/droppable/");

        WebElement ele_frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(ele_frame);
        System.out.println("Switched to iframe");
        Thread.sleep(3000);
        WebElement src = driver.findElement(By.id("draggable"));
        WebElement dest = driver.findElement(By.id("droppable"));

        Actions ob1 = new Actions(driver);
        //ob1.dragAndDrop(src, dest).perform();
        ob1.dragAndDropBy(src,20, 40).perform();
        System.out.println("Drag and drop is successful");


    }
}
