package teachings.selenium.webElementBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class FluentDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.xpath("//button[text()='Start']")).click();

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        String headerText = wait.until(new Function<WebDriver, String>() {
                       public String apply(WebDriver driver){
                           System.out.println("This is Test");
                           WebElement element = driver.findElement(By.xpath("//div[@id='finish']/h4"));
                           String text = element.getText();
                           if(text.equalsIgnoreCase("Automation Testing")){
                               return text;
                           }else{
                               return null;
                           }
                       }
                   }
        );
        System.out.println("Header Text is :"+headerText);
    }
}
