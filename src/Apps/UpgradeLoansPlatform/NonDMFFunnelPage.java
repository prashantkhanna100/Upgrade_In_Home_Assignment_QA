package UpgradeLoansPlatform;

import General.Helper;
import General.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * This class contains locators and wrapper methods for all the user actions that can be done on Non DMF Funnel Page -> https://www.credify.tech/funnel/nonDMFunnel
 */
public class NonDMFFunnelPage extends PageBase {
    // Variables
    private static WebDriver driver;

    // Locators for this Page
    private static By inputLoanAmount = By.xpath("//*[contains(text(),'Loan Amount')]/parent::*//input[contains(@name,'desiredAmount')]");
    private static By selectLoanPurpose = By.xpath("//select[ contains ( @name ,'loan-purpose' ) ]//option[text() != '']");
    private static By clickCheckYourRate = By.xpath("//button[contains( text(), 'Check your rate')]");

    // Constructor
    public NonDMFFunnelPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    // Actual Wrapper Methods which will be called by Domain Classes

    /**
     * Enters given Loan Amount in Loan Amount field
     * @param loanAmount
     */
    public void enterLoanAmount(double loanAmount){
        WebElement element = driver.findElement(inputLoanAmount);
        element.clear();
        element.sendKeys(String.valueOf(loanAmount));
    }


    /**
     * Select Any Purpose from the dropdown list in Dropdown Field - Loan Purpose
     */
    public void selectAnyLoanPurpose(){
        // Getting list of dropdown options
        List<WebElement> listOfPurpose = driver.findElements(selectLoanPurpose);
        // Number of purposes available in dropdown
        int size = listOfPurpose.size();
        // Generate a random number with in range
        int randNum = Helper.generateRandomNumber(size);
        // Selecting random value
        listOfPurpose.get(randNum).click();
    }


    /**
     * Click Check Your Rate Button
     */
    public void clickCheckYourRate(){
        WebElement element = driver.findElement(clickCheckYourRate);
        element.submit();
    }


}


