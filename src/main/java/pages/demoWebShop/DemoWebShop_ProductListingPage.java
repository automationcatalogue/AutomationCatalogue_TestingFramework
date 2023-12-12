package pages.demoWebShop;

import org.openqa.selenium.By;

public class DemoWebShop_ProductListingPage {
    public static By addToCart_Product(String productName){
        return By.xpath("(//h2//a[text()='"+productName+"'])[1]/../..//input");
    }
}
