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

public class TC12_DemoWebShop_PlaceOrder extends Runner {

    private static WebDriver driver;
    private static String sheetName;
    private static String username, password;
    private  static int row;

    @BeforeClass
    public void preRequisites() throws Exception{
        sheetName = "Demo_PlaceOrder";
        row = ExcelUtils.getRowNumber(Config.testID_Demo_PlaceOrder,sheetName);
        username = ExcelUtils.getCellData(sheetName, row, Config.col_UserName);
        password = ExcelUtils.getCellData(sheetName, row, Config.col_Password);

    }
    @BeforeMethod
    public void launchURL() throws Exception{
        driver = CommonMethods.openBrowser();
        BaseClass ob = new BaseClass(driver);
        CommonMethods.launchURL(Config.demoWebShopLogin_URL);
    }

    @Test
    public void demoWebShop_PlaceOrder() throws Exception{
        DemoWebShop_LoginPage.login(username, password);
        DemoWebShop_HomePage.clickApparelsShoes();
        DemoWebShop_ProductListingPage.clickShoesLink();
        double itemValue = DemoWebShop_ProductListingPage.getItemPrice();
        DemoWebShop_ProductListingPage.addToCart();
        DemoWebShop_HomePage.clickShoppingCart();
        DemoWebShop_ShoppingCartPage.selectBelgiumCountry();
        DemoWebShop_ShoppingCartPage.clickAgreeAndCheckout();
        DemoWebShop_CheckoutPage.placeOrder();
        DemoWebShop_CheckoutPage.printOrderNumber();
        DemoWebShop_CheckoutPage.clickOrderDetails();
        DemoWebShop_OrdersPage.validateSubTotal(itemValue);
        DemoWebShop_HomePage.logout();
    }

    @AfterMethod
    public void tearDown(){
        CommonMethods.closeBrowser();
    }
}
