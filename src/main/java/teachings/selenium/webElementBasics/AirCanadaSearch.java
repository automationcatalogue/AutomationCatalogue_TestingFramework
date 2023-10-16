package teachings.selenium.webElementBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AirCanadaSearch {
    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.aircanada.com/ca/en/aco/home.html");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='bkmgFlights_tripTypeSelector_M']")).click();
        System.out.println("MutiCity/StopCover radio-button is clicked");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='bkmgFlights_origin_trip_1']")).clear();
        driver.findElement(By.xpath("//input[@id='bkmgFlights_origin_trip_1']")).sendKeys("Chennai");
        Thread.sleep(5000);

        WebElement element =driver.findElement(By.xpath("/html/body/abc-overlay/div/div/ac-locations-dropdown-panel/ul/li/abc-ripple/div"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",element);
        System.out.println("From data is selected from drop-down");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='bkmgFlights_destination_trip_1']")).sendKeys("Toronto");
        Thread.sleep(5000);
        driver.findElement(By.xpath("(/html/body/abc-overlay/div/div/ac-locations-dropdown-panel/ul/li/abc-ripple/div)[1]")).click();
        System.out.println("To data is selected from drop-down");
        Thread.sleep(5000);


        WebElement element1 = driver.findElement(By.xpath("//span[text()=' 1 Adult ']"));
        JavascriptExecutor js1 = (JavascriptExecutor)driver;
        js1.executeScript("arguments[0].click();",element1);


        System.out.println("Passengers drop-down is clicked");
        Thread.sleep(5000);
        int adultcount=3;
        driver.findElement(By.xpath("(//span[text()='+'])[1]")).click();
        driver.findElement(By.xpath("(//span[text()='+'])[1]")).click();
        //driver.findElement(By.xpath("(//span[text()='+'])[1]")).click();
        System.out.println("3 Adults are selected");
        Thread.sleep(2000);
        int youthcount=2;
        driver.findElement(By.xpath("(//span[text()='+'])[2]")).click();
        driver.findElement(By.xpath("(//span[text()='+'])[2]")).click();
        System.out.println("2 Youths are selected");
        Thread.sleep(2000);
        int childcount=1;
        driver.findElement(By.xpath("(//span[text()='+'])[3]")).click();
        System.out.println("1 child is selected");
        Thread.sleep(2000);
        int infantLapcount=1;
        driver.findElement(By.xpath("(//span[text()='+'])[4]")).click();
        System.out.println("1 Infant (on Lap) is selected");
        Thread.sleep(2000);
        int infantSeatCount=2;
        driver.findElement(By.xpath("(//span[text()='+'])[5]")).click();
        driver.findElement(By.xpath("(//span[text()='+'])[5]")).click();
        System.out.println("2 Infants (on Seat is) is selected");
        Thread.sleep(2000);
        int totalPassengers = adultcount+childcount+youthcount+infantLapcount+infantSeatCount;


        WebElement element2 = driver.findElement(By.xpath("//span[@id='bkmgFlights_selectTravelers_confirmTravelersContent']"));
        JavascriptExecutor js2 = (JavascriptExecutor)driver;
        js2.executeScript("arguments[0].click();",element2);

        System.out.println("Close button is clicked");
        Thread.sleep(5000);
        String str = driver.findElement(By.xpath("//span[text()=' 9 Passengers ']")).getText();
        str=str.trim();

        String s[]=str.split(" ");
        int y=Integer.parseInt(s[0]);

        if(y==totalPassengers){
            System.out.println("Number of Passengers are updated correctly");
        }else {
            System.out.println("Number of Passengers are not updated correctly");
        }








    }
}
