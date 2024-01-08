package pages.demoWebShop;

import Utilities.BaseClass;
import Utilities.Config;
import Utilities.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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

    public static void placeOrder_MoneyOrder() throws Exception{
        driver.findElement(DemoWebShop_CheckoutPage.btn_ContinueBillingAddress).click();
        System.out.println("continue billing address");
        Thread.sleep(1000);
        WebElement element_ShippingAddress = driver.findElement(DemoWebShop_CheckoutPage.link_ShippingAddress);
        js.executeScript("arguments[0].click();",element_ShippingAddress);
        System.out.println("shipping address is clicked ");
        Thread.sleep(1000);
        driver.findElement(DemoWebShop_CheckoutPage.btn_ContinueShippingMethod).click();
        System.out.println("shipping method");
        Thread.sleep(1000);
        driver.findElement(DemoWebShop_CheckoutPage.rbtn_MoneyOrder).click();
        System.out.println("money order is selected");
        Thread.sleep(1000);
        driver.findElement(DemoWebShop_CheckoutPage.btn_ContinuePaymentMethod).click();
        System.out.println("continue to confirm");
        Thread.sleep(1000);
        driver.findElement(DemoWebShop_CheckoutPage.btn_ContinuePaymentInformation).click();
        System.out.println("confirm order");
        Thread.sleep(1000);
        driver.findElement(DemoWebShop_CheckoutPage.btn_ConfirmOrder).click();
        System.out.println("order is confirmed");
    }

    public static void updateOrderNumber(String sheetName, int row) throws Exception{
        String orderNumber = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/ul/li[1]")).getText();
        ExcelUtils.setCellData(orderNumber, sheetName, row, Config.col_OrderID);
        System.out.println(orderNumber+" is written as Order ID in Excel sheet");
    }

    public static void placeOrder_CreditCard(String paymentInfo, String cardholderName, String creditCardNum, String cardCode){
        driver.findElement(DemoWebShop_CheckoutPage.btn_ContinueBillingAddress).click();
        System.out.println("Billing address continue button is clicked");

        driver.findElement(DemoWebShop_CheckoutPage.btn_ContinueShippingAddress).click();
        System.out.println("Shipping address continue button is clicked");

        driver.findElement(DemoWebShop_CheckoutPage.btn_ContinueShippingMethod).click();
        System.out.println("Shipping method continue button is clicked");

        driver.findElement(DemoWebShop_CheckoutPage.btn_CreditCardPayment).click();
        System.out.println("Payment information is selected as " + paymentInfo);

        driver.findElement(DemoWebShop_CheckoutPage.btn_CreditCardContinueShippingMethod).click();
        System.out.println("Payment method continue button is clicked");

        driver.findElement(DemoWebShop_CheckoutPage.txtbx_CardholderName).sendKeys(cardholderName);
        System.out.println("Credit card name is selected as " + cardholderName);

        driver.findElement(DemoWebShop_CheckoutPage.txtbx_CreditCardNumber).sendKeys(creditCardNum);
        System.out.println("Credit card number is entered as " + creditCardNum);

        Select MonthDropdown = new Select(driver.findElement(DemoWebShop_CheckoutPage.drpdwn_CreditCardExpiryMonth));
        System.out.println("Month drop-down is clicked");

        Select yearDropdown = new Select(driver.findElement(DemoWebShop_CheckoutPage.drpdwn_CreditCardExpiryYear));
        System.out.println("year drop-down is clicked");

        MonthDropdown.selectByVisibleText("04");
        System.out.println("Month is selected as 04");

        yearDropdown.selectByVisibleText("2024");
        System.out.println("Year is selected as 2024");

        driver.findElement(DemoWebShop_CheckoutPage.txtbx_CreditCardCode).sendKeys(cardCode);
        System.out.println("Card code is entered as " + cardCode);

        driver.findElement(DemoWebShop_CheckoutPage.btn_ContinuePaymentInformation).click();
        System.out.println("Payment info continue button is clicked");

        driver.findElement(DemoWebShop_CheckoutPage.btn_ConfirmOrder).click();
        System.out.println("Conform order continue button is clicked");
    }

    public static void clickOrderDetails(){
        driver.findElement(DemoWebShop_CheckoutPage.txt_OrderDetails).click();
        System.out.println("Order details is clicked");
    }

    public static void placeOrder() throws Exception{
        WebElement element_BillingAddress = driver.findElement(DemoWebShop_CheckoutPage.btn_ContinueBillingAddress);
        element_BillingAddress.click();
        System.out.println("Billing address continue button is clicked");

        Thread.sleep(1000);
        WebElement element_ShoppingAddress = driver.findElement(DemoWebShop_CheckoutPage.link_ShippingAddress);
        element_ShoppingAddress.click();
        System.out.println("Shopping address continue button is clicked");

        Thread.sleep(1000);
        WebElement element_ShippingMethod = driver.findElement(DemoWebShop_CheckoutPage.btn_ContinueShippingMethod);
        element_ShippingMethod.click();
        System.out.println("Shipping Method continue button is clicked");

        Thread.sleep(1000);
        WebElement element_PaymentMethod = driver.findElement(DemoWebShop_CheckoutPage.btn_ContinuePaymentMethod);
        element_PaymentMethod.click();
        System.out.println("Payment Method continue button is clicked");

        Thread.sleep(1000);
        WebElement element_PaymentConfirmation = driver.findElement(DemoWebShop_CheckoutPage.btn_ContinuePaymentInformation);
        element_PaymentConfirmation.click();
        System.out.println("Payment Confirmation continue button is clicked");

        driver.findElement(DemoWebShop_CheckoutPage.btn_ConfirmOrder).click();
        System.out.println("Conform order continue button is clicked");
    }

    public static void printOrderNumber(){
        String element_orderNumber = driver.findElement(By.xpath("(//div[@class='section order-completed']/ul/li)[1]")).getText();
        System.out.println("Order number is printed:"+element_orderNumber);
    }

}
