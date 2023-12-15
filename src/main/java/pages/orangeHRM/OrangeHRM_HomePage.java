package pages.orangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeHRM_HomePage {
    public static By link_Logout = By.xpath("//span[text()='Log Out']");
    public static By link_HRAdministration = By.xpath("(//a[@data-automation-id='menu_admin_viewSystemUsers'])[1]/span");
    public static By link_Leave = By.xpath("(//span[text()='Leave'])[1]");
    public static By label_EmployeeName = By.xpath("//a[@class='name']");
    public static By link_ReportsAndAnalytics = By.xpath("");
    public static By link_EmployeeManagement = By.xpath("");

    public static void verifyTitle(WebDriver driver){
        //Title Verification
        String title = driver.getTitle();
        if(title.equalsIgnoreCase("Employee Management")){
            System.out.println("Login is successful");
        }else{
            System.out.println("Login is not successful");
        }
    }

    public static void logout(WebDriver driver){
        //Logout
        driver.findElement(OrangeHRM_HomePage.link_Logout).click();
        System.out.println("Logout button is clicked");
    }
}


