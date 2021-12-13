package General;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * This class contains common methods for all the child Page classes to avoid duplicates
 */
public class PageBase {

    // Variables
    private static WebDriver driver;
    private static final int WEB_ELEMENT_WAIT_TIMEOUT_IN_SECONDS = 30;

    public PageBase(WebDriver driver) {
        PageBase.driver = driver;
    }

    /**
     * This method can be used by any child Page class
     * @param by
     * @return WebElement
     */
    public static WebElement waitForElementToBeDisplayed(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WEB_ELEMENT_WAIT_TIMEOUT_IN_SECONDS));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return element;
    }

    /**
     * This method can be used by any child Page class
     * @param by
     * @return WebElement
     */
    public static WebElement waitForElementToBeClickable(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WEB_ELEMENT_WAIT_TIMEOUT_IN_SECONDS));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
        return element;
    }
}
