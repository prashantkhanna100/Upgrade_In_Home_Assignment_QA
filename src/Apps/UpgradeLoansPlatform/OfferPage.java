package Apps.UpgradeLoansPlatform;

import General.General.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This class contains locators and wrapper methods for all the user actions that can be done on Offer Page -> https://www.credify.tech/funnel/offer-page
 */
public class OfferPage extends PageBase {
    // Variables
    private static WebDriver driver;

    // Locators for this Page
    private static By textLoanAmount = By.xpath("//*[@data-auto='userLoanAmount']");
    private static By textFasterPayoffDefaultMonthlyPayment = By.xpath("//*[contains(text(),'Faster Payoff')]/parent::div/parent::div/parent::div/following-sibling::*//*[@data-auto='defaultMonthlyPayment']");
    private static By textFasterPayoffDefaultTerm = By.xpath("//*[contains(text(),'Faster Payoff')]/parent::div/parent::div/parent::div/following-sibling::*//*[@data-auto='defaultLoanTerm']//div");
    private static By textFasterPayoffDefaultInterestRate = By.xpath("//*[contains(text(),'Faster Payoff')]/parent::div/parent::div/parent::div/following-sibling::*//*[@data-auto='defaultLoanInterestRate']//div");
    private static By textFasterPayoffDefaultAPR = By.xpath("//*[contains(text(),'Faster Payoff')]/parent::div/parent::div/parent::div/following-sibling::*//*[@data-auto='defaultAPR']");
    private static By clickMenu = By.xpath("//*[@aria-label='Open Site Menu']");
    private static By clickSignOut = By.xpath("//*[contains(text(),'Sign Out')]");

    // Constructor
    public OfferPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    // Actual Wrapper Methods which will be called by Domain Classes

    /**
     * Returns the Loan Amount Displayed on the Page
     */
    public String getLoanAmount() {
        WebElement element = waitForElementToBeDisplayed(textLoanAmount); // This element was taking more time to load, that's why added explicit wait on this method only
        return element.getText();
    }

    /**
     * Returns the Faster Payoff Default Monthly Payment Displayed on the Page
     */
    public String getFasterPayoffDefaultMonthlyPayment() {
        WebElement element = driver.findElement(textFasterPayoffDefaultMonthlyPayment);
        return element.getText();
    }

    /**
     * Returns the Faster Payoff Default Term Displayed on the Page
     */
    public String getFasterPayoffDefaultTerm() {
        WebElement element = driver.findElement(textFasterPayoffDefaultTerm);
        return element.getText();
    }

    /**
     * Returns the Faster Payoff Default Interest Rate Displayed on the Page
     */
    public String getFasterPayoffDefaultInterestRate() {
        WebElement element = driver.findElement(textFasterPayoffDefaultInterestRate);
        return element.getText();
    }

    /**
     * Returns the Faster Payoff Default APR Displayed on the Page
     */
    public String getFasterPayoffDefaultAPR() {
        WebElement element = driver.findElement(textFasterPayoffDefaultAPR);
        return element.getText();
    }

    /**
     * Click Menu Option Button on top right corner of the page
     */
    public void clickMenu() {
        WebElement element = driver.findElement(clickMenu);
        JavascriptExecutor js = (JavascriptExecutor) driver; // To scroll up on the page
        js.executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    /**
     * Click Sign Out Under Menu Option Button on top right corner of the page
     */
    public void clickSignOut() {
        WebElement element = driver.findElement(clickSignOut);
        element.click();
    }


}


