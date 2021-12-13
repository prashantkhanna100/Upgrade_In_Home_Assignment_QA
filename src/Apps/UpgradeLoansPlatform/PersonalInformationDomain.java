package UpgradeLoansPlatform;

import General.DomainBase;
import org.openqa.selenium.WebDriver;

/**
 * This class contains clubbed methods which performs series of actions like - Enter Username, Password and click Sign In.
 * Most of the time, these three actions will be done together only, so i am adding a extra layer between Page Class and Test Class for Code Cleanliness in Test Class
 */
public class PersonalInformationDomain extends DomainBase {
    // Variables
    private WebDriver driver;
    // Page Classes -> Every domain can use one or more Page Classes
    private static PersonalInformationPage personalInformationPage;


    // Constructor
    public PersonalInformationDomain(WebDriver driver){
        this.driver = driver;
        personalInformationPage = new PersonalInformationPage(this.driver);
    }

    /**
     * This method with add the contact details on Personal Information Page 1
     */
    public void addContactDetails(String firstName, String lastName, String street, String city, String state, String zipCode, String dob, boolean clickContinue){
        personalInformationPage.enterFirstName(firstName);
        personalInformationPage.enterLastName(lastName);
        personalInformationPage.enterHomeAddress(street);
        personalInformationPage.clickJointAppMoreInfoIcon(); // just to take the control away from list of Automatically Searched Addresses
        personalInformationPage.enterCity(city);
        personalInformationPage.enterState(state);
        personalInformationPage.enterZipCode(zipCode);
        personalInformationPage.enterDob(dob);
        if (clickContinue)
            personalInformationPage.clickContinue();
    }

    /**
     * This method with add the Income details on Personal Information Page 1
     */
    public void addIncomeDetails(String annualIncome, String annualAdditionalIncome, boolean clickContinue){
        personalInformationPage.enterAnnualIncome(annualIncome);
        personalInformationPage.enterAdditionalAnnualIncome(annualAdditionalIncome);
        if (clickContinue)
            personalInformationPage.clickContinue();
    }

    /**
     * This method with add the Login details on Personal Information Page 1
     */
    public void addLoginDetails(String emailId, String password, boolean checkTerms, boolean clickCheckYourRate){
        personalInformationPage.enterEmailAddress(emailId);
        personalInformationPage.enterPassword(password);
        if(checkTerms)
            personalInformationPage.checkTermsOfConditions();
        if (clickCheckYourRate)
            personalInformationPage.clickCheckYourRate();
    }


}


