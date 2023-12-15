package testcases.demoWebShop;

import Utilities.Config;
import Utilities.ExcelUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.demoWebShop.*;
import java.time.Duration;

public class TC12_DemoWebshop_ApplyDiscount {
    static WebDriver driver;
    public static WebDriverWait wait;

    public static void main(String[] args) throws Exception{
        String projectPath = System.getProperty("user.dir");
        String sheetName = "Demo_ApplyDiscount";
        ExcelUtils.setExcelFilePath(projectPath+"//TestData//Automation_TestData.xlsx");
        int row = ExcelUtils.getRowNumber(Config.testID_DEMOApplyDiscount,sheetName);

        driver = new ChromeDriver();
        System.out.println("Chrome Browser is opened");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        driver.manage().window().maximize();

        driver.get(Config.demoWebShopLogin_URL);
        System.out.println("DemoWebshop Application is loaded");

        DemoWebShop_LoginPage.login(driver, sheetName, row);

        String productCategory = ExcelUtils.getCellData(sheetName, row, Config.col_ApplyDiscount_ProductCategory);
        String productName = ExcelUtils.getCellData(sheetName, row, Config.col_ApplyDiscount_ProductName);
        clickCategory(productCategory);
        driver.findElement(DemoWebShop_ProductListingPage.addToCart_Product(productName)).click();
        System.out.println(productName+" Add to Cart button is clicked");
        enterProductData(productName);

        driver.findElement(DemoWebShop_HomePage.link_ShoppingCart).click();
        System.out.println("Shopping cart button is clicked");

        driver.navigate().refresh();

        String discountCode  = ExcelUtils.getCellData(sheetName, row, Config.col_ApplyDiscount_DiscountCode);
        driver.findElement(DemoWebShop_ShoppingCartPage.txtbx_DiscountCode).sendKeys(discountCode);
        System.out.println("Discount code is entered");

        wait.until(ExpectedConditions.elementToBeClickable(DemoWebShop_ShoppingCartPage.txtbx_DiscountCode)).click();
        System.out.println("Discount code check-box is clicked");

        driver.findElement(DemoWebShop_ShoppingCartPage.btn_ApplyCoupon).click();
        System.out.println("Apply coupon button is clicked");

        WebElement element_ActualValue = driver.findElement(DemoWebShop_ShoppingCartPage.txt_ActualValue);
        System.out.println("Acual value is text selected");

        WebElement element_DiscountValue=driver.findElement(DemoWebShop_ShoppingCartPage.txt_DiscountValue);
        System.out.println("Discount value is text selected");

        String actualValueText=element_ActualValue.getText();
        System.out.println("Actual value  is retrived");

        String discountValueText=element_DiscountValue.getText();
        System.out.println("Discount value is retrived");

        //string is converted to double
        double actualValue = Double.parseDouble(actualValueText);
        double discountValue = Double.parseDouble(discountValueText);

        //discount value is displayed
        double Discountedvalue = (actualValue-discountValue);
        System.out.println("Total discount is:" + Discountedvalue);

        //discount percentage is displayed
        double discountPercentage = Discountedvalue/actualValue*100;
        System.out.println("Discount percentage is:"+discountPercentage);

        driver.findElement(DemoWebShop_ShoppingCartPage.chckbox_termsconditions).click();
        System.out.println("Agree button is clicked");

        driver.findElement(DemoWebShop_ShoppingCartPage.btn_Checkout).click();
        System.out.println("checkout button is clicked");

        driver.findElement(DemoWebShop_CheckoutPage.btn_ContinueBillingAddress).click();
        System.out.println("Billing address continue button is clicked");

        driver.findElement(DemoWebShop_CheckoutPage.btn_ContinueShippingAddress).click();
        System.out.println("Shipping address continue button is clicked");

        driver.findElement(DemoWebShop_CheckoutPage.btn_ContinueShippingMethod).click();
        System.out.println("Shipping method continue button is clicked");

        String paymentInfo = ExcelUtils.getCellData(sheetName, row, Config.col_ApplyDiscount_PaymentInformation);
        driver.findElement(DemoWebShop_CheckoutPage.btn_CreditCardPayment).click();
        System.out.println("Payment information is selected as " + paymentInfo);

        driver.findElement(DemoWebShop_CheckoutPage.btn_CreditCardContinueShippingMethod).click();
        System.out.println("Payment method continue button is clicked");

        String cardholderName = ExcelUtils.getCellData(sheetName, row, Config.col_ApplyDiscount_CardHolderName);
        driver.findElement(DemoWebShop_CheckoutPage.txtbx_CardholderName).sendKeys(cardholderName);
        System.out.println("Credit card name is selected as " + cardholderName);

        String creditCardNum  = ExcelUtils.getCellData(sheetName, row, Config.col_ApplyDiscount_CardNumber);
        driver.findElement(DemoWebShop_CheckoutPage.txtbx_CreditCardNumber).sendKeys(creditCardNum);
        System.out.println("Credit card number is entered as " + creditCardNum);

        Select MonthDropdown = new Select(driver.findElement(DemoWebShop_CheckoutPage.drpdwn_CreditCardExpiryMonth));
        System.out.println("Month drop-down is clicked");

        Select yearDropdown = new Select(driver.findElement(DemoWebShop_CheckoutPage.drpdwn_CreditCardExpiryYear));
        System.out.println("year drop-down is clicked");

        MonthDropdown.selectByVisibleText("04");
        System.out.println("Month is selected as 04");

        yearDropdown.selectByVisibleText("2023");
        System.out.println("Year is selected as 2023");

        String cardCode = ExcelUtils.getCellData(sheetName, row, Config.col_ApplyDiscount_CardCode);
        driver.findElement(DemoWebShop_CheckoutPage.txtbx_CreditCardCode).sendKeys(cardCode);
        System.out.println("Card code is entered as " + cardCode);

        driver.findElement(DemoWebShop_CheckoutPage.btn_ContinuePaymentInformation).click();
        System.out.println("Payment info continue button is clicked");

        driver.findElement(DemoWebShop_CheckoutPage.btn_ConfirmOrder).click();
        System.out.println("Conform order continue button is clicked");

        driver.findElement(DemoWebShop_CheckoutPage.txt_OrderDetails).click();
        System.out.println("Order details is clicked");

        //orderId displayed and printed
        WebElement element_OrderId = driver.findElement(DemoWebShop_OrdersPage.txt_OrderID);
        String orderIDvalueText =element_OrderId.getText();
        System.out.println("OrderID is : " +orderIDvalueText);

        //ordervalue is displayed and printed
        WebElement element_OrderValue = driver.findElement(DemoWebShop_OrdersPage.txt_OrderValue);
        String orderValueText = element_OrderValue.getText();
        System.out.println("Ordervalue is : " +orderValueText);

        //converted ordervalue(string) to double
        double orderTotal=Double.parseDouble(orderValueText);
        System.out.println("doubled the order value");

        String expectedOrderID = orderIDvalueText;
        System.out.println("OrderID value is retriver");

        double expectedorderTotal = orderTotal;
        System.out.println("Totalorder value is retriver");

        if (orderIDvalueText.equals(expectedOrderID) && orderTotal == expectedorderTotal){
            System.out.println("OrderIDvalue and total order is as expected");
        }else {
            System.out.println("OrderIDvalue and total order is not as expected");
        }

        DemoWebShop_HomePage.logout(driver);

        driver.quit();
        System.out.println("Testcase Execution is completed and Driver instance is terminated");

    }

