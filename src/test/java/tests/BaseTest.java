package tests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.Strings;

import java.util.ArrayList;

public class BaseTest {
    ChromeDriver driver;
    //wait moze da se koristi i u testovima
//    WebDriverWait wait = new WebDriverWait(driver, 5);

    //Ovde pravimo metodu koja otvara chrome sa svim potrebnim opcijama
    public ChromeDriver openChromeDriver() {
        print("Openening Chrome Driver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments(new String[]{"--start-maximized"});
        options.addArguments(new String[]{"--ignore-certificate-errors"});
        options.addArguments(new String[]{"--disable-popup-blocking"});
        options.addArguments(new String[]{"--incognito"});
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        ChromeDriver driver = new ChromeDriver(options);
        //ovo dole sluzi za setovanje dimenzija browsera
//        driver.manage().window().setSize(new Dimension(600,768));
        return driver;
    }

//    public void sleep(int seconds) {
//        try {
//            Thread.sleep(seconds*1000);
//        }catch (Exception e) {
////            print(e.getMessage());
//        }
//    }

    public void loginWithValidCreds(ChromeDriver driver) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(Strings.VALID_USERNAME);
        loginPage.enterPassword(Strings.VALID_PASSWORD);
        loginPage.clickLoginButton();
        print("Verify that the url is correct");
        assert driver.getCurrentUrl().equals(Strings.INVENTORY_PAGE_URL) : "Error";
    }



    //ovo sluzi samo za printanje texta u konzoli
    public static void print(String s) {
        System.out.println(s);
    }

    //metoda za proveru da li je niz sortiran u rastucem poretuku
    //dohvata susedna dva broja i uporedjuje ih
    public boolean isArraySortedInAscendingOrder(ArrayList<Float> arrayList) {
        for(int i = 0; i<arrayList.size()-1; i++) {
            Float firstItem = arrayList.get(i);
            Float secondItem = arrayList.get(i+1);
            if (firstItem>secondItem) {
                return false;
            }
        } return true;
    }

}


