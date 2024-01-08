package testcases.demoWebShop;

import Utilities.BaseClass;
import Utilities.CommonMethods;
import Utilities.Config;
import Utilities.ExcelUtils;
import org.openqa.selenium.WebDriver;
import pages.demoWebShop.*;

public class TC10_DemoWebShop_MultipleOrders {

    static WebDriver driver;

    public static void main(String[] args) throws Exception {
        String projectPath = System.getProperty("user.dir");
        String sheetName = "Demo_MultipleProducts";
        ExcelUtils.setExcelFilePath(projectPath + "//TestData//Automation_TestData.xlsx");
        int row = ExcelUtils.getRowNumber(Config.testID_DemoMultipleProducts, sheetName);
        String username = ExcelUtils.getCellData(sheetName, row, Config.col_UserName);
        String password = ExcelUtils.getCellData(sheetName, row, Config.col_Password);
        String product1Category = ExcelUtils.getCellData(sheetName, row, Config.col_Product1Category);
        String product2Category = ExcelUtils.getCellData(sheetName, row, Config.col_Product2Category);
        String product3Category = ExcelUtils.getCellData(sheetName, row, Config.col_Product3Category);
        String product4Category = ExcelUtils.getCellData(sheetName, row, Config.col_Product4Category);
        String product1Name = ExcelUtils.getCellData(sheetName, row, Config.col_Product1Name);
        String product2Name = ExcelUtils.getCellData(sheetName, row, Config.col_Product2Name);
        String product3Name = ExcelUtils.getCellData(sheetName, row, Config.col_Product3Name);
        String product4Name = ExcelUtils.getCellData(sheetName, row, Config.col_Product4Name);

        driver = CommonMethods.openBrowser();
        BaseClass ob = new BaseClass(driver);

        CommonMethods.launchURL(Config.demoWebShopLogin_URL);
        DemoWebShop_LoginPage.login(username, password);
        DemoWebShop_HomePage.clickCategory(product1Category);
        DemoWebShop_ProductListingPage.addToCartProduct(product1Name);
        DemoWebShop_ProductDisplayPage.enterProductData(product1Name);
        DemoWebShop_HomePage.clickCategory(product2Category);
        DemoWebShop_ProductListingPage.addToCartProduct(product2Name);
        DemoWebShop_ProductDisplayPage.enterProductData(product2Name);
        DemoWebShop_HomePage.clickCategory(product3Category);
        DemoWebShop_ProductListingPage.addToCartProduct(product3Name);
        DemoWebShop_ProductDisplayPage.enterProductData(product3Name);
        DemoWebShop_HomePage.clickCategory(product4Category);
        DemoWebShop_ProductListingPage.addToCartProduct(product4Name);
        DemoWebShop_ProductDisplayPage.enterProductData(product4Name);
        DemoWebShop_HomePage.clickShoppingCart();
        DemoWebShop_ShoppingCartPage.clickTermsAndCheckout();
        DemoWebShop_CheckoutPage.placeOrder_MoneyOrder();
        DemoWebShop_CheckoutPage.updateOrderNumber(sheetName, row);
        DemoWebShop_HomePage.logout();
        CommonMethods.closeBrowser();
    }
}
