package pages.orangeHRM;

import org.openqa.selenium.By;

public class OrangeHRM_WorkingWeekendPage {
    public static By btn_addWorkingWeekend= By.xpath("//a[@id='addItemBtn']/i");
    public static By txtbx_Name=By.xpath("//input[@id='addWorkingWeekend_description']");
    public static By cal_Date=By.xpath("//label[@for='addWorkingWeekend_date']");
    public static By drpdwn_Year=By.xpath("//div[@class='select-wrapper picker__select--year']/input");
    public static By drpdwn_Month=By.xpath("//div[@class='select-wrapper picker__select--month']/input");
    public static By link_Day=By.xpath("//table[@id='addWorkingWeekend_date_table']/tbody/tr/td/div[contains(@class,'infocus')]");
    public static By link_Hours=By.xpath("//*[@id='addForm']/div/div[2]/div[1]/div/input");
    public static By drpdwn_Country=By.xpath("//form[@id='addForm']/div/div[2]/div[2]/div/input");
    public static By btn_Save =By.xpath("//a[@id='saveItemBtn']");
}