    public static void enterProductData(String productName){
        if(productName.equalsIgnoreCase("Create Your Own Jewelry")){
            driver.findElement(DemoWebShop_ProductDisplayPage.txtbx_JeweleryLength).sendKeys("10");
            System.out.println("Length in cm is entered for "+productName);

            driver.findElement(DemoWebShop_ProductDisplayPage.link_AddToCart).click();
            System.out.println("Added to cart button for "+productName+" is clicked");

        }else if(productName.equalsIgnoreCase("Build your own cheap computer")
                || productName.equalsIgnoreCase("Blue and green Sneaker")
                || productName.equalsIgnoreCase("Phone Cover")
                || productName.equalsIgnoreCase("TCP Coaching day")){
            driver.findElement(DemoWebShop_ProductDisplayPage.link_AddToCart).click();
            System.out.println("Added to cart button for "+productName+" is clicked");

        }else if(productName.equalsIgnoreCase("$5 Virtual Gift Card")
                || productName.equalsIgnoreCase("$25 Virtual Gift Card")){
            enterVirtualGiftCardDetails();
            driver.findElement(DemoWebShop_ProductDisplayPage.link_AddToCart).click();
            System.out.println("Added to cart button for "+productName+" is clicked");

        }else if(productName.equalsIgnoreCase("$50 Physical Gift Card")
                || productName.equalsIgnoreCase("$100 Physical Gift Card")){
            enterPhysicalGiftCardDetails();
            driver.findElement(DemoWebShop_ProductDisplayPage.link_AddToCart).click();
            System.out.println("Added to cart button for "+productName+" is clicked");
        }
    }

