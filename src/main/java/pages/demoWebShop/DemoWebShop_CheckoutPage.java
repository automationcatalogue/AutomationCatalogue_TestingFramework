package pages.demoWebShop;

import org.openqa.selenium.By;

public class DemoWebShop_CheckoutPage {
    public static By btn_ContinueBillingAddress=By.xpath("//*[@id='billing-buttons-container']/input");
    public static By link_ShippingAddress=By.xpath("//*[@id='shipping-buttons-container']/input");
    public static By btn_ContinueShippingAddress=By.xpath("//*[@id='shipping-buttons-container']/input");
    public static By btn_ContinueShippingMethod=By.xpath("//*[@id='shipping-method-buttons-container']/input");
    public static By rbtn_MoneyOrder=By.xpath("//input[@id='paymentmethod_1']");
    public static By btn_ContinuePaymentMethod=By.xpath("//*[@id='payment-method-buttons-container']/input");
    public static By btn_ContinuePaymentInformation=By.xpath("//*[@id='payment-info-buttons-container']/input");
    public static By btn_ConfirmOrder=By.xpath("//*[@id='confirm-order-buttons-container']/input");

}
