package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
    //webelements

    @FindBy (xpath = "//button[text() = 'Checkout']")
    WebElement checkoutButton;

    @FindBy ( id = "continue-shopping")
    WebElement continueShoppingButton;

    @FindBy (id = "remove-sauce-labs-backpack")
    WebElement removeButton;

    //konstruktor
    public CartPage(ChromeDriver driver) {
        super(driver);
        print("You are on Cart page");
    }

    //metode
    public void clickCheckoutButton() {
        print("clickCheckoutButton");
        scrollIntoView(checkoutButton);
        waitForElement(checkoutButton);
        checkoutButton.click();
    }



}
