package TestNGRunner;

import Driver.DriverSetup;
import Tests.HomeScreen;
import Tests.OnBoarding;
import org.testng.annotations.Test;

public class runHomeScreen extends DriverSetup {
    HomeScreen  homeScreen;
    OnBoarding onBoarding;
    @Test
    public void checkFavApp() throws InterruptedException {
        homeScreen = new HomeScreen(aDriver);
        onBoarding = new OnBoarding(aDriver);

        onBoarding.skipOnboarding();
        homeScreen.checkFavIcons();
    }

    @Test
    public void checkSearchBar() throws InterruptedException {
        homeScreen = new HomeScreen(aDriver);
        homeScreen.checkSearchScreen();

    }
}
