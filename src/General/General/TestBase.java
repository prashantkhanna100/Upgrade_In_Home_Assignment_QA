package General;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


/**
 * This class contains common methods for all Test classes like initiating a driver etc
 */
public class TestBase extends SuperBase {

    private static final int WEB_DRIVER_WAIT_TIMEOUT_IN_SECONDS = 10;

    /**
     * Method to initiate the Web driver and return driver instance
     *
     * @return
     */
    public static WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WEB_DRIVER_WAIT_TIMEOUT_IN_SECONDS));
        return driver;
    }
}