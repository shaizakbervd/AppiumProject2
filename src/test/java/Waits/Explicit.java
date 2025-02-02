package Waits;

import LocatorStrategies.CreateDriverSession;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.time.Duration;

public class Explicit {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        AppiumDriver driver = CreateDriverSession.Initialize_Driver();

        By viewselement = AppiumBy.accessibilityId("Views");
        By textfieldselement = AppiumBy.accessibilityId("TextFields");
        By editfield = AppiumBy.id("io.appium.android.apis:id/edit");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(viewselement)).click();

//        driver.findElement(viewselement).click();

//        Thread.sleep(3000);


        //swipe down
        WebElement element = driver.findElement(AppiumBy.id("android:id/list"));
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "up",
                "percent", 0.95
        ));

//        Thread.sleep(6000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(textfieldselement)).click();

//        driver.findElement(textfieldselement).click();
//        Thread.sleep(4000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(editfield)).sendKeys("Hello world");
        wait.until(ExpectedConditions.visibilityOfElementLocated(editfield)).clear();
//        driver.findElement(editfield).sendKeys("Hello world");
//        driver.findElement(editfield).clear();
    }
}
