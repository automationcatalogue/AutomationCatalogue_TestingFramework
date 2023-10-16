package teachings.selenium.webElementBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class W3SchoolsSelection {
    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();
        System.out.println("Chrome browser is launched");

        driver.manage().window().maximize();
        System.out.println("Browser window is maximized");

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

        //driver.findElement(By.xpath("/html/body/form/input")).click();
        //System.out.println("Submit button is clicked");

        //Thread.sleep(3000);
        //String result = driver.findElement(By.xpath("/html/body/div[1]")).getText();
        //System.out.println(result);

        /*Thread.sleep(3000);
        ob_select.deselectByIndex(2);
        System.out.println("Deselects the value of List-box in 2nd position");

        Thread.sleep(3000);
        ob_select.deselectByVisibleText("Volvo");
        System.out.println("Deselects the Volvo in a List-box");

        Thread.sleep(3000);
        ob_select.deselectByValue("audi");
        System.out.println("Audi value is deselected");*/

        driver.switchTo().defaultContent();
        System.out.println("Exited from the frame");

    }
}
