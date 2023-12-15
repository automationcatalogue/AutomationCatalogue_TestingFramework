package pages.orangeHRM;

import org.openqa.selenium.By;

public class OrangeHRM_HRAdministrationPage {
    public static By table_UserData = By.xpath("//div[@id='systemUserDiv']/crud-panel/div/div/list/table/tbody/tr[1]/td[2]/ng-include/span");
    public static By btn_AddUser = By.xpath("//i[text()='add']");
}
