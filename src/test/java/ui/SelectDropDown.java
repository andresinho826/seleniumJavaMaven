package ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDown {
    public static String browser = "chrome"; // external configuration - XLS, CSV
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

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


        driver.get("https://www.sugarcrm.com/es/request-demo/?utm_medium=referral&utm_source=sugarcrm.com");
        driver.manage().window().maximize();
        WebElement ddown = driver.findElement(By.name("input_8"));
        Select select = new Select(ddown);

        select.selectByValue("level1");
        Thread.sleep(2000);

        select.selectByVisibleText("251 - 500 employees");

        select.selectByIndex(9);
        Thread.sleep(2000);

        driver.quit();



    }
}
