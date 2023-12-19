package testcases.demoWebShop;

import Utilities.Config;
import Utilities.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.demoWebShop.DemoWebShop_HomePage;
import pages.demoWebShop.DemoWebShop_LoginPage;
import pages.demoWebShop.DemoWebShop_OrdersPage;

import java.time.Duration;
import java.util.List;

public class TC10_DemoWebshop_TotalOrders {

    public static void main(String[] args) throws Exception{

        String projectPath = System.getProperty("user.dir");
        String sheetName = "Demo_TotalOrders";
        ExcelUtils.setExcelFilePath(projectPath+"//TestData//Automation_TestData.xlsx");
        int row = ExcelUtils.getRowNumber(Config.testID_Demo_TotalOrders,sheetName);


        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println("Chrome browser is launched");

        driver.manage().window().maximize();
        System.out.println("Window is maximized");

        driver.get("http://demowebshop.tricentis.com/login");
        System.out.println("Demowebshop page is loaded");


        String userName = ExcelUtils.getCellData(sheetName, row, Config.col_UserName);
        driver.findElement(DemoWebShop_LoginPage.txtbx_UserName).sendKeys(userName);
        System.out.println("Email id entered");


        String password = ExcelUtils.getCellData(sheetName, row, Config.col_Password);
        driver.findElement(DemoWebShop_LoginPage.txtbx_Password).sendKeys(password);
        System.out.println("Password is entered");

        driver.findElement(DemoWebShop_LoginPage.btn_Login).submit();
        System.out.println("Login button clicked successfully");

        driver.findElement(DemoWebShop_HomePage.link_Account).click();
        System.out.println("Account clicked");

        driver.findElement(DemoWebShop_OrdersPage.drpdwn_Orders).click();
        System.out.println("Orders dropdown clicked");

        List<WebElement> totalOrders = driver.findElements(DemoWebShop_OrdersPage.list_TotalOrders);
        //System.out.println(totalOrders.size());
        int count = 0;
        for (WebElement size : totalOrders){
            count = count + 1;
        }
        System.out.println("The total no. of orders are: "+count);

        List<WebElement> totalValue= driver.findElements(DemoWebShop_OrdersPage.list_TotalValue);

        float totalSum = 0;
        for(WebElement text : totalValue){
            String value = text.getText();
            String[] order = value.split(":");
            float sum = Float.parseFloat(order[1]);
            totalSum = totalSum + sum;
        }

        System.out.println("The value of total number of orders is: $"+totalSum);

        Thread.sleep(5000);
        driver.quit();






    }
}



