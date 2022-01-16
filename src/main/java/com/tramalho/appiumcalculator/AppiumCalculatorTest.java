package com.tramalho.appiumcalculator;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AppiumCalculatorTest {

  private static AndroidDriver driver;

  public static void main(String[] args) throws MalformedURLException {
    final DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    desiredCapabilities.setCapability("platformName", "android");
    desiredCapabilities.setCapability("deviceName", "emulator-5554");
    desiredCapabilities.setCapability("automationName", "uiautomator2");
    desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
    desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
    desiredCapabilities.setCapability("ensureWebviewsHavePages", true);

    final URL remoteUrl = new URL("http://localhost:4723/wd/hub");

    driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);

    sampleTest();
  }

  public static void sampleTest() {
    MobileElement el1 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_2");
    el1.click();
    MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("plus");
    el2.click();
    MobileElement el3 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_3");
    el3.click();

    driver.quit();
  }
}
