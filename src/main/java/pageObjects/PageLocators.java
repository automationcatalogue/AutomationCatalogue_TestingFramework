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

    public static final By folderDrpdwn = By.xpath("//div[@id='mount-vue-app']/div/div[2]/div[3]/div[3]/div/div/div/form/div[2]/div[2]/div/div");

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

    public static final By txtbx_userName = By.xpath("//input[@id='txtUsername']");
    public static final By txtbx_pass = By.cssSelector("#txtPassword");
    public static final By butt_Login = By.cssSelector("button[type='submit']");
    public static final By perfor_Tab = By.xpath("//a[@class=' main-menu-item-1' and @data-tooltip='Performance']/span");
    public static final By add_Appraisal = By.xpath("//i[@class='material-icons' and text()='add']");
    public static final By txtbx_Employee = By.cssSelector("input[name='employeeAppraisal[emp_name][empName]']");
    public static final By empName = By.xpath("//div[text()='1116']");
    public static final By description = By.cssSelector("#employeeAppraisal_description");
    public static final By durationDropdown = By.xpath("//div[@class='select-wrapper']");
    public static final By timePeriod = By.xpath("//div[@class='select-wrapper']/ul/li/span");
    public static final By dateFrom = By.cssSelector("#date_from");
    public static final By fromMonth = By.xpath("//div[@class='select-wrapper picker__select--month']");
    public static final By fromMonth1 = By.xpath("//div[@class='select-wrapper picker__select--month']/ul/li/span");
    public static final By fromYear = By.xpath("//div[@class='select-wrapper picker__select--year']");
    public static final By fromYear1 = By.xpath("//div[@class='select-wrapper picker__select--year']/ul/li/span");
    public static final By fromDate = By.xpath("(//table[@class='picker__table'])[1]/tbody/tr/td/div[contains(@class,'infocus')]");
    public static final By toDatedrop = By.cssSelector("#date_to");
    public static final By toMonth = By.xpath("(//div[@class='select-wrapper picker__select--month'])[2]");
    public static final By toMonth1 = By.xpath("(//div[@class='select-wrapper picker__select--month'])[2]/ul/li/span");
    public static final By toYear = By.xpath("(//div[@class='select-wrapper picker__select--year'])[2]");
    public static final By toYear1 = By.xpath("(//div[@class='select-wrapper picker__select--year'])[2]/ul/li/span");
    public static final By toDate = By.xpath("(//table[@class='picker__table'])[2]/tbody/tr/td/div[contains(@class,'infocus')]");
    public static final By dueDateDrop = By.cssSelector("#date_due");
    public static final By dueMonth = By.xpath("(//div[@class='select-wrapper picker__select--month'])[3]");
    public static final By dueMonth1 = By.xpath("(//div[@class='select-wrapper picker__select--month'])[3]/ul/li/span");
    public static final By dueYear = By.xpath("(//div[@class='select-wrapper picker__select--year'])[3]");
    public static final By dueYear1 = By.xpath("(//div[@class='select-wrapper picker__select--year'])[3]/ul/li/span");
    public static final By dueDate = By.xpath("(//table[@class='picker__table'])[3]/tbody/tr/td/div[contains(@class,'infocus')]");
    public static final By nextButton = By.cssSelector("#saveBtn");
    public static final By appraisal = By.xpath("//label[@for='appraisalEval_eval_name_grp_self']");
    public static final By nextButton1 = By.cssSelector("#saveBtn");




    public static final By Loginbtn = By.xpath("//a[@href='/login']");
    public static final By usrnamebx = By.cssSelector("#Email");
    public static final By paswrdbx = By.cssSelector(".password");
    public static final By Login_btn = By.xpath("//input[@value='Log in']");
    public static final By computers_icn = By.xpath("(//a[@href='/computers'])[1]");
    public static final By dsktp_img = By.xpath("//img[@alt='Picture for category Desktops']");
    public static final By Owndsktp = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[1]/div/div[1]/a/img");
    public static final By Add_cart = By.xpath("(//input[@value='Add to cart'])[1]");
    public static final By shp_cart = By.xpath("//span[text()='Shopping cart']");
    public static final By Dis_code = By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/div[2]/div[1]/div[1]/div[1]/div[3]/input[1]");
    public static final By Apply_cpn = By.xpath("//input[@name='applydiscountcouponcode']");
    public static final By Actual_val = By.xpath("(//span[@class='product-price'])[1]");
    public static final By Dis_val = By.xpath("//span[@class='product-price order-total']/strong");
    public static final By Agree_btn = By.xpath("//input[@id='termsofservice']");
    public static final By checkout_btn = By.xpath("//button[@type='submit']");
    public static final By Billing_btn = By.xpath("(//input[@title='Continue'])[1]");
    public static final By Shipping_btn = By.xpath("(//input[@title='Continue'])[2]");
    public static final By shipping_mtd = By.xpath("//div[@id='shipping-method-buttons-container']/input");
    public static final By creditcard = By.xpath("//label[text()='Credit Card']");
    public static final By payment_btn  = By.xpath("//div[@id='payment-method-buttons-container']/input");
    public static final By Card_holder = By.cssSelector("#CardholderName");
    public static final By Card_number = By.cssSelector("#CardNumber");
    public static final By Card_month  = By.cssSelector("#ExpireMonth");
    public static final By Card_year  = By.cssSelector("#ExpireYear");
    public static final By Cardcode = By.cssSelector("#CardCode");
    public static final By Paymentinfo_btn = By.xpath("//div[@id='payment-info-buttons-container']/input");
    public static final By Conformorder_btn  = By.xpath("//div[@id='confirm-order-buttons-container']/input");
    public static final By Order_details = By.xpath("//ul[@class='details']/li[2]/a");
    public static final By Order_ID = By.xpath("//div[@class='order-number']/strong");
    public static final By Order_value = By.xpath("//div[@class='order-total']/strong");








}
