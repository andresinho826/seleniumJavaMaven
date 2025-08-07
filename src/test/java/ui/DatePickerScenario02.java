package ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class DatePickerScenario02 {
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

        // ●	Hacer clic en el campo de selección de fecha.
        WebElement inputCalendar = driver.findElement(By.id("datepicker"));
        inputCalendar.isDisplayed();
        inputCalendar.click();

        // ●	Navegar hasta el próximo mes.

        WebElement nextMontBtn = driver.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']"));
        nextMontBtn.isDisplayed();
        nextMontBtn.click();


        // ●	Seleccionar el día 10 del próximo mes.

        List<WebElement> currentDay = driver.findElements(By.xpath("//a[@class='ui-state-default']"));

        for (int i = 0; i < currentDay.size(); i++) {
            String day = currentDay.get(i).getText();
            if (day.equals("10")) {
                currentDay.get(i).click();

            }
        }



        // ●	Validar que la fecha seleccionada aparece en el campo de texto.
        String factual = inputCalendar.getText();
        String fEsperada = "09/10/2025";
        Boolean validation = factual.equals(fEsperada);
        System.out.println(validation);
        //Assert.assertTrue(validation, "NO coinciden o input regresa vacio");



        driver.quit();


    }

}
