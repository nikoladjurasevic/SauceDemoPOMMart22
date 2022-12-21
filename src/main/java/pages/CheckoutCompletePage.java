package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends BasePage{

    @FindBy (className = "complete-header")
    WebElement completeHeaderText;

    @FindBy (className = "complete-text")
    WebElement completeText;

    public CheckoutCompletePage(ChromeDriver driver) {
        super(driver);
    }


    public String getCompleteHeaderText() {
        return completeHeaderText.getText();
    }

    public String getCompleteText() {
        return completeText.getText();
    }
}
