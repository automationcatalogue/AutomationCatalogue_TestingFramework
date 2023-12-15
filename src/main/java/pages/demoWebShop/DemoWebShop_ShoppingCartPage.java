package pages.demoWebShop;

import org.openqa.selenium.By;

public class DemoWebShop_ShoppingCartPage {
    public static By chckbox_termsconditions=By.xpath("//input[@id='termsofservice']");
    public static By btn_Checkout=By.xpath("//button[@id='checkout']");
    public static By txtbx_DiscountCode = By.xpath("//input[@name='discountcouponcode']");
    public static By btn_ApplyCoupon = By.xpath("//input[@name='applydiscountcouponcode']");
    public static By txt_ActualValue = By.xpath("(//span[@class='product-price'])[1]");
    public static By txt_DiscountValue = By.xpath("//span[@class='product-price order-total']/strong");



}
