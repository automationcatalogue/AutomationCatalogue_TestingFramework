package pages.demoWebShop;

import org.openqa.selenium.By;

public class DemoWebShop_OrdersPage {
    public static By drpdwn_Orders = By.xpath("(//a[text()='Orders'])[1]");
    public static By list_TotalOrders = By.xpath("//div[@class='order-list']/div/div/strong");
    public static By list_TotalValue = By.xpath("//div[@class='order-list']/div/ul/li[3]");
}
