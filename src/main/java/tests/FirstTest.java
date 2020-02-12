package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class FirstTest {
    private AppiumDriver<MobileElement> driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName","Android");
        caps.setCapability("platformVersion","8.1");
        caps.setCapability("deviceName","AndroidTest");
        caps.setCapability("appPackage","com.afollestad.materialdialogssample");
        caps.setCapability("appActivity","com.afollestad.materialdialogssample.MainActivity");
        caps.setCapability("app","/home/ddmitrochenko/IdeaProjects/homework13/src/main/resources/Apps/sample__1-79126-c1eae1.apk");

        URL appiumUrl = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver<MobileElement>(appiumUrl,caps);
    }

    @AfterTest
    public void tearDown() {driver.quit();}

    @Test
    public void firstTest() {System.out.println("First test run");}

    @Test
    public void secondTest() throws InterruptedException {
        WebElement element = driver.findElementById("basic_titled");
        element.click();
        //Чтобы увидеть, что клик был
        Thread.sleep(3000);
    }
}
