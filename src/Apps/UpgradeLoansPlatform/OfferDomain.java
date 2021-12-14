package Apps.UpgradeLoansPlatform;

import General.DomainBase;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

/**
 * This class contains clubbed methods which performs series of actions like - Enter Username, Password and click Sign In.
 * Most of the time, these three actions will be done together only, so i am adding a extra layer between Page Class and Test Class for Code Cleanliness in Test Class
 */
public class OfferDomain extends DomainBase {
    // Page Classes -> Every domain can use one or more Page Classes
    private static OfferPage offerPage;
    // Variables
    private WebDriver driver;


    // Constructor
    public OfferDomain(WebDriver driver) {
        this.driver = driver;
        offerPage = new OfferPage(this.driver);
    }

    /**
     * This method with fetch the Faster Payoff Default Offer Details data from UI screen and  return a HashMap
     *
     * @return fasterPayoffDefaultOfferDetails
     */
    public HashMap<String, String> getFasterPayoffDefaultOfferDetails() {
        HashMap<String, String> fasterPayoffDefaultOfferDetails = new HashMap<String, String>();
        fasterPayoffDefaultOfferDetails.put("Loan Amount", offerPage.getLoanAmount());
        fasterPayoffDefaultOfferDetails.put("Faster Payoff Default Monthly Payment", offerPage.getFasterPayoffDefaultMonthlyPayment());
        fasterPayoffDefaultOfferDetails.put("Faster Payoff Default Term", offerPage.getFasterPayoffDefaultTerm());
        fasterPayoffDefaultOfferDetails.put("Faster Payoff Default Interest Rate", offerPage.getFasterPayoffDefaultInterestRate());
        fasterPayoffDefaultOfferDetails.put("Faster Payoff Default APR", offerPage.getFasterPayoffDefaultAPR());
        return fasterPayoffDefaultOfferDetails;
    }

    /**
     * This method will Sign Out from the Offer Page
     */
    public void signOut() {
        offerPage.clickMenu();
        offerPage.clickSignOut();
    }

}


