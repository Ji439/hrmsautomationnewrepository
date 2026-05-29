package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    WebDriver driver;

    // Constructor
    public ForgotPasswordPage(WebDriver driver) {

        this.driver = driver;
    }

    // Locators
    By forgotPasswordLink =
    By.linkText("Forgot Password?");

    By emailField =
    By.xpath("//input[@type='text']");

    By getPasswordBtn =
    By.xpath("//button[contains(text(),'GET PASSWORD')]");

    By loginLink =
    By.linkText("Login");

    // Methods
    public void clickForgotPassword() {

        driver.findElement(forgotPasswordLink).click();
    }

    public void enterEmail(String email) {

        driver.findElement(emailField).sendKeys("test@123gmail.com");
    }

    public void clickGetPassword() {

        driver.findElement(getPasswordBtn).click();
    }

    public void clickLoginLink() {

        driver.findElement(loginLink).click();
    }
}