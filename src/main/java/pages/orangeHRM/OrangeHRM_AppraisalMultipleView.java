package pages.orangeHRM;

import Utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrangeHRM_AppraisalMultipleView extends BaseClass {

    public OrangeHRM_AppraisalMultipleView(WebDriver driver){
        super(driver);
    }

    public static By drpdwn_FinalReview = By.xpath("//a[@data-activates='dropdown-7']");
    public static By drpdwn_Submit = By.xpath("//a[text()='Submit']");

    public static void submitAppraisal(){
        driver.findElement(OrangeHRM_AppraisalMultipleView.drpdwn_FinalReview).click();
        System.out.println("Final Review dropdown clicked");

        driver.findElement(OrangeHRM_AppraisalMultipleView.drpdwn_Submit).click();
        System.out.println("Submit button is clicked");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='dialogSubmitBtn']")));
        WebElement element = driver.findElement(By.xpath("//a[@id='dialogSubmitBtn']"));
        js.executeScript("arguments[0].click()", element);
        System.out.println("Ok button is clicked in Alert window");
    }
}
