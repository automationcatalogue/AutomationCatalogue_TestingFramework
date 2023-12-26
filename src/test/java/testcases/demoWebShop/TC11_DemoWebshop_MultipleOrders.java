package testcases.demoWebShop;

import Utilities.CommonMethods;
import Utilities.Config;
import Utilities.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.demoWebShop.*;
import teachings.selenium.webElementBasics.DropdownSelectionDemo;

import java.time.Duration;

public class TC11_DemoWebshop_MultipleOrders {

    static WebDriver driver;

    public static void main(String[] args) throws Exception {
        String projectPath = System.getProperty("user.dir");
        String sheetName = "Demo_MultipleProducts";
        ExcelUtils.setExcelFilePath(projectPath + "//TestData//Automation_TestData.xlsx");
        int row = ExcelUtils.getRowNumber(Config.testID_DemoMultipleProducts, sheetName);

        driver = CommonMethods.openBrowser();
        JavascriptExecutor js = (JavascriptExecutor)driver;

        driver.get(Config.demoWebShopLogin_URL);
        System.out.println("website is loaded");

        DemoWebShop_LoginPage.login(driver, sheetName, row);

        String product1Category = ExcelUtils.getCellData(sheetName, row, Config.col_Product1Category);
        String product2Category = ExcelUtils.getCellData(sheetName, row, Config.col_Product2Category);
        String product3Category = ExcelUtils.getCellData(sheetName, row, Config.col_Product3Category);
        String product4Category = ExcelUtils.getCellData(sheetName, row, Config.col_Product4Category);

        String product1Name = ExcelUtils.getCellData(sheetName, row, Config.col_Product1Name);
        String product2Name = ExcelUtils.getCellData(sheetName, row, Config.col_Product2Name);
        String product3Name = ExcelUtils.getCellData(sheetName, row, Config.col_Product3Name);
        String product4Name = ExcelUtils.getCellData(sheetName, row, Config.col_Product4Name);

        clickCategory(product1Category);
        driver.findElement(DemoWebShop_ProductListingPage.addToCart_Product(product1Name)).click();
        System.out.println(product1Name+" Add to Cart button is clicked");
        enterProductData(product1Name);

        clickCategory(product2Category);
        driver.findElement(DemoWebShop_ProductListingPage.addToCart_Product(product2Name)).click();
        System.out.println(product2Name+" Add to Cart button is clicked");
        enterProductData(product2Name);

        clickCategory(product3Category);
        driver.findElement(DemoWebShop_ProductListingPage.addToCart_Product(product3Name)).click();
        System.out.println(product3Name+" Add to Cart button is clicked");
        enterProductData(product3Name);

        clickCategory(product4Category);
        driver.findElement(DemoWebShop_ProductListingPage.addToCart_Product(product4Name)).click();
        System.out.println(product4Name+" Add to Cart button is clicked");
        enterProductData(product4Name);


        driver.findElement(DemoWebShop_HomePage.link_ShoppingCart).click();
        System.out.println("shopping cart is clicked");
        driver.findElement(DemoWebShop_ShoppingCartPage.chckbox_termsconditions).click();
        System.out.println("Terms and conditions clicked");
        driver.findElement(DemoWebShop_ShoppingCartPage.btn_Checkout).click();
        System.out.println("checkout");
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
        String data = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/ul/li[1]")).getText();
        ExcelUtils.setCellData(data, sheetName, row, Config.col_OrderID);
        System.out.println(data+" is written as Order ID in Excel sheet");

        DemoWebShop_HomePage.logout(driver);

        driver.quit();

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
