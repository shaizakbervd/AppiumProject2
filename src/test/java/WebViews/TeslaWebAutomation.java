package WebViews;

import LocatorStrategies.CreateDriverSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Set;

public class TeslaWebAutomation {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        AppiumDriver web_driver = CreateDriverSession.Initialize_Driver_WebBrowser();
        web_driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        web_driver.navigate().to("https://tesla.com");
        web_driver.findElement(By.xpath("//*[@id=\"mega-menu\"]/div/dialog/div[1]/div[1]/button")).click();

        web_driver.findElement(By.xpath("//*[@id=\"tds-site-header\"]/ol/li/button")).click();
        web_driver.findElement(By.xpath("//*[@id=\"dx-nav-item--vehicles\"]")).click();
        web_driver.findElement(By.xpath("//*[@id=\"mega-menu\"]/div/dialog/div[2]/div/div[1]/div[5]/div[1]/a")).click();
        web_driver.findElement(By.xpath("//*[@id=\"tesla-hero-5834\"]/div[2]/div/section/div/section/a[1]")).click();
        web_driver.findElement(By.xpath("//*[@id=\"footer\"]/div/div/div/button")).click();

        Set<String> contexts =  ((AndroidDriver) web_driver).getContextHandles();
        for(String contexthandle:contexts)
        {
            System.out.println(contexthandle);
        }
        ((AndroidDriver) web_driver).context(contexts.toArray()[0].toString());
        web_driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.android.chrome:id/positive_button\"]")).click();
        ((AndroidDriver) web_driver).context(contexts.toArray()[1].toString());


        web_driver.findElement(By.xpath("//*[@id=\"main-content\"]/section/div[2]/div/div[12]/div/div/div/div[4]/div/div/div/div[1]/div/div[2]/div/div[1]/button")).click();




    }
}
