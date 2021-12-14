package Applications.UpgradeLoansPlatform.Domains;

import Applications.UpgradeLoansPlatform.Page.LoginPage;
import General.DomainBase;
import org.openqa.selenium.WebDriver;

/**
 * This class contains clubbed methods which performs series of actions like - Enter Username, Password and click Sign In.
 * Most of the time, these three actions will be done together only, so i am adding a extra layer between Page Class and Test Class for Code Cleanliness in Test Class
 */
public class LoginDomain extends DomainBase {
    // Page Classes -> Every domain can use one or more Page Classes
    private static LoginPage loginPage;
    // Variables
    private WebDriver driver;


    // Constructor
    public LoginDomain(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(this.driver);
    }

    /**
     * This method will login on Login Page
     *
     * @param emailId
     * @param password
     */
    public void login(String emailId, String password) {
        driver.get(getProperty("loginPageUrl"));
        loginPage.enterEmailAddress(emailId);
        loginPage.enterPassword(password);
        loginPage.clickSignIn();
    }

}


