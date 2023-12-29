package pages.demoWebShop;

import Utilities.BaseClass;
import Utilities.Config;
import Utilities.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoWebShop_CheckoutPage extends BaseClass {

    public DemoWebShop_CheckoutPage(WebDriver driver){
        super(driver);
    }

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

    public static void placeOrder(){
        driver.findElement(DemoWebShop_CheckoutPage.btn_ContinueBillingAddress).click();
        System.out.println("continue billing address");
        WebElement element_ShippingAddress = driver.findElement(DemoWebShop_CheckoutPage.link_ShippingAddress);
        js.executeScript("arguments[0].click();",element_ShippingAddress);
        System.out.println("shipping address is clicked ");
        driver.findElement(DemoWebShop_CheckoutPage.btn_ContinueShippingAddress).click();
        System.out.println("continue Shipping address");
        driver.findElement(DemoWebShop_CheckoutPage.btn_ContinueShippingMethod).click();
        System.out.println("shipping method");
        driver.findElement(DemoWebShop_CheckoutPage.rbtn_MoneyOrder).click();
        System.out.println("money order is selected");
        driver.findElement(DemoWebShop_CheckoutPage.btn_ContinuePaymentMethod).click();
        System.out.println("continue to confirm");
        driver.findElement(DemoWebShop_CheckoutPage.btn_ContinuePaymentInformation).click();
        System.out.println("confirm order");
        driver.findElement(DemoWebShop_CheckoutPage.btn_ConfirmOrder).click();
        System.out.println("order is confirmed");
    }

    public static void updateOrderNumber(String sheetName, int row) throws Exception{
        String orderNumber = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/ul/li[1]")).getText();
        ExcelUtils.setCellData(orderNumber, sheetName, row, Config.col_OrderID);
        System.out.println(orderNumber+" is written as Order ID in Excel sheet");
    }

}
