package testcases.orangeHRM;

import Utilities.CommonMethods;
import Utilities.Config;
import Utilities.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.orangeHRM.OrangeHRM_EmployeeManagement;
import pages.orangeHRM.OrangeHRM_HomePage;
import pages.orangeHRM.OrangeHRM_LoginPage;

import java.time.Duration;
import java.util.List;

public class TC07_OrangeHRM_Nationality {
    public static void main(String[] args) throws Exception {

        String projectPath = System.getProperty("user.dir");
        String sheetName = "HRM_Nationality";
        ExcelUtils.setExcelFilePath(projectPath + "//TestData//Automation_TestData.xlsx");
        int row = ExcelUtils.getRowNumber(Config.testID_HRM_Nationality, sheetName);
        String userName = ExcelUtils.getCellData(sheetName, row, Config.col_UserName);
        String password = ExcelUtils.getCellData(sheetName, row, Config.col_Password);

        WebDriver driver = CommonMethods.openBrowser();

        driver.get(Config.orangeHRM_URL);
        System.out.println("Orange HRM Website loaded successfully");

        OrangeHRM_LoginPage.orangeHRM_Login(driver, sheetName, row, userName, password);

        OrangeHRM_HomePage.verifyTitle(driver);

        driver.findElement(OrangeHRM_HomePage.link_EmployeeManagement).click();
        System.out.println("Employee Management link is selected");

        try {
            driver.findElement(OrangeHRM_EmployeeManagement.link_MoreOption).click();
            System.out.println("More link is present and it is clicked");
        } catch (Exception e) {
            System.out.println("More option is not available");
        }

        driver.findElement(OrangeHRM_EmployeeManagement.link_Nationality).click();
        System.out.println("Nationalities link is clicked");

        driver.findElement(OrangeHRM_EmployeeManagement.btn_addNationality).click();
        System.out.println("Add button is selected");

        String countryName = ExcelUtils.getCellData(sheetName, row, Config.col_Nationality_CountryName);
        driver.findElement(OrangeHRM_EmployeeManagement.txtbx_CountryName).sendKeys(countryName);
        System.out.println(countryName + " is entered as CountryName");

        driver.findElement(OrangeHRM_EmployeeManagement.btn_Save).click();
        System.out.println("Save button is clicked");

        driver.findElement(OrangeHRM_HomePage.link_EmployeeManagement).click();
        System.out.println("Employee Management link is clicked");

        driver.findElement(OrangeHRM_EmployeeManagement.link_MyInfo).click();
        System.out.println("MyInfo link is clicked");

        driver.findElement(OrangeHRM_EmployeeManagement.link_PersonalDetails).click();
        System.out.println("Personal Details link is clicked");

        driver.findElement(OrangeHRM_EmployeeManagement.drpdwn_Nationality).click();
        System.out.println("Nationality Dropdown is clicked");

        boolean isNationalityPresent = false;
        List<WebElement> list_Nationalities = driver.findElements(OrangeHRM_EmployeeManagement.drpdown_selectNationality);
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

        OrangeHRM_HomePage.logout(driver);

        driver.quit();
        System.out.println("Testcase Execution is completed and Driver instance is terminated");
    }
}
