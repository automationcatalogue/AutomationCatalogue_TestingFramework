package pages.orangeHRM;

import Utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeHRM_Evaluator extends BaseClass {

    public OrangeHRM_Evaluator(WebDriver driver){
        super(driver);
    }

    public static By chkbx_SelfAppraisal = By.xpath("//label[@for='appraisalEval_eval_name_grp_self']");
    public static By btn_Next = By.cssSelector("#saveBtn");

    public static void clickSelfAppraisal(){
        driver.findElement(OrangeHRM_Evaluator.chkbx_SelfAppraisal).click();
        System.out.println("Self appraisal check-box checked ");

        driver.findElement(OrangeHRM_Evaluator.btn_Next).click();
        System.out.println("Next button in Evaluator Page Clicked");
    }
}
