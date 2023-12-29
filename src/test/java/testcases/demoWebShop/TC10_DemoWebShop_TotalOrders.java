package testcases.demoWebShop;

import Utilities.BaseClass;
import Utilities.CommonMethods;
import Utilities.Config;
import Utilities.ExcelUtils;
import org.openqa.selenium.WebDriver;
import pages.demoWebShop.DemoWebShop_HomePage;
import pages.demoWebShop.DemoWebShop_LoginPage;
import pages.demoWebShop.DemoWebShop_OrdersPage;

public class TC10_DemoWebShop_TotalOrders {

    public static void main(String[] args) throws Exception{

        String projectPath = System.getProperty("user.dir");
        String sheetName = "Demo_TotalOrders";
        ExcelUtils.setExcelFilePath(projectPath+"//TestData//Automation_TestData.xlsx");
        int row = ExcelUtils.getRowNumber(Config.testID_Demo_TotalOrders,sheetName);
        String username = ExcelUtils.getCellData(sheetName, row, Config.col_UserName);
        String password = ExcelUtils.getCellData(sheetName, row, Config.col_Password);

        WebDriver driver = CommonMethods.openBrowser();
        BaseClass ob = new BaseClass(driver);

        CommonMethods.launchURL(Config.demoWebShop_URL);
        DemoWebShop_LoginPage.login(username, password);
        DemoWebShop_HomePage.clickAccountName();
        DemoWebShop_OrdersPage.clickOrders();
        DemoWebShop_OrdersPage.getTotalOrdersCount();
        DemoWebShop_OrdersPage.getTotalOrdersValue();
        DemoWebShop_HomePage.logout();
        CommonMethods.closeBrowser();

    }
}



