package testsPackage;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTestCross {

    WebDriver driver;
    ChromeOptions chromeoptions = new ChromeOptions ();
    FirefoxOptions firefoxoptions = new FirefoxOptions ();
    EdgeOptions Edgeoptions = new EdgeOptions ();

    @Parameters("browser")
    @BeforeMethod
    public void initialize(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {
        //	System.out.println("Chrome is launched");
        	WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            System.out.println("Chrome is launched");
         
        } 
        else if (browser.equalsIgnoreCase("firefox")) {
        	WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            System.out.println("Firefox is launched");

        } 
        else if (browser.equalsIgnoreCase("edge")) {
        	WebDriverManager.edgedriver().setup();

            driver = new EdgeDriver();
            System.out.println("Edge is launched");

        }

        
    }

    @Test
    public void verifyLogin() {
    	driver.manage().window().maximize();
        driver.get("https://staginghrmsuat-gil.gujarat.gov.in/");

        driver.findElement(By.name("HRPN"))
              .sendKeys("30100000");

        driver.findElement(By.name("Password"))
              .sendKeys("abc123");

      //  driver.findElement(By.xpath("//button[@type='submit']"))
         //     .click();
        driver.findElement(By.xpath("//button[normalize-space()='Login']"));

        String actualTitle = driver.getTitle();
        System.out.println("Page Title: " + actualTitle);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}