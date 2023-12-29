package pages.demoWebShop;

import Utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoWebShop_ProductListingPage extends BaseClass {

    public DemoWebShop_ProductListingPage(WebDriver driver){
        super(driver);
    }

    public static By addToCart_Product(String productName){
        return By.xpath("(//h2//a[text()='"+productName+"'])[1]/../..//input");

    }
    public static By link_Shoes=By.xpath("//div[@class='product-grid']/div[2]/div/div[2]/h2/a");
    public static By btn_addToCart=By.xpath("//div[@class='add-to-cart']/div/input[2]");

    public static void addToCartProduct(String productName){
        driver.findElement(DemoWebShop_ProductListingPage.addToCart_Product(productName)).click();
        System.out.println(productName+" Add to Cart button is clicked");
    }

}
