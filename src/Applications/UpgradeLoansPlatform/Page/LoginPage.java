package Applications.UpgradeLoansPlatform.Page;

import General.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This class contains locators and wrapper methods for all the user actions that can be done on Login Page -> https://www.credify.tech/portal/login
 */
public class LoginPage extends PageBase {
    // Variables
    private static WebDriver driver;

    // Locators for this Page
    private static By inputEmailAddress = By.xpath("//input[@name='username']");
    private static By inputPassword = By.xpath("//input[@name='password']");
    private static By clickSignIn = By.xpath("//button[contains( text(), 'Sign in to your account') ]");

    // Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    // Actual Wrapper Methods which will be called by Domain Classes

    /**
     * Enters email ID in the Email Address Field on the Page
     */
    public void enterEmailAddress(String emailId) {
        WebElement element = driver.findElement(inputEmailAddress);
        element.clear();
        element.sendKeys(emailId);
    }

    /**
     * Enters password in the Password Field on the Page
     */
    public void enterPassword(String password) {
        WebElement element = driver.findElement(inputPassword);
        element.clear();
        element.sendKeys(password);
    }

    /**
     * Click Sign In Button
     */
    public void clickSignIn() {
        WebElement element = driver.findElement(clickSignIn);
        element.click();
    }

}


