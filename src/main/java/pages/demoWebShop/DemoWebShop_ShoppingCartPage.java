package pages.demoWebShop;

import Utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

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

    public static void enterDiscountCode(String discountCode){
        driver.navigate().refresh();
        driver.findElement(DemoWebShop_ShoppingCartPage.txtbx_DiscountCode).sendKeys(discountCode);
        System.out.println("Discount code is entered");
        wait.until(ExpectedConditions.elementToBeClickable(DemoWebShop_ShoppingCartPage.txtbx_DiscountCode)).click();
        System.out.println("Discount code check-box is clicked");
    }

    public static void clickApplyBtn(){
        driver.findElement(DemoWebShop_ShoppingCartPage.btn_ApplyCoupon).click();
        System.out.println("Apply coupon button is clicked");
    }

    public static void validateDiscount(){
        WebElement element_ActualValue = driver.findElement(DemoWebShop_ShoppingCartPage.txt_ActualValue);
        System.out.println("Actual value is text selected");

        WebElement element_DiscountValue=driver.findElement(DemoWebShop_ShoppingCartPage.txt_DiscountValue);
        System.out.println("Discount value is text selected");

        String actualValueText=element_ActualValue.getText();
        System.out.println("Actual value  is retrieved");

        String discountValueText=element_DiscountValue.getText();
        System.out.println("Discount value is retrieved");

        //string is converted to double
        double actualValue = Double.parseDouble(actualValueText);
        double discountValue = Double.parseDouble(discountValueText);

        //discount value is displayed
        double discountedValue = (actualValue-discountValue);
        System.out.println("Total discount is:" + discountedValue);

        //discount percentage is displayed
        double discountPercentage = discountedValue/actualValue*100;
        System.out.println("Discount percentage is:"+discountPercentage);
    }

    public static void clickAgreeAndCheckout(){
        driver.findElement(DemoWebShop_ShoppingCartPage.chckbox_termsconditions).click();
        System.out.println("Agree button is clicked");

        driver.findElement(DemoWebShop_ShoppingCartPage.btn_Checkout).click();
        System.out.println("checkout button is clicked");
    }

    public static void selectBelgiumCountry(){
        List<WebElement> allCountry = driver.findElements(By.xpath("//option[text()='Belgium']"));
        for(WebElement element:allCountry){
            String actualValue = element.getText();
            if(actualValue.equalsIgnoreCase("Belgium")){
                element.click();
                break;
            }
        }
        System.out.println("Belgium is selected");
    }
}

