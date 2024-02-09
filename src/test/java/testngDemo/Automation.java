package testngDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.util.List;

public class Automation {

    static WebDriver driver;
    static FileInputStream fis;

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
    public void amazonSearch() throws Exception{

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

    @Test
    public void selectDropDown() throws Exception{
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
        System.out.println("W3 Schools website is loaded");

        driver.switchTo().frame("iframeResult");
        System.out.println("Switched into iframe");

        WebElement element_listbox = driver.findElement(By.xpath("//*[@id='cars']"));
        Select ob_select = new Select(element_listbox);
        ob_select.selectByIndex(0);
        System.out.println("Oth index value is selected");

        Thread.sleep(3000);
        ob_select.selectByValue("opel");
        System.out.println("Opel value is selected");

        Thread.sleep(3000);
        ob_select.selectByVisibleText("Audi");
        System.out.println("Audi is selected from drop-down");

        WebElement element1 = ob_select.getFirstSelectedOption();
        String text = element1.getText();
        System.out.println(text);
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
