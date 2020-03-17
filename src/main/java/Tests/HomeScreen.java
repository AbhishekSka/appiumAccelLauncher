package Tests;

import Driver.DriverSetup;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofMillis;
import static org.testng.Assert.assertEquals;

public class HomeScreen extends DriverSetup {


    public HomeScreen(AppiumDriver appiumDriver) {
        this.aDriver = appiumDriver;
    }


    public void checkFavIcons() throws InterruptedException {
        aDriver.findElement(By.id("com.accel.launcher:id/img_close")).click();
        Thread.sleep(5000);

        String phone = aDriver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Phone\"]")).getText();
        Assert.assertEquals(phone, "Phone", "Phone app has been found");

        String message = aDriver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Messages\"]")).getText();
        Assert.assertEquals(message, "Messages", "Messages app has been found");

        String camera = aDriver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Camera\"]")).getText();
        assertEquals(camera, "Camera", "Camera app found");

        String chrome = aDriver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Chrome\"]")).getText();
        assertEquals(chrome, "Chrome", "Chrome Browser found");

        Thread.sleep(1000);

    }

    public void checkSearchScreen() throws InterruptedException {
        //Swipe up gesture to open Search
        TouchAction swipeGesture = new TouchAction(aDriver);
        swipeGesture.press(PointOption.point(380, 850))
             .waitAction(waitOptions(ofMillis(800)))
                .moveTo(PointOption.point(380, 230))
                .release().perform();


        boolean displaySearchIcon=aDriver.findElement(By.id("com.accel.launcher:id/imageView_search")).isDisplayed();
        Assert.assertTrue(displaySearchIcon,"Search icon displayed on search bar");

        String displaySearchField = aDriver.findElement(By.id("com.accel.launcher:id/editText_query_input")).getText();
        Assert.assertEquals(displaySearchField,"Search apps, contacts...","Placeholder and search field active");

        boolean displayMicIcon=aDriver.findElement(By.id("com.accel.launcher:id/imageView_voice_search_edittext")).isDisplayed();
        Assert.assertTrue(displayMicIcon,"Mic icon displayed on search bar");

        //Check trending
        aDriver.findElement(By.id(("com.accel.launcher:id/flow_treding"))).isDisplayed();
        Reporter.log("Trending section is being shown");

    }

}
