package page.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.text.ParseException;

public class PageObjectModel {
    private static WebDriver driver;
    private String blazeUrl ="http://blazedemo.com";

    @Test
    public void selectFlight(){
        driver.get(blazeUrl);
        homepage.originBox(driver);
        homepage.destBox(driver);
        homepage.moveToConfirm(driver);
    }

    @Test
    public void selectLowestFare() throws ParseException {
        flightReservationPage.lowestFare(driver);
    }

    @Test
    public void validateFlightDetails(){
        userDetailsPage.validateToandFrom(driver);
        userDetailsPage.validatePrice(driver);
        userDetailsPage.validateUserDetails(driver);
    }

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "/Users/adhiraj/Desktop/OneDrive/My_Development/BlazeDemo_PO/files/chromedriver");
        driver = new ChromeDriver();
    }

    @AfterTest
    public void exitBrowser(){
        driver.quit();
    }
}
