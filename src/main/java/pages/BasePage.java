package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    ChromeDriver driver;


    @FindBy (xpath = "//button[@id = 'react-burger-menu-btn']")
    WebElement hamburgerMenu;

    @FindBy (xpath = "//a[@class = 'shopping_cart_link']")
    WebElement shoppingCartIcon;

    @FindBy (id = "logout_sidebar_link")
    WebElement logoutLink;

    public void clickHamburgerMenu() {
        hamburgerMenu.click();
    }

    public void clickShoppingCartIcon() {
        shoppingCartIcon.click();
    }

    public void clickLogoutLink() {
        waitForElement(logoutLink);
        logoutLink.click();
    }

    public void logoutUser() {
        clickHamburgerMenu();
        clickLogoutLink();
        String actualUrl = driver.getCurrentUrl();
        assert actualUrl.equals(Strings.LOGIN_PAGE_URL) : "Error. User is not logged out. Current url " + actualUrl;
    }

    //ovo je konstruktor za Base page koji ce nasledjivati sve ostale page klase
    public BasePage(ChromeDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //ovo cemo koristiti za elemente stranice gde treba da se skroluje do njih
    public void scrollIntoView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);" ,element);
    }

    public void waitForElement(WebElement element) {
        //ovde najcesce stavljam wait zato sto ga koristim da sacekam da se webelementi pojave a oni su u Page klasama
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public boolean isElementPresent(WebElement element) {
        try {
            boolean present = element.isDisplayed();
            return present;
        } catch(Exception e) {
            return false;
        }
    }

    //ovo sluzi samo za printanje texta u konzoli
    public static void print(String s) {
        System.out.println(s);
    }

    public void sleep () {
        try {
            Thread.sleep(1000);
        }catch (Exception e) {
            print(e.getMessage());
        }
    }


}
