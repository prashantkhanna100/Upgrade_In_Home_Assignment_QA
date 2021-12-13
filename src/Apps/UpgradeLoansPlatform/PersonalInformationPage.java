package UpgradeLoansPlatform;

import General.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This class contains locators and wrapper methods for all the user actions that can be done on Personal Information 1 Page -> https://www.credify.tech/funnel/personal-information-1/LARGE_PURCHASE/20000?step=contact
 */
public class PersonalInformationPage extends PageBase {
    // Variables
    private static WebDriver driver;

    // Locators for this Page - Step Contact
    private static By inputFirstName = By.xpath("//input[contains(@name, 'borrowerFirstName')]");
    private static By inputLastName = By.xpath("//input[contains(@name, 'borrowerLastName')]");
    private static By inputHomeAddress = By.xpath("//input[contains(@name, 'borrowerStreet')]");
    private static By inputCity = By.xpath("//input[contains(@name, 'borrowerCity')]");
    private static By inputState = By.xpath("//input[contains(@name, 'borrowerState')]");
    private static By inputZipCode = By.xpath("//input[contains(@name, 'borrowerZipCode')]");
    private static By inputDateOfBirth = By.xpath("//input[contains(@name, 'borrowerDateOfBirth')]");
    private static By iconJointAppMoreInfo = By.xpath("//*[contains(@data-auto,'jointAppMoreInfo')]");

    // Locators for this Page - Step Income
    private static By inputAnnualIncome = By.xpath("//input[contains(@name, 'borrowerIncome')]");
    private static By inputAdditionalAnnualIncome = By.xpath("//input[contains(@name, 'borrowerAdditionalIncome')]");

    // Locators for this Page - Step Login
    private static By inputEmailAddress = By.xpath("//input[contains(@name, 'username')]");
    private static By inputPassword = By.xpath("//input[contains(@name, 'password')]");
    private static By checkTermsOfUse = By.xpath("//input[@name='agreements' and @type='checkbox']/following-sibling::div[1]");
    private static By clickCheckYourRate = By.xpath(" //button[contains( @data-auto, 'submitPersonalInfo') ] ");

    // Locators for this Page - Common
    private static By clickContinue = By.xpath("//button[contains( text(), 'Continue') ] ");

    // Constructor
    public PersonalInformationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    // Actual Wrapper Methods which will be called by Domain Classes

    /**
     * Click Joint Application More Info Icon
     */
    public void clickJointAppMoreInfoIcon() {
        WebElement element = waitForElementToBeClickable(iconJointAppMoreInfo);
        element.click();
    }


    /**
     * Enters First Name in First Name field
     *
     * @param firstName
     */
    public void enterFirstName(String firstName) {
        WebElement element = driver.findElement(inputFirstName);
        element.clear();
        element.sendKeys(firstName);
    }


    /**
     * Enters Last Name in Last Name field
     *
     * @param lastName
     */
    public void enterLastName(String lastName) {
        WebElement element = driver.findElement(inputLastName);
        element.clear();
        element.sendKeys(lastName);
    }


    /**
     * Enters Home Address  in Home Address field
     *
     * @param street
     */
    public void enterHomeAddress(String street) {
        WebElement element = driver.findElement(inputHomeAddress);
        element.clear();
        element.sendKeys(street);
    }


    /**
     * Enters City Name in City field
     *
     * @param city
     */
    public void enterCity(String city) {
        WebElement element = driver.findElement(inputCity);
        element.clear();
        element.sendKeys(city);
    }


    /**
     * Enters State Name in State field
     *
     * @param state
     */
    public void enterState(String state) {
        WebElement element = driver.findElement(inputState);
        element.clear();
        element.sendKeys(state);
    }


    /**
     * Enters Zip Code in Zip Code field
     *
     * @param zipCode
     */
    public void enterZipCode(String zipCode) {
        WebElement element = driver.findElement(inputZipCode);
        element.clear();
        element.sendKeys(zipCode);
    }


    /**
     * Enters DOB (MM/DD/YYYY) in Date Of Birth field
     *
     * @param dob
     */
    public void enterDob(String dob) {
        WebElement element = driver.findElement(inputDateOfBirth);
        element.clear();
        element.sendKeys(dob);
    }


    /**
     * Click Continue Button
     */
    public void clickContinue() {
        WebElement element = driver.findElement(clickContinue);
        element.submit();
    }


    /**
     * Enters Annual Income on Step -Income -> Annual Income Field
     *
     * @param annualIncome
     */
    public void enterAnnualIncome(String annualIncome) {
        WebElement element = driver.findElement(inputAnnualIncome);
        element.clear();
        element.sendKeys(annualIncome);
    }


    /**
     * Enters Additional Annual Income on Step -Income -> Additional Annual Income Field
     *
     * @param additionalAnnualIncome
     */
    public void enterAdditionalAnnualIncome(String additionalAnnualIncome) {
        WebElement element = driver.findElement(inputAdditionalAnnualIncome);
        element.clear();
        element.sendKeys(additionalAnnualIncome);
    }


    /**
     * Enters Email Address in Email Address Field
     *
     * @param emailId
     */
    public void enterEmailAddress(String emailId) {
        WebElement element = driver.findElement(inputEmailAddress);
        element.clear();
        element.sendKeys(emailId);
    }

    /**
     * Enters DOB (MM/DD/YYYY) in Date Of Birth field
     *
     * @param password
     */
    public void enterPassword(String password) {
        WebElement element = driver.findElement(inputPassword);
        element.clear();
        element.sendKeys(password);
    }


    /**
     * Check Terms Of Use Checkbox
     */
    public void checkTermsOfConditions() {
        WebElement element = driver.findElement(checkTermsOfUse);
        if (!element.isSelected()) {
            element.click();
        }
    }

    /**
     * Click Check Your Rate Button
     */
    public void clickCheckYourRate() {
        WebElement element = driver.findElement(clickCheckYourRate);
        element.submit();
    }


}


