package page.classes;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.IAssert;
import org.testng.asserts.SoftAssert;

public class CustomSoftAssert extends SoftAssert {
    private static WebDriver driver = null;
    @Override
    public void onAssertFailure(IAssert<?> a, AssertionError ex){
        myUtilities.takeScreenshot(driver);
    }

}
