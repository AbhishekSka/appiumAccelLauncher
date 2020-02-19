package org.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Hello world!
 */
public class DriverSetup {
    AppiumDriver aDriver;
    String path;

    @BeforeSuite
    public void setup() {
        System.out.println("Session starts..");
        // path = System.getProperty("~/Projects/appiumAccelLauncher");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "5.1");
        desiredCapabilities.setCapability("deviceName", "HUAWEI TAG-L22");
        desiredCapabilities.setCapability("app", "/home/yipl/Projects/appiumAccelLauncher/app/ALFeb13.apk");
        desiredCapabilities.setCapability("autoGrantPermissions", "true");
        desiredCapabilities.setCapability("appPackage", "com.accel.launcher");
        desiredCapabilities.setCapability("appActivity", "com.android.launcher3.Launcher");
        try {
            aDriver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testOnBoarding() throws InterruptedException {
        //Onboarding Screen1
        String TitleText1 = aDriver.findElement(By.id("com.accel.launcher:id/text_title_1")).getText();
        Assert.assertEquals(TitleText1, "Welcome to \n Accel Launcher");
        aDriver.findElement(By.id("com.accel.launcher:id/next_button")).click();

        //Onboarding Screen2
        Thread.sleep(1000);

        String TitleText2 = aDriver.findElement(By.id("com.accel.launcher:id/text_title_1")).getText();
        Assert.assertEquals(TitleText2, "Accel Launcher");
        aDriver.findElement(By.id("com.accel.launcher:id/next_button")).click();

        //Onboarding Screen 3
        String TitleText3 = aDriver.findElement(By.id("com.accel.launcher:id/text_title_1")).getText();
        Assert.assertEquals(TitleText3, "Hide apps");
        aDriver.findElement(By.id("com.accel.launcher:id/next_button")).click();


        //Onboarding Screen 4
        String TitleText4 = aDriver.findElement(By.id("com.accel.launcher:id/text_title_1")).getText();
        Assert.assertEquals(TitleText4, "Gestures");
        aDriver.findElement(By.id("com.accel.launcher:id/next_button")).click();

        //Onboarding Screen 5
        String TitleText5 = aDriver.findElement(By.id("com.accel.launcher:id/text_title_1")).getText();
        Assert.assertEquals(TitleText5, "Accelerate your productivity");
        aDriver.findElement(By.id("com.accel.launcher:id/next_button")).click();

        // Set Default screen
        aDriver.findElement(By.id("com.accel.launcher:id/btn_set_default_launcher")).isDisplayed();

    }

    @AfterSuite
    public void close() {
        aDriver.quit();
    }

}


