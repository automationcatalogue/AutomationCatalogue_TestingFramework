package Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.time.Duration;

public class CommonMethods {

    public static WebDriver openBrowser(){
        WebDriver driver = new ChromeDriver();
        System.out.println("Chrome Browser is launched");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        return driver;
    }

    public static void launchURL(WebDriver driver, String url){
        driver.get(url);
        System.out.println("OrangeHRM URL is launched");
    }

    public static void takeScreenshot(WebDriver driver, String screenShotName) throws Exception{
        String projectPath = System.getProperty("user.dir");
        TakesScreenshot ts = (TakesScreenshot)driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File(projectPath + "\\Screenshots\\"+screenShotName+".jpg");
        FileUtils.copyFile(src, dest);
        System.out.println("OrangeHRMLogin screenshot is captured");
    }
}
