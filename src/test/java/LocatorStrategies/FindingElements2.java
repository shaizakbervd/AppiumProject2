package LocatorStrategies;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

public class FindingElements2 {

    public static void main(String[] args) throws MalformedURLException {
        AppiumDriver driver = CreateDriverSession.Initialize_Driver();

        WebElement element1 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Accessibility\")"));

        System.out.println(element1.getText());

        WebElement element2 = driver.findElements(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.TextView\")")).get(2);
        System.out.println(element2.getText());

        WebElement element3 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().description(\"Accessibility\")"));
        System.out.println(element3.getText());

        WebElement element4 = driver.findElements(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/text1\")")).get(1);
        System.out.println(element4.getText());




    }
}
