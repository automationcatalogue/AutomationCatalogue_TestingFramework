package teachings.selenium.webElementBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AmazonSearch {
    public static void main(String[] args) throws Exception{
        WebDriver driver = new FirefoxDriver();
        System.out.println("Chrome browser is launched");

        driver.manage().window().maximize();
        System.out.println("Browser window is maximized");

        driver.get("https://www.amazon.com/");
        System.out.println("Amazon website is loaded");

        WebElement element_dropdown = driver.findElement(By.id("searchDropdownBox"));

        Select ob_select = new Select(element_dropdown);
        ob_select.selectByIndex(5);
        System.out.println("5th Index value is selected from the drop-down");

        Thread.sleep(3000);
        ob_select.selectByValue("search-alias=digital-music");
        System.out.println("Digital Music is selected");

        Thread.sleep(3000);
        ob_select.selectByVisibleText("Tools & Home Improvement");
        System.out.println("Tools & Home Improvement drop-down is selected");

        System.out.println("All Values from a Drop down are:");

        List<WebElement> list= ob_select.getOptions();
        for(int i=0;i<list.size();i++){
            String text = list.get(i).getText();
            System.out.println(text);
        }

        WebElement element1=   ob_select.getFirstSelectedOption();
        String text=element1.getText();
        System.out.println(text);

    }
}
