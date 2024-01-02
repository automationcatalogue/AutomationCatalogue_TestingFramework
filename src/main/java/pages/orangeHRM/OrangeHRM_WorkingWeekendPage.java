package pages.orangeHRM;

import Utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class OrangeHRM_WorkingWeekendPage extends BaseClass {

    public OrangeHRM_WorkingWeekendPage(WebDriver driver){
        super(driver);
    }

    public static By btn_addWorkingWeekend= By.xpath("//a[@id='addItemBtn']/i");
    public static By txtbx_Name=By.xpath("//input[@id='addWorkingWeekend_description']");
    public static By cal_Date=By.xpath("//label[@for='addWorkingWeekend_date']");
    public static By drpdwn_Year=By.xpath("//div[@class='select-wrapper picker__select--year']/input");
    public static By drpdwn_Month=By.xpath("//div[@class='select-wrapper picker__select--month']/input");
    public static By link_Day=By.xpath("//table[@id='addWorkingWeekend_date_table']/tbody/tr/td/div[contains(@class,'infocus')]");
    public static By link_Hours=By.xpath("//*[@id='addForm']/div/div[2]/div[1]/div/input");
    public static By drpdwn_Country=By.xpath("//form[@id='addForm']/div/div[2]/div[2]/div/input");
    public static By btn_Save =By.xpath("//a[@id='saveItemBtn']");

    public static void enterName(String name){
        driver.switchTo().frame("noncoreIframe");
        System.out.println("Switched into iframe");

        WebElement element_add = driver.findElement(OrangeHRM_WorkingWeekendPage.btn_addWorkingWeekend);
        js.executeScript("arguments[0].click();", element_add);
        System.out.println("add option is clicked");

        driver.findElement(OrangeHRM_WorkingWeekendPage.txtbx_Name).sendKeys(name);
        System.out.println(name + " is entered as Name");
    }

    public static void selectDate(String date) throws Exception{
        WebElement element_date = driver.findElement(OrangeHRM_WorkingWeekendPage.cal_Date);
        js.executeScript("arguments[0].click();", element_date);
        System.out.println("Date calendar is clicked");

        String day = date.split("/")[0];
        String month = date.split("/")[1];
        String year = date.split("/")[2];

        //Year
        driver.findElement(OrangeHRM_WorkingWeekendPage.drpdwn_Year).click();
        System.out.println("Year drop-down is clicked");
        Thread.sleep(2000);
        List<WebElement> elements_years = driver.findElements(By.xpath("//div[@class='select-wrapper picker__select--year']/ul/li/span"));
        for (WebElement element_year : elements_years) {
            String actualYear = element_year.getText();
            if (actualYear.equalsIgnoreCase(year)) {
                element_year.click();
                System.out.println(actualYear + " Year is Selected");
                break;
            }
        }
        //Month
        Thread.sleep(2000);
        driver.findElement(OrangeHRM_WorkingWeekendPage.drpdwn_Month).click();
        System.out.println("Month drop-down is clicked");
        wait.until((ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='select-wrapper picker__select--month']/ul/li/span"))));
        List<WebElement> elements_Months = driver.findElements(By.xpath("//div[@class='select-wrapper picker__select--month']/ul/li/span"));
        for (WebElement element_Month : elements_Months) {
            String actualMonth = element_Month.getText();
            if (actualMonth.equalsIgnoreCase(month)) {
                element_Month.click();
                System.out.println(actualMonth + " month is Selected");
                break;
            }
        }
        //Day
        Thread.sleep(2000);
        List<WebElement> elements_Days = driver.findElements(OrangeHRM_WorkingWeekendPage.link_Day);
        for (WebElement element_Day : elements_Days) {
            String actualDay = element_Day.getText();
            if (actualDay.equalsIgnoreCase(day)) {
                element_Day.click();
                System.out.println(actualDay + " day is Selected");
                break;
            }
        }
    }

    public static void enterWorkingHours(String hours) throws  Exception{
        JavascriptExecutor js = (JavascriptExecutor)driver;
        driver.findElement(OrangeHRM_WorkingWeekendPage.link_Hours).click();
        System.out.println("hours drop-down is clicked");

        Thread.sleep(5000);
        if (hours.equalsIgnoreCase("Full Day")) {
            js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//label[@for='addWorkingWeekend_length']/..//li[1]/span")));
            System.out.println("Full Day value is selected from Working Hours drop-down");
        } else if (hours.equalsIgnoreCase("Half Day")) {
            js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//label[@for='addWorkingWeekend_length']/..//li[2]/span")));
            System.out.println("Half Day value is selected from Working Hours drop-down");
        } else {
            System.out.println("Invalid data is given in Excel sheet");
        }
    }

    public static void selectCountry(String country) throws Exception{
        driver.findElement(OrangeHRM_WorkingWeekendPage.drpdwn_Country).click();
        System.out.println("Country drop-down is clicked");

        wait.until((ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@class='dropdown-content select-dropdown active']/li/span"))));
        List<WebElement> element_Countries = driver.findElements(By.xpath("//ul[@class='dropdown-content select-dropdown active']/li/span"));
        for (WebElement element_Country : element_Countries) {
            String actualCountry = element_Country.getText();
            if (actualCountry.equalsIgnoreCase(country)) {
                element_Country.click();
                System.out.println(actualCountry + " is selected as Country");
                break;
            }
        }
        Thread.sleep(2000);
        driver.findElement(OrangeHRM_WorkingWeekendPage.btn_Save).click();
        System.out.println("Save button is clicked");
    }

    public static void validateName(String name){
        List<WebElement> elements_Names = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td[2]/a"));
        for (WebElement element_Name : elements_Names) {
            String actualName = element_Name.getText();
            if (actualName.equalsIgnoreCase(name)) {
                System.out.println(actualName + " is verified After Saving Details");
            }
        }
    }
}
