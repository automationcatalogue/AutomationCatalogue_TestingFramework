package pages.demoWebShop;

import Utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoWebShop_ShoppingCartPage extends BaseClass {

    public DemoWebShop_ShoppingCartPage(WebDriver driver){
        super(driver);
    }

    public static By chckbox_termsconditions=By.xpath("//input[@id='termsofservice']");
    public static By btn_Checkout=By.xpath("//button[@id='checkout']");
    public static By txtbx_DiscountCode = By.xpath("//input[@name='discountcouponcode']");
    public static By btn_ApplyCoupon = By.xpath("//input[@name='applydiscountcouponcode']");
    public static By txt_ActualValue = By.xpath("(//span[@class='product-price'])[1]");
    public static By txt_DiscountValue = By.xpath("//span[@class='product-price order-total']/strong");

    public static void clickTermsAndCheckout(){
        driver.findElement(DemoWebShop_ShoppingCartPage.chckbox_termsconditions).click();
        System.out.println("Terms and conditions clicked");
        driver.findElement(DemoWebShop_ShoppingCartPage.btn_Checkout).click();
        System.out.println("checkout button is clicked");
    }

}
