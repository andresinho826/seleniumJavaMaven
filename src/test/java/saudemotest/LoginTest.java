package saudemotest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class LoginTest {
    public static String browser = "edge"; // external configuration - XLS, CSV
    public static WebDriver driver;

    public static void main(String[] args) {

        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
        }


        driver.get("https://www.saucedemo.com/");
        //using relativeLocator in selenium (version 4 onwards)
        WebElement password = driver.findElement(By.id("password"));
        //WebElement emailField = (WebElement) RelativeLocator.with(By.tagName("input")).above(password);
        driver.findElement(RelativeLocator.with(By.tagName("input")).above(password)).sendKeys("andres test");
        password.sendKeys("paswoerd");


        /*driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("#login-button")).click();

         */
        //driver.close();

    }
}
