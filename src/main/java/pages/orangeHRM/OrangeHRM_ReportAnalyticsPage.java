package pages.orangeHRM;

import Utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeHRM_ReportAnalyticsPage extends BaseClass {

    public OrangeHRM_ReportAnalyticsPage(WebDriver driver){
        super(driver);
    }

    public static By btn_NewReport = By.cssSelector(".oxd-button-label-wrapper");
    public static By drpdwn_ReportType = By.xpath("//div[text()='Employee Informational Report']");
    public static By drpdwn_SelectReportType = By.xpath("//div[@role='listbox']/div/div");
    public static By drpdwn_FolderType = By.xpath("(//div[@clear='false'])[2]");
    public static By drpdwn_SelectFolderType = By.xpath("(//div[@clear='false'])[2]");
    public static By btn_Next = By.xpath("//button[@type='submit']");
    public static By txtbx_ReportName = By.cssSelector("#pimDefineReportName");
    public static By btn_ReportsNext = By.xpath("//button[@translate='Next']");
    public static By btn_BackArrow = By.xpath("//i[text()='arrow_back']");
    public static By txtbx_Search = By.xpath("(//input[@placeholder='Search'])[2]");

    public static void clickNewReport(){
        driver.findElement(OrangeHRM_ReportAnalyticsPage.btn_NewReport).click();
        System.out.println("New Report button is clicked");
    }
}
