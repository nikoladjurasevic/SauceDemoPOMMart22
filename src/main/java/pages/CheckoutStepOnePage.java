package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutStepOnePage extends BasePage{

    //webelements
    @FindBy (id = "first-name")
    WebElement firstNameField;

    @FindBy (id = "last-name")
    WebElement lastNameField;

    @FindBy (id = "postal-code")
    WebElement postalCodeField;

    @FindBy (id = "continue")
    WebElement continueButton;

    public CheckoutStepOnePage(ChromeDriver driver) {
        super(driver);
        print("You are on Checkout Step One Page");
    }

    //methods
    public void enterTextInFirstNameField(String text) {
        waitForElement(firstNameField);
        firstNameField.sendKeys(text);
    }

    public void enterTextInLastNameField(String text) {
        lastNameField.sendKeys(text);
    }

    public void enterTextInPostalCodeField(String text) {
        postalCodeField.sendKeys(text);
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    //dodajte metodu koja ce da popuni sva ova polja sa validnim podatcima

}
