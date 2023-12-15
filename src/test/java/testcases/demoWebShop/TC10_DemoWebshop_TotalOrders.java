package testcases.demoWebShop;

import Utilities.Config;
import Utilities.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.demoWebShop.DemoWebShop_HomePage;
import pages.demoWebShop.DemoWebShop_LoginPage;
import pages.orangeHRM.OrangeHRM_HomePage;

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

        driver.get(Config.demoWebShopLogin_URL);
        System.out.println("Demowebshop page is loaded");

        DemoWebShop_LoginPage.login(driver, sheetName, row);

        driver.findElement(By.xpath("//a[text()='aarosagarch@gmail.com']")).click();
        System.out.println("Account clicked");

        driver.findElement(By.xpath("(//a[text()='Orders'])[1]")).click();
        System.out.println("Orders dropdown clicked");

        List<WebElement> totalOrders = driver.findElements(By.xpath("//div[@class='order-list']/div/div/strong"));
        //System.out.println(totalOrders.size());
        int count = 0;
        for (WebElement size : totalOrders){
            count = count + 1;
        }
        System.out.println("The total no. of orders are: "+count);

        List<WebElement> totalValue= driver.findElements(By.xpath("//div[@class='order-list']/div/ul/li[3]"));

        float totalSum = 0;
        for(WebElement text : totalValue){
            String value = text.getText();
            String[] order = value.split(":");
            float sum = Float.parseFloat(order[1]);
            totalSum = totalSum + sum;
        }

        System.out.println("The value of total number of orders is: $"+totalSum);

        Thread.sleep(5000);

        DemoWebShop_HomePage.logout(driver);

        driver.quit();
    }
}



