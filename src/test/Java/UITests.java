package Test.Java;

import Apps.UpgradeLoansPlatform.LoginDomain;
import Apps.UpgradeLoansPlatform.NonDmfFunnelDomain;
import Apps.UpgradeLoansPlatform.OfferDomain;
import Apps.UpgradeLoansPlatform.PersonalInformationDomain;
import General.General.Helper;
import General.General.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * This is the UI test cases Class which contains UI Test Cases (1 method for each test case)
 */
public class UITests extends TestBase {
    private WebDriver driver;
    private NonDmfFunnelDomain nonDmfFunnelDomain;
    private LoginDomain loginDomain;
    private PersonalInformationDomain personalInformationDomain;
    private OfferDomain offerDomain;


    @BeforeTest
    public void setUp() {
        driver = getDriver();
        nonDmfFunnelDomain = new NonDmfFunnelDomain(driver);
        personalInformationDomain = new PersonalInformationDomain(driver);
        offerDomain = new OfferDomain(driver);
        loginDomain = new LoginDomain(driver);
    }

    @Test
    // Test Description: Verify via the UI that as a loan borrower - you are seeing loan offers, upon filling the required form fields with valid inputs
    public void test_1_loanBorrower() {

        // Step1 and 2: Navigate to nonDmfFunnelPage and Enter loan amount as 2000, select any purpose. Click "Check your Rate"
        nonDmfFunnelDomain.checkRate(2000.0);

        // Step3: On the "Personal Information 1 Page - Step -Contact, enter First name, Last Name, Address, DOB and Click Continue
        personalInformationDomain.addContactDetails("Test", "Singh", "10219 Southeast 270th Street", "Kent", "WA", "98030", "01/01/1988", true);

        // Step4: On the "Personal Information 1 Page - Step - Income, enter Annual Income, Additional Income and Click Continue
        personalInformationDomain.addIncomeDetails("130000", "50000", true);

        // Step5: On the "Personal Information 1 Page - Step - Login, Enter Email, Password, Check Terms and Click Check Your Rate
        // Generate Random Number
        int randomNumber = Helper.generateRandomNumber(10000);
        String emailId = "candidate+" + randomNumber + "@upgrade-challenge.com";
        String password = "Test1234";
        personalInformationDomain.addLoginDetails(emailId, password, true, true);

        //Step6: On the "Offer Page - Store the Loan Amount, Monthly Payment, Term, Interest Rate and APR from the default offer and then Sign Out
        HashMap<String, String> expectedResultsData = offerDomain.getFasterPayoffDefaultOfferDetails();
        offerDomain.signOut();

        //Step 7: Navigate to Login Page and Sign in
        loginDomain.login(emailId, password);

        //Step 8: Make sure if you are on Offer Page and Validate that Loan Amount, APR, Loan Term and Monthly Payment matches with the info submitted previously
        HashMap<String, String> actualResultsData = offerDomain.getFasterPayoffDefaultOfferDetails();
        String currentUrl = driver.getCurrentUrl();

        //Final Assertions
        Assert.assertEquals(currentUrl, getProperty("offerPageUrl"));
        Assert.assertEquals(expectedResultsData, actualResultsData);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
