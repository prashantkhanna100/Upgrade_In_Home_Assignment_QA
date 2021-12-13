package Java;

import General.*;
import UpgradeLoansPlatform.LoginPage;
import UpgradeLoansPlatform.NonDMFFunnelPage;
import UpgradeLoansPlatform.OfferPage;
import UpgradeLoansPlatform.PersonalInformation1Page;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.time.Duration;
import java.util.HashMap;

/**
 * This is the UI test cases Class which contains UI Test Cases (1 method for each test case)
 */
public class UITests extends TestBase {
    private WebDriver driver;
    private NonDMFFunnelPage nonDmfFunnel;
    private PersonalInformation1Page personalInformation1Page;
    private OfferPage offerPage;
    private LoginPage loginPage;

    @BeforeTest
    public void setUp() {
        driver = getDriver();
        nonDmfFunnel = new NonDMFFunnelPage(driver);
        personalInformation1Page = new PersonalInformation1Page(driver);
        offerPage = new OfferPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void test_1_loanBorrower(){
        // Step1: Navigate to https://www.credify.tech/phone/nonDMFunnel
        driver.get( getProperty("nonDmfFunnelPageUrl") );
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Step2: On this page: Enter loan amount as 2,000 and select any purpose. Click "Check your Rate"
        nonDmfFunnel.enterLoanAmount(2000.0);
        nonDmfFunnel.selectAnyLoanPurpose();
        nonDmfFunnel.clickCheckYourRate();

        // Step3: On the "Personal Information 1 Page - Step -Contact, enter First name, Last Name, Address, DOB and Click Continue
        personalInformation1Page.enterFirstName("Test");
        personalInformation1Page.enterLastName("Singh");
        personalInformation1Page.enterHomeAddress("10219 Southeast 270th Street");
        personalInformation1Page.clickJointAppMoreInfoIcon(); // just to take the control away from list of Automatically Searched Addresses
        personalInformation1Page.enterCity("Kent");
        personalInformation1Page.enterState("WA");
        personalInformation1Page.enterZipCode("98030");
        personalInformation1Page.enterDob("01/10/1988");
        personalInformation1Page.clickContinue();


        // Step4: On the "Personal Information 1 Page - Step - Income, enter Annual Income, Additional Income and Click Continue
        personalInformation1Page.enterAnnualIncome("130000");
        personalInformation1Page.enterAdditionalAnnualIncome("50000");
        personalInformation1Page.clickContinue();

        // Step5: On the "Personal Information 1 Page - Step - Login, Enter Email, Password, Check Terms and Click Check Your Rate
        // Generate Random Number
        int randomNumber = Helper.generateRandomNumber(10000);
        String emailId = "candidate+" + randomNumber + "@upgrade-challenge.com";
        String password = "Test1234";
        personalInformation1Page.enterEmailAddress(emailId);
        personalInformation1Page.enterPassword(password);
        personalInformation1Page.checkTermsOfConditions();
        personalInformation1Page.clickCheckYourRate();


        //Step6: On the "Offer Page - Store the Loan Amount, Monthly Payment, Term, Interest Rate and APR from the default offer and then Sign Out
        HashMap<String, String> expectedResultsData = new HashMap<>();
        expectedResultsData.put("Loan Amount", offerPage.getLoanAmount());
        expectedResultsData.put("First Payoff Default Monthly Payment", offerPage.getFasterPayoffDefaultMonthlyPayment());
        expectedResultsData.put("First Payoff Default Term", offerPage.getFasterPayoffDefaultTerm());
        expectedResultsData.put("First Payoff Default Interest Rate", offerPage.getFasterPayoffDefaultInterestRate());
        expectedResultsData.put("First Payoff Default APR", offerPage.getFasterPayoffDefaultAPR());
        offerPage.clickMenu();
        offerPage.clickSignOut();

        //Step 7: Navigate to Login Page and Sign in
        driver.get(getProperty("loginPageUrl"));
        loginPage.enterEmailAddress(emailId);
        loginPage.enterPassword(password);
        loginPage.clickSignIn();

        //Step 8: Make sure if you are on Offer Page and Validate that Loan Amount, APR, Loan Term and Monthly Payment matches with the info submitted previously

        HashMap<String, String> actualResultsData = new HashMap<>();
        actualResultsData.put("Loan Amount", offerPage.getLoanAmount());
        actualResultsData.put("First Payoff Default Monthly Payment", offerPage.getFasterPayoffDefaultMonthlyPayment());
        actualResultsData.put("First Payoff Default Term", offerPage.getFasterPayoffDefaultTerm());
        actualResultsData.put("First Payoff Default Interest Rate", offerPage.getFasterPayoffDefaultInterestRate());
        actualResultsData.put("First Payoff Default APR", offerPage.getFasterPayoffDefaultAPR());

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, getProperty("offerPageUrl"));
        Assert.assertEquals(expectedResultsData, actualResultsData);

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
