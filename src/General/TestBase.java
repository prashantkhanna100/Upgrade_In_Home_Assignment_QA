package General;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;


/**
 * This class contains common methods for all Test classes like initiating a driver etc
 */
public class TestBase extends SuperBase {

    private static final int WEB_DRIVER_WAIT_TIMEOUT_IN_SECONDS = 10;
    public static WebDriver driver;

    /**
     * Method to initiate the Web driver and return driver instance
     *
     * @return
     */
    public static WebDriver getDriver() {
        if (getProperty("BROWSER").equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            if (getProperty("HEADLESS").equalsIgnoreCase("true"))
            {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                driver = new ChromeDriver(chromeOptions);
            }else {
                driver = new ChromeDriver();
            }
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WEB_DRIVER_WAIT_TIMEOUT_IN_SECONDS));
        return driver;
    }
}