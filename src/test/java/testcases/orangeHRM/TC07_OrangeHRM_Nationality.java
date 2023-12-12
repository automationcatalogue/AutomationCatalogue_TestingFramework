package testcases.orangeHRM;

import Utilities.Config;
import Utilities.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class TC07_OrangeHRM_Nationality {
    public static void main(String[] args) throws Exception {

        String projectPath = System.getProperty("user.dir");
        String sheetName = "HRM_Nationality";
        ExcelUtils.setExcelFilePath(projectPath + "//TestData//Automation_TestData.xlsx");
        int row = ExcelUtils.getRowNumber(Config.testID_HRM_Nationality, sheetName);

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();

        driver.get("https://testcatalogu-trials711.orangehrmlive.com/");
        System.out.println("Orange HRM Website loaded successfully");

        String userName = ExcelUtils.getCellData(sheetName, row, Config.col_UserName);
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(userName);
        System.out.println("Username entered");

        String password = ExcelUtils.getCellData(sheetName, row, Config.col_Password);
        driver.findElement(By.cssSelector("#txtPassword")).sendKeys(password);
        System.out.println("Password entered");

        driver.findElement(By.cssSelector("button[type='submit']")).submit();
        String actualTitle = driver.getTitle();
        if (actualTitle.equalsIgnoreCase("Employee Management")) {
            System.out.println("Title is Verified and Login is successful");
        } else {
            System.out.println("Title is not matched and Login is not successful");
        }

        driver.findElement(By.xpath("//a[@data-automation-id='menu_pim_viewEmployeeList']/span")).click();
        System.out.println("Employee Management link is selected");

        try {
            driver.findElement(By.xpath("//i[@class='expand-icon material-icons']")).click();
            System.out.println("More link is present and it is clicked");
        } catch (Exception e) {
            System.out.println("More option is not available");
        }

        driver.findElement(By.xpath("//a[@data-automation-id='more_menu_child_menu_admin_nationality']")).click();
        System.out.println("Nationalities link is clicked");

        driver.findElement(By.xpath("//i[text()='add']")).click();
        System.out.println("Add button is selected");

        String countryName = ExcelUtils.getCellData(sheetName, row, Config.col_Nationality_CountryName);
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys(countryName);
        System.out.println(countryName + " is entered as CountryName");

        driver.findElement(By.xpath("//a[@class='modal-action waves-effect waves-green btn primary-btn']")).click();
        System.out.println("Save button is clicked");

        driver.findElement(By.xpath("//a[@data-automation-id='menu_pim_viewEmployeeList']/span")).click();
        System.out.println("Employee Management link is clicked");

        driver.findElement(By.xpath("//a[@data-automation-id='menu_pim_viewMyDetails']")).click();
        System.out.println("MyInfo link is clicked");

        driver.findElement(By.xpath("//a[@data-automation-id='menu_employee_profile_PersonalDetails']")).click();
        System.out.println("Personal Details link is clicked");

        driver.findElement(By.xpath("((//input[@readonly='true'])[4]")).click();
        System.out.println("Nationality Dropdown is clicked");

        boolean isNationalityPresent = false;
        List<WebElement> list_Nationalities = driver.findElements(By.xpath("(//ul[@class='dropdown-content select-dropdown '])[4]/li"));
        for (WebElement element_Nationality : list_Nationalities) {
            String actualNationality = element_Nationality.getText();
            if (actualNationality.equalsIgnoreCase(countryName)) {
                isNationalityPresent = true;
                break;
            }
        }

        if(isNationalityPresent){
            System.out.println(countryName + "New Nationality is verified");
        }else{
            System.out.println(countryName + "New Nationality is not present");
        }

        driver.findElement(By.xpath("//span[text()='Log Out']")).click();
        System.out.println("Logout is successfully done from the Website");

        driver.quit();
        System.out.println("Testcase Execution is completed and Driver instance is terminated");
    }
}
