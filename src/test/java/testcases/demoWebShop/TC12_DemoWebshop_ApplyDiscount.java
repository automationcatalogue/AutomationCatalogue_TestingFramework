package testcases.demoWebShop;

import Utilities.Config;
import Utilities.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.PageLocators;

import java.time.Duration;

public class TC12_DemoWebshop_ApplyDiscount {
    static WebDriver driver;
    public static void main(String[] args) throws Exception{

        String projectPath = System.getProperty("user.dir");
        String sheetName = "Demo_ApplyDiscount";
        ExcelUtils.setExcelFilePath(projectPath+"//TestData//Automation_TestData.xlsx");
        int row = ExcelUtils.getRowNumber(Config.testID_DEMOApplyDiscount,sheetName);

        driver = new ChromeDriver();
        System.out.println("chrome browser is launched");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        System.out.println("Implicit timeout is given");

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        System.out.println("Webdriver timeout is given");

        driver.get("https://demowebshop.tricentis.com/");
        System.out.println("DemoWebshop url is loaded");

        driver.manage().window().maximize();
        System.out.println("browser is maximized");

        driver.findElement(PageLocators.Loginbtn).click();
        System.out.println("login button is clicked");

        String userName = ExcelUtils.getCellData(sheetName,row,Config.col_UserName);
        driver.findElement(PageLocators.usrnamebx).sendKeys(userName);
        System.out.println("username is entered as " + userName);

        String Password = ExcelUtils.getCellData(sheetName,row,Config.col_Password);
        driver.findElement(PageLocators.paswrdbx).sendKeys(Password);
        System.out.println("password is entered as " + Password);

        driver.findElement(PageLocators.Login_btn).click();
        System.out.println("login button is clicked");

        String productCategory = ExcelUtils.getCellData(sheetName, row, Config.col_ApplyDiscount_ProductCategory);
        String productName = ExcelUtils.getCellData(sheetName, row, Config.col_ApplyDiscount_ProductName);
        clickCategory(productCategory);
        driver.findElement(addToCart_Product(productName)).click();
        System.out.println(productName+" Add to Cart button is clicked");
        enterProductData(productName);

        driver.findElement(PageLocators.shp_cart).click();
        System.out.println("shopping cart is clicked");

        driver.navigate().refresh();

        String Discountcode  = ExcelUtils.getCellData(sheetName, row, Config.col_ApplyDiscount_DiscountCode);
        driver.findElement(PageLocators.Dis_code).sendKeys(Discountcode);
        System.out.println("discount code is entered");

        wait.until(ExpectedConditions.elementToBeClickable(PageLocators.Dis_code)).click();

        driver.findElement(PageLocators.Apply_cpn).click();
        System.out.println("Apply coupon is clicked");

        WebElement element_actualvalue = driver.findElement(PageLocators.Actual_val);
        System.out.println("acual value dropdown is selected");

        WebElement element_Discountvalue=driver.findElement(PageLocators.Dis_val);
        System.out.println("Discount value is drpdown is selected");

        String actualvaluetext=element_actualvalue.getText();
        System.out.println("actual value  is retrived");

        String Discountvaluetext=element_Discountvalue.getText();
        System.out.println("Discount value is retrived");

        //string is converted to double
        double actualvalue = Double.parseDouble(actualvaluetext);
        double Discountvalue = Double.parseDouble(Discountvaluetext);

        //discount value is displayed
        double Discountedvalue = (actualvalue-Discountvalue);
        System.out.println("total discount is:" + Discountedvalue);

        //discount percentage is displayed
        double discountpercentage = Discountedvalue/actualvalue*100;
        System.out.println("discount percentage is:"+discountpercentage);

        driver.findElement(PageLocators.Agree_btn).click();
        System.out.println("agree button is clicked");

        driver.findElement(PageLocators.checkout_btn).click();
        System.out.println("checkout button is clicked");

        driver.findElement(PageLocators.Billing_btn).click();
        System.out.println("billing address continue button is clicked");

        driver.findElement(PageLocators.Shipping_btn).click();
        System.out.println("shipping address continue button is clicked");

        driver.findElement(PageLocators.shipping_mtd).click();
        System.out.println("shipping method continue button is clicked");

        String Paymentinfo = ExcelUtils.getCellData(sheetName, row, Config.col_ApplyDiscount_PaymentInformation);
        driver.findElement(PageLocators.creditcard).click();
        System.out.println("payment information is selected as " + Paymentinfo);

        driver.findElement(PageLocators.payment_btn).click();
        System.out.println("payment method continue button is clicked");

        String CardholderName = ExcelUtils.getCellData(sheetName, row, Config.col_ApplyDiscount_CardHolderName);
        driver.findElement(PageLocators.Card_holder).sendKeys(CardholderName);
        System.out.println("credit card name is selected as " + CardholderName);

        String CreditcardNum  = ExcelUtils.getCellData(sheetName, row, Config.col_ApplyDiscount_CardNumber);
        driver.findElement(PageLocators.Card_number).sendKeys(CreditcardNum);
        System.out.println("credit card number is entered as " + CreditcardNum);

        //String Expdate = ExcelUtils.getCellData(sheetName, row, Config.col_ExpirationDate);
        Select monthDropdown = new Select(driver.findElement(PageLocators.Card_month));
        System.out.println("month is clicked");


        Select yearDropdown = new Select(driver.findElement(PageLocators.Card_year));
        System.out.println("year is clicked");

        monthDropdown.selectByVisibleText("04");
        System.out.println("month is selected as 04");

        yearDropdown.selectByVisibleText("2023");
        System.out.println("Year is selected as 2023");

        String Cardcode = ExcelUtils.getCellData(sheetName, row, Config.col_ApplyDiscount_CardCode);
        driver.findElement(PageLocators.Cardcode).sendKeys(Cardcode);
        System.out.println("card code is entered as " + Cardcode);

        driver.findElement(PageLocators.Paymentinfo_btn).click();
        System.out.println("payment info continue button is clicked");

        driver.findElement(PageLocators.Conformorder_btn).click();
        System.out.println("conform order continue button is clicked");

        driver.findElement(PageLocators.Order_details).click();
        System.out.println("Click here for order details is clicked");

        //orderId displayed and printed
        WebElement element_orderid = driver.findElement(PageLocators.Order_ID);
        String orderIDvalueText =element_orderid.getText();
        System.out.println("orderID is : " +orderIDvalueText);

        //ordervalue is displayed and printed
        WebElement element_ordervalue = driver.findElement(PageLocators.Order_value);
        String ordervalueText = element_ordervalue.getText();
        System.out.println("ordervalue is : " +ordervalueText);

        //converted ordervalue(string) to double
        double orderTotal=Double.parseDouble(ordervalueText);
        System.out.println("doubled the order value");

        String expectedOrderID = orderIDvalueText;
        System.out.println("orderID value is retriver");

        double expecteedorderTotal = orderTotal;
        System.out.println("Totalorder value is retriver");

        if (orderIDvalueText.equals(expectedOrderID) && orderTotal == expecteedorderTotal){
            System.out.println("orderIDvalue and total order is as expected");
        }else {
            System.out.println("orderIDvalue and total order is not as expected");
        }

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
