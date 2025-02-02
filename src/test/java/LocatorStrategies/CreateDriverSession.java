package LocatorStrategies;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class CreateDriverSession {

//    public static void main(String[] args) throws MalformedURLException {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("platformName", "Android");
//        capabilities.setCapability("appium:automationName", "uiautomator2");
//        capabilities.setCapability("appium:deviceName", "pixel_7");
//        capabilities.setCapability("appium:udid", "emulator-5554");
//        capabilities.setCapability("appium:app", System.getProperty("user.dir")+ File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"ApiDemos-debug.apk");
//        capabilities.setCapability("appium:newCommandTimeout", 500);
//
//        URL url = new URL("http://0.0.0.0:4723");
//
//        AppiumDriver driver = new AndroidDriver(url, capabilities);
//        System.out.println(driver.getSessionId());
//    }

    public static AppiumDriver Initialize_Driver() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:automationName", "uiautomator2");
        capabilities.setCapability("appium:deviceName", "pixel_7");
        capabilities.setCapability("appium:udid", "emulator-5554");
        capabilities.setCapability("appium:app", System.getProperty("user.dir")+ File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"ApiDemos-debug.apk");
        capabilities.setCapability("appium:newCommandTimeout", 500);

        URL url = new URL("http://0.0.0.0:4723");

        return new AndroidDriver(url, capabilities);

    }
}
