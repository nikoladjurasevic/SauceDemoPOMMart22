package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.Strings;

import javax.swing.*;

public class LoginTests extends BaseTest{

    //tests steps
    @Test
    public void loginWithValidCredentials() {
        ChromeDriver driver = openChromeDriver();
        try{
            print("Navigate to login page");
            LoginPage loginPage = new LoginPage(driver);

            print("Enter username");
            loginPage.enterUsername(Strings.VALID_USERNAME);
            print("Enter password");

            loginPage.enterPassword(Strings.VALID_PASSWORD);
            loginPage.clickLoginButton();

            print("Verify that the url is correct");
            assert driver.getCurrentUrl().equals(Strings.INVENTORY_PAGE_URL) : "Error";
        }finally {
            driver.quit();
        }
    }

    @Test
    public void loginWithInvalidUserNameAndValidPass() {
        ChromeDriver driver = openChromeDriver();
        try {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.enterUsername(Strings.INVALID_USERNAME);
            loginPage.enterPassword(Strings.VALID_PASSWORD);
            loginPage.clickLoginButton();
            print("Verify that users is NOT logged in");
            assert driver.getCurrentUrl().equals(Strings.LOGIN_PAGE_URL) : "Wrong URL. Expected: " + Strings.LOGIN_PAGE_URL
                    + " . Actual" + driver.getCurrentUrl();
            String actualErrorMessage = loginPage.getTextFromErrorMessage();
            assert actualErrorMessage.equals(Strings.LOGIN_ERROR_MESSAGE) : "Wrong error message. Expected: " + Strings.LOGIN_ERROR_MESSAGE
                    + " . Actual: " + actualErrorMessage;
        } finally {
            driver.quit();
        }
    }




}
