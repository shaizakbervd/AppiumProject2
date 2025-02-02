package Gestures;

import LocatorStrategies.CreateDriverSession;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.time.Duration;

public class Gestures {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        AppiumDriver driver = CreateDriverSession.Initialize_Driver();

//        Long_Click_Gesture(driver);
//        Click_Gesture(driver);
        Drag_Drop_Gesture(driver);

    }

    public static void Drag_Drop_Gesture(AppiumDriver driver)
    {
        By viewselement = AppiumBy.accessibilityId("Views");
        By dragAndDrop = AppiumBy.accessibilityId("Drag and Drop");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(viewselement)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(dragAndDrop)).click();

        WebElement element1 = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
        WebElement element2 = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_2"));

        driver.executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element1).getId(),
                "startX", element1.getLocation().x,
                "startY", element1.getLocation().y,
                "endX", element2.getLocation().x,
                "endY", element2.getLocation().y
        ));


    }

    public static void Click_Gesture(AppiumDriver driver)
    {
        By viewselement = AppiumBy.accessibilityId("Views");

        WebElement element  = driver.findElement(viewselement);

        driver.executeScript("mobile: clickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId()
        ));



    }

    public static void Long_Click_Gesture(AppiumDriver driver)
    {
        By viewselement = AppiumBy.accessibilityId("Views");
        By dragAndDrop = AppiumBy.accessibilityId("Drag and Drop");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(viewselement)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(dragAndDrop)).click();


        WebElement element = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));

//        Using element
//        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
//                "elementId", ((RemoteWebElement) element).getId(),
//                "duration", 3000
//        ));


        Dimension screenSize = driver.manage().window().getSize();
        int screenWidth = screenSize.getWidth();
        int screenHeight = screenSize.getHeight();

        int centerx = (0+414)/2;
        int centery = (420+834)/2;

        float percentagex = (float) centerx / screenWidth;
        float percentagey = (float) centery /screenHeight;

        int x = (int) (screenWidth * percentagex);
        int y = (int) (screenHeight * percentagey);


//        Using coordinates
                driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "x", x,
                "y", y,
                "duration", 3000
        ));
    }
}
