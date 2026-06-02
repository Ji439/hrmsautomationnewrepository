package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    By hrpn = By.xpath("//input[@placeholder='HRPN No']");
    By password = By.xpath("//input[@placeholder='Password']");
    By loginBtn = By.xpath("//button[contains(text(),'Login')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String hrpnNo, String pass) {

        driver.findElement(hrpn).sendKeys(hrpnNo);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }
}