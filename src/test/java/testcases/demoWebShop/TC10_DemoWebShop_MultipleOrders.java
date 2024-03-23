package testcases.demoWebShop;

import Utilities.BaseClass;
import Utilities.CommonMethods;
import Utilities.Config;
import Utilities.ExcelUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.demoWebShop.*;
import testcases.runner.Runner;

public class TC10_DemoWebShop_MultipleOrders extends Runner {

    static WebDriver driver;
    private static String username,password,product1Category,product2Category,product1Name,product2Name,product3Category,product3Name,product4Category,product4Name;
    private static String sheetName;
    private static int row;

    @BeforeClass
    public void preRequisites() throws Exception {
        String sheetName = "Demo_MultipleProducts";
        row = ExcelUtils.getRowNumber(Config.testID_DemoMultipleProducts, sheetName);
        username = ExcelUtils.getCellData(sheetName, row, Config.col_UserName);
        password = ExcelUtils.getCellData(sheetName, row, Config.col_Password);
        product1Category = ExcelUtils.getCellData(sheetName, row, Config.col_Product1Category);
        product2Category = ExcelUtils.getCellData(sheetName, row, Config.col_Product2Category);
        product4Category = ExcelUtils.getCellData(sheetName, row, Config.col_Product4Category);
        product3Category = ExcelUtils.getCellData(sheetName, row, Config.col_Product3Category);
        product1Name = ExcelUtils.getCellData(sheetName, row, Config.col_Product1Name);
        product2Name = ExcelUtils.getCellData(sheetName, row, Config.col_Product2Name);
        product3Name = ExcelUtils.getCellData(sheetName, row, Config.col_Product3Name);
        product4Name = ExcelUtils.getCellData(sheetName, row, Config.col_Product4Name);
    }



    @BeforeMethod
    public void launchURL() throws Exception{
        driver = CommonMethods.openBrowser();
        BaseClass ob = new BaseClass(driver);

        CommonMethods.launchURL(Config.demoWebShopLogin_URL);
    }

    @Test
    public void demoWebShop_MultipleOrders() throws Exception{
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
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
        System.out.println("Testcase Execution is completed and Driver instance is terminated");
    }


}
