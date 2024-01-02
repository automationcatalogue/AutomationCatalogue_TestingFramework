package pages.demoWebShop;

import Utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoWebShop_HomePage extends BaseClass {

    public DemoWebShop_HomePage(WebDriver driver){
        super(driver);
    }

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
    public static By link_Account = By.xpath("//a[text()='aarosagarch@gmail.com']");
    public static By link_Logout=By.linkText("Log out");
    public static By link_UserName=By.xpath("(//a[@class='account'])[1]");

    public static void logout(){
        driver.findElement(DemoWebShop_HomePage.link_Logout).click();
        System.out.println("Successfully logout");
    }

    public static void clickUserName(){
        driver.findElement(DemoWebShop_HomePage.link_UserName).click();
        System.out.println("User name is been clicked");
    }

    public static void clickAccountName(){
        driver.findElement(DemoWebShop_HomePage.link_Account).click();
        System.out.println("Account clicked");
    }

    public static void clickCategory(String productCategory){
        if(productCategory.equalsIgnoreCase("Books")){
            driver.findElement(DemoWebShop_HomePage.link_BooksCategory).click();
            System.out.println("Books category is clicked");
        }else if(productCategory.contains("Computers")){
            driver.findElement(DemoWebShop_HomePage.link_ComputersCategory).click();
            System.out.println("Computers category is clicked");

            String subCategory = productCategory.split("-")[1];
            if(subCategory.equalsIgnoreCase("Desktop")){
                driver.findElement(DemoWebShop_HomePage.link_DesktopSubCategory).click();
            }else if(subCategory.equalsIgnoreCase("Notebooks")){
                driver.findElement(DemoWebShop_HomePage.link_NotebooksSubCategory).click();
            }else if(subCategory.equalsIgnoreCase("Accessories")){
                driver.findElement(DemoWebShop_HomePage.link_AccessoriesSubCategory).click();
            }
            System.out.println(subCategory+" SubCategory is clicked");

        }else if(productCategory.contains("Electronics")){
            driver.findElement(DemoWebShop_HomePage.link_ElectronicsCategory).click();
            System.out.println("Electronics category is clicked");

            String subCategory = productCategory.split("-")[1];
            if(subCategory.equalsIgnoreCase("Cell phones")){
                driver.findElement(DemoWebShop_HomePage.link_CellphonesSubCategory).click();
                System.out.println("Cell phones subcategory is clicked");
            }

        }else if(productCategory.equalsIgnoreCase("Apparel & Shoes")){
            driver.findElement(DemoWebShop_HomePage.link_ApparelShoesCategory).click();
            System.out.println("Apparel & Shoes category is clicked");
        }else if(productCategory.equalsIgnoreCase("Digital downloads")){
            driver.findElement(DemoWebShop_HomePage.link_DigitalDownloadsCategory).click();
            System.out.println("Digital downloads category is clicked");
        }else if(productCategory.equalsIgnoreCase("Jewelry")){
            driver.findElement(DemoWebShop_HomePage.link_JewelaryCategory).click();
            System.out.println("Jewelry category is clicked");
        }else if(productCategory.equalsIgnoreCase("Gift Cards")){
            driver.findElement(DemoWebShop_HomePage.link_GiftCardsCategory).click();
            System.out.println("Gift Cards category is clicked");
        }
    }

    public static void clickShoppingCart(){
        driver.findElement(DemoWebShop_HomePage.link_ShoppingCart).click();
        System.out.println("shopping cart is clicked");
    }

    public static void clickApparelsShoes(){
        WebElement element_Apparels_Shoes =driver.findElement(DemoWebShop_HomePage.link_ApparelShoesCategory);
        element_Apparels_Shoes.click();
        System.out.println("Apparels_Shoes is clicked");
    }
}
