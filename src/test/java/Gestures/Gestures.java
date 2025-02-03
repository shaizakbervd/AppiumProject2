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
//        AppiumDriver driver = CreateDriverSession.Initialize_Driver_AppPack_Activity();
//        PinchOpenClose(driver);

//        Long_Click_Gesture(driver);
//        Click_Gesture(driver);
//        Drag_Drop_Gesture(driver);
//        Swipe_Vertical(driver);
//        Swipe_Horizontal(driver);
        Scroll(driver);
    }

    public static void Scroll(AppiumDriver driver) throws InterruptedException {
        By viewselement = AppiumBy.accessibilityId("Views");
        By list_swipe = AppiumBy.id("android:id/list");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(viewselement)).click();

        WebElement element = driver.findElement(list_swipe);

        boolean canscrollmore=true;
        while(canscrollmore)
        {
            canscrollmore = (boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "elementId", ((RemoteWebElement) element).getId(),
                    "direction", "down",
                    "percent", 1.0
            ));

        }

        Thread.sleep(3000);

        Dimension screenSize = driver.manage().window().getSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        int centerX = screenWidth / 2;  // Center X-axis
        int startY = (int) (screenHeight * 0.3);  // Start swipe from 30% of the screen height
        int endY = (int) (screenHeight * 0.7);    // End swipe at 70% of the screen height



        driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                "left",centerX , "top",startY, "width",0, "height",endY-startY,
                "direction", "up",
                "percent", 1.0
        ));






    }

    public static void Swipe_Horizontal(AppiumDriver driver) throws InterruptedException {
        By viewselement = AppiumBy.accessibilityId("Views");
        By galleryelement = AppiumBy.accessibilityId("Gallery");
        By photos = AppiumBy.accessibilityId("1. Photos");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(viewselement)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(galleryelement)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(photos)).click();

        WebElement element = driver.findElement(AppiumBy.xpath("//*[@resource-id=\"io.appium.android.apis:id/gallery\"]/android.widget.ImageView[1]"));

        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "left",
                "percent", 0.75
        ));
        Thread.sleep(2000);

        Dimension screenSize = driver.manage().window().getSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        int centerY = screenHeight / 6;  // Center X-axis
        int startX = (int) (screenWidth * 0.3);  // Start swipe from 30% of the screen width
        int endX = (int) (screenWidth * 0.7);    // End swipe at 70% of the screen width

        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "left",startX , "top",centerY, "width",endX-startX, "height",0,
                "direction", "right",
                "percent", 0.75
        ));




    }

    public static void Swipe_Vertical(AppiumDriver driver) throws InterruptedException {
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

        Dimension screenSize = driver.manage().window().getSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        int centerX = screenWidth / 2;  // Center X-axis
        int startY = (int) (screenHeight * 0.3);  // Start swipe from 30% of the screen height
        int endY = (int) (screenHeight * 0.7);    // End swipe at 70% of the screen height



        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "left",centerX , "top",startY, "width",0, "height",endY-startY,
                "direction", "down",
                "percent", 0.75
        ));

    }

    public static void PinchOpenClose(AppiumDriver driver) throws InterruptedException {

        Thread.sleep(3000);
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"SKIP\"]")).click();
        Thread.sleep(3000);

        By map = AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"com.google.android.apps.maps:id/home_bottom_sheet_container\"]");
        WebElement element = driver.findElement(map);

        //can be possible by using element

//        driver.executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
//                "elementId", ((RemoteWebElement) element).getId(),
//                "percent", 0.75
//        ));

        //        driver.executeScript("mobile: pinchCloseGesture", ImmutableMap.of(
//                "elementId", ((RemoteWebElement) element).getId(),
//                "percent", 0.75
//        ));

        // using only coordinates
        // pehle you give left which is x cordinate and top y coordinate which is y
        // uske baad deko kitna box bana na ha uske hisaab se mouse ko x wise drag kro lets say value bani 700 so left cordinate which was 100 usko minus kro so wudth is 600 same for height
        driver.executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
                "left", 100,
                "top", 300,
                "width", 600,
                "height", 400,
                "percent", 0.75
        ));

        driver.executeScript("mobile: pinchCloseGesture", ImmutableMap.of(
                "left", 100,
                "top", 300,
                "width", 600,
                "height", 400,
                "percent", 0.75
        ));


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
