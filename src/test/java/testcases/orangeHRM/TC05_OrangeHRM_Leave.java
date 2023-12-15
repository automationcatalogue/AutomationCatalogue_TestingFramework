package testcases.orangeHRM;

import Utilities.Config;
import Utilities.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.orangeHRM.OrangeHRM_HomePage;
import pages.orangeHRM.OrangeHRM_LeavePage;
import pages.orangeHRM.OrangeHRM_LoginPage;
import pages.orangeHRM.OrangeHRM_WorkingWeekendPage;

import java.time.Duration;
import java.util.List;

public class TC05_OrangeHRM_Leave {
    public static void main(String[] args) throws Exception {
        String projectPath = System.getProperty("user.dir");
        String sheetName = "HRM_Leave";
        ExcelUtils.setExcelFilePath(projectPath + "//TestData//Automation_TestData.xlsx");
        int row = ExcelUtils.getRowNumber(Config.testID_HRMLeave, sheetName);

        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        System.out.println("Chrome browser is launched");

        driver.manage().window().maximize();
        System.out.println("Chrome browser is maximized");

        driver.get(Config.orangeHRM_URL);
        System.out.println("Orange HRM Application is loaded");

        OrangeHRM_LoginPage.orangeHRM_Login(driver, sheetName, row);

        OrangeHRM_HomePage.verifyTitle(driver);

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
        driver.findElement(OrangeHRM_LeavePage.link_Configure).click();
        System.out.println("configure link is clicked");

        WebElement element_configure = driver.findElement(OrangeHRM_LeavePage.link_Workingweekends);
        js.executeScript("arguments[0].click();", element_configure);
        System.out.println("Working Weekends is clicked");

        driver.switchTo().frame("noncoreIframe");
        System.out.println("Switched into iframe");

        WebElement element_add = driver.findElement(OrangeHRM_WorkingWeekendPage.btn_addWorkingWeekend);
        js.executeScript("arguments[0].click();", element_add);
        System.out.println("add option is clicked");

        String name = ExcelUtils.getCellData(sheetName, row, Config.col_Name);
        driver.findElement(OrangeHRM_WorkingWeekendPage.txtbx_Name).sendKeys(name);
        System.out.println(name + " is entered as Name");

        WebElement element_date = driver.findElement(OrangeHRM_WorkingWeekendPage.cal_Date);
        js.executeScript("arguments[0].click();", element_date);
        System.out.println("Date calendar is clicked");

        String date = ExcelUtils.getCellData(sheetName, row, Config.col_Date);
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

        driver.findElement(OrangeHRM_WorkingWeekendPage.link_Hours).click();
        System.out.println("hours drop-down is clicked");
        String hours = ExcelUtils.getCellData(sheetName, row, Config.col_Workinghours);
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

        driver.findElement(OrangeHRM_WorkingWeekendPage.drpdwn_Country).click();
        System.out.println("Country drop-down is clicked");

        String country = ExcelUtils.getCellData(sheetName, row, Config.col_country);
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

        List<WebElement> elements_Names = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td[2]/a"));
        for (WebElement element_Name : elements_Names) {
            String actualName = element_Name.getText();
            if (actualName.equalsIgnoreCase(name)) {
                System.out.println(actualName + " is verified After Saving Details");
            }
        }

        Thread.sleep(2000);
        OrangeHRM_HomePage.logout(driver);

        driver.quit();
        System.out.println("Testcase Execution is completed and Driver instance is terminated");
    }
}

