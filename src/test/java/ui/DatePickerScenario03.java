package ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class DatePickerScenario03 {
    public static String browser = "chrome";
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


        //●	Abrir la página principal de JQuery Datepicker.
        driver.get("https://jqueryui.com/datepicker/");
        driver.manage().window().maximize();

        // ●	Cambiar al iframe donde se encuentra el calendario.
        WebElement iframe = driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(iframe);

        // ● Intentar ingresar una fecha manualmente en el campo de texto.
        WebElement inputCalendar = driver.findElement(By.id("datepicker"));
        inputCalendar.sendKeys("08/10/2025");
        inputCalendar.sendKeys(Keys.ENTER);
        Thread.sleep(1000);


        //●	Validar que no se permite la edición manual y que solo es posible seleccionar una fecha desde el calendario.

        inputCalendar.sendKeys("08/20/2025");
        Thread.sleep(10000);


        driver.quit();


    }

}
