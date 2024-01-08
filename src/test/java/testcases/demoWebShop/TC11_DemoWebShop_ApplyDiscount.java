package testcases.demoWebShop;

import Utilities.BaseClass;
import Utilities.CommonMethods;
import Utilities.Config;
import Utilities.ExcelUtils;
import org.openqa.selenium.WebDriver;
import pages.demoWebShop.*;

public class TC11_DemoWebShop_ApplyDiscount {
    static WebDriver driver;

    public static void main(String[] args) throws Exception{
        String projectPath = System.getProperty("user.dir");
        String sheetName = "Demo_ApplyDiscount";
        ExcelUtils.setExcelFilePath(projectPath+"//TestData//Automation_TestData.xlsx");
        int row = ExcelUtils.getRowNumber(Config.testID_DEMOApplyDiscount,sheetName);
        String username = ExcelUtils.getCellData(sheetName, row, Config.col_UserName);
        String password = ExcelUtils.getCellData(sheetName, row, Config.col_Password);
        String productCategory = ExcelUtils.getCellData(sheetName, row, Config.col_ApplyDiscount_ProductCategory);
        String productName = ExcelUtils.getCellData(sheetName, row, Config.col_ApplyDiscount_ProductName);
        String discountCode  = ExcelUtils.getCellData(sheetName, row, Config.col_ApplyDiscount_DiscountCode);
        String paymentInfo = ExcelUtils.getCellData(sheetName, row, Config.col_ApplyDiscount_PaymentInformation);
        String cardholderName = ExcelUtils.getCellData(sheetName, row, Config.col_ApplyDiscount_CardHolderName);
        String cardCode = ExcelUtils.getCellData(sheetName, row, Config.col_ApplyDiscount_CardCode);
        String creditCardNum  = ExcelUtils.getCellData(sheetName, row, Config.col_ApplyDiscount_CardNumber);

        driver = CommonMethods.openBrowser();
        BaseClass ob = new BaseClass(driver);

        CommonMethods.launchURL(Config.demoWebShopLogin_URL);
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
        CommonMethods.closeBrowser();
    }
}
