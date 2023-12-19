package pages.orangeHRM;

import org.openqa.selenium.By;

public class OrangeHRM_EmployeeManagement {
    public static By link_MoreOption=By.xpath("//i[@class='expand-icon material-icons']");
    public static By link_Nationality=By.xpath("//a[@data-automation-id='more_menu_child_menu_admin_nationality']");
    public static By btn_addNationality=By.xpath("//i[text()='add']");
    public static By txtbx_CountryName=By.xpath("//input[@id='name']");
    public static By btn_Save=By.xpath("//a[@class='modal-action waves-effect waves-green btn primary-btn']");
    public static By link_MyInfo=By.xpath("//a[@data-automation-id='menu_pim_viewMyDetails']");

    public static By link_PersonalDetails=By.xpath("//a[@data-automation-id='menu_employee_profile_PersonalDetails']");
    public static By drpdwn_Nationality=(By.xpath("((//input[@readonly='true'])[4]"));

    public static By drpdown_selectNationality=By.xpath("(//ul[@class='dropdown-content select-dropdown '])[4]/li");

}
