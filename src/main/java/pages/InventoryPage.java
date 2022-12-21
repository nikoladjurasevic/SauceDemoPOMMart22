package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class InventoryPage extends BasePage {


    //webelementi stranice
    @FindBy ( xpath = "//button[@id = 'add-to-cart-sauce-labs-backpack']")
    WebElement addToCartBackPackButton;

    @FindBy ( xpath = "//button[@id = 'add-to-cart-sauce-labs-onesie']")
    WebElement addToCartOnesieButton;

    @FindBy (xpath = "//span[@class = 'shopping_cart_badge']")
    WebElement shoppingCartBadge;

    @FindBy ( xpath = "//button[@id = 'remove-sauce-labs-backpack']")
    WebElement removeFromCartBackPackButton;

    @FindBy (xpath = "//select[@class = 'product_sort_container']")
    WebElement sortDropDown;

    //konstruktor
    public InventoryPage(ChromeDriver driver) {
        super(driver);
        print("Open Inventory page");
    }

    //metode

    public void clickAddToCartBackpackButton() {
        print("clickAddToCartBackpackButton");
        addToCartBackPackButton.click();
    }

    public void clickAddToCartOnesieButton() {
        print("clickAddToCartOnesieButton");
        addToCartOnesieButton.click();
    }

    public void clickRemoveFromCartBackpackButton() {
        print("clickRemoveFromCartBackpackButton");
        removeFromCartBackPackButton.click();
    }

    public String getNumberFromShoppingCart() {
        print("getNumberFromShoppingCart");

        String number = shoppingCartBadge.getText();
        return number;

//        return shoppingCartBadge.getText();
    }

    public boolean isShoppingBadgeShown() {
        return isElementPresent(shoppingCartBadge);
    }


    public void sortItemsByText(String text) {
        Select dropdown = new Select(sortDropDown);
        dropdown.selectByVisibleText(text);
    }

    //ova metoda dohvata sve iteme na strinici i vraca cenu prvog
    public String getFirstItemPrice() {
        List<WebElement> items = driver.findElements(By.xpath("//div[@class = 'inventory_item']"));
        WebElement firstItem = items.get(0);
        WebElement firstItemPrice = firstItem.findElement(By.xpath("//div[@class = 'inventory_item_price']"));
        return firstItemPrice.getText();
    }

    public void addToCartByText(String itemName) {
        List<WebElement> items = driver.findElements(By.xpath("//div[@class = 'inventory_item']"));
        for(WebElement item : items) {
            String curentItemName = item.findElement(By.xpath(".//div[@class = 'inventory_item_name']")).getText();
            if (curentItemName.contains(itemName)) {
                WebElement addToCart = item.findElement(By.xpath(".//button[text() = 'Add to cart']"));
                scrollIntoView(addToCart);
                addToCart.click();
                break;
            }
        }
    }

    public ArrayList<Float> getAllITemPrices() {
        List<WebElement> items = driver.findElements(By.xpath("//div[@class = 'inventory_item']"));
        ArrayList<Float> itemPrices = new ArrayList<>();
        for (WebElement item : items) {
            String itemPrice = item.findElement(By.xpath(".//div[@class = 'inventory_item_price']")).getText();
            Float justFLoatValue = Float.valueOf(itemPrice.substring(1));
            itemPrices.add(justFLoatValue);
        }
        return itemPrices;
    }

}
