package demorcv;

import org.openqa.selenium.chrome.ChromeDriver;

public class DemoAutomation {
    public static void main(String[] args) {

        //System.setProperty("webdriver.gecko.driver","src/test/java/utils/geckodriver.exe");
        //System.setProperty("webdriver.chrome.driver","src/test/java/utils/chromedriver.exe");
        //System.setProperty("webdriver.edge.driver","src/test/java/utils/msedgedriver.exe");

        ChromeDriver driver = new ChromeDriver();
        //FirefoxDriver  driver = new FirefoxDriver();
        //EdgeDriver driver = new EdgeDriver();

        driver.get("https://www.google.com/");

        driver.close();

    }
}
