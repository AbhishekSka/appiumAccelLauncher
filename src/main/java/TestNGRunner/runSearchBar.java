package TestNGRunner;

import Driver.DriverSetup;
import Tests.HomeScreen;
import Tests.OnBoarding;
import Tests.SearchBar;
import org.testng.annotations.Test;

public class runSearchBar extends DriverSetup {

    @Test
    public void checkSearchContent() throws InterruptedException {
        new OnBoarding(aDriver).skipOnboarding();
        new HomeScreen(aDriver).checkSearchScreen();
        new SearchBar(aDriver).searchAction();
    }

}
