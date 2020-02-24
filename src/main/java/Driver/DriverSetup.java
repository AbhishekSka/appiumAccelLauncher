package Driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Hello world!
 */
public class DriverSetup {
    protected AppiumDriver aDriver;


    @BeforeTest
    public void setup() {
        System.out.println("Session starts..");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "5.1");
        desiredCapabilities.setCapability("deviceName", "HUAWEI TAG-L22");
        desiredCapabilities.setCapability("app", "/home/yipl/Projects/appiumAccelLauncher/app/AL_Feb20.apk");
        desiredCapabilities.setCapability("autoGrantPermissions", "true");
        desiredCapabilities.setCapability("appPackage", "com.accel.launcher");
        desiredCapabilities.setCapability("appActivity", "com.android.launcher3.Launcher");
        try {
            aDriver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


    @AfterSuite
    public void close() {
        aDriver.quit();
    }

}


