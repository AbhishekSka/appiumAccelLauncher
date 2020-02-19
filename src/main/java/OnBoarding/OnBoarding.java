package OnBoarding;

import Driver.DriverSetup;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OnBoarding extends DriverSetup {

    public  OnBoarding(AppiumDriver appiumDriver){
        this.aDriver=appiumDriver;
    }


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

}

