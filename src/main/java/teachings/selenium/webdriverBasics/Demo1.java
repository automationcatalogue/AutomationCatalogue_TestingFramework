package teachings.selenium.webdriverBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo1 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        System.out.println("Chrome browser is launched");

        driver.get("https://seleniumautom-trials710.orangehrmlive.com/");
        System.out.println("Orange HRM URL is opened");

        String s1=driver.getTitle();
        System.out.println("Title of the OrangeHRM application is :"+s1);

        driver.get("https:/www.amazon.com");
        String s2= driver.getTitle();
        System.out.println("Title of the Amazon website is :"+s2);

        boolean b= s1.equals(s2);
        if(b){
            System.out.println("Both the titles are same");
        }else{
            System.out.println("Both the title are not same");
        }
    }
    
}
