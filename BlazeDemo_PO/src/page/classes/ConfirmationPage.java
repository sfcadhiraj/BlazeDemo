package page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfirmationPage {
    private static WebElement element = null;
    public static WebElement validateTransactionID(WebDriver driver){
        By element2 = By.xpath("//table[@class='table']/tbody/tr[1]/td[2]");
        myUtilities.waitforaWhileImplicit(driver,20);
        element = driver.findElement(element2);

        System.out.println("Confirmation Code to be sent is : "+ element.getText());

        return element;
    }
}
