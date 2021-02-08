package page.classes;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.server.handler.ImplicitlyWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class myUtilities  {
    private static WebElement element = null;
    public static WebElement takeScreenshot(WebDriver driver) {
        String pattern = "yyyy-MM-dd HH mm ss SSS";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String date = sdf.format(new Date());
        try{
            File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcfile, new File("/Users/adhiraj/Desktop/OneDrive/My_Development/BlazeDemo_PO/files/"+date+".png"));
        }catch (Exception e){
           e.printStackTrace();
        }
        return element;
    }
    public static boolean validateNonZeroInputs(WebDriver driver){
        element = driver.findElement(By.id("inputName"));

        if (element.getText().length()==0){
            element.sendKeys("Adhiraj Singh");

        }

        element = driver.findElement(By.xpath("/html/body/div[2]/form/div[11]/div/input"));
        By nw = By.xpath("/html/body/div[2]/form/div[11]/div/input");
        waitforaWhileExplicit(driver, nw);
        element.click();
        return false;

    }

    public static WebElement waitforaWhileImplicit(WebDriver driver, int i){

        WebDriverWait wait = new WebDriverWait(driver,i);

        return element;
    }
    public static WebElement waitforaWhileExplicit(WebDriver driver, By element2){

        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated((element2)));
        return element;
    }
}
