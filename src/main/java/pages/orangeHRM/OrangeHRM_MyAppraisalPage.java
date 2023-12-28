package pages.orangeHRM;

import Utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrangeHRM_MyAppraisalPage extends BaseClass {

    public OrangeHRM_MyAppraisalPage(WebDriver driver){
        super(driver);
    }

    public static By emp_Description = By.xpath("//list/table//tbody/tr[1]/td[6]//span");
    public static By appraisal_Status = By.xpath("//list/table//tbody/tr[1]/td[7]//span");

    public static void validateAppraisalData(String description){
        wait.until(ExpectedConditions.visibilityOfElementLocated(OrangeHRM_MyAppraisalPage.emp_Description));
        String actualDescription = driver.findElement(OrangeHRM_MyAppraisalPage.emp_Description).getText();
        if (actualDescription.equalsIgnoreCase(description)) {
            System.out.println("Description data is matched");
        } else {
            System.out.println("Description data is not matched");
        }

        //Validating the Appraisal Status
        String actualAppraisalStatus = driver.findElement(OrangeHRM_MyAppraisalPage.appraisal_Status).getText();
        if (actualAppraisalStatus.equalsIgnoreCase("COMPLETED")) {
            System.out.println("Appraisal Status is COMPLETED");
        } else {
            System.out.println("Appraisal Status is not COMPLETED");
        }
    }

}
