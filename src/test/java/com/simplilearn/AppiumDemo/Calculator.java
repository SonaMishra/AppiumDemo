package com.simplilearn.AppiumDemo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Calculator {

	AndroidDriver<MobileElement> driver;

	@BeforeTest
	public void LaunchApplication() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		cap.setCapability("platformName", "Android");
		cap.setCapability("appPackage", "com.miui.calculator");
		cap.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");
		cap.setCapability("noReset", true);

		driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
	}

	@Test
	public void VerifyAdditionProcess() {

		//Press digit 9
		MobileElement digi1 = driver.findElement(By.id("com.miui.calculator:id/digit_9"));
		digi1.click();
        
		//Press +
		MobileElement symbol1 = driver.findElementByAccessibilityId("plus");
		symbol1.click();
        
		//Press 6
		MobileElement digi2 = driver.findElement(By.id("com.miui.calculator:id/digit_6"));
		digi2.click();

		//Press =
		MobileElement symbol2 = driver.findElement(By.id("com.miui.calculator:id/btn_equal_s"));
		symbol2.click();
		
		String expectedResult = "15";
		
		String ActualResult = driver.findElementByXPath("//android.widget.TextView[@content-desc=\"= 15\"]").getText().substring(2, 4);
		
		Assert.assertEquals(ActualResult, expectedResult);

	}
	
	@Test
	public void VerifyMultipicationProcess() {

		//Press digit 4
		MobileElement digi1 = driver.findElement(By.id("com.miui.calculator:id/digit_4"));
		digi1.click();

		//Press *
		MobileElement symbol1 = driver.findElementByAccessibilityId("multiply");
		symbol1.click();

		//Press 5
		MobileElement digi2 = driver.findElement(By.id("com.miui.calculator:id/digit_5"));
		digi2.click();

		//Press =
		MobileElement symbol2 = driver.findElement(By.id("com.miui.calculator:id/btn_equal_s"));
		symbol2.click();
		
		String expectedResult = "20";
		
		String ActualResult = driver.findElementByXPath("//android.widget.TextView[@content-desc=\"= 20\"]").getText().substring(2, 4);
		
		Assert.assertEquals(ActualResult, expectedResult);
		
	}
	
	@Test
	public void VerifyDelButtonIsPresent() {
		
		boolean ClearbtnDisplayed = driver.findElementById("com.miui.calculator:id/btn_del_s").isDisplayed();
		
		Assert.assertTrue(ClearbtnDisplayed);
	}
	
	@AfterTest
	public void CloseApp() {
		
		driver.quit();
	}

}
