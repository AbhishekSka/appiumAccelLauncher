package Tests;

import Driver.DriverSetup;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;

public class OnBoarding extends DriverSetup {

    public  OnBoarding(AppiumDriver appiumDriver){
        this.aDriver=appiumDriver;
    }


    public void normalOnBoarding() throws InterruptedException {
        //Onboarding Screen1
        String TitleText1 = aDriver.findElement(By.id("com.accel.launcher:id/text_title_1")).getText();
        Assert.assertEquals(TitleText1, "Welcome to \n Accel Launcher");
        Reporter.log(TitleText1);
        aDriver.findElement(By.id("com.accel.launcher:id/next_button")).click();

        //Onboarding Screen2
        Thread.sleep(1000);

        String TitleText2 = aDriver.findElement(By.id("com.accel.launcher:id/text_title_1")).getText();
        Assert.assertEquals(TitleText2, "Accel Launcher","Accel launcher screen could be seen");
        Reporter.log(TitleText2);
        aDriver.findElement(By.id("com.accel.launcher:id/next_button")).click();


        //Onboarding Screen 3
        String TitleText3 = aDriver.findElement(By.id("com.accel.launcher:id/text_title_1")).getText();
        Assert.assertEquals(TitleText3, "Hide apps","Hide apps screen could be seen");
        Reporter.log(TitleText3);
        aDriver.findElement(By.id("com.accel.launcher:id/next_button")).click();


        //Onboarding Screen 4
        String TitleText4 = aDriver.findElement(By.id("com.accel.launcher:id/text_title_1")).getText();
        Assert.assertEquals(TitleText4, "Gestures","Gestures screen could be seen");
        Reporter.log(TitleText4);
        aDriver.findElement(By.id("com.accel.launcher:id/next_button")).click();

        //Onboarding Screen 5
        String TitleText5 = aDriver.findElement(By.id("com.accel.launcher:id/text_title_1")).getText();
        Assert.assertEquals(TitleText5, "Accelerate your productivity","Accelerate your productivity screen could be seen");
        Reporter.log(TitleText5);
        aDriver.findElement(By.id("com.accel.launcher:id/next_button")).click();

        // Set Default screen
        Thread.sleep(2000);

        aDriver.findElement(By.id("com.accel.launcher:id/btn_set_default_launcher")).isDisplayed();

        String packageName = ((AndroidDriver) aDriver).getCurrentPackage();
        aDriver.resetApp();
       // aDriver.terminateApp(packageName);
        aDriver.activateApp(packageName);

    }

    public void skipOnboarding() throws InterruptedException {

        //onboarding screen1
        Thread.sleep(3000);
        String TitleText1 = aDriver.findElement(By.id("com.accel.launcher:id/text_title_1")).getText();
        Assert.assertEquals(TitleText1, "Welcome to \n Accel Launcher");
        Reporter.log(TitleText1);
        Thread.sleep(1000);
        aDriver.findElement(By.id("com.accel.launcher:id/next_button")).click();

        //Onboarding Screen2
        Thread.sleep(1000);
        String TitleText2 = aDriver.findElement(By.id("com.accel.launcher:id/text_title_1")).getText();
        Assert.assertEquals(TitleText2, "Accel Launcher");
        Reporter.log(TitleText2);
        aDriver.findElement(By.id("com.accel.launcher:id/skip_button")).click();

        //Onboarding Screen 5
        Thread.sleep(1000);
        String TitleText5 = aDriver.findElement(By.id("com.accel.launcher:id/text_title_1")).getText();
        Assert.assertEquals(TitleText5, "Accelerate your productivity");
        Reporter.log(TitleText5);
        aDriver.findElement(By.id("com.accel.launcher:id/next_button")).click();

        // Set Default screen
        Thread.sleep(3000);
        aDriver.findElement(By.id("com.accel.launcher:id/btn_set_default_launcher")).isDisplayed();

    }

}

