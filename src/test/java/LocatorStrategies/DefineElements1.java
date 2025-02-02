package LocatorStrategies;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

public class DefineElements1 {

    public static void main(String[] args) throws MalformedURLException {
        AppiumDriver driver = CreateDriverSession.Initialize_Driver();

        //method1 web oriented

        By ByElement = By.xpath("//android.widget.TextView[@content-desc=\"Accessibility\"]");
        System.out.println(driver.findElement(ByElement).getText());

        //method2 mobile

        WebElement element = driver.findElement(AppiumBy.accessibilityId("Accessibility"));
        System.out.println(element.getText());

        //method3 specific mobile

        By appiumelement = AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Accessibility\"]");
        System.out.println(driver.findElement(appiumelement).getText());

    }
}
