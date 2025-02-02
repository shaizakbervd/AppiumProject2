package ElementAttributes;

import LocatorStrategies.CreateDriverSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class GetAttributes {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        AppiumDriver driver = CreateDriverSession.Initialize_Driver();

        By accessibility = AppiumBy.accessibilityId("Accessibility");

        System.out.println("Text: "+driver.findElement(accessibility).getAttribute("text"));
        System.out.println("Checked: "+driver.findElement(accessibility).getAttribute("checked"));
        System.out.println("Enabled: "+driver.findElement(accessibility).getAttribute("enabled"));
        System.out.println("Selected: "+driver.findElement(accessibility).getAttribute("selected"));
        System.out.println("Displayed: "+driver.findElement(accessibility).getAttribute("displayed"));

        System.out.println("IsSelected Attribute: "+driver.findElement(accessibility).isSelected());
        System.out.println("IsDisplayed Attribute: "+driver.findElement(accessibility).isDisplayed());
        System.out.println("IsEnabled Attribute: "+driver.findElement(accessibility).isEnabled());

        System.out.println("Bouunds: "+driver.findElement(accessibility).getAttribute("bounds"));



    }
}
