import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;

public class Login {

    @Test

    public void openBrowser(){
        WebDriver webDriver;

        String baseUrl = "https://www.saucedemo.com/";
        WebDriverManager.firefoxdriver().setup();

        webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
        webDriver.get(baseUrl);

//        Success Login
        webDriver.findElement(By.id("user-name")).sendKeys("standard_user");
        webDriver.findElement(By.id("password")).sendKeys("secret_sauce");
        webDriver.findElement(By.id("login-button")).click();

//        Add Product to Shopping cart
        webDriver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        webDriver.findElement(By.xpath("//input[@class= 'shopping_cart_container']")).click();

//        Logout
        webDriver.findElement(By.id("react-burger-menu-btn")).click();
        webDriver.findElement(By.id("logout_sidebar_link")).click();


//        Failed Login with empty input
        webDriver.findElement(By.id("login-button")).click();
    }
}
