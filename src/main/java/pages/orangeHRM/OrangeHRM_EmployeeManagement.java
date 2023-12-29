package pages.orangeHRM;

import Utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OrangeHRM_EmployeeManagement extends BaseClass {

    public OrangeHRM_EmployeeManagement(WebDriver driver){
        super(driver);
    }

    public static By link_MoreOption=By.xpath("//i[@class='expand-icon material-icons']");
    public static By link_Nationality=By.xpath("//a[@data-automation-id='more_menu_child_menu_admin_nationality']");
    public static By btn_addNationality=By.xpath("//i[text()='add']");
    public static By txtbx_CountryName=By.xpath("//input[@id='name']");
    public static By btn_Save=By.xpath("//a[@class='modal-action waves-effect waves-green btn primary-btn']");
    public static By link_MyInfo=By.xpath("//a[@data-automation-id='menu_pim_viewMyDetails']");

    public static By link_PersonalDetails=By.xpath("//a[@data-automation-id='menu_employee_profile_PersonalDetails']");
    public static By drpdwn_Nationality=(By.xpath("((//input[@readonly='true'])[4]"));

    public static By drpdown_selectNationality=By.xpath("(//ul[@class='dropdown-content select-dropdown '])[4]/li");

    public static void clickNationality(){
        try {
            driver.findElement(OrangeHRM_EmployeeManagement.link_MoreOption).click();
            System.out.println("More link is present and it is clicked");
        } catch (Exception e) {
            System.out.println("More option is not available");
        }

        driver.findElement(OrangeHRM_EmployeeManagement.link_Nationality).click();
        System.out.println("Nationalities link is clicked");
    }

    public static void createCountryName(String countryName){
        driver.findElement(OrangeHRM_EmployeeManagement.btn_addNationality).click();
        System.out.println("Add button is selected");

        driver.findElement(OrangeHRM_EmployeeManagement.txtbx_CountryName).sendKeys(countryName);
        System.out.println(countryName + " is entered as CountryName");

        driver.findElement(OrangeHRM_EmployeeManagement.btn_Save).click();
        System.out.println("Save button is clicked");
    }

    public static void clickMyInfo(){
        driver.findElement(OrangeHRM_EmployeeManagement.link_MyInfo).click();
        System.out.println("MyInfo link is clicked");
    }

    public static void clickPersonalDetails(){
        driver.findElement(OrangeHRM_EmployeeManagement.link_PersonalDetails).click();
        System.out.println("Personal Details link is clicked");
    }

    public static void validateCountryName(String countryName){
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
    }

}
