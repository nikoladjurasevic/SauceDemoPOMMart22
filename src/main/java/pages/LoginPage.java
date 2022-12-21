package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    ChromeDriver driver;

    @FindBy (xpath = "//input[@id = 'user-name']")
    WebElement userNameField;

    @FindBy (xpath = "//input[@id = 'password']")
    WebElement passwordField;

    @FindBy (xpath = "//input[@id = 'login-button']")
    WebElement loginButton;

    @FindBy (xpath = "//h3[@data-test = 'error']")
    WebElement errorMessageText;


    public LoginPage(ChromeDriver driver) {
        BasePage.print("Open LOGIN PAGE");
        driver.get("https://www.saucedemo.com/");
        PageFactory.initElements(driver, this);
    }


    public void enterUsername(String userName) {
        BasePage.print("enterUsername");
        userNameField.click();
        userNameField.sendKeys(userName);
    }

    public void enterPassword(String pass) {
        BasePage.print("enterPassword");
        passwordField.click();
        passwordField.sendKeys(pass);
    }

    public void clickLoginButton() {
        BasePage.print("clickLOginButton");
        loginButton.click();
    }

    public String getTextFromErrorMessage() {
        return errorMessageText.getText();
    }




}
