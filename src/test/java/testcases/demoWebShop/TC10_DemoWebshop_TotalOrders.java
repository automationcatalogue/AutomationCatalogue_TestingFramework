package testcases.demoWebShop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class TC10_DemoWebshop_TotalOrders {

    public static void main(String[] args) throws Exception{

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println("Chrome browser is launched");

        driver.manage().window().maximize();
        System.out.println("Window is maximized");

        driver.get("http://demowebshop.tricentis.com/login");
        System.out.println("Demowebshop page is loaded");

        driver.findElement(By.cssSelector("#Email")).sendKeys("aarosagarch@gmail.com");
        System.out.println("Email id entered");

        driver.findElement(By.cssSelector("#Password")).sendKeys("Admin@123");
        System.out.println("Password is entered");

        driver.findElement(By.xpath("//input[@class='button-1 login-button' and @type='submit']")).submit();
        System.out.println("Login button clicked successfully");

        driver.findElement(By.xpath("//a[text()='aarosagarch@gmail.com']")).click();
        System.out.println("Account clicked");

        driver.findElement(By.xpath("(//a[text()='Orders'])[1]")).click();
        System.out.println("Orders dropdown clicked");

        List<WebElement> totalOrders = driver.findElements(By.xpath("//div[@class='order-list']/div/div/strong"));
        //System.out.println(totalOrders.size());
        int count = 0;
        for (WebElement size : totalOrders){
            count = count + 1;
        }
        System.out.println("The total no. of orders are: "+count);

        List<WebElement> totalValue= driver.findElements(By.xpath("//div[@class='order-list']/div/ul/li[3]"));

        float totalSum = 0;
        for(WebElement text : totalValue){
            String value = text.getText();
            String[] order = value.split(":");
            float sum = Float.parseFloat(order[1]);
            totalSum = totalSum + sum;
        }

        System.out.println("The value of total number of orders is: $"+totalSum);

        Thread.sleep(5000);
        driver.quit();









    }
}



