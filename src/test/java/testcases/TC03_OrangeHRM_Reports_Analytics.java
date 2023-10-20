package testcases;

import Utilities.Config_Data;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.PageLocators;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class TC03_OrangeHRM_Reports_Analytics {
    public static void main(String[] args) throws Exception{
        {
            String projectPath = System.getProperty("user.dir");

            WebDriver driver = new ChromeDriver();
            System.out.println("Browser is launched");

            String projectpath = System.getProperty("user.dir");
            System.out.println(projectpath+"Screenshots");

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            System.out.println("Implicit timeout is given");

            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
            System.out.println("Webdriver timeout is given");

            driver.get("https://automatetest-trials710.orangehrmlive.com/");
            System.out.println("OrangeHRM Application is loaded");

            driver.manage().window().maximize();
            System.out.println("browser is maximized");

            String title = driver.getTitle();
            System.out.println("Title of the page is :" + title);

            driver.findElement(PageLocators.usrnmbx).sendKeys(Config_Data.username);
            System.out.println("UserName is entered");

            driver.findElement(PageLocators.pwdbx).sendKeys(Config_Data.password);
            System.out.println("Password is entered");

            driver.findElement(PageLocators.btn_login).click();
            System.out.println("Login button is clicked");

            TakesScreenshot ts=(TakesScreenshot)driver;
            File src =ts.getScreenshotAs(OutputType.FILE);
            File dest = new File(projectPath+"\\Screenshots\\Login.jpg");
            FileUtils.copyFile(src,dest);
            System.out.println("login screenshot is captured");

            driver.findElement(PageLocators.reportstxtbx).click();
            System.out.println("reports and analytics is clicked");

            String s1 = driver.getTitle();
            String s2 = Config_Data.Titel1;
            if (s1.equalsIgnoreCase(s2)) {
                System.out.println("Title is Matched and Login is successful");
            } else {
                System.out.println("Title is not Matched and Login is not successful");
            }

            driver.findElement(PageLocators.newreportbtn).click();

            System.out.println("new report is clicked");

            driver.findElement(PageLocators.empinfobtn).click();
            System.out.println("employ info is clicked");

            List<WebElement> elements_Reports = driver.findElements(PageLocators.reportsDrpdwn);
            for(WebElement element : elements_Reports) {
                String Report = element.getText();
                if(Report.equalsIgnoreCase(Config_Data.webelement1)) {
                    element.click();
                    System.out.println("Reports drop-down is clicked");
                    break;
                }
            }
            driver.findElement(PageLocators.selfolderBtn).click();
            System.out.println("select folders is clicked");

            List<WebElement> elements_Folders =  driver.findElements(PageLocators.folderDrpdwn);
            for (WebElement element : elements_Folders) {
                String Folder = element.getText();
                if (Folder.equalsIgnoreCase(Config_Data.elefolder)) {
                    element.click();
                    System.out.println("Folder drop-down is clicked");
                    break;
                }
            }
            driver.findElement(PageLocators.nxtBtn1).click();
            System.out.println("next button is clicked");

            driver.findElement(PageLocators.repnameBtn).sendKeys(Config_Data.reportname);
            System.out.println("report name is entered");

            TakesScreenshot ts1=(TakesScreenshot)driver;
            File src_rep =ts1.getScreenshotAs(OutputType.FILE);
            File dest_rep= new File(projectPath+"\\Screenshots\\reportname.jpg");
            FileUtils.copyFile(src_rep,dest_rep);
            System.out.println("report screenshot is captured");

            wait.until((ExpectedConditions.elementToBeClickable(PageLocators.nxtBtn2))).click();
            System.out.println("next button is clicked");

            driver.findElement(PageLocators.trvlreqBtn).click();
            System.out.println("Travel request Id  is selected");

            driver.findElement(PageLocators.jobttlBtn).click();
            System.out.println("job title  is selected");

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            System.out.println("window is scrolled to down");

            driver.findElement(PageLocators.nxtBtn3).click();
            System.out.println("next button is clicked");

            driver.findElement(PageLocators.disfieldBx).click();
            System.out.println("Add display field group is clicked");

            List<WebElement> elements_Displayfields =  driver.findElements(PageLocators.displaydrpdwn);
            for (WebElement element : elements_Displayfields) {
                String Folder = element.getText();
                if (Folder.equalsIgnoreCase(Config_Data.eleDisfields)) {
                    element.click();
                    System.out.println("Display fields dropdown is selected ");
                    break;
                }
            }
            driver.findElement(PageLocators.slctEstDt).click();
            System.out.println("Travel request Estimation date is selected");

            TakesScreenshot ts2=(TakesScreenshot)driver;
            File src_trvlreq =ts2.getScreenshotAs(OutputType.FILE);
            File dest_trvlreq= new File("C:projectpath+\\trvlreq_est.jpg");
            FileUtils.copyFile(src_trvlreq,dest_trvlreq);
            System.out.println(" Travel request Estimation date is captured");

            driver.findElement(PageLocators.trvlreqbx).click();
            System.out.println("travel request btn is clicked");

            driver.findElement(PageLocators.cashadvbx).click();
            System.out.println("cash in advance button is clicked");

            driver.findElement(PageLocators.saveBtn).click();
            System.out.println("save button is clicked");

            driver.findElement(PageLocators.backarrowbtn).click();
            System.out.println("one step back button is clicked");

            driver.findElement(PageLocators.searchbx).sendKeys(Config_Data.reportname);
            System.out.println("clicked on search bar and entered report name");

            WebElement element = driver.findElement(PageLocators.texttrvlreq);
            String s3 = element.getText();
            String s4 =Config_Data.texttrvlreq;
            if (s3.equalsIgnoreCase(s4)) {
                System.out.println("text is Matched as travel request ");
            } else {
                System.out.println("Text is not matched");
            }

            TakesScreenshot ts3=(TakesScreenshot)driver;
            File src_trvltxt =ts3.getScreenshotAs(OutputType.FILE);
            File dest_trvltxt= new File(projectPath+"\\Screenshots\\travelreq_text.jpg");
            FileUtils.copyFile(src_trvltxt,dest_trvltxt);
            System.out.println("travel request text screenshot is captured");

            WebElement element_EstDt = driver.findElement(PageLocators.textEstdt);
            String s5 = element_EstDt.getText();
            String s6 =Config_Data.textEstdt;
            if (s5.equalsIgnoreCase(s6)) {
                System.out.println("text is Matched as Estimated Date ");
            } else {
                System.out.println("Text is not matched");
            }

            TakesScreenshot ts4=(TakesScreenshot)driver;
            File src_Estdt =ts3.getScreenshotAs(OutputType.FILE);
            File dest_Estdt= new File(projectPath+"\\Screenshots\\Estdt_text.jpg");
            FileUtils.copyFile(src_Estdt,dest_Estdt);
            System.out.println("Estimated Date text screenshot is captured");

            WebElement element_Cash= driver.findElement(PageLocators.textCash);
            String s7 = element_Cash.getText();
            String s8 =Config_Data.textCashadv;
            if (s7.equalsIgnoreCase(s8)) {
                System.out.println("text is Matched as Cash in Advance ");
            } else {
                System.out.println("Text is not matched");
            }

            TakesScreenshot ts5=(TakesScreenshot)driver;
            File src_Cashadv =ts5.getScreenshotAs(OutputType.FILE);
            File dest_Cashadv= new File(projectPath+"\\Screenshots\\Cashadv_text.jpg");
            FileUtils.copyFile(src_Cashadv,dest_Cashadv);
            System.out.println("Estimated Date text screenshot is captured");

            //driver.quit();
            System.out.println("browser is closed");


        }
    }
}
