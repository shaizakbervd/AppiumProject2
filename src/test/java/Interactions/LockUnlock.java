package Interactions;

import LocatorStrategies.CreateDriverSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.time.Duration;

public class LockUnlock {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
//        AppiumDriver driver = CreateDriverSession.Initialize_Driver();

        // no security password etc should be set
        // essential where we want to test the device idle and test push notification on lock screen and when clicked upon user is navigated to app

        // --- if pin or passcode is not set
        //((AndroidDriver) driver).lockDevice(Duration.ofSeconds(5));
//        ((AndroidDriver) driver).lockDevice();
//        System.out.println(((AndroidDriver) driver).isDeviceLocked());
//        ((AndroidDriver) driver).unlockDevice();

        // --- if pin or passcode is set then set the parameter in capabilities
        AppiumDriver driver = CreateDriverSession.Initialize_Driver_Lock_Unlock();
        //((AndroidDriver) driver).lockDevice(Duration.ofSeconds(5));
        ((AndroidDriver) driver).lockDevice();
        System.out.println(((AndroidDriver) driver).isDeviceLocked());
        ((AndroidDriver) driver).unlockDevice();







    }
}
