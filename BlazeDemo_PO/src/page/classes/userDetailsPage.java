package page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class userDetailsPage {
    private static WebElement element = null;
    private static int count=0;
    private static SoftAssert so = new SoftAssert();

    public static WebElement validateToandFrom(WebDriver driver) {
        element = driver.findElement(By.xpath("/html/body/div[2]/h2"));
        String validatetoandfrom = element.getText();
        try{
            Assert.assertTrue(validatetoandfrom.contains("BOS"));

        }
        catch (AssertionError error){
            System.out.println(error.getMessage());
            System.out.println("Origin is not populated correctly");

        }
        try{
            Assert.assertTrue(validatetoandfrom.contains("LON"));
        }
        catch (AssertionError error){
            System.out.println(error.getMessage());
            System.out.println("Destination is not populated correctly");

        }

        return element;
    }

    public static WebElement validatePrice(WebDriver driver) {
        element = driver.findElement(By.xpath("/html/body/div[2]/h2"));
        String txtPrice = element.getText();
        try{
            Assert.assertTrue(txtPrice.contains("200"));
        }
        catch (AssertionError error){
            System.out.println(error.getMessage());
            System.out.println("Price is not populated correctly");
            }
        return element;
    }

    public static WebElement validateUserDetails(WebDriver driver){
        boolean ans = myUtilities.validateNonZeroInputs(driver);
        if(ans ==false){

        }

        return element;
    }
}