    public static void enterVirtualGiftCardDetails(){
        driver.findElement(DemoWebShop_ProductDisplayPage.txtbx_GiftCardName).clear();
        driver.findElement(DemoWebShop_ProductDisplayPage.txtbx_GiftCardName).sendKeys("Automation");
        driver.findElement(DemoWebShop_ProductDisplayPage.txtbx_GiftCardEmail).clear();
        driver.findElement(DemoWebShop_ProductDisplayPage.txtbx_GiftCardEmail).sendKeys("Automation@test.com");
        driver.findElement(DemoWebShop_ProductDisplayPage.txtbx_GiftCardSenderName).clear();
        driver.findElement(DemoWebShop_ProductDisplayPage.txtbx_GiftCardSenderName).sendKeys("AutomationCatalogue");
        driver.findElement(DemoWebShop_ProductDisplayPage.txtbx_GiftCardSenderEmail).clear();
        driver.findElement(DemoWebShop_ProductDisplayPage.txtbx_GiftCardSenderEmail).sendKeys("AutomationCatalogue@test.com");
    }

    public static void enterPhysicalGiftCardDetails(){
        driver.findElement(DemoWebShop_ProductDisplayPage.txtbx_GiftCardName).clear();
        driver.findElement(DemoWebShop_ProductDisplayPage.txtbx_GiftCardName).sendKeys("Automation");
        driver.findElement(DemoWebShop_ProductDisplayPage.txtbx_GiftCardSenderName).clear();
        driver.findElement(DemoWebShop_ProductDisplayPage.txtbx_GiftCardSenderName).sendKeys("AutomationCatalogue");
    }

    public static void clickCategory(String productCategory){
        if(productCategory.equalsIgnoreCase("Books")){
            driver.findElement(DemoWebShop_HomePage.link_BooksCategory).click();
            System.out.println("Books category is clicked");

        }else if(productCategory.contains("Computers")){
            driver.findElement(DemoWebShop_HomePage.link_ComputersCategory).click();
            System.out.println("Computers category is clicked");

            String subCategory = productCategory.split("-")[1];
            if(subCategory.equalsIgnoreCase("Desktop")){
                driver.findElement(DemoWebShop_HomePage.link_DesktopSubCategory).click();

            }else if(subCategory.equalsIgnoreCase("Notebooks")){
                driver.findElement(DemoWebShop_HomePage.link_NotebooksSubCategory).click();

            }else if(subCategory.equalsIgnoreCase("Accessories")){
                driver.findElement(DemoWebShop_HomePage.link_AccessoriesSubCategory).click();
            }
            System.out.println(subCategory+" SubCategory is clicked");

        }else if(productCategory.contains("Electronics")){
            driver.findElement(DemoWebShop_HomePage.link_ElectronicsCategory).click();
            System.out.println("Electronics category is clicked");

            String subCategory = productCategory.split("-")[1];
            if(subCategory.equalsIgnoreCase("Cell phones")){
                driver.findElement(DemoWebShop_HomePage.link_CellphonesSubCategory).click();
                System.out.println("Cell phones subcategory is clicked");
            }

        }else if(productCategory.equalsIgnoreCase("Apparel & Shoes")){
            driver.findElement(DemoWebShop_HomePage.link_ApparelShoesCategory).click();
            System.out.println("Apparel & Shoes category is clicked");

        }else if(productCategory.equalsIgnoreCase("Digital downloads")){
            driver.findElement(DemoWebShop_HomePage.link_DigitalDownloadsCategory).click();
            System.out.println("Digital downloads category is clicked");

        }else if(productCategory.equalsIgnoreCase("Jewelry")){
            driver.findElement(DemoWebShop_HomePage.link_JewelaryCategory).click();
            System.out.println("Jewelry category is clicked");

        }else if(productCategory.equalsIgnoreCase("Gift Cards")){
            driver.findElement(DemoWebShop_HomePage.link_GiftCardsCategory).click();
            System.out.println("Gift Cards category is clicked");
        }
    }

}
