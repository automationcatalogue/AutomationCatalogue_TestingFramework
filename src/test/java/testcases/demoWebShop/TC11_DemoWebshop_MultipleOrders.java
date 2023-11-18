package testcases.demoWebShop;

import Utilities.Config;
import Utilities.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TC11_DemoWebshop_MultipleOrders {

    static WebDriver driver;

    public static void main(String[] args) throws Exception {
        String projectPath = System.getProperty("user.dir");
        String sheetName = "Demo_MultipleProducts";
        ExcelUtils.setExcelFilePath(projectPath + "//TestData//Automation_TestData.xlsx");
        int row = ExcelUtils.getRowNumber(Config.testID_DemoMultipleProducts, sheetName);

        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        System.out.println("Chrome browser is launched");

        driver.get("http://demowebshop.tricentis.com/login");
        System.out.println("website is loaded");
        driver.manage().window().maximize();
        System.out.println("Chrome browser is maximized");

        String userName = ExcelUtils.getCellData(sheetName, row, Config.col_UserName);
        driver.findElement(By.name("Email")).sendKeys(userName);
        System.out.println("Email is entered");

        String password = ExcelUtils.getCellData(sheetName, row, Config.col_Password);
        driver.findElement(By.name("Password")).sendKeys(password);
        System.out.print("password is entered");

        driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
        System.out.println("login is clicked");

        String product1Category = ExcelUtils.getCellData(sheetName, row, Config.col_Product1Category);
        String product2Category = ExcelUtils.getCellData(sheetName, row, Config.col_Product2Category);
        String product3Category = ExcelUtils.getCellData(sheetName, row, Config.col_Product3Category);
        String product4Category = ExcelUtils.getCellData(sheetName, row, Config.col_Product4Category);

        String product1Name = ExcelUtils.getCellData(sheetName, row, Config.col_Product1Name);
        String product2Name = ExcelUtils.getCellData(sheetName, row, Config.col_Product2Name);
        String product3Name = ExcelUtils.getCellData(sheetName, row, Config.col_Product3Name);
        String product4Name = ExcelUtils.getCellData(sheetName, row, Config.col_Product4Name);




        driver.findElement(By.xpath("//h2[@class='product-title']/a")).click();
        System.out.println("first product is selected");
        driver.findElement(By.xpath("//input[@id='add-to-cart-button-13']")).click();
        System.out.println("added to cart");

        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ul/li[2]/ul/li[2]/a")).click();
        System.out.println("notebooks are clicked");
        driver.findElement(By.xpath("//div[@class='details']/h2/a")).click();
        System.out.println("laptop is clicked");
        driver.findElement(By.xpath("//input[@id='add-to-cart-button-31']")).click();
        System.out.println("laptop is added");

        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[1]/div/div[2]/h2/a")).click();
        System.out.println("product is clicked");
        driver.findElement(By.xpath("//*[@id=\"product-details-form\"]/div/div[1]/div[2]/div[6]/div/label")).click();
        System.out.println("added to cart");
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ul/li[5]/a")).click();
        System.out.println("digital is clicked");
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[1]/div/div[2]/h2/a")).click();
        System.out.println("product is selected");
        driver.findElement(By.xpath("//input[@id='add-to-cart-button-53']")).click();
        System.out.println("added to cart");
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ul/li[6]/a")).click();
        System.out.println("jewllery is clicked");
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[2]/h2/a")).click();
        System.out.println("jewellery is clicked");
        driver.findElement(By.xpath("//input[@id='add-to-cart-button-14']")).click();
        System.out.println("added to cart");
        driver.findElement(By.xpath("//*[@id='topcartlink']/a/span[1]")).click();
        System.out.println("shopping cart is clicked");
        driver.findElement(By.xpath("//input[@id='termsofservice']")).click();
        System.out.println("Terms and conditions clicked");
        driver.findElement(By.xpath("//button[@id='checkout']")).click();
        System.out.println("checkout");
        driver.findElement(By.xpath("//*[@id='billing-buttons-container']/input")).click();
        System.out.println("continue billing address");
        WebElement element_ShippingAddress = driver.findElement(By.xpath("//*[@id='shipping-buttons-container']/input"));
        js.executeScript("arguments[0].click();",element_ShippingAddress);
        System.out.println("shipping address is clicked ");
        driver.findElement(By.xpath("//*[@id='shipping-method-buttons-container']/input")).click();
        System.out.println("shipping method");
        driver.findElement(By.xpath("//input[@id='paymentmethod_1']")).click();
        System.out.println("money order is selected");
        driver.findElement(By.xpath("//*[@id='payment-method-buttons-container']/input")).click();
        System.out.println("continue to confirm");
        driver.findElement(By.xpath("//*[@id='payment-info-buttons-container']/input")).click();
        System.out.println("confirm order");
        driver.findElement(By.xpath("//*[@id='confirm-order-buttons-container']/input")).click();
        System.out.println("order is confirmed");
        String data = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/ul/li[1]")).getText();

    }


    public static By getLocator_Product(String productName){
        return By.xpath("(//h2//a[text()='"+productName+"'])[1]");
    }

    public static void clickCategory(String productCategory){
        if(productCategory.equalsIgnoreCase("Books")){
            driver.findElement(By.xpath("//div[@class='header-menu']/ul/li/a")).click();
            System.out.println("Books category is clicked");
        }else if(productCategory.contains("Computers")){
            driver.findElement(By.xpath("//div[@class='block block-category-navigation']//a[contains(text(),'Computers')]")).click();
            System.out.println("Computers category is clicked");

            String subCategory = productCategory.split("-")[1];
            if(subCategory.equalsIgnoreCase("Desktop")){
                driver.findElement(By.xpath("//div[@class='block block-category-navigation']//a[contains(text(),'Desktops')]")).click();
            }else if(subCategory.equalsIgnoreCase("Notebooks")){
                driver.findElement(By.xpath("//div[@class='block block-category-navigation']//a[contains(text(),'Notebooks')]")).click();
            }else if(subCategory.equalsIgnoreCase("Accessories")){
                driver.findElement(By.xpath("//div[@class='block block-category-navigation']//a[contains(text(),'Accessories')]")).click();
            }
            System.out.println(subCategory+" SubCategory is clicked");

        }else if(productCategory.contains("Electronics")){
            driver.findElement(By.xpath("//div[@class='block block-category-navigation']//a[contains(text(),'Electronics')]")).click();
            System.out.println("Electronics category is clicked");

            String subCategory = productCategory.split("-")[1];
            if(subCategory.equalsIgnoreCase("Cell phones")){
                driver.findElement(By.xpath("//div[@class='block block-category-navigation']//a[contains(text(),'Cell phones')]")).click();
                System.out.println("Cell phones subcategory is clicked");
            }

        }else if(productCategory.equalsIgnoreCase("Apparel & Shoes")){
            driver.findElement(By.xpath("//div[@class='block block-category-navigation']//a[contains(text(),'Apparel & Shoes')]")).click();
            System.out.println("Apparel & Shoes category is clicked");
        }else if(productCategory.equalsIgnoreCase("Digital downloads")){
            driver.findElement(By.xpath("//div[@class='block block-category-navigation']//a[contains(text(),'Digital downloads')]")).click();
            System.out.println("Digital downloads category is clicked");
        }else if(productCategory.equalsIgnoreCase("Jewelry")){
            driver.findElement(By.xpath("//div[@class='block block-category-navigation']//a[contains(text(),'Jewelry')]")).click();
            System.out.println("Jewelry category is clicked");
        }else if(productCategory.equalsIgnoreCase("Gift Cards")){
            driver.findElement(By.xpath("//div[@class='block block-category-navigation']//a[contains(text(),'Gift Cards')]")).click();
            System.out.println("Gift Cards category is clicked");
        }
    }
}
