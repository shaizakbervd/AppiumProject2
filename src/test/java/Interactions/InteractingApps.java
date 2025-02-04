package Interactions;

import LocatorStrategies.CreateDriverSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.appmanagement.AndroidInstallApplicationOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.time.Duration;

public class InteractingApps {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        AppiumDriver driver = CreateDriverSession.Initialize_Driver();

        By viewselement = AppiumBy.accessibilityId("Views");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(viewselement)).click();

        //1---terminate app
//        Thread.sleep(3000);
//        ((AndroidDriver) driver).terminateApp("io.appium.android.apis"); //it requires bundleid so we'll be giving app package in bundleid
        //bundle id is basically app name

        //2---remove app it also requires bundleid

//        ((AndroidDriver) driver).removeApp("io.appium.android.apis");
//
//        Thread.sleep(5000);

        //3--- update app it requires new app installation path
//        ((AndroidDriver) driver).installApp(System.getProperty("user.dir")+ File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"ApiDemos-debug.apk", new AndroidInstallApplicationOptions().withReplaceEnabled());

        //4---check if app installed

//        System.out.println(((AndroidDriver) driver).isAppInstalled("io.appium.android.apis"));

        //5---put app to background for certain time

//        ((AndroidDriver) driver).runAppInBackground(Duration.ofMillis(3000));

        //6.--- activate another app and move current app to foreground

        Thread.sleep(3000);
        ((AndroidDriver) driver).terminateApp("io.appium.android.apis"); //it requires bundleid so we'll be giving app package in bundleid
        Thread.sleep(3000);
        ((AndroidDriver) driver).activateApp("com.android.settings");
        Thread.sleep(3000);
        ((AndroidDriver) driver).activateApp("io.appium.android.apis");

        //7. query app state tells whether app is running in foreground or not

        System.out.println(((AndroidDriver) driver).queryAppState("io.appium.android.apis"));
        ((AndroidDriver) driver).terminateApp("io.appium.android.apis");
        System.out.println(((AndroidDriver) driver).queryAppState("io.appium.android.apis"));


    }
}
