package com.tramalho.appiumcalculator;

import static org.junit.Assert.assertEquals;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AppiumCalculatorTest {

  private AndroidDriver<MobileElement> driver;

  @Before
  public void setUp() throws MalformedURLException {
    final DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    desiredCapabilities.setCapability("platformName", "android");
    desiredCapabilities.setCapability("deviceName", "emulator-5554");
    desiredCapabilities.setCapability("automationName", "uiautomator2");
    desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
    desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
    desiredCapabilities.setCapability("ensureWebviewsHavePages", true);

    final URL remoteUrl = new URL("http://localhost:4723/wd/hub");

    driver = new AndroidDriver<>(remoteUrl, desiredCapabilities);
  }

  @After
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void shouldSum02Values() {
    final MobileElement el1 = driver.findElementById("com.android.calculator2:id/digit_2");
    el1.click();
    final MobileElement el2 = driver.findElementByAccessibilityId("plus");
    el2.click();
    final MobileElement el3 = driver.findElementById("com.android.calculator2:id/digit_3");
    el3.click();

    final MobileElement el4 = driver.findElementById("com.android.calculator2:id/result");

    assertEquals("5", el4.getText());
  }
}
