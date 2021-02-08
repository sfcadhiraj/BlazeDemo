package page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class homepage {
    private static WebElement element = null;

    public static WebElement originBox(WebDriver driver){
        WebElement fromPort = driver.findElement(By.name("fromPort"));
        Select selfromPort = new Select (fromPort);
        List<WebElement> options = selfromPort.getOptions();
        selfromPort.selectByValue("Boston");
        return element;
    }
    public static WebElement destBox(WebDriver driver){
        WebElement toPort = driver.findElement(By.name("toPort"));
        Select seltoPort = new Select(toPort);
        List<WebElement> options2 = seltoPort.getOptions();
        seltoPort.selectByValue("London");
        return  element;
    }

    public static WebElement moveToConfirm(WebDriver driver){
        WebElement submitbtn = driver.findElement(By.xpath(".//input[@type='submit']"));
        submitbtn.click();
        return element;
    }
}
