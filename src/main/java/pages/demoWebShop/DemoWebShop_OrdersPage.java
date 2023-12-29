package pages.demoWebShop;

import Utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DemoWebShop_OrdersPage extends BaseClass {

    public DemoWebShop_OrdersPage(WebDriver driver){
        super(driver);
    }

    public static By drpdwn_Orders = By.xpath("(//a[text()='Orders'])[1]");
    public static By list_TotalOrders = By.xpath("//div[@class='order-list']/div/div/strong");
    public static By list_TotalValue = By.xpath("//div[@class='order-list']/div/ul/li[3]");
    public static By txt_OrderID = By.xpath("//div[@class='order-number']/strong");
    public static By txt_OrderValue = By.xpath("//div[@class='order-total']/strong");

    public static void clickOrders(){
        driver.findElement(DemoWebShop_OrdersPage.drpdwn_Orders).click();
        System.out.println("Orders dropdown clicked");
    }

    public static void getTotalOrdersCount(){
        List<WebElement> totalOrders = driver.findElements(DemoWebShop_OrdersPage.list_TotalOrders);
        System.out.println("The total no. of orders are: "+totalOrders.size());
    }

    public static void getTotalOrdersValue(){
        List<WebElement> totalValue= driver.findElements(DemoWebShop_OrdersPage.list_TotalValue);

        float totalSum = 0;
        for(WebElement text : totalValue){
            String value = text.getText();
            String[] order = value.split(":");
            float sum = Float.parseFloat(order[1]);
            totalSum = totalSum + sum;
        }

        System.out.println("The value of total number of orders is: $"+totalSum);
    }
}
