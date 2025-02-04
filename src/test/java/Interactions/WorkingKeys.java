package Interactions;

import LocatorStrategies.CreateDriverSession;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.time.Duration;

public class WorkingKeys {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        AppiumDriver driver = CreateDriverSession.Initialize_Driver();

        // need to check keyboard functionality and need to check presence of keyboard and send values using keys

        By viewselement = AppiumBy.accessibilityId("Views");
        By list_swipe = AppiumBy.id("android:id/list");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(viewselement)).click();
        WebElement element = driver.findElement(list_swipe);

        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "up",
                "percent", 0.75
        ));
        Thread.sleep(2000);
        driver.findElement(AppiumBy.accessibilityId("TextFields")).click();
        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"io.appium.android.apis:id/edit\"]")).click();
        Thread.sleep(2000);

        System.out.println(((AndroidDriver) driver).isKeyboardShown());

        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.A));
        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.C));
        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.D));

        Thread.sleep(2000);
        ((AndroidDriver) driver).hideKeyboard();
        System.out.println(((AndroidDriver) driver).isKeyboardShown());











    }
}
