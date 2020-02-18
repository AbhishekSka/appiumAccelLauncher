package org.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Hello world!
 *
 */
public class DriverSetup
{
   AppiumDriver aDriver;
   String path;

   @BeforeSuite
   public void setup(){
      System.out.println("Session starts..");
     // path = System.getProperty("~/Projects/appiumAccelLauncher");
      DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
      desiredCapabilities.setCapability("platformName", "Android");
      desiredCapabilities.setCapability("platformVersion", "5.1");
      desiredCapabilities.setCapability("deviceName", "HUAWEI TAG-L22");
      desiredCapabilities.setCapability("app", "/home/yipl/Projects/appiumAccelLauncher/app/ALFeb13.apk");
      desiredCapabilities.setCapability("appPackage","com.accel.launcher");
      desiredCapabilities.setCapability("appActivity","com.accel.launcher.ui.onboarding.OnboardingActivity");
      try {
         aDriver=new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
      } catch (MalformedURLException e) {
         e.printStackTrace();
      }
   }

//
//   @Test
//   public void testOnBoarding(){
//     aDriver.findElementByAccessibilityId("");
//
//   }

   @AfterSuite
   public void close(){
      aDriver.quit();
   }

}


