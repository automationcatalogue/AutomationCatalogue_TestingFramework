package pageObjects;

import org.openqa.selenium.By;

public class PageLocators {

    public static final By jobttlBtn = By.xpath("//label[@for='selectedFilters_job_title']");

    public static final By ReimbursementCurrency = By.xpath("//td[text()='Total Estimated Expense (Reimbursement Currency)']");


    public static final By txtbx_userName = By.xpath("//input[@id='txtUsername']");
    public static final By txtbx_pass = By.cssSelector("#txtPassword");
    public static final By butt_Login = By.cssSelector("button[type='submit']");
    public static final By perfor_Tab = By.xpath("//a[@class=' main-menu-item-1' and @data-tooltip='Performance']/span");
    public static final By add_Appraisal = By.xpath("//i[@class='material-icons' and text()='add']");
    public static final By txtbx_Employee = By.cssSelector("input[name='employeeAppraisal[emp_name][empName]']");
    public static final By empName = By.xpath("//div[@class='autoComplete-title']/strong");
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
    public static final By Add_cart = By.xpath("(//input[@value='Add to cart'])[1]");
    public static final By shp_cart = By.xpath("//span[text()='Shopping cart']");
    public static final By Dis_code = By.xpath("//input[@name='discountcouponcode']");
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
    public static final By account_Name = By.xpath("//a[text()='aarosagarch@gmail.com']");
    public static final By order_Dropdown = By.xpath("(//a[text()='Orders'])[1]");
    public static final By total_Orders = By.xpath("//div[@class='order-list']/div/div/strong");
    public static final By total_Value = By.xpath("//div[@class='order-list']/div/ul/li[3]");
    public static final By final_Review = By.xpath("//a[@data-activates='dropdown-7']");
    public static final By butt_Submit = By.xpath("//a[text()='Submit']");
    public static final By arrow_Back = By.xpath("//i[text()='arrow_back']");
    public static final By name_Check = By.xpath("//tbody[@ng-if='listData.staticBody']/tr/td[2]/ng-include/span");










}
