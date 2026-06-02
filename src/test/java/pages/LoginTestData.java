package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginTestData {

    WebDriver driver;

    public LoginTestData(WebDriver driver) {
        this.driver = driver;
    }

    By hrpn = By.id("hrpn");
    By password = By.id("password");
    By loginBtn = By.id("loginBtn");

    public void login(String user,
                      String pass) {

        driver.findElement(hrpn)
              .sendKeys(user);

        driver.findElement(password)
              .sendKeys(pass);

        driver.findElement(loginBtn)
              .click();
    }
}