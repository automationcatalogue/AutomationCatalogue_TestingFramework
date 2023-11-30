package pageObjects;

import org.openqa.selenium.By;

public class PageLocators {

    public static final By account_Name = By.xpath("//a[text()='aarosagarch@gmail.com']");
    public static final By order_Dropdown = By.xpath("(//a[text()='Orders'])[1]");
    public static final By total_Orders = By.xpath("//div[@class='order-list']/div/div/strong");
    public static final By total_Value = By.xpath("//div[@class='order-list']/div/ul/li[3]");

    public static final By arrow_Back = By.xpath("//i[text()='arrow_back']");
    public static final By name_Check = By.xpath("//tbody[@ng-if='listData.staticBody']/tr/td[2]/ng-include/span");










}
