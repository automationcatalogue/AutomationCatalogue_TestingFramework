package testcases.demoWebShop;

import Utilities.Config;
import Utilities.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class TC13_DemoWebShop_PlaceOrder {
    public static void main(String[] args) throws Exception{
        String projectPath = System.getProperty("user.dir");
        String sheetName = "Demo_PlaceOrder";
        ExcelUtils.setExcelFilePath(projectPath+"//TestData//Automation_TestData.xlsx");
        int row = ExcelUtils.getRowNumber(Config.testID_Demo_PlaceOrder,sheetName);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://demowebshop.tricentis.com/");
        System.out.println("DemoWebShop url is launched");

        WebElement element_LoginIco = driver.findElement(By.className("ico-login"));
        element_LoginIco.click();
        System.out.println("Login icon button is clicked");

        String userName = ExcelUtils.getCellData(sheetName, row, Config.col_User_Name);
        WebElement element_Email = driver.findElement(By.name("Email"));
        element_Email.sendKeys(userName);
        System.out.println(userName + "is entered");

        String password = ExcelUtils.getCellData(sheetName, row, Config.col_Password_DWS);
        WebElement element_Password = driver.findElement(By.id("Password"));
        element_Password.sendKeys(password);
        System.out.println(password + " is entered");

        WebElement element_Login = driver.findElement(By.xpath("//input[@value='Log in']"));
        element_Login.click();
        System.out.println("Login button is clicked");

        WebElement element_Apparels_Shoes =driver.findElement(By.xpath("//div[@class='listbox']/ul/li[4]/a"));
        element_Apparels_Shoes.click();
        System.out.println("Apparels_Shoes is clicked");

        WebElement element_Shoes = driver.findElement(By.xpath("//div[@class='product-grid']/div[2]/div/div[2]/h2/a"));
        element_Shoes.click();
        System.out.println("Shoes is clicked");

        String itemPrice = driver.findElement(By.xpath("//div[@class='product-price']/span")).getText();
        double itemValue = Double.parseDouble(itemPrice);
        System.out.println("Selected Iem Value is :" + itemValue);

        WebElement element_Addtocart = driver.findElement(By.xpath("//div[@class='add-to-cart']/div/input[2]"));
        element_Addtocart.click();
        System.out.println("Add to cart button is clicked");

        WebElement element_Shopping_cart = driver.findElement(By.xpath("//span[text()='Shopping cart']"));
        element_Shopping_cart.click();
        System.out.println("Shopping cart is clicked");


        List<WebElement> allCountry = driver.findElements(By.xpath("//option[text()='Belgium']"));
        for(WebElement element:allCountry){
            String actualValue = element.getText();
            if(actualValue.equalsIgnoreCase("Belgium")){
                element.click();
                break;
            }
        }
        System.out.println("Belgium is selected");


        WebElement element_Checkbox = driver.findElement(By.xpath("//input[@id='termsofservice']"));
        element_Checkbox.click();
        System.out.println("Checkbox is selected");

        WebElement element_Checkout = driver.findElement(By.xpath("//button[@id='checkout']"));
        element_Checkout.click();
        System.out.println("Checkout button is clicked");

        WebElement element_BillingAddress = driver.findElement(By.xpath("(//input[@type='button'])[2]"));
        element_BillingAddress.click();
        System.out.println("Billing address continue button is clicked");

        WebElement element_ShoppingAddress = driver.findElement(By.xpath("(//input[@type='button'])[3]"));
        element_ShoppingAddress.click();
        System.out.println("Shopping address continue button is clicked");

        WebElement element_ShoppingMethod = driver.findElement(By.xpath("(//input[@type='button'])[4]"));
        element_ShoppingMethod.click();
        System.out.println("Shopping method continue button is clicked");

        WebElement element_PaymentMethod = driver.findElement(By.xpath("(//input[@type='button'])[5]"));
        element_PaymentMethod.click();
        System.out.println("Payment method continue button is clicked");

        WebElement element_PaymentInformation = driver.findElement(By.xpath("(//input[@type='button'])[6]"));
        element_PaymentInformation.click();
        System.out.println("Payment information continue button is clicked");

        WebElement element_Confirm = driver.findElement(By.xpath("//input[@value='Confirm']"));
        element_Confirm.click();
        System.out.println("Confirm button is clicked");

        String element_orderNumber = driver.findElement(By.xpath("(//div[@class='section order-completed']/ul/li)[1]")).getText();
        System.out.println("Order number is printed:"+element_orderNumber);

        WebElement element_orderDetails = driver.findElement(By.xpath("//div[@class='section order-completed']/ul/li[2]/a"));
        element_orderDetails.click();
        System.out.println("Order details is clicked");

        WebElement element_subTotal = driver.findElement(By.xpath("(//table[@class='cart-total']/tbody/tr/td[2]/span)[1]"));
        String text_SubTotal = element_subTotal.getText();
        System.out.println("Sub total amount of order:"+text_SubTotal);
        double subTotal = Double.parseDouble(text_SubTotal);

        if(itemValue == subTotal){
            System.out.println("Sub Total is displayed correctly");
        }else {
            System.out.println("Sub Total is displayed not correctly");
        }

        driver.findElement(By.xpath("//a[text()='Log out']")).click();
        System.out.println("Logout is clicked");

        driver.quit();
    }
}
