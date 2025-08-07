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

public class DatePickerScenario01 {
    public static String browser = "chrome";
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


        //●	Abrir la página principal de JQuery Datepicker.
        driver.get("https://jqueryui.com/datepicker/");
        driver.manage().window().maximize();

        // ●	Cambiar al iframe donde se encuentra el calendario.
        WebElement iframe = driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(iframe);

        // ●	Hacer clic en el campo de selección de fecha.
        WebElement inputCalendar = driver.findElement(By.id("datepicker"));
        inputCalendar.click();




        // ●	Seleccionar el día 15 del mes actual.

        LocalDate fechaActual = LocalDate.now();
        Month mesAc = fechaActual.getMonth();
        String mesActual = mesAc.toString().toLowerCase();


        List<WebElement> currentDay = driver.findElements(By.xpath("//a[@class='ui-state-default']"));
        List<WebElement> currentMonth = driver.findElements(By.xpath("//span[@class='ui-datepicker-month']"));

        String currentM = currentMonth.get(0).getText();

        if (mesActual.equals(currentM.toLowerCase())) {
            for (int i = 0; i < currentDay.size(); i++) {
                String day = currentDay.get(i).getText();
                if (day.equals("15")) {
                    currentDay.get(i).click();

                }
            }
        }


        // ●	Validar que la fecha seleccionada aparece en el campo de texto.
        String factual = inputCalendar.getText();
        String fEsperada = "08/15/2025";
        Boolean validation = factual.equals(fEsperada);
        System.out.println(validation);
        //Assert.assertTrue(validation, "NO coinciden o input regresa vacio");



        driver.quit();


    }

}
