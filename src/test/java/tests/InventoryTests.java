package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import pages.Strings;

public class InventoryTests extends BaseTest{

    /*Adding one item and verifying cart icon
    1. Login with valid user
    2. Click on one item e.g. Backpack

    Expected result:
    2. Verify that the shopping cart icon shows number 1
     */
    @Test
    public void addOneItemToShoppingCart() {
        ChromeDriver driver = openChromeDriver();
        try {
            print("1. Login with valid user");
            loginWithValidCreds(driver);
            InventoryPage inventoryPage = new InventoryPage(driver);

            assert !inventoryPage.isShoppingBadgeShown() : "Error. Badge is shown, but it should NOT";

            print("2. Click on one item e.g. Backpack");
            inventoryPage.clickAddToCartBackpackButton();

            assert inventoryPage.isShoppingBadgeShown() : "Error. Badge is not shown , but it should be";

            print("2. Verify that the shopping cart icon shows number 1");
            String actualNumberFromCart = inventoryPage.getNumberFromShoppingCart();
            assert actualNumberFromCart.equals("1") : "Wrong number in shopping cart. Expected: 1 . Actual : "
                    + actualNumberFromCart;

        }finally {
            driver.quit();
        }
    }

    /*Adding one item and verifying cart icon
    1. Login with valid user
    2. Click on one item e.g. Backpack
    3. Clilck on second item e.g. onesie

    Expected result:
    3. Verify that the shopping cart icon shows number 2
 */
    @Test
    public void addTwoItemsToShoppingCart() {
        ChromeDriver driver = openChromeDriver();
        try {
            print("1. Login with valid user");
            loginWithValidCreds(driver);
            InventoryPage inventoryPage = new InventoryPage(driver);

            print("2. Click on one item e.g. Backpack");
            inventoryPage.clickAddToCartBackpackButton();

            print("3. Click on second item e.g. Onesie");
            inventoryPage.clickAddToCartOnesieButton();

            print("3. Verify that the shopping cart icon shows number 2");
            String actualNumberFromCart = inventoryPage.getNumberFromShoppingCart();
            assert actualNumberFromCart.equals("2") : "Wrong number in shopping cart. Expected: 2 . Actual : "
                    + actualNumberFromCart;

        }finally {
            driver.quit();
        }
    }

    /*Adding two items and removing one
    1. Login with valid user
    2. Click on one item e.g. Backpack
    3. Clilk on second item e.g. onesie
    4. Click to remove one item

    Expected result:
    3. Verify that the shopping cart icon shows number 2
    4. Verify that the shopping cart icon shown number 1
    */
    @Test
    public void addTwoItemsAndRemoveOneFromShoppingCart() {
        ChromeDriver driver = openChromeDriver();
        try {
            print("1. Login with valid user");
            loginWithValidCreds(driver);
            InventoryPage inventoryPage = new InventoryPage(driver);

            print("2. Click on one item e.g. Backpack");
            inventoryPage.clickAddToCartBackpackButton();

            print("3. Click on second item e.g. Onesie");
            inventoryPage.clickAddToCartOnesieButton();

            print("3. Verify that the shopping cart icon shows number 2");
            String actualNumberFromCart = inventoryPage.getNumberFromShoppingCart();
            assert actualNumberFromCart.equals("2") : "Wrong number in shopping cart. Expected: 2 . Actual : "
                    + actualNumberFromCart;

            print("4. Remove one item from shopping cart");
            inventoryPage.clickRemoveFromCartBackpackButton();

            print("4. Verify that the shopping cart icon shows number 1");
            actualNumberFromCart = inventoryPage.getNumberFromShoppingCart();
            assert actualNumberFromCart.equals("1") : "Wrong number in shopping cart. Expected: 1 . Actual : "
                    + actualNumberFromCart;

        }finally {
            driver.quit();
        }
    }

}
