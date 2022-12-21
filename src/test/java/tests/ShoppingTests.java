package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.*;

public class ShoppingTests extends BaseTest{


    @Test
    public void shoppingOfOneItem() {
        ChromeDriver driver = openChromeDriver();
        try {
            loginWithValidCreds(driver);
            InventoryPage inventoryPage = new InventoryPage(driver);
            inventoryPage.clickAddToCartBackpackButton();
            inventoryPage.clickShoppingCartIcon();

            CartPage cartPage = new CartPage(driver);
            cartPage.clickCheckoutButton();

            CheckoutStepOnePage checkoutStepOnePage = new CheckoutStepOnePage(driver);
            checkoutStepOnePage.enterTextInFirstNameField("Pera");
            checkoutStepOnePage.enterTextInLastNameField("Peric");
            checkoutStepOnePage.enterTextInPostalCodeField("11080");
            checkoutStepOnePage.clickContinueButton();

            CheckoutStepTwoPage checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
            checkoutStepTwoPage.clickFinishButton();

            CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
            String actualCompleteHeaderText = checkoutCompletePage.getCompleteHeaderText();
            String actualCompleteText = checkoutCompletePage.getCompleteText();

            assert actualCompleteHeaderText.equals(Strings.COMPLETE_HEADER_TEXT) : "Error. Expected text: " + Strings.COMPLETE_HEADER_TEXT
                    + " . Actual : " + actualCompleteHeaderText;

            assert actualCompleteText.equals(Strings.COMPLETE_TEXT) : "Error. Expected text: " + Strings.COMPLETE_TEXT
                    + " . Actual : " + actualCompleteText;

            checkoutCompletePage.logoutUser();

        }finally {
            driver.quit();
        }

    }

    @Test
    public void addOneItemByText() {
        ChromeDriver driver = openChromeDriver();
        try {

            loginWithValidCreds(driver);
            InventoryPage inventoryPage = new InventoryPage(driver);
            inventoryPage.addToCartByText("Backpack");

            String actualNumberFromCart = inventoryPage.getNumberFromShoppingCart();
            assert actualNumberFromCart.equals("1") : "Wrong number in shopping cart. Expected: 1 . Actual : "
                    + actualNumberFromCart;

        }finally {
//            driver.quit();
        }
    }

    @Test
    public void addMultipleItemsByText() {
        ChromeDriver driver = openChromeDriver();
        try {

            loginWithValidCreds(driver);
            InventoryPage inventoryPage = new InventoryPage(driver);
            inventoryPage.addToCartByText("T-Shirt (Red)");

            inventoryPage.addToCartByText("Jacket");

            String actualNumberFromCart = inventoryPage.getNumberFromShoppingCart();
            assert actualNumberFromCart.equals("2") : "Wrong number in shopping cart. Expected: 2 . Actual : "
                    + actualNumberFromCart;

        }finally {
            driver.quit();
        }
    }

}
