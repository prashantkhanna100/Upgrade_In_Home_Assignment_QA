package Java;

import General.*;
import UpgradeLoansPlatform.NonDMFFunnelPage;
import UpgradeLoansPlatform.PersonalInformation1Page;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * This is the UI test cases Class which contains UI Test Cases (1 method for each test case)
 */
public class UITests extends DriverBase {
    private WebDriver driver;
    private NonDMFFunnelPage nonDmfFunnel;
    private PersonalInformation1Page personalInformation1Page;

    @BeforeTest
    public void setUp() {
        driver = getDriver();
        nonDmfFunnel = new NonDMFFunnelPage(driver);
        personalInformation1Page = new PersonalInformation1Page(driver);
    }

    @Test
    public void test_1_loanBorrower(){
        // Step1: Navigate to https://www.credify.tech/phone/nonDMFunnel
        driver.get("https://www.credify.tech/phone/nonDMFunnel");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Step2: On this page: Enter loan amount as 2,000 and select any purpose. Click "Check your Rate"
        nonDmfFunnel.enterLoanAmount(2000.0);
        nonDmfFunnel.selectAnyLoanPurpose();
        nonDmfFunnel.clickCheckYourRate();

        // Step3: In the "Personal Information 1 Page - Step -Contact, enter First name, Last Name, Address, DOB and Click Continue
        personalInformation1Page.enterFirstName("Test");
        personalInformation1Page.enterLastName("Singh");
        personalInformation1Page.enterHomeAddress("10219 Southeast 270th Street");
        personalInformation1Page.clickJointAppMoreInfoIcon(); // just to take the control away from list of Automatically Searched Addresses
        personalInformation1Page.enterCity("Kent");
        personalInformation1Page.enterState("WA");
        personalInformation1Page.enterZipCode("98030");
        personalInformation1Page.enterDob("01/10/1988");
        personalInformation1Page.clickContinue();


        // Step4: In the "Personal Information 1 Page - Step - Income, enter Annual Income, Additional Income and Click Continue
        personalInformation1Page.enterAnnualIncome("130000");
        personalInformation1Page.enterAdditionalAnnualIncome("50000");
        personalInformation1Page.clickContinue();

        // Step5: In the "Personal Information 1 Page - Step - Login, Enter Email, Password, Check Terms and Click Check Your Rate
        // Generate Random Number
        int randomNumber = Helper.generateRandomNumber(10000);
        String emailId = "candidate+" + randomNumber + "@upgrade-challenge.com";
        String password = "Test1234";
        personalInformation1Page.enterEmailAddress(emailId);
        personalInformation1Page.enterPassword(password);
        personalInformation1Page.checkTermsOfConditions();
        personalInformation1Page.clickCheckYourRate();

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
