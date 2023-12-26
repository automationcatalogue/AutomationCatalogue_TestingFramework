package testcases.demoWebShop;

import Utilities.CommonMethods;
import Utilities.Config;
import Utilities.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.demoWebShop.*;

import java.time.Duration;
import java.util.List;

public class TC13_DemoWebShop_PlaceOrder {
    public static void main(String[] args) throws Exception{
        String projectPath = System.getProperty("user.dir");
        String sheetName = "Demo_PlaceOrder";
        ExcelUtils.setExcelFilePath(projectPath+"//TestData//Automation_TestData.xlsx");
        int row = ExcelUtils.getRowNumber(Config.testID_Demo_PlaceOrder,sheetName);

        WebDriver driver = CommonMethods.openBrowser();

        driver.get(Config.demoWebShopLogin_URL);
        System.out.println("DemoWebShop url is launched");

        DemoWebShop_LoginPage.login(driver, sheetName, row);

        WebElement element_Apparels_Shoes =driver.findElement(DemoWebShop_HomePage.link_ApparelShoesCategory);
        element_Apparels_Shoes.click();
        System.out.println("Apparels_Shoes is clicked");

        WebElement element_Shoes = driver.findElement(DemoWebShop_ProductListingPage.link_Shoes);
        element_Shoes.click();
        System.out.println("Shoes is clicked");

        String itemPrice = driver.findElement(By.xpath("//div[@class='product-price']/span")).getText();
        double itemValue = Double.parseDouble(itemPrice);
        System.out.println("Selected Iem Value is :" + itemValue);

        WebElement element_Addtocart = driver.findElement(DemoWebShop_ProductListingPage.btn_addToCart);
        element_Addtocart.click();
        System.out.println("Add to cart button is clicked");

        WebElement element_Shopping_cart = driver.findElement(DemoWebShop_HomePage.link_ShoppingCart);
        element_Shopping_cart.click();
        System.out.println("Shopping cart is clicked");


        List<WebElement> allCountry = driver.findElements(By.xpath("//option[text()='Belgium']"));
        for(WebElement element:allCountry){
            String actualValue = element.getText();
            if(actualValue.equalsIgnoreCase("Belgium")){
                element.click();
                break;
            }
        }
        System.out.println("Belgium is selected");


        WebElement element_Checkbox = driver.findElement(DemoWebShop_ShoppingCartPage.chckbox_termsconditions);
        element_Checkbox.click();
        System.out.println("Checkbox is selected");

        WebElement element_Checkout = driver.findElement(DemoWebShop_ShoppingCartPage.btn_Checkout);
        element_Checkout.click();
        System.out.println("Checkout button is clicked");

        WebElement element_BillingAddress = driver.findElement(DemoWebShop_CheckoutPage.btn_ContinueBillingAddress);
        element_BillingAddress.click();
        System.out.println("Billing address continue button is clicked");

        WebElement element_ShoppingAddress = driver.findElement(DemoWebShop_CheckoutPage.link_ShippingAddress);
        element_ShoppingAddress.click();
        System.out.println("Shopping address continue button is clicked");

        WebElement element_ShoppingMethod = driver.findElement(DemoWebShop_CheckoutPage.btn_ContinueShippingAddress);
        element_ShoppingMethod.click();
        System.out.println("Shopping method continue button is clicked");

        WebElement element_PaymentMethod = driver.findElement(DemoWebShop_CheckoutPage.btn_ContinueShippingMethod);
        element_PaymentMethod.click();
        System.out.println("Payment method continue button is clicked");

        WebElement element_PaymentInformation = driver.findElement(DemoWebShop_CheckoutPage.btn_ContinuePaymentMethod);
        element_PaymentInformation.click();
        System.out.println("Payment information continue button is clicked");

        WebElement element_Confirm = driver.findElement(DemoWebShop_CheckoutPage.btn_ConfirmOrder);
        element_Confirm.click();
        System.out.println("Confirm button is clicked");

        String element_orderNumber = driver.findElement(By.xpath("(//div[@class='section order-completed']/ul/li)[1]")).getText();
        System.out.println("Order number is printed:"+element_orderNumber);

        WebElement element_orderDetails = driver.findElement(By.xpath("//div[@class='section order-completed']/ul/li[2]/a"));
        element_orderDetails.click();
        System.out.println("Order details is clicked");

        WebElement element_subTotal = driver.findElement(By.xpath("(//table[@class='cart-total']/tbody/tr/td[2]/span)[1]"));
        String text_SubTotal = element_subTotal.getText();
        System.out.println("Sub total amount of order:"+text_SubTotal);
        double subTotal = Double.parseDouble(text_SubTotal);

        if(itemValue == subTotal){
            System.out.println("Sub Total is displayed correctly");
        }else {
            System.out.println("Sub Total is displayed not correctly");
        }

        DemoWebShop_HomePage.logout(driver);

        driver.quit();
    }
}
