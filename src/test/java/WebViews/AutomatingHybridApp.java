package WebViews;

import LocatorStrategies.CreateDriverSession;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Set;

public class AutomatingHybridApp {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        AppiumDriver driver = CreateDriverSession.Initialize_Driver_Web();

        By viewselement = AppiumBy.accessibilityId("Views");
        By webviewelement = AppiumBy.accessibilityId("WebView");
        By list_swipe = AppiumBy.id("android:id/list");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(viewselement)).click();
        Thread.sleep(3000);
        WebElement element = driver.findElement(list_swipe);

        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "up",
                "percent", 0.75
        ));
        Thread.sleep(2000);
        driver.findElement(webviewelement).click();
        Thread.sleep(3000);

        Set<String> contexts =  ((AndroidDriver) driver).getContextHandles();
        for(String contexthandle:contexts)
        {
            System.out.println(contexthandle);
        }
//        ((AndroidDriver) driver).context("WEBVIEW");
        ((AndroidDriver) driver).context(contexts.toArray()[1].toString()); //getting the 2nd element from array
        Thread.sleep(3000);
        System.out.println(driver.findElement(AppiumBy.xpath("/html/body/h1")).getText());
//        ((AndroidDriver) driver).context("NATIVE");
        ((AndroidDriver) driver).context(contexts.toArray()[0].toString());
    }
}
