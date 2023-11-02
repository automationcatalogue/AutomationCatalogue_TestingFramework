package testcases.demoWebShop;

import Utilities.Config_Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import pageObjects.PageLocators;

import java.time.Duration;

public class TC12_DemoWebshop_ApplyDiscount {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        System.out.println("chrome browser is launched");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        System.out.println("Implicit timeout is given");

        driver.get("https://demowebshop.tricentis.com/");
        System.out.println("DemoWebshop url is loaded");

        driver.manage().window().maximize();
        System.out.println("browser is maximized");

        driver.findElement(PageLocators.Loginbtn).click();
        System.out.println("login button is clicked");

        driver.findElement(PageLocators.usrnamebx).sendKeys(Config_Data.username1);
        System.out.println("username is entered");

        driver.findElement(PageLocators.paswrdbx).sendKeys(Config_Data.password1);
        System.out.println("username is entered");

        driver.findElement(PageLocators.Login_btn).click();
        System.out.println("login button is clicked");

        driver.findElement(PageLocators.computers_icn).click();
        System.out.println("computers is selected");

        driver.findElement(PageLocators.dsktp_img).click();
        System.out.println("Desktops imag is clicked");

        driver.findElement(PageLocators.Owndsktp).click();
        System.out.println("own computer is clicked");

        driver.findElement(PageLocators.Add_cart).click();
        System.out.println("add to cart is clicked");

        driver.findElement(PageLocators.shp_cart).click();
        System.out.println("shopping cart is clicked");

        driver.findElement(PageLocators.Dis_code).sendKeys(Config_Data.Discountcode);
        System.out.println("discount code is entered");

        driver.findElement(PageLocators.Apply_cpn).click();
        System.out.println("Apply coupon is clicked");

        WebElement element_actualvalue = driver.findElement(PageLocators.Actual_val);
        System.out.println("acual value is dropdown is selected");

        WebElement element_Discountvalue=driver.findElement(PageLocators.Dis_val);
        System.out.println("Discount value is drpdown is selected");

        String actualvaluetext=element_actualvalue.getText();
        System.out.println("actual value  is retrived");

        String Discountvaluetext=element_Discountvalue.getText();
        System.out.println("Discount value is retrived");

        //string is converted to double
        double actualvalue = Double.parseDouble(actualvaluetext);
        double Discountvalue = Double.parseDouble(Discountvaluetext);

        //discount value is displayed
        double Discountedvalue = (actualvalue-Discountvalue);
        System.out.println("total discount is:" + Discountedvalue);

        //discount percentage is displayed
        double discountpercentage = Discountedvalue/actualvalue*100;
        System.out.println("discount percentage is:"+discountpercentage);

        driver.findElement(PageLocators.Agree_btn).click();
        System.out.println("agree button is clicked");

        driver.findElement(PageLocators.checkout_btn).click();
        System.out.println("checkout button is clicked");

        driver.findElement(PageLocators.Billing_btn).click();
        System.out.println("billing address continue button is clicked");

        driver.findElement(PageLocators.Shipping_btn).click();
        System.out.println("shipping address continue button is clicked");

        driver.findElement(PageLocators.shipping_mtd).click();
        System.out.println("shipping method continue button is clicked");

        driver.findElement(PageLocators.creditcard).click();
        System.out.println("credit card is selected");

        driver.findElement(PageLocators.payment_btn).click();
        System.out.println("payment method continue button is clicked");

        driver.findElement(PageLocators.Card_holder).sendKeys(Config_Data.Cardholder_name);
        System.out.println("credit card name is selected");

        driver.findElement(PageLocators.Card_number).sendKeys(Config_Data.Card_number);
        System.out.println("credit card number is entered");

        Select monthDropdown = new Select(driver.findElement(PageLocators.Card_month));
        System.out.println("month is clicked");

        Select yearDropdown = new Select(driver.findElement(PageLocators.Card_year));
        System.out.println("year is clicked");

        monthDropdown.selectByVisibleText("04");
        System.out.println("month is selected as 04");

        yearDropdown.selectByVisibleText("2023");
        System.out.println("Year is selected as 2023");

        driver.findElement(PageLocators.Cardcode).sendKeys(Config_Data.Card_code);
        System.out.println("card code is entered");

        driver.findElement(PageLocators.Paymentinfo_btn).click();
        System.out.println("payment info continue button is clicked");

        driver.findElement(PageLocators.Conformorder_btn).click();
        System.out.println("conform order continue button is clicked");

        driver.findElement(PageLocators.Order_details).click();
        System.out.println("Click here for order details is clicked");

        //orderId displayed and printed
        WebElement element_orderid = driver.findElement(PageLocators.Order_ID);
        String orderIDvalueText =element_orderid.getText();
        System.out.println("orderID is : " +orderIDvalueText);

        //ordervalue is displayed and printed
        WebElement element_ordervalue = driver.findElement(PageLocators.Order_value);
        String ordervalueText = element_ordervalue.getText();
        System.out.println("ordervalue is : " +ordervalueText);

        //converted ordervalue(string) to double
        double orderTotal=Double.parseDouble(ordervalueText);
        System.out.println("doubled the order value");

        String expectedOrderID = orderIDvalueText;
        System.out.println("orderID value is retriver");

        double expecteedorderTotal = orderTotal;
        System.out.println("Totalorder value is retriver");

        if (orderIDvalueText.equals(expectedOrderID) && orderTotal == expecteedorderTotal){
            System.out.println("orderIDvalue and total order is as expected");
        }else {
            System.out.println("orderIDvalue and total order is not as expected");
        }

        driver.quit();
        System.out.println("Browser is closed");

    }

}
