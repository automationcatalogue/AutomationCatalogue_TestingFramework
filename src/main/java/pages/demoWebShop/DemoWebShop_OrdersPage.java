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

    public static void validateOrderId_OrderValue(){
        //orderId displayed and printed
        WebElement element_OrderId = driver.findElement(DemoWebShop_OrdersPage.txt_OrderID);
        String orderIDvalueText =element_OrderId.getText();
        System.out.println("OrderID is : " +orderIDvalueText);

        //ordervalue is displayed and printed
        WebElement element_OrderValue = driver.findElement(DemoWebShop_OrdersPage.txt_OrderValue);
        String orderValueText = element_OrderValue.getText();
        System.out.println("Ordervalue is : " +orderValueText);

        //converted ordervalue(string) to double
        double orderTotal=Double.parseDouble(orderValueText);
        System.out.println("doubled the order value");

        String expectedOrderID = orderIDvalueText;
        System.out.println("OrderID value is retriver");

        double expectedorderTotal = orderTotal;
        System.out.println("Totalorder value is retriver");

        if (orderIDvalueText.equals(expectedOrderID) && orderTotal == expectedorderTotal){
            System.out.println("OrderID value and total order is as expected");
        }else {
            System.out.println("OrderID value and total order is not as expected");
        }
    }

    public static void validateSubTotal(double itemValue){
        WebElement element_subTotal = driver.findElement(By.xpath("(//table[@class='cart-total']/tbody/tr/td[2]/span)[1]"));
        String text_SubTotal = element_subTotal.getText();
        System.out.println("Sub total amount of order:"+text_SubTotal);
        double subTotal = Double.parseDouble(text_SubTotal);

        if(itemValue == subTotal){
            System.out.println("Sub Total is displayed correctly");
        }else {
            System.out.println("Sub Total is displayed not correctly");
        }
    }

}
