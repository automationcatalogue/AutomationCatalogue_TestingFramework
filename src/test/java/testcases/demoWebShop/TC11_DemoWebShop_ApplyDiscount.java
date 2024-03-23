package testcases.demoWebShop;

import Utilities.BaseClass;
import Utilities.CommonMethods;
import Utilities.Config;
import Utilities.ExcelUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.demoWebShop.*;

public class TC11_DemoWebShop_ApplyDiscount {
    private static WebDriver driver;
    private static String sheetName;
    private static String username, password, productCategory, discountCode, paymentInfo, cardholderName;
    private static String cardCode, creditCardNum, productName;

    @BeforeMethod
    public void preRequisites() throws Exception{
        String projectPath = System.getProperty("user.dir");
        sheetName = "Demo_ApplyDiscount";
        ExcelUtils.setExcelFilePath(projectPath+"//TestData//Automation_TestData.xlsx");
        int row = ExcelUtils.getRowNumber(Config.testID_DEMOApplyDiscount,sheetName);
        username = ExcelUtils.getCellData(sheetName, row, Config.col_UserName);
        password = ExcelUtils.getCellData(sheetName, row, Config.col_Password);
        productCategory = ExcelUtils.getCellData(sheetName, row, Config.col_ApplyDiscount_ProductCategory);
        productName = ExcelUtils.getCellData(sheetName, row, Config.col_ApplyDiscount_ProductName);
        discountCode  = ExcelUtils.getCellData(sheetName, row, Config.col_ApplyDiscount_DiscountCode);
        paymentInfo = ExcelUtils.getCellData(sheetName, row, Config.col_ApplyDiscount_PaymentInformation);
        cardholderName = ExcelUtils.getCellData(sheetName, row, Config.col_ApplyDiscount_CardHolderName);
        cardCode = ExcelUtils.getCellData(sheetName, row, Config.col_ApplyDiscount_CardCode);
        creditCardNum  = ExcelUtils.getCellData(sheetName, row, Config.col_ApplyDiscount_CardNumber);

        driver = CommonMethods.openBrowser();
        BaseClass ob = new BaseClass(driver);

        CommonMethods.launchURL(Config.demoWebShopLogin_URL);
    }

    @Test
    public void demoWebShop_ApplyDiscount(){
        DemoWebShop_LoginPage.login(username, password);
        DemoWebShop_HomePage.clickCategory(productCategory);
        DemoWebShop_ProductListingPage.addToCartProduct(productName);
        DemoWebShop_ProductDisplayPage.enterProductData(productName);
        DemoWebShop_HomePage.clickShoppingCart();
        DemoWebShop_ShoppingCartPage.enterDiscountCode(discountCode);
        DemoWebShop_ShoppingCartPage.clickApplyBtn();
        DemoWebShop_ShoppingCartPage.validateDiscount();
        DemoWebShop_ShoppingCartPage.clickAgreeAndCheckout();
        DemoWebShop_CheckoutPage.placeOrder_CreditCard(paymentInfo, cardholderName, creditCardNum, cardCode);
        DemoWebShop_CheckoutPage.clickOrderDetails();
        DemoWebShop_OrdersPage.validateOrderId_OrderValue();
        DemoWebShop_HomePage.logout();
    }

    @AfterMethod
    public void tearDown(){
        CommonMethods.closeBrowser();
    }
}
