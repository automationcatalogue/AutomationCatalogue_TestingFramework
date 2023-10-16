package teachings.selenium.webElementBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddLocation {
    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();
        System.out.println("Chrome browser is launched");

        driver.manage().window().maximize();
        System.out.println("Browser is maximized");

        driver.get("https://seleniumautom-trials710.orangehrmlive.com/auth/seamlessLogin");
        System.out.println("OrangeHRM application is loaded");

        driver.findElement(By.cssSelector("#txtUsername")).sendKeys("Admin");
        System.out.println("Admin is entered as a UserName");

        Thread.sleep(1000);

        driver.findElement(By.className("password-input")).sendKeys("Automation");
        System.out.println("Automation is entered as a password");

        Thread.sleep(1000);

        driver.findElement(By.className("password-input")).clear();
        System.out.println("Password field data is cleared");

        Thread.sleep(1000);

        driver.findElement(By.className("password-input")).sendKeys("Admin@123");
        System.out.println("Admin@123 Password is entered");

        Thread.sleep(1000);

        boolean abcd=driver.findElement(By.xpath("//*[@id='frmLogin']/div[4]/button")).isEnabled();
        if(abcd){
            driver.findElement(By.xpath("//*[@id='frmLogin']/div[4]/button")).click();
            System.out.println("Login button is enabled and It is clicked");
        }else{
            System.out.println("Login button is disabled");
        }

        Thread.sleep(10000);

        driver.findElement(By.linkText("HR Administration")).click();
        System.out.println("HR Administration link is clicked");

        Thread.sleep(15000);

        boolean displayed=driver.findElement(By.partialLinkText("Organiza")).isDisplayed();
        if(displayed){
            driver.findElement(By.partialLinkText("Organiza")).click();
            System.out.println("Oragnization link is clicked");
        }else {
            System.out.println("Orgnization link is not displayed");
        }


        Thread.sleep(3000);

        driver.findElement(By.partialLinkText("Locations")).click();
        System.out.println("Locations link is clicked");

        Thread.sleep(10000);

        Point p =  driver.findElement(By.xpath("//*[@id='locationDiv']/div/a/i")).getLocation();
        int x=p.getX();
        System.out.println("X co-ordinate value of add button is :"+x);
        int y=p.getY();
        System.out.println("Y co-ordinate value of add button is :"+y);

        driver.findElement(By.xpath("//*[@id='locationDiv']/div/a/i")).click();
        System.out.println("Add button is clicked");

        Thread.sleep(10000);

        String c=driver.findElement(By.cssSelector("#locationAddModal > form > div.modal-footer > a.modal-action.waves-effect.waves-green.btn.primary-btn")).getCssValue("color");
        System.out.println("Color is :"+c);

        String size=driver.findElement(By.cssSelector("#locationAddModal > form > div.modal-footer > a.modal-action.waves-effect.waves-green.btn.primary-btn")).getCssValue("font-size");
        System.out.println("Font-size is :"+size);

        String f=driver.findElement(By.cssSelector("#locationAddModal > form > div.modal-footer > a.modal-action.waves-effect.waves-green.btn.primary-btn")).getCssValue("font-family");
        System.out.println("Font-family is :"+f);

        String attributeValue = driver.findElement(By.cssSelector("#locationAddModal > form > div.modal-footer > a.modal-action.waves-effect.waves-green.btn.primary-btn")).getAttribute("ohrm-save-form");
        System.out.println("Attribute value is :"+attributeValue);

        String tag=driver.findElement(By.cssSelector("#locationAddModal > form > div.modal-footer > a.modal-action.waves-effect.waves-green.btn.primary-btn")).getTagName();
        System.out.println("TagName is :"+tag);

        driver.findElement(By.cssSelector("#locationAddModal > form > div.modal-footer > a.modal-action.waves-effect.waves-green.btn.primary-btn")).click();
        System.out.println("Save button is clicked");





    }
}
