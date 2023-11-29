package pageObjects;

import org.openqa.selenium.By;

public class PageLocators {

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

    public static final By arrow_Back = By.xpath("//i[text()='arrow_back']");
    public static final By name_Check = By.xpath("//tbody[@ng-if='listData.staticBody']/tr/td[2]/ng-include/span");










}
