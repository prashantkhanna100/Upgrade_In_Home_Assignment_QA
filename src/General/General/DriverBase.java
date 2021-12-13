package General;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverBase {

    public static WebDriver getDriver(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver =  new ChromeDriver();
        return driver;
    }
}
