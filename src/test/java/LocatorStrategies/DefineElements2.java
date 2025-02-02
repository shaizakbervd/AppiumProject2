package LocatorStrategies;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class DefineElements2 {

    //method3
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Accessibility\"]")
//    @iOSXCUITFindBy(accessibility = "Accessibility");
    private static WebElement element;

    public DefineElements2(AppiumDriver driver)
    {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public static void main(String[] args) throws MalformedURLException {
        AppiumDriver driver = CreateDriverSession.Initialize_Driver();
        DefineElements2 define = new DefineElements2(driver);
        System.out.println(element.getText());

    }
}
