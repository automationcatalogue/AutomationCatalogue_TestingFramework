package pages.demoWebShop;

import org.openqa.selenium.By;

public class DemoWebShop_ProductListingPage {
    public static By addToCart_Product(String productName){
        return By.xpath("(//h2//a[text()='"+productName+"'])[1]/../..//input");

    }
    public static By link_Shoes=By.xpath("//div[@class='product-grid']/div[2]/div/div[2]/h2/a");
    public static By btn_addToCart=By.xpath("//div[@class='add-to-cart']/div/input[2]");

}
