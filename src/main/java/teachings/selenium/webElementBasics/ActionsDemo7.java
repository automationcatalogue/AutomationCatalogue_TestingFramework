package teachings.selenium.webElementBasics;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo7 {
    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");

        WebElement element_fullName = driver.findElement(By.xpath("//input[@id='userName']"));
        Actions action = new Actions(driver);
        action.click(element_fullName);
        action.sendKeys("Automation Catalogue").build().perform();
        System.out.println("FullName is entered");

        Thread.sleep(3000);
        action.keyDown(Keys.TAB);
        action.keyUp(Keys.TAB).build().perform();
        System.out.println("Tab button is pressed");

        Thread.sleep(3000);
        action.sendKeys("automationcatalogue@test.com").perform();

        Thread.sleep(3000);
        action.keyDown(Keys.TAB);
        action.keyUp(Keys.TAB).build().perform();
        System.out.println("Tab button is pressed");

        Thread.sleep(3000);
        action.sendKeys("21st Avenue, Near Main Road, Hyderabad, Telangana, 500090");
        System.out.println("Current Address is entered");

        Thread.sleep(3000);
        action.keyDown(Keys.CONTROL);
        action.sendKeys("a");

        Thread.sleep(3000);
        action.sendKeys("c");
        action.keyUp(Keys.CONTROL).build().perform();
        System.out.println("Copied the Current Address");


        Cookie ob = new Cookie("","");
        driver.manage().addCookie(ob);

        Thread.sleep(3000);
        action.keyDown(Keys.TAB);
        action.keyUp(Keys.TAB).build().perform();
        System.out.println("Tab button is pressed");


        Thread.sleep(3000);
        action.keyDown(Keys.CONTROL);
        action.sendKeys("v");
        action.keyUp(Keys.CONTROL).build().perform();
        System.out.println("Content is pasted in Permanent address");

        Thread.sleep(3000);
        action.keyDown(Keys.TAB);
        action.keyUp(Keys.TAB).build().perform();

        Thread.sleep(3000);
        action.keyDown(Keys.ENTER);
        action.keyUp(Keys.ENTER).build().perform();


    }
}
