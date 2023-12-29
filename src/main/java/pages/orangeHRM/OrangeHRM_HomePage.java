package pages.orangeHRM;

import Utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrangeHRM_HomePage extends BaseClass {

    public OrangeHRM_HomePage(WebDriver driver){
        super(driver);
    }

    public static By link_Logout = By.xpath("//span[text()='Log Out']");
    public static By link_HRAdministration = By.xpath("(//a[@data-automation-id='menu_admin_viewSystemUsers'])[1]/span");
    public static By link_Leave = By.xpath("(//span[text()='Leave'])[1]");
    public static By link_Performance = By.xpath("//a[@class=' main-menu-item-1' and @data-tooltip='Performance']/span");
    public static By label_EmployeeName = By.xpath("//a[@class='name']");
    public static By link_ReportsAndAnalytics = By.xpath("");
    public static By link_EmployeeManagement = By.xpath("");

    public static void verifyTitle(){
        //Title Verification
        String title = driver.getTitle();
        if(title.equalsIgnoreCase("Employee Management")){
            System.out.println("Login is successful");
        }else{
            System.out.println("Login is not successful");
        }
    }

    public static void logout(){
        //Logout
        driver.findElement(OrangeHRM_HomePage.link_Logout).click();
        System.out.println("Logout button is clicked");
    }

    public static void clickHRAdministration(){
        driver.findElement(OrangeHRM_HomePage.link_HRAdministration).click();
        System.out.println("HR administration is been clicked");
    }

    public static void clickReportsAndAnalytics(){
        driver.findElement(OrangeHRM_HomePage.link_ReportsAndAnalytics).click();
        System.out.println("Reports and analytics link is clicked");
    }

    public static void clickLeaveLink() throws Exception{
        JavascriptExecutor js = (JavascriptExecutor)driver;
        driver.findElement(OrangeHRM_HomePage.link_Leave).click();
        System.out.println("Leave link is clicked");
        try {
            WebElement element_More = driver.findElement(By.xpath("//a[@class='top-level-menu-item '][@data-automation-id='more_menu_child_menu_top_more']"));
            js.executeScript("arguments[0].click();", element_More);
            System.out.println("more option is clicked");
        } catch (Exception e) {
            System.out.println("Exception Occurred and More button is not available!!!");
        }
        Thread.sleep(2000);
    }

    public static void clickPerformanceLink(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement element_Performance = driver.findElement(OrangeHRM_HomePage.link_Performance);
        js.executeScript("arguments[0].click();", element_Performance);
        System.out.println("Performance link clicked");
    }

    public static void clickEmployeeManagement(){
        driver.findElement(OrangeHRM_HomePage.link_EmployeeManagement).click();
        System.out.println("Employee Management link is selected");
    }
}


