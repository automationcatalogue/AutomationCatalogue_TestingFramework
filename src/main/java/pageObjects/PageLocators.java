package pageObjects;

import org.openqa.selenium.By;

public class PageLocators {
    public static final By usrnmbx = By.name("txtUsername");

    public static final  By pwdbx =By.id("txtPassword");
    public static final By btn_login = By.xpath("//button[@type='submit']");

    public static final By reportstxtbx = By.xpath("(//span[text()='Reports and Analytics'])[1]");

    public static final By newreportbtn = By.cssSelector(".oxd-button-label-wrapper");

    public static final By empinfobtn = By.xpath("//div[text()='Employee Informational Report']");

    public static final By reportsDrpdwn = By.xpath("//div[@role='listbox']/div/div");

    public static final By selfolderBtn = By.xpath("//div[@id='mount-vue-app']/div/div[2]/div[3]/div[3]/div/div/div/form/div[2]/div[2]/div/div");

    public static final By folderDrpdwn = By.xpath("//div[@id='mount-vue-app']/div/div[2]/div[3]/div[3]/div/div/div/form/div[2]/div[2]/div/div[1]/div");

    public static final By nxtBtn1 = By.xpath("//div[@id='mount-vue-app']/div/div[2]/div[3]/div[3]/div/div/div/form/div[4]/button[2]/div");

    public static final By repnameBtn = By.cssSelector("#pimDefineReportName");

    public static final By nxtBtn2 = By.xpath("//button[@translate='Next']");

    public static final By trvlreqBtn = By.xpath("//label[@for='selectedFilters_request_id']");

    public static final By jobttlBtn = By.xpath("//label[@for='selectedFilters_job_title']");

    public static final By nxtBtn3 = By.xpath("//button[text()='Next']");

    public static final By disfieldBx = By.cssSelector("#display-group-dropdown-trigger");

    public static final By displaydrpdwn = By.xpath("//ul[@id='add-display-group-dropdown']/li");

    public static final By slctEstDt = By.xpath("//label[text()='Estimated Date']");

    public static final By trvlreqbx= By.xpath("//label[text()='Travel Request ID']");

    public static final By cashadvbx = By.xpath("//label[text()='Cash in Advance']");

    public static final By saveBtn = By.xpath("//button[text()='Save']");

    public static final By backarrowbtn = By.xpath("//i[text()='arrow_back']");

    public static final By searchbx = By.xpath("(//input[@placeholder='Search'])[2]");

    public static final By enterbtn = By.xpath("(//input[@placeholder='Search'])[2]");

    public static final By texttrvlreq = By.xpath("//td[text()='Travel Request ID']");

    public static final By textEstdt = By.xpath("//td[text()='Estimated Date']");

    public static final By textCash = By.xpath("//td[text()='Cash in Advance']");



}
