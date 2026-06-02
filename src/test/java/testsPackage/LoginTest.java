package testsPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest {

    @DataProvider(name = "loginData")
    public Object[][] getData() {

        return new Object[][] {
            {"20053998", "abc123"},
            {"20054605", "abc123"},
            {"20013011", "abc123"},
        //    {"20048845", "abc123"},
         //   {"20012568", "abc123"},
         //   {"20053999", "abc123"},
         //   {"20010702", "abc123"},
         ///   {"20054604", "abc123"},
          //  {"20101051", "abc123"},
          //  {"20010530", "abc123"},

        };
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username,
                          String password) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://staginghrmsuat-gil.gujarat.gov.in/");

        driver.findElement(By.id("HRPN"))
              .sendKeys(username);

        driver.findElement(By.id("Password"))
              .sendKeys(password);

        driver.findElement(By.xpath("//button[normalize-space()='Login']"))
              .click();

        System.out.println(
            "Login with: " + username);

        driver.quit();
    }
}

