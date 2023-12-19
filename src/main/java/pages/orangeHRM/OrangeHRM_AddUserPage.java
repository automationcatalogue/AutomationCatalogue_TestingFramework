package pages.orangeHRM;

import org.openqa.selenium.By;

public class OrangeHRM_AddUserPage {
    public static By txtbx_EmployeeName = By.id("selectedEmployee_value");
    public static By txtbx_UserName = By.id("user_name");
    public static By drpdwn_Ess = By.cssSelector("button.btn[aria-owns='bs-select-1']");
    public static By label_DefaultEss= By.cssSelector("#bs-select-1-1");
    public static By drpdwn_Supervisor = By.xpath("//button[@type='button'][@data-id='supervisorrole']");
    public static By txt_DefaultSupervisor = By.xpath("//span[text()='Default Supervisor']");
    public static By drpdwn_Admin= By.xpath("//button[@data-id='adminrole']/div/div/div");
    public static By label_Admin = By.xpath("//button[@data-id='adminrole']//following-sibling::div//ul/li//span");
    public static By txtbx_NewPassword = By.id("password");
    public static By txtbx_ConfirmPassword = By.cssSelector("#confirmpassword");
    public static By btn_Save = By.xpath("//button[@id='modal-save-button']");

}
