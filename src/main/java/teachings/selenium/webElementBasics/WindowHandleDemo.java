package teachings.selenium.webElementBasics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Set;

public class WindowHandleDemo {
    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://letcode.in/windows");

        String str = driver.getWindowHandle();
        System.out.println("Parent window session id is:"+str);

        driver.findElement(By.xpath("//button[text()='Muiltiple windows']")).click();
        System.out.println("Multiple Windows button is clicked");

        Thread.sleep(15000);


        Set<String> allSessions=  driver.getWindowHandles();
        for(String session:allSessions){
            driver.switchTo().window(session);
            String url = driver.getCurrentUrl();
            if(url.equalsIgnoreCase("https://letcode.in/dropdowns")){
                break;
            }
        }
        System.out.println("Driver focus is switched to latest window");
        String str1 = driver.getWindowHandle();
        System.out.println("Latest window session id is :"+str1);

        WebElement element_dropdown = driver.findElement(By.cssSelector("#lang"));
        Select s = new Select(element_dropdown);
        s.selectByVisibleText("Java");

        Thread.sleep(8000);
        Set<String> sessions = driver.getWindowHandles();
        for(String s1:sessions){
            driver.switchTo().window(s1);
            String url = driver.getCurrentUrl();
            if(url.equalsIgnoreCase("https://letcode.in/alert")){
                break;
            }
        }
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@id='prompt']")).click();
        Thread.sleep(3000);

        Alert al = driver.switchTo().alert();
        al.sendKeys("Testing");
        Thread.sleep(3000);
        al.accept();

        Thread.sleep(3000);
        String text= driver.findElement(By.xpath("//p[@id='myName']")).getText();
        if(text.equalsIgnoreCase("Testing")){
            System.out.println("Alert text is correctly displayed");
        }else{
            System.out.println("Alert text is not correctly displayed");
        }

        driver.close();
        System.out.println("Alert window is closed");

        driver.switchTo().window(str);
        System.out.println("Switched to the parent window");

    }
}
