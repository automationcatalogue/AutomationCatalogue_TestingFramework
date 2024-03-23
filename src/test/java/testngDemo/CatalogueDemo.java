package testngDemo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.util.Set;

public class CatalogueDemo {

    static WebDriver driver;
    static FileInputStream fis;

    @BeforeTest
    public void openHtmlReport(){
        System.out.println("I am in BEFORE TEST Block!!!");
    }

    @BeforeClass
    public void openExcelFile() throws Exception{
        System.out.println("I am in BEFORE CLASS block!!!!");
        String projectPath = System.getProperty("user.dir");
        fis = new FileInputStream(projectPath+"//TestData//Automation_TestData.xlsx");
        System.out.println("Excel file is opened to read the data");
    }

    @BeforeMethod
    public void launchBrowser(){
        System.out.println("I am in BEFORE METHOD block!!!");
        driver = new ChromeDriver();
        System.out.println("Chrome browser is launched");
    }

    @Test
    public void switchTabsDemo() throws Exception{
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

    @Test
    public void actionsDemo() throws Exception{
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");

        driver.findElement(By.xpath("//span[text()='Login']/../../../../../button")).click();
        System.out.println("Clicking on close pop-up");
        Thread.sleep(3000);

        WebElement eleElectronics = driver.findElement(By.xpath("//div[text()='Electronics']"));
        Actions ob = new Actions(driver);
        ob.moveToElement(eleElectronics).perform();
        System.out.println("Mouse hovered on Electronics link");
        Thread.sleep(6000);

        driver.findElement(By.linkText("Laptop and Desktop")).click();
        System.out.println("Laptop and Desktop is clicked");
    }


    @AfterMethod
    public void closeDriver(){
        System.out.println("I am in AFTER METHOD block!!!");
        driver.quit();
        System.out.println("Driver instance is terminated");
    }

    @AfterClass
    public void closeExcelFile() throws Exception{
        System.out.println("I am in AFTER CLASS block!!!");
        fis.close();
    }
}
