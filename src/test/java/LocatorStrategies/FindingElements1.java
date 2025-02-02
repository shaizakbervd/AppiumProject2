package LocatorStrategies;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

public class FindingElements1 {

    public static void main(String[] args) throws MalformedURLException {
        AppiumDriver driver = CreateDriverSession.Initialize_Driver();

        WebElement element1 = driver.findElement(AppiumBy.accessibilityId("Access'ibility"));
        System.out.println(element1.getText());

        WebElement element2 = driver.findElements(AppiumBy.id("android:id/text1")).get(1);
        System.out.println(element2.getText());

        WebElement element3 = driver.findElements(AppiumBy.className("android.widget.TextView")).getFirst();
        System.out.println(element3.getText());

        WebElement element4 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Access'ibility\"]"));
        System.out.println(element4.getText());

//        obsolete
//        WebElement element5 = driver.findElement(AppiumBy.tagName("Access'ibility")); //content-description
//        System.out.println(element5.getText());
//
//        WebElement element6 = driver.findElement(AppiumBy.name("Access'ibility\n")); //text
//        System.out.println(element6.getText());
    }
}
