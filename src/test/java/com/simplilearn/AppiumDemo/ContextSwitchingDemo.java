package com.simplilearn.AppiumDemo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ContextSwitchingDemo {
	AndroidDriver<AndroidElement> driver;

	@BeforeTest
	public void LaunchApplication() throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
        
		//Connect device and launch browser
		dc.setCapability("deviceName", "emulator-5554");
		dc.setCapability("platformName", "ANDROID");
		dc.setCapability("chromedriverExecutable","C:\\Users\\91887\\Downloads\\chromedriver_win32\\chromedriver.exe");
		dc.setCapability("browserName", "Chrome");
		
		dc.setCapability("noReset", true);
		
		driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
		
		driver.get("https://ebay.com");
		 
	}
	
	@Test
	public void addShortcutToHomeScreen() {
		
		//to get current context
		Set<String> context = driver.getContextHandles();
		
		for(String t:context) {
			System.out.println(t);
		}
		
		System.out.println("Current context = " +driver.getContext());
		
		//Switch context
		driver.context("NATIVE_APP");
		
		//Click 3 dots 
		 driver.findElementById("com.android.chrome:id/menu_button").click();
		 
		 //Click to "Add home to Screen"
		 driver.findElementByXPath("//android.widget.TextView[@text ='Add to Home screen']").click();
		 
		 //Adding Wait
		 
		 WebDriverWait wait = new WebDriverWait(driver,60);
		 wait.until(ExpectedConditions.elementToBeClickable(By.id("com.android.chrome:id/positive_button")));
		 
		 //Click on add button on pop up
		 
		 driver.findElementById("com.android.chrome:id/positive_button").click();
		 
		 
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@text ='Add to Home screen']")));
		 
		 //Click to "Add home to Screen"
		 driver.findElementByXPath("//android.widget.Button[@text ='Add to Home screen']").click();
		 
		
	}
	
	@AfterTest
	public void CloseApp() {
		driver.quit();
	}
}
