package Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseClass {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static JavascriptExecutor js;

    public BaseClass(WebDriver driver){
        BaseClass.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(Config.explicitTimeOut));
        js = (JavascriptExecutor)driver;
    }
}
