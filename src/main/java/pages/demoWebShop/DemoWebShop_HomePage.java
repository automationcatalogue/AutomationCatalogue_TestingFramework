package pages.demoWebShop;

import org.openqa.selenium.By;

public class DemoWebShop_HomePage {
    public static By link_BooksCategory=By.xpath("//div[@class='header-menu']/ul/li/a");
    public static By link_ComputersCategory=By.xpath("//div[@class='block block-category-navigation']//a[contains(text(),'Computers')]");
    public static By link_DesktopSubCategory=By.xpath("//div[@class='block block-category-navigation']//a[contains(text(),'Desktops')]");
    public static By link_NotebooksSubCategory=By.xpath("//div[@class='block block-category-navigation']//a[contains(text(),'Notebooks')]");
    public static By link_AccessoriesSubCategory=By.xpath("//div[@class='block block-category-navigation']//a[contains(text(),'Accessories')]");
    public static By link_ElectronicsCategory=By.xpath("//div[@class='block block-category-navigation']//a[contains(text(),'Electronics')]");
    public static By link_CellphonesSubCategory=By.xpath("//div[@class='block block-category-navigation']//a[contains(text(),'Cell phones')]");
    public static By link_ApparelShoesCategory=By.xpath("//div[@class='block block-category-navigation']//a[contains(text(),'Apparel & Shoes')]");
    public static By link_DigitalDownloadsCategory=By.xpath("//div[@class='block block-category-navigation']//a[contains(text(),'Digital downloads')]");
    public static By link_JewelaryCategory=By.xpath("//div[@class='block block-category-navigation']//a[contains(text(),'Jewelry')]");
    public static By link_GiftCardsCategory=By.xpath("//div[@class='block block-category-navigation']//a[contains(text(),'Gift Cards')]");
    public static By link_ShoppingCart=By.xpath("//*[@id='topcartlink']/a/span[1]");
    public static By link_Logout=By.linkText("Log out");

    public static By link_ShpngCart = By.xpath("//span[text()='Shopping cart']");




}
