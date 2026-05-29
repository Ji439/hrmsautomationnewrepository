package testsPackage;

import java.time.Duration;

// ===============================
// Selenium Imports
// ===============================
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// ===============================
// TestNG Imports
// ===============================
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;

// ===============================
// Class Creation  --> OOPS Concept
// ===============================
public class LoginTestCases {

    // ===============================
    // WebDriver Interface
    // Java Concept Used:
    // Interface + Object
    // ===============================
    WebDriver driver;

    // ===============================
    // BeforeMethod
    // Runs before every test case
    // ===============================
    @BeforeMethod
    
    public void setup() {

        // Object Creation
        // Java Concept:
        // Object + Constructor

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://staginghrmsuat-gil.gujarat.gov.in/");
    }

    // ==================================================
    // Reusable Login Method
    // Java Concept Used:
    // Method + Parameters + Reusability
    // ==================================================
    public void login(String username, String password) {

        // Username Field
        driver.findElement(By.xpath("//input[@placeholder='HRPN No']"))
              .clear();

        driver.findElement(By.xpath("//input[@placeholder='HRPN No']"))
              .sendKeys(username);

        // Password Field
        driver.findElement(By.xpath("//input[@placeholder='Password']"))
              .clear();

        driver.findElement(By.xpath("//input[@placeholder='Password']"))
              .sendKeys(password);

        // Click Login Button
        driver.findElement(By.xpath("//button[contains(text(),'Login')]"))
              .click();
    }

    // ==================================================
    // Test Case 1 : Valid Login
    // ==================================================
    @Test(groups = {"smoke"})   //(priority = 1)
    public void validLogin() throws InterruptedException {

        // Method Calling
        login("20051337", "abc123");

        Thread.sleep(5000);

        // Assertion
        // Java Concept:
        // Condition Checking

        // Step 2: Wait for dashboard element (replace locator properly)
    //    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

     //   WebElement positionElement = wait.until(
            //    ExpectedConditions.visibilityOfElementLocated(
                 //       By.xpath("//*[contains(text(),'Position')]")
              //  )
       // );

        Assert.assertTrue(
                driver.getPageSource().contains("Position"),
                "Valid Login Failed"
        );

        System.out.println("Test Case 1 Passed");
    }

    // ==================================================
    // Test Case 2 : Invalid Password
    // ==================================================
    @Test(priority = 2)
    public void invalidPassword() throws InterruptedException {

        login("20051337", "abc1234");

        Thread.sleep(3000);

        // String Concept
        String error = driver.getPageSource();

        Assert.assertTrue(
                error.contains("Please Check your UserName and Password")
        );

        System.out.println("Test Case 2 Passed");
    }

    // ==================================================
    // Test Case 3 : Invalid Username
    // ==================================================
    @Test(priority = 3)
    public void invalidUsername() throws InterruptedException {

        login("2005133", "abc123");

        Thread.sleep(3000);

        String error = driver.getPageSource();

        Assert.assertTrue(
                error.contains("Please Check your UserName and Password")
        );

        System.out.println("Test Case 3 Passed");
    }

    // ==================================================
    // Test Case 4 : Empty Fields
    // ==================================================
    @Test(priority = 4)
    public void emptyFields() throws InterruptedException {

        login("", "");

        Thread.sleep(3000);

        String error = driver.getPageSource();

        // Java Concept:
        // OR Condition

        Assert.assertTrue(
                error.contains("required")
                        || error.contains("Invalid")
        );

        System.out.println("Test Case 4 Passed");
    }

    // ==================================================
    // Test Case 5 : Only Username
    // ==================================================
    @Test(groups = {"regression"})//(priority = 5)
    public void onlyUsername() throws InterruptedException {

        login("20051337", "");

        Thread.sleep(3000);

        String error = driver.getPageSource();

        Assert.assertTrue(
                error.contains("Enter password!")
        );

        System.out.println("Test Case 5 Passed");
    }

    // ==================================================
    // Test Case 6 : Only Password
    // ==================================================
    @Test(groups = {"regression"})//(priority = 6)
    public void onlyPassword() throws InterruptedException {

        login("", "abc123");

        Thread.sleep(3000);

        String error = driver.getPageSource();

        Assert.assertTrue(
                error.contains("Enter HRPN no.!")
        );

        System.out.println("Test Case 6 Passed");
    }

    // ==================================================
    // Test Case 7 : Invalid Username & Password
    // ==================================================
    @Test(priority = 7)
    public void invalidUsernameAndPassword()
            throws InterruptedException {

        login("2005133", "abc12");

        Thread.sleep(3000);

        String error = driver.getPageSource();

        Assert.assertTrue(
                error.contains("Please Check your UserName and Password")
        );

        System.out.println("Test Case 7 Passed");
    }

    // ==================================================
    // Test Case 8 : Invalid Password Only
    // ==================================================
    @Test(priority = 8)
    public void invalidPasswordOnly()
            throws InterruptedException {

        login("20051337", "abc12");

        Thread.sleep(3000);

        String error = driver.getPageSource();

        Assert.assertTrue(
                error.contains("Please Check your UserName and Password")
        );

        System.out.println("Test Case 8 Passed");
    }

    // ===============================
    // AfterMethod
    // Runs after every test case
    // ===============================
    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}
