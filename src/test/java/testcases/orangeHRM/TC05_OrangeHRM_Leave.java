package testcases.orangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class TC05_OrangeHRM_Leave {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println("Chrome browser is launched");

        driver.manage().window().maximize();
        System.out.println("Chrome browser is maximized");

        driver.get("https://automatetest-trials710.orangehrmlive.com");
        System.out.println("Orange HRM Application is loaded");

        driver.findElement(By.name("txtUsername")).sendKeys("Admin");
        System.out.println("Username is Entered");

        driver.findElement(By.id("txtPassword")).sendKeys("Admin@123");
        System.out.println("Password is Entered");

        driver.findElement(By.xpath("//*[@id='frmLogin']/div[4]/button")).submit();
        System.out.println("Login button is clicked");

        String title = driver.getTitle();
        if (title.equalsIgnoreCase("Employee Management")) {
            System.out.println("Login is Successful");
        } else {
            System.out.println("Login is not Successful");
        }
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div[4]/div/div/div/ul/li[6]/a[1]/span")).click();
        System.out.println("leave option is clicked");
        WebElement element_More = driver.findElement(By.xpath("//a[@class='top-level-menu-item '][@data-automation-id='more_menu_child_menu_top_more']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element_More);
        System.out.println("more option is clicked");
        driver.findElement(By.xpath("//a[@data-automation-id='more_menu_child_menu_leave_Configure']")).click();
        System.out.println("configure option");
        WebElement element_configure = driver.findElement(By.xpath("//a[@data-automation-id='more_menu_child_menu_leave_viewWorkingWeekendList']"));
        js.executeScript("arguments[0].click();", element_configure);
        driver.switchTo().frame("noncoreIframe");
        System.out.println("Switched into iframe");
        WebElement element_add = driver.findElement(By.xpath("//*[@id='addItemBtn']/i"));
        js.executeScript("arguments[0].click();", element_add);
        System.out.println("add option is clicked");
        //driver.switchTo().defaultContent();
        // System.out.println("Exited from the frame");
        driver.findElement(By.xpath("//input[@id='addWorkingWeekend_description']")).sendKeys("Automation");
        System.out.println("Name is entered");

        WebElement element_date = driver.findElement(By.xpath("/html/body/div[1]/div[2]/section/div/div[3]/div[2]/form/div/div[1]/div[2]/label"));
        js.executeScript("arguments[0].click();", element_date);
        System.out.println("date is clicked");
        String date = "12-October-2023";
        String day = date.split("-")[0];
        String month = date.split("-")[1];
        String year = date.split("-")[2];
        driver.findElement(By.xpath("//div[@class='select-wrapper picker__select--year']/input")).click();
        System.out.println("year is clicked");
        List<WebElement> element_year = driver.findElements(By.xpath("//div[@class='select-wrapper picker__select--year']/ul/li/span"));
        for (WebElement element : element_year) {
            String actualYear = element.getText();
            if (actualYear.equalsIgnoreCase(year)) {
                element.click();
                System.out.println("Year is Selected");
                break;
            }
        }
        driver.findElement(By.xpath("//div[@class='select-wrapper picker__select--month']/input")).click();
        System.out.println("month is clicked");
        List<WebElement> element_month = driver.findElements(By.xpath("//div[@class='select-wrapper picker__select--month']/ul/li/span"));
        for (WebElement element : element_month) {
            String actualmonth = element.getText();
            if (actualmonth.equalsIgnoreCase(month)) {
                element.click();
                System.out.println("month is Selected");
                break;
            }
        }
        driver.findElement(By.xpath("//table[@id='addWorkingWeekend_date_table']/tbody/tr[2]/td[5]/div")).click();
        System.out.println("day is clicked");
        List<WebElement> element_day = driver.findElements(By.xpath("//table[@id='addWorkingWeekend_date_table']/tbody/tr[2]/td[5]/div"));
        for (WebElement element : element_day) {
            String actualday = element.getText();
            if (actualday.equalsIgnoreCase(day)) {
                element.click();
                System.out.println("day is Selected");
                break;
            }
        }
        driver.findElement(By.xpath("//*[@id='addForm']/div/div[2]/div[2]/div/input")).click();
        // driver.switchTo().defaultContent();
        //System.out.println("Exited from the frame");

        List<WebElement> allElements = driver.findElements(By.xpath("//ul[@class='dropdown-content select-dropdown active']/li/span"));
        for (WebElement element : allElements) {
            String actualValue = element.getText();
            if (actualValue.equalsIgnoreCase("Australia")) {
                element.click();
                break;
            }
        }
        System.out.println("Selection of the Location drop-down is completed");
        driver.findElement(By.xpath("//a[@id='saveItemBtn']")).click();
        System.out.println("details are saved");
    }
}
