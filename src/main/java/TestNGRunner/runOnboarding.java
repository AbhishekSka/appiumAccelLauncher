package TestNGRunner;

import Driver.DriverSetup;
import Tests.OnBoarding;
import org.testng.annotations.Test;

public class runOnboarding  extends DriverSetup{
    OnBoarding onBoarding;

    @Test
    public void runNormalOnBoardingTest() throws InterruptedException {
        onBoarding = new OnBoarding(aDriver);
        onBoarding.normalOnBoarding();
    }


    @Test
    public void runSkipOnboardingTest() throws InterruptedException {
        onBoarding = new OnBoarding(aDriver);
         onBoarding.skipOnboarding();

    }

}
