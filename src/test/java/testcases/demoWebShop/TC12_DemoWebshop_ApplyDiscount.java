package testcases.demoWebShop;

import Utilities.Config;
import Utilities.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TC12_DemoWebshop_ApplyDiscount {
    static WebDriver driver;
    public static WebDriverWait wait;

    public static void main(String[] args) throws Exception{
        String projectPath = System.getProperty("user.dir");
        String sheetName = "Demo_ApplyDiscount";
        ExcelUtils.setExcelFilePath(projectPath+"//TestData//Automation_TestData.xlsx");
        int row = ExcelUtils.getRowNumber(Config.testID_DEMOApplyDiscount,sheetName);

        driver = new ChromeDriver();
        System.out.println("Chrome Browser is opened");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        driver.manage().window().maximize();

        driver.get("https://demowebshop.tricentis.com/");
        System.out.println("DemoWebshop Application is loaded");

        driver.findElement(By.xpath("//a[@href='/login']")).click();
        System.out.println("login button is clicked");

        String userName = ExcelUtils.getCellData(sheetName,row,Config.col_UserName);
        driver.findElement(By.cssSelector("#Email")).sendKeys(userName);
        System.out.println("username is entered as " + userName);

        String Password = ExcelUtils.getCellData(sheetName,row,Config.col_Password);
        driver.findElement(By.cssSelector(".password")).sendKeys(Password);
        System.out.println("password is entered as " + Password);

        driver.findElement(By.xpath("//input[@value='Log in']")).click();
        System.out.println("login button is clicked");

        String productCategory = ExcelUtils.getCellData(sheetName, row, Config.col_ApplyDiscount_ProductCategory);
        String productName = ExcelUtils.getCellData(sheetName, row, Config.col_ApplyDiscount_ProductName);
        clickCategory(productCategory);
        driver.findElement(addToCart_Product(productName)).click();
        System.out.println(productName+" Add to Cart button is clicked");
        enterProductData(productName);

        driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
        System.out.println("Shopping cart button is clicked");

        driver.navigate().refresh();

        String discountCode  = ExcelUtils.getCellData(sheetName, row, Config.col_ApplyDiscount_DiscountCode);
        driver.findElement(By.xpath("//input[@name='discountcouponcode']")).sendKeys(discountCode);
        System.out.println("Discount code is entered");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='discountcouponcode']"))).click();
        System.out.println("Discount code check-box is clicked");

        driver.findElement(By.xpath("//input[@name='applydiscountcouponcode']")).click();
        System.out.println("Apply coupon button is clicked");

        WebElement element_Actualvalue = driver.findElement(By.xpath("(//span[@class='product-price'])[1]"));
        System.out.println("Acual value is selected");

        WebElement element_Discountvalue=driver.findElement(By.xpath("//span[@class='product-price order-total']/strong"));
        System.out.println("Discount value is selected");

        String actualvalueText=element_Actualvalue.getText();
        System.out.println("actual value  is retrived");

        String discountvalueText=element_Discountvalue.getText();
        System.out.println("Discount value is retrived");

        //string is converted to double
        double actualvalue = Double.parseDouble(actualvalueText);
        double Discountvalue = Double.parseDouble(discountvalueText);

        //discount value is displayed
        double Discountedvalue = (actualvalue-Discountvalue);
        System.out.println("total discount is:" + Discountedvalue);

        //discount percentage is displayed
        double discountPercentage = Discountedvalue/actualvalue*100;
        System.out.println("discount percentage is:"+discountPercentage);

        driver.findElement(By.xpath("//input[@id='termsofservice']")).click();
        System.out.println("Agree button is clicked");

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("checkout button is clicked");

        driver.findElement(By.xpath("(//input[@title='Continue'])[1]")).click();
        System.out.println("billing address continue button is clicked");

        driver.findElement(By.xpath("(//input[@title='Continue'])[2]")).click();
        System.out.println("shipping address continue button is clicked");

        driver.findElement(By.xpath("//div[@id='shipping-method-buttons-container']/input")).click();
        System.out.println("shipping method continue button is clicked");

        String paymentInfo = ExcelUtils.getCellData(sheetName, row, Config.col_ApplyDiscount_PaymentInformation);
        driver.findElement(By.xpath("//label[text()='Credit Card']")).click();
        System.out.println("payment information is selected as " + paymentInfo);

        driver.findElement(By.xpath("//div[@id='payment-method-buttons-container']/input")).click();
        System.out.println("payment method continue button is clicked");

        String cardholderName = ExcelUtils.getCellData(sheetName, row, Config.col_ApplyDiscount_CardHolderName);
        driver.findElement(By.cssSelector("#CardholderName")).sendKeys(cardholderName);
        System.out.println("credit card name is selected as " + cardholderName);

        String creditCardNum  = ExcelUtils.getCellData(sheetName, row, Config.col_ApplyDiscount_CardNumber);
        driver.findElement(By.cssSelector("#CardNumber")).sendKeys(creditCardNum);
        System.out.println("credit card number is entered as " + creditCardNum);

        Select monthDropdown = new Select(driver.findElement(By.cssSelector("#ExpireMonth")));
        System.out.println("Month drop-down is clicked");

        Select yearDropdown = new Select(driver.findElement(By.cssSelector("#ExpireYear")));
        System.out.println("year drop-down is clicked");

        monthDropdown.selectByVisibleText("04");
        System.out.println("Month is selected as 04");

        yearDropdown.selectByVisibleText("2023");
        System.out.println("Year is selected as 2023");

        String cardCode = ExcelUtils.getCellData(sheetName, row, Config.col_ApplyDiscount_CardCode);
        driver.findElement(By.cssSelector("#CardCode")).sendKeys(cardCode);
        System.out.println("Card code is entered as " + cardCode);

        driver.findElement(By.xpath("//div[@id='payment-info-buttons-container']/input")).click();
        System.out.println("Payment info continue button is clicked");

        driver.findElement(By.xpath("//div[@id='confirm-order-buttons-container']/input")).click();
        System.out.println("Conform order continue button is clicked");

        driver.findElement(By.xpath("//ul[@class='details']/li[2]/a")).click();
        System.out.println("Order details is clicked");

        //orderId displayed and printed
        WebElement element_orderid = driver.findElement(By.xpath("//div[@class='order-number']/strong"));
        String orderIDvalueText =element_orderid.getText();
        System.out.println("orderID is : " +orderIDvalueText);

        //ordervalue is displayed and printed
        WebElement element_ordervalue = driver.findElement(By.xpath("//div[@class='order-total']/strong"));
        String ordervalueText = element_ordervalue.getText();
        System.out.println("ordervalue is : " +ordervalueText);

        //converted ordervalue(string) to double
        double orderTotal=Double.parseDouble(ordervalueText);
        System.out.println("doubled the order value");

        String expectedOrderID = orderIDvalueText;
        System.out.println("orderID value is retriver");

        double expectedorderTotal = orderTotal;
        System.out.println("Totalorder value is retriver");

        if (orderIDvalueText.equals(expectedOrderID) && orderTotal == expectedorderTotal){
            System.out.println("orderIDvalue and total order is as expected");
        }else {
            System.out.println("orderIDvalue and total order is not as expected");
        }
        driver.findElement(By.linkText("Log out")).click();
        System.out.println("Successfully logout");

        driver.quit();
        System.out.println("Browser is closed");

    }
    public static By addToCart_Product(String productName){
        return By.xpath("(//h2//a[text()='"+productName+"'])[1]/../..//input");
    }

    public static void enterProductData(String productName){
        if(productName.equalsIgnoreCase("Create Your Own Jewelry")){
            driver.findElement(By.xpath("//label[contains(text(),'Length in cm')]/..//following-sibling::dd[1]/input")).sendKeys("10");
            System.out.println("Length in cm is entered for "+productName);
            driver.findElement(By.xpath("//input[@class='button-1 add-to-cart-button']")).click();
            System.out.println("Added to cart button for "+productName+" is clicked");
        }else if(productName.equalsIgnoreCase("Build your own cheap computer")
                || productName.equalsIgnoreCase("Blue and green Sneaker")
                || productName.equalsIgnoreCase("Phone Cover")
                || productName.equalsIgnoreCase("TCP Coaching day")){
            driver.findElement(By.xpath("//input[@class='button-1 add-to-cart-button']")).click();
            System.out.println("Added to cart button for "+productName+" is clicked");
        }else if(productName.equalsIgnoreCase("$5 Virtual Gift Card")
                || productName.equalsIgnoreCase("$25 Virtual Gift Card")){
            enterVirtualGiftCardDetails();
            driver.findElement(By.xpath("//input[@class='button-1 add-to-cart-button']")).click();
            System.out.println("Added to cart button for "+productName+" is clicked");
        }else if(productName.equalsIgnoreCase("$50 Physical Gift Card")
                || productName.equalsIgnoreCase("$100 Physical Gift Card")){
            enterPhysicalGiftCardDetails();
            driver.findElement(By.xpath("//input[@class='button-1 add-to-cart-button']")).click();
            System.out.println("Added to cart button for "+productName+" is clicked");
        }
    }

    public static void enterVirtualGiftCardDetails(){
        driver.findElement(By.xpath("//input[@class='recipient-name']")).clear();
        driver.findElement(By.xpath("//input[@class='recipient-name']")).sendKeys("Automation");
        driver.findElement(By.xpath("//input[@class='recipient-email']")).clear();
        driver.findElement(By.xpath("//input[@class='recipient-email']")).sendKeys("Automation@test.com");
        driver.findElement(By.xpath("//input[@class='sender-name']")).clear();
        driver.findElement(By.xpath("//input[@class='sender-name']")).sendKeys("AutomationCatalogue");
        driver.findElement(By.xpath("//input[@class='sender-name']")).clear();
        driver.findElement(By.xpath("//input[@class='sender-name']")).sendKeys("AutomationCatalogue@test.com");
    }

    public static void enterPhysicalGiftCardDetails(){
        driver.findElement(By.xpath("//input[@class='recipient-name']")).clear();
        driver.findElement(By.xpath("//input[@class='recipient-name']")).sendKeys("Automation");
        driver.findElement(By.xpath("//input[@class='sender-name']")).clear();
        driver.findElement(By.xpath("//input[@class='sender-name']")).sendKeys("AutomationCatalogue");
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
