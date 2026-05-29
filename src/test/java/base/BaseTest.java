package base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
	

    public WebDriver driver;

    @BeforeMethod
    @Parameters("browser")

    public void setup(String browser) {

        if(browser.equalsIgnoreCase("chrome")) {

            driver = new ChromeDriver();
        }

        else if(browser.equalsIgnoreCase("firefox")) {

            driver = new FirefoxDriver();
        }

        else if(browser.equalsIgnoreCase("edge")) {

            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();

        driver.get("https://staginghrmsuat-gil.gujarat.gov.in/");
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }

}
