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
import pages.demoWebShop.DemoWebShop_HomePage;
import pages.demoWebShop.DemoWebShop_LoginPage;
import pages.demoWebShop.DemoWebShop_OrdersPage;
import testcases.runner.Runner;

public class TC09_DemoWebShop_TotalOrders extends Runner {

    private static WebDriver driver;
    private static String username, password, sheetName;
    private static int row;
    @BeforeClass
    public void preRequisites() throws Exception {
        sheetName = "Demo_TotalOrders";
        row = ExcelUtils.getRowNumber(Config.testID_Demo_TotalOrders, sheetName);
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
    public void demoWebShop_TotalOrders(){
        DemoWebShop_LoginPage.login(username, password);
        DemoWebShop_HomePage.clickAccountName();
        DemoWebShop_OrdersPage.clickOrders();
        DemoWebShop_OrdersPage.getTotalOrdersCount();
        DemoWebShop_OrdersPage.getTotalOrdersValue();
        DemoWebShop_HomePage.logout();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
        System.out.println("Testcase Execution is completed and Driver instance is terminated");
    }

}



