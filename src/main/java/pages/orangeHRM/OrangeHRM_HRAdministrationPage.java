package pages.orangeHRM;

import org.openqa.selenium.By;

public class OrangeHRM_HRAdministrationPage {
    public static By table_UserData = By.xpath("//div[@id='systemUserDiv']/crud-panel/div/div/list/table/tbody/tr[1]/td[2]/ng-include/span");
    public static By empNames = By.xpath("//list/table//tbody/tr/td[4]//span");
    public static By chkbx_ChangePassword = By.xpath("//label[@for='changepassword']/span");
    public static By btn_AddUser = By.xpath("//i[text()='add']");
}
