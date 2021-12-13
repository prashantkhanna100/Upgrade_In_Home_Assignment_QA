package General;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


public class TestBase {

    private static final int WEB_DRIVER_WAIT_TIMEOUT_IN_SECONDS = 10;

    /**
     * Method to initiate the Web driver and return driver instance
     * @return
     */
    public static WebDriver getDriver(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver =  new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WEB_DRIVER_WAIT_TIMEOUT_IN_SECONDS));
        return driver;
    }

    /**
     * Method to return any data saved in Properties file
     * @param propertyName
     * @return
     */
    public static String getProperty(String propertyName) {
        final String propertyFilePath = "src/General/General/Framework.properties";
        Properties properties;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Framework.properties not found at " + propertyFilePath);
        }
        String url = properties.getProperty(propertyName);
        if (url != null)
            return url;
        else
            throw new RuntimeException("url not specified in the Configuration.properties file.");
    }
}