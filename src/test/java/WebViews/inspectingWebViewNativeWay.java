package WebViews;

import LocatorStrategies.CreateDriverSession;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.time.Duration;

public class inspectingWebViewNativeWay {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        AppiumDriver driver = CreateDriverSession.Initialize_Driver();

        By viewselement = AppiumBy.accessibilityId("Views");
        By webviewelement = AppiumBy.accessibilityId("WebView2");
        By text = AppiumBy.androidUIAutomator("new UiSelector().text(\"This page is a Second Selenium sandbox\")");
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
        driver.findElement(webviewelement).click();
        Thread.sleep(3000);
        System.out.println(driver.getPageSource());
        //unable to locate web element using native strategy
//        System.out.println(driver.findElement(text).getText());




    }
}
