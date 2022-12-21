package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutStepTwoPage extends BasePage{

    @FindBy (xpath = "//button[@class = 'btn btn_action btn_medium cart_button']")
    WebElement finishButton;

    public CheckoutStepTwoPage(ChromeDriver driver) {
        super(driver);
        print("You are on Checkout Step Two Page");
    }

    public void clickFinishButton () {
        finishButton.click();
    }
}
