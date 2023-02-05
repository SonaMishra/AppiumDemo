package com.simplilearn.AppiumDemo;


import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;


public class SwipeDemo {

	
	AndroidDriver<MobileElement> driver;
	
	@BeforeTest
	public void LaunchApp() throws MalformedURLException {
DesiredCapabilities dc = new DesiredCapabilities();
		
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		dc.setCapability("platformName", "ANDROID");
		dc.setCapability("appPackage", "com.google.android.apps.maps");
		dc.setCapability("appActivity", "com.google.android.maps.MapsActivity");
		dc.setCapability("noReset", true);
		
		driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
	}
	
	@Test
	public void SwipeFromLeftToright() {
		
		TouchAction<?> ta = new TouchAction<>(driver);
		
		ta.press(PointOption.point(183,849)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000))).moveTo(PointOption.point(1045,1057)).release().perform();
		
		
	}
}
