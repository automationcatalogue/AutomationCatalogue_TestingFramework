package teachings.selenium.webElementBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddEmployee {
    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();
        System.out.println("Chrome browser is launched");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.manage().window().maximize();
        System.out.println("Chrome browser is maximized");

        driver.get("https://automatetest-trials710.orangehrmlive.com/");
        System.out.println("Orange HRM Application is loaded");

        driver.findElement(By.name("txtUsername")).sendKeys("Admin");
        System.out.println("Username is Entered");

        driver.findElement(By.id("txtPassword")).sendKeys("Admin@123");
        System.out.println("Password is Entered");

        driver.findElement(By.xpath("//*[@id='frmLogin']/div[4]/button")).submit();
        System.out.println("Login button is clicked");

        String title=driver.getTitle();
        if(title.equalsIgnoreCase("Employee Management")){
            System.out.println("Login is Successful");
        }else{
            System.out.println("Login is not Successful");
        }

        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div[4]/div/div/div/ul/li[3]/a[1]/span")).click();
        System.out.println("Employee Management Clicked");


        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='addEmployeeButton']/i")));
        driver.findElement(By.xpath("//*[@id='addEmployeeButton']/i")).click();
        System.out.println("Add Employee button is clicked");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name-box")));
        WebElement element_firstname= driver.findElement(By.id("first-name-box"));
        element_firstname.sendKeys("Sagar");
        System.out.println("Firstname is entered as Sagar");


        element_firstname.clear();
        System.out.println("Firstname data is cleared");

        element_firstname.sendKeys("Test");
        System.out.println("Firstname is entered as Test");

        driver.findElement(By.id("last-name-box")).sendKeys("Automation");
        System.out.println("Lastname is entered as Automation");

        driver.findElement(By.xpath("//*[@id='modal-holder']/div/div/div/div[2]/form/oxd-decorator/div/div[2]/div/div[3]/div/div[3]/div/div[1]/button/div/div/div")).click();
        System.out.println("Location drop-down is clicked");



        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/form/oxd-decorator/div/div[2]/div/div[3]/div/div[3]/div/div[1]/div/div/ul/li[8]/a/span")).click();
        System.out.println("India office is selected");

        boolean b= driver.findElement(By.id("modal-save-button")).isDisplayed();
        if(b){
            driver.findElement(By.id("modal-save-button")).click();
            System.out.println("Next button is displayed and it is clicked");
        }else{
            System.out.println("Next button is not displayed");
        }

        driver.findElement(By.xpath("//*[@id='emp_marital_status_inputfileddiv']/div/input")).click();
        System.out.println("Marital Status is clicked");

        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/section/div[3]/ui-view/div[1]/div/form/materializecss-decorator[4]/div/sf-decorator[2]/div/div/ul/li[2]/span")).click();
        System.out.println("Married status is selected");


        driver.findElement(By.xpath("//*[@id='emp_gender_inputfileddiv']/div/input")).click();
        System.out.println("Gender drop-down is clicked");


        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/section/div[3]/ui-view/div[1]/div/form/materializecss-decorator[4]/div/sf-decorator[3]/div/div/ul/li[3]/span")).click();
        System.out.println("Male is selected");

        WebElement element_Next = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/section/div[3]/ui-view/div[2]/button[2]"));
        boolean b1 = element_Next.isEnabled();
        if(b1){
            element_Next.click();
            System.out.println("Next button is enabled and clicked");
        }else{
            System.out.println("Element is not enabled");
        }


        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/section/div[3]/ui-view/div[1]/div/custom-fields-panel/div/form/oxd-decorator[1]/div/div[2]/div/div[1]/button/div/div/div")).click();
        System.out.println("FTE drop-down is clicked");


        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/section/div[3]/ui-view/div[1]/div/custom-fields-panel/div/form/oxd-decorator[1]/div/div[2]/div/div[1]/div/div/ul/li[3]/a")).click();
        System.out.println("075 is selected");


        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/section/div[3]/ui-view/div[1]/div/custom-fields-panel/div/form/oxd-decorator[1]/div/div[1]/div/div[1]/button/div/div/div")).click();
        System.out.println("Region drop-down is clicked");


        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/section/div[3]/ui-view/div[1]/div/custom-fields-panel/div/form/oxd-decorator[1]/div/div[1]/div/div[1]/div/div/ul/li[3]/a")).click();
        System.out.println("Region-2 is selected");


        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/section/div[3]/ui-view/div[1]/div/custom-fields-panel/div/form/oxd-decorator[1]/div/div[3]/div/div[1]/button/div/div/div")).click();
        System.out.println("Temporary Department drop-down is clicked");


        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/section/div[3]/ui-view/div[1]/div/custom-fields-panel/div/form/oxd-decorator[1]/div/div[3]/div/div[1]/div/div/ul/li[5]/a")).click();
        System.out.println("Sub-unit4 is selected");

        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/section/div[3]/ui-view/div[2]/button[3]")).click();
        System.out.println("Save button is clicked");


        String empID  = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/section/div[3]/ui-view/div[2]/div/div/div/dashboard-layout/div/widget-container/div/div[1]/span/span/vue-dashboard-widget/div/div/div/div[2]/div[2]/div[2]/div/div[1]/div/div[2]/div[3]/span")).getText();
        System.out.println("Employee Id is created :"+empID);


    }
}
