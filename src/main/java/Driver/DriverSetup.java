package Driver;

import com.testinium.deviceinformation.DeviceInfo;
import com.testinium.deviceinformation.DeviceInfoImpl;
import com.testinium.deviceinformation.device.DeviceType;
import com.testinium.deviceinformation.exception.DeviceNotFoundException;
import com.testinium.deviceinformation.model.Device;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Hello world!
 */
public class DriverSetup {
    public AppiumDriver aDriver;


    @BeforeTest
    public void setup() throws IOException, DeviceNotFoundException {
        System.out.println("Session starts..");
        DeviceInfo deviceInfo = new DeviceInfoImpl(DeviceType.ANDROID);
        Device device = deviceInfo.getFirstDevice();
        if (deviceInfo.anyDeviceConnected()) {
            System.out.println("Device Name - " + device.getDeviceProductName());
            System.out.println("Device id   - " + device.getUniqueDeviceID());
            System.out.println("Device version - " + device.getProductVersion());
        }

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(CapabilityType.PLATFORM, device.getDeviceProductName());
        desiredCapabilities.setCapability("platformName", device.getDeviceProductName());
        desiredCapabilities.setCapability(CapabilityType.VERSION, device.getProductVersion());
        desiredCapabilities.setCapability("deviceName", device.getModelNumber());
        desiredCapabilities.setCapability("udid", device.getUniqueDeviceID());
        desiredCapabilities.setCapability("app", "/home/yipl/Projects/appiumAccelLauncher/app/AL_Feb27.apk");
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


