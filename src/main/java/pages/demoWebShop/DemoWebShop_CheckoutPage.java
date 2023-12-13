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
    public static By btn_CreditCardPayment = By.xpath("//label[text()='Credit Card']");
    public static By btn_CreditCardContinueShippingMethod = By.xpath("//div[@id='payment-method-buttons-container']/input");
    public static By txtbx_CardholderName = By.cssSelector("#CardholderName");
    public static By txtbx_CreditCardNumber = By.cssSelector("#CardNumber");
    public static By drpdwn_CreditCardExpiryMonth = By.cssSelector("#ExpireMonth");
    public static By drpdwn_CreditCardExpiryYear = By.cssSelector("#ExpireYear");
    public static By txtbx_CreditCardCode = By.cssSelector("#CardCode");
    public static By txt_OrderDetails = By.xpath("//ul[@class='details']/li[2]/a");



}
