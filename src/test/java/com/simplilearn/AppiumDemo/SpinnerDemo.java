package com.simplilearn.AppiumDemo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class SpinnerDemo {

	
	AndroidDriver<MobileElement> driver;
	
	@BeforeTest
	public void LunchApp() throws MalformedURLException {
		//Launch the app
		DesiredCapabilities dc = new DesiredCapabilities();
		
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		dc.setCapability("platformName", "ANDROID");
		dc.setCapability("appPackage", "com.touchboarder.android.api.demos");
		dc.setCapability("appActivity", "com.touchboarder.androidapidemos.MainActivity");
		dc.setCapability("noReset", true);
		
		driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
		
	}
	
	@Test
	public void SelectColorAndDateFromSpinner() {
		//Click on API Demo
		driver.findElementByXPath("//android.widget.TextView[@text='API Demos']").click();
		
		//Click on Views
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"View\").instance(0))").click();
		//Click on Spinner
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Spinner\").instance(0))").click();
		
		WebDriverWait wait = new WebDriverWait(driver,60);
		//Select 'yellow' from spinner
		driver.findElementById("android:id/text1").click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.CheckedTextView[@text='yellow']")));
		driver.findElementByXPath("//android.widget.CheckedTextView[@text='yellow']").click();
		
		//Select 'Earth' from Spinner
		driver.findElementById("com.touchboarder.android.api.demos:id/spinner2").click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.CheckedTextView[@text='Earth']")));
		
		driver.findElementByXPath("//android.widget.CheckedTextView[@text='Earth']").click();
		
		
	}
}

