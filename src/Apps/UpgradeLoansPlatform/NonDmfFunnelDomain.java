package Apps.UpgradeLoansPlatform;

import General.General.DomainBase;
import org.openqa.selenium.WebDriver;

/**
 * This class contains clubbed methods which performs series of actions like - Enter Username, Password and click Sign In.
 * Most of the time, these three actions will be done together only, so i am adding a extra layer between Page Class and Test Class for Code Cleanliness in Test Class
 */
public class NonDmfFunnelDomain extends DomainBase {
    // Page Classes -> Every domain can use one or more Page Classes
    private static NonDMFFunnelPage nonDMFFunnelPage;
    // Variables
    private WebDriver driver;

    // Constructor
    public NonDmfFunnelDomain(WebDriver driver) {
        this.driver = driver;
        nonDMFFunnelPage = new NonDMFFunnelPage(this.driver);
    }

    /**
     * This method will Enter Given Amount, Any Purpose and check your rate on Non DMF Funnel Page
     *
     * @param amount
     */
    public void checkRate(double amount) {
        driver.get(getProperty("nonDmfFunnelPageUrl"));
        nonDMFFunnelPage.enterLoanAmount(amount);
        nonDMFFunnelPage.selectAnyLoanPurpose();
        nonDMFFunnelPage.clickCheckYourRate();
    }

}


