package TestNGRunner;

import Driver.DriverSetup;
import OnBoarding.OnBoarding;
import org.testng.annotations.Test;

public class runOnboarding  extends DriverSetup{
    OnBoarding onBoarding;

    @Test
    public void runOnBoardingTest() throws InterruptedException {
        onBoarding = new OnBoarding(aDriver);
        onBoarding.testOnBoarding();

    }

}
