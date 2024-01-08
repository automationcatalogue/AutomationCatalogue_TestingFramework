package pages.demoWebShop;

import Utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    public static void clickShoesLink(){
        WebElement element_Shoes = driver.findElement(DemoWebShop_ProductListingPage.link_Shoes);
        element_Shoes.click();
        System.out.println("Shoes is clicked");
    }

    public static double getItemPrice(){
        String itemPrice = driver.findElement(By.xpath("//div[@class='product-price']/span")).getText();
        double itemValue = Double.parseDouble(itemPrice);
        System.out.println("Selected Iem Value is :" + itemValue);
        return itemValue;
    }

    public static void addToCart(){
        WebElement element_Addtocart = driver.findElement(DemoWebShop_ProductListingPage.btn_addToCart);
        element_Addtocart.click();
        System.out.println("Add to cart button is clicked");
    }

}
