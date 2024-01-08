package testcases.demoWebShop;

import Utilities.BaseClass;
import Utilities.CommonMethods;
import Utilities.Config;
import Utilities.ExcelUtils;
import org.openqa.selenium.WebDriver;
import pages.demoWebShop.*;

public class TC12_DemoWebShop_PlaceOrder {
    public static void main(String[] args) throws Exception{
        String projectPath = System.getProperty("user.dir");
        String sheetName = "Demo_PlaceOrder";
        ExcelUtils.setExcelFilePath(projectPath+"//TestData//Automation_TestData.xlsx");
        int row = ExcelUtils.getRowNumber(Config.testID_Demo_PlaceOrder,sheetName);
        String username = ExcelUtils.getCellData(sheetName, row, Config.col_UserName);
        String password = ExcelUtils.getCellData(sheetName, row, Config.col_Password);

        WebDriver driver = CommonMethods.openBrowser();
        BaseClass ob = new BaseClass(driver);
        CommonMethods.launchURL(Config.demoWebShopLogin_URL);
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
        CommonMethods.closeBrowser();
    }
}
