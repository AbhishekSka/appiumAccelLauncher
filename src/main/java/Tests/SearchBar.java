package Tests;

import Driver.DriverSetup;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;

public class SearchBar extends DriverSetup {


    public SearchBar(AppiumDriver appiumDriver){
        this.aDriver=appiumDriver;
    }

    public void searchAction() throws InterruptedException {
        new HomeScreen(aDriver).checkSearchScreen();
        MobileElement searchElement = (MobileElement) aDriver.findElement(By.id("com.accel.launcher:id/editText_query_input"));

        searchElement.sendKeys("a");
        Thread.sleep(2000);

        aDriver.findElement(By.id("com.accel.launcher:id/flow_suggestions")).isDisplayed();
        aDriver.findElement(By.id("com.accel.launcher:id/textView_text_search_web")).isDisplayed();
        String searchAppLabel=aDriver.findElement(By.id("com.accel.launcher:id/textView_text_search_apps")).getText();
        Assert.assertEquals(searchAppLabel,"Search apps");
        aDriver.findElement(By.id("com.accel.launcher:id/appsContainer")).isDisplayed();
        String contactsLabel = aDriver.findElement(By.id("com.accel.launcher:id/textView_text_contacts")).getText();
        Assert.assertEquals(contactsLabel,"Contacts");

    }
}
