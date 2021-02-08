package page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

public class flightReservationPage {
    private static WebElement element = null;


    public static WebElement lowestFare(WebDriver driver) throws ParseException {
        List<WebElement> col = driver.findElements(By.xpath(".//table/thead/tr/th"));
        System.out.println("No. of Columns are : " + col.size());
        //Number of rows in Amount Table
        List<WebElement> rows = driver.findElements(By.xpath(".//table/tbody/tr/td[1]"));
        System.out.println("N0. of rows are: " + rows.size());
        int min,j = 0;
        int[] arr = new int[6];
        Locale locale = Locale.US;
        final NumberFormat format = NumberFormat.getNumberInstance(locale);
        for (int i = 1; i <= rows.size(); i++) {

            String amnt = driver.findElement(By.xpath(".//table/tbody/tr["+i+"]/td[6]")).getText();
            if (format instanceof DecimalFormat) {
                ((DecimalFormat) format).setParseBigDecimal(true);
            }
            BigDecimal bamnt = (BigDecimal) format.parse(amnt.replaceAll("[^\\d.,]", ""));
            arr[i-1] = bamnt.intValue();
        }
        min = arr[0];
        for (int i=0;i<rows.size();i++){
            if (min > arr[i]){
                min = arr[i];
                j=i+1;
            }

        }
        element = driver.findElement(By.xpath(".//table/tbody/tr["+j+"]/td[1]/input"));
        System.out.println("Lowest Amount ticket is for: "+ min);
        System.out.println("Choosing the flight with lowest amount");
        //element contains the flight with lowest amount for selection
        element.click();
        return element;
    }
}
