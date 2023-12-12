package pages.demoWebShop;

import org.openqa.selenium.By;

public class DemoWebShop_ProductDisplayPage {
    public static By txtbx_JeweleryLength = By.xpath("//label[contains(text(),'Length in cm')]/..//following-sibling::dd[1]/input");
    public static By link_AddToCart = By.xpath("//input[@class='button-1 add-to-cart-button']");
    public static By txtbx_GiftCardName=By.xpath("//input[@class='recipient-name']");
    public static By txtbx_GiftCardEmail=By.xpath("//input[@class='recipient-email']");
    public static By txtbx_GiftCardSenderName=By.xpath("//input[@class='sender-name']");
    public static By txtbx_GiftCardSenderEmail=By.xpath("//input[@class='sender-email']");

}
