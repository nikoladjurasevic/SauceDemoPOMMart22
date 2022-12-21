package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.Strings;

import java.util.ArrayList;

public class SortingTests extends BaseTest {

    /* Sorting in ascending order by price
    1. Login to swag labs
    2. CLick on the Sorting dropdown and choose to sort 'Price low to high'

    Expected results:
    2. Verify that items are sorted in ascending order by price
     */

    @Test
    public void sortItemsByPriceAscending() {
        ChromeDriver driver = openChromeDriver();
        try {
            print("1. Login to swag labs");
            loginWithValidCreds(driver);
            InventoryPage inventoryPage = new InventoryPage(driver);

            print("Get firs item price, before sorting");
            String firstItemPriceUnsorted = inventoryPage.getFirstItemPrice();
            float priceUnsorted = Float.valueOf(firstItemPriceUnsorted.substring(1));

            print("2. CLick on the Sorting dropdown and choose to sort 'Price low to high'");
            inventoryPage.sortItemsByText(Strings.DROPDOWN_SORT_BY_PRICE_ASC);

            print("Again, get the first item price after sorting");
            String firstItemPriceSorted = inventoryPage.getFirstItemPrice();
            float priceSorted = Float.valueOf(firstItemPriceSorted.substring(1));

            //ovo je napredna provera sortiranja gde se proverava ceo niz
            ArrayList<Float> itemPricesAfterSorting = inventoryPage.getAllITemPrices();
            assert isArraySortedInAscendingOrder(itemPricesAfterSorting) : "Error. Array is not sorted in ascending order";

            print("2. Verify that items are sorted in ascending order by price");
            //we are just checking if the first item price has changed and this is how we verify that list is sorted
            assert priceSorted<priceUnsorted: "Error: Prices are not sorted in ascending order";

        }finally {
            driver.quit();
        }
    }

}
