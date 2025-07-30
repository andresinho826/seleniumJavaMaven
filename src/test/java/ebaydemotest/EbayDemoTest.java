package ebaydemotest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EbayDemoTest {
    public static void main(String[] args) {
        //WebDriver driver;

        //System.setProperty("webdriver.gecko.driver","src/test/java/utils/geckodriver.exe");
        //System.setProperty("webdriver.chrome.driver","src/test/java/utils/chromedriver.exe");
        //System.setProperty("webdriver.edge.driver","src/test/java/utils/msedgedriver.exe");
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        //FirefoxDriver  driver = new FirefoxDriver();
        //EdgeDriver driver = new EdgeDriver();

        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("#gh-ac")).sendKeys("mobile");
        driver.findElement(By.cssSelector("#gh-search-btn")).click();

        driver.close();

    }
}
