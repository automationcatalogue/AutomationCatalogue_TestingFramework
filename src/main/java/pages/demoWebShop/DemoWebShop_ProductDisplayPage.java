package pages.demoWebShop;

import Utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoWebShop_ProductDisplayPage extends BaseClass {

    public DemoWebShop_ProductDisplayPage(WebDriver driver){
        super(driver);
    }

    public static By txtbx_JeweleryLength = By.xpath("//label[contains(text(),'Length in cm')]/..//following-sibling::dd[1]/input");
    public static By link_AddToCart = By.xpath("//input[@class='button-1 add-to-cart-button']");
    public static By txtbx_GiftCardName=By.xpath("//input[@class='recipient-name']");
    public static By txtbx_GiftCardEmail=By.xpath("//input[@class='recipient-email']");
    public static By txtbx_GiftCardSenderName=By.xpath("//input[@class='sender-name']");
    public static By txtbx_GiftCardSenderEmail=By.xpath("//input[@class='sender-email']");

    public static void enterProductData(String productName){
        if(productName.equalsIgnoreCase("Create Your Own Jewelry")){
            driver.findElement(DemoWebShop_ProductDisplayPage.txtbx_JeweleryLength).sendKeys("10");
            System.out.println("Length in cm is entered for "+productName);
            driver.findElement(DemoWebShop_ProductDisplayPage.link_AddToCart).click();
            System.out.println("Added to cart button for "+productName+" is clicked");
        }else if(productName.equalsIgnoreCase("Build your own cheap computer")
                || productName.equalsIgnoreCase("Blue and green Sneaker")
                || productName.equalsIgnoreCase("Phone Cover")
                || productName.equalsIgnoreCase("TCP Coaching day")){
            driver.findElement(DemoWebShop_ProductDisplayPage.link_AddToCart).click();
            System.out.println("Added to cart button for "+productName+" is clicked");
        }else if(productName.equalsIgnoreCase("$5 Virtual Gift Card")
                || productName.equalsIgnoreCase("$25 Virtual Gift Card")){
            enterVirtualGiftCardDetails();
            driver.findElement(DemoWebShop_ProductDisplayPage.link_AddToCart).click();
            System.out.println("Added to cart button for "+productName+" is clicked");
        }else if(productName.equalsIgnoreCase("$50 Physical Gift Card")
                || productName.equalsIgnoreCase("$100 Physical Gift Card")){
            enterPhysicalGiftCardDetails();
            driver.findElement(DemoWebShop_ProductDisplayPage.link_AddToCart).click();
            System.out.println("Added to cart button for "+productName+" is clicked");
        }
    }

    public static void enterVirtualGiftCardDetails(){
        driver.findElement(DemoWebShop_ProductDisplayPage.txtbx_GiftCardName).clear();
        driver.findElement(DemoWebShop_ProductDisplayPage.txtbx_GiftCardName).sendKeys("Automation");
        driver.findElement(DemoWebShop_ProductDisplayPage.txtbx_GiftCardEmail).clear();
        driver.findElement(DemoWebShop_ProductDisplayPage.txtbx_GiftCardEmail).sendKeys("Automation@test.com");
        driver.findElement(DemoWebShop_ProductDisplayPage.txtbx_GiftCardSenderName).clear();
        driver.findElement(DemoWebShop_ProductDisplayPage.txtbx_GiftCardSenderName).sendKeys("AutomationCatalogue");
        driver.findElement(DemoWebShop_ProductDisplayPage.txtbx_GiftCardSenderEmail).clear();
        driver.findElement(DemoWebShop_ProductDisplayPage.txtbx_GiftCardSenderEmail).sendKeys("AutomationCatalogue@test.com");
    }

    public static void enterPhysicalGiftCardDetails(){
        driver.findElement(DemoWebShop_ProductDisplayPage.txtbx_GiftCardName).clear();
        driver.findElement(DemoWebShop_ProductDisplayPage.txtbx_GiftCardName).sendKeys("Automation");
        driver.findElement(DemoWebShop_ProductDisplayPage.txtbx_GiftCardSenderName).clear();
        driver.findElement(DemoWebShop_ProductDisplayPage.txtbx_GiftCardSenderName).sendKeys("AutomationCatalogue");
    }

}
