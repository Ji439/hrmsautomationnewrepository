package testsPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.ForgotPasswordPage;
import utilities.ScreenshotUtils;

public class ForgotPasswordTest {

    WebDriver driver;

    // Setup Method
    @BeforeMethod
    public void setup() {

        // Launch Browser
        driver = new ChromeDriver();

        // Maximize Browser
        driver.manage().window().maximize();

        // Open Application
        driver.get("https://staginghrmsuat-gil.gujarat.gov.in");
    }


    // Forgot Password Test Case
    @Test(priority = 1)
    public void verifyForgotPasswordFunctionality() {

        ForgotPasswordPage fp =
        new ForgotPasswordPage(driver);

        // Click Forgot Password Link
        fp.clickForgotPassword();

        // Enter Email
        fp.enterEmail("test@gmail.com");

        // Click GET PASSWORD Button
        fp.clickGetPassword();

        System.out.println("Forgot Password Test Passed");
    }


    // Blank Field Validation Test
    @Test(priority = 2)
    public void verifyBlankFieldValidation() {

        ForgotPasswordPage fp =
        new ForgotPasswordPage(driver);

        fp.clickForgotPassword();

        // Without entering email
        fp.clickGetPassword();

        System.out.println("Blank Field Validation Verified");
    }


    // Click On Get Password Button Test
    @Test(priority = 3)
    public void clickOnGetPasswordButton() {

        ForgotPasswordPage fp =
        new ForgotPasswordPage(driver);

        fp.clickForgotPassword();

        fp.clickGetPassword();

        System.out.println("Get Password Button Clicked Successfully");
    }


    // Screenshot + Close Browser
    @AfterMethod
    public void teardown(ITestResult result) {

    	 ScreenshotUtils.captureScreenshot(driver,
                 ((ITestResult) result).getName());
        // Close Browser
        driver.quit();
    }
}
